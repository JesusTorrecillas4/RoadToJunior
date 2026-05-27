package mma_admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class VentanaCombates extends JDialog {

    private static final String URL = "jdbc:mysql://localhost:3306/mma_admin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ArrayList<Luchador> listaLuchadores;
    private ArrayList<Combate> listaCombates;

    private DefaultTableModel modeloCombates;
    private JTable tablaCombates;

    public VentanaCombates(JFrame padre, ArrayList<Luchador> listaLuchadores,
                           ArrayList<Combate> listaCombates) {

        super(padre, "Gestión de combates", true); // true = modal

        this.listaLuchadores = listaLuchadores;
        this.listaCombates = listaCombates;

        setSize(800, 400);
        setLocationRelativeTo(padre);
        setLayout(new BorderLayout());

        crearTablaCombates();
        cargarCombatesDeDB();
    }

    private void crearTablaCombates() {

        modeloCombates = new DefaultTableModel(
                new Object[]{"ID", "Peleador 1", "Peleador 2", "Hora", "Lugar"}, 0
        );

        tablaCombates = new JTable(modeloCombates);

        JButton bCrearCombate = new JButton("Crear combate");
        JButton bModificarCombate = new JButton("Modificar combate");
        JButton bEliminarCombate = new JButton("Eliminar combate");

        JPanel pBotones = new JPanel();
        pBotones.add(bCrearCombate);
        pBotones.add(bModificarCombate);
        pBotones.add(bEliminarCombate);

        add(new JScrollPane(tablaCombates), BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        bCrearCombate.addActionListener(e -> crearOModificarCombate(-1));

        bModificarCombate.addActionListener(e -> {

            int fila = tablaCombates.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un combate");
                return;
            }

            crearOModificarCombate(fila);
        });

        bEliminarCombate.addActionListener(e -> eliminarCombate());
    }

    private void crearOModificarCombate(int filaEditar) {

        if (listaLuchadores.size() < 2) {
            JOptionPane.showMessageDialog(this, "Necesitas mínimo 2 luchadores");
            return;
        }

        JComboBox<String> cbPeleador1 = new JComboBox<>();
        JComboBox<String> cbPeleador2 = new JComboBox<>();

        for (Luchador l : listaLuchadores) {
            cbPeleador1.addItem(l.getNombre());
            cbPeleador2.addItem(l.getNombre());
        }

        JComboBox<String> cbHora = new JComboBox<>(new String[]{
            "18:00", "18:30", "19:00", "19:30",
            "20:00", "20:30", "21:00", "21:30",
            "22:00", "22:30"
        });

        JComboBox<String> cbLugar = new JComboBox<>(new String[]{
            "Madrid", "Barcelona", "Valencia", "Sevilla",
            "Zaragoza", "Málaga", "Murcia", "Bilbao",
            "Alicante", "Terrassa"
        });

        if (filaEditar != -1) {
            Combate combate = listaCombates.get(filaEditar);
            cbPeleador1.setSelectedItem(combate.getLuchador1());
            cbPeleador2.setSelectedItem(combate.getLuchador2());
            cbHora.setSelectedItem(combate.getFecha());
            cbLugar.setSelectedItem(combate.getLugar());
        }

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Peleador 1:"));
        panel.add(cbPeleador1);
        panel.add(new JLabel("Peleador 2:"));
        panel.add(cbPeleador2);
        panel.add(new JLabel("Hora:"));
        panel.add(cbHora);
        panel.add(new JLabel("Lugar:"));
        panel.add(cbLugar);

        int opcion = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Combate",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (opcion == JOptionPane.OK_OPTION) {

            String peleador1 = cbPeleador1.getSelectedItem().toString();
            String peleador2 = cbPeleador2.getSelectedItem().toString();
            String hora = cbHora.getSelectedItem().toString();
            String lugar = cbLugar.getSelectedItem().toString();

            if (peleador1.equals(peleador2)) {
                JOptionPane.showMessageDialog(this, "No puede luchar contra sí mismo");
                return;
            }

            if (filaEditar == -1) {
                crearCombate(peleador1, peleador2, hora, lugar);
            } else {
                modificarCombate(filaEditar, peleador1, peleador2, hora, lugar);
            }
        }
    }

    private void crearCombate(String peleador1, String peleador2, String hora, String lugar) {

        String id = "C" + (listaCombates.size() + 1);

        String sql = "INSERT INTO Combates (id, luchador1, luchador2, hora, lugar) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, peleador1);
            pstmt.setString(3, peleador2);
            pstmt.setString(4, hora);
            pstmt.setString(5, lugar);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error BBDD: " + e.getMessage());
            return;
        }

        Combate combate = new Combate(id, peleador1, peleador2, lugar, hora);
        listaCombates.add(combate);

        modeloCombates.addRow(new Object[]{
            id, peleador1, peleador2, hora, lugar
        });
    }

    private void modificarCombate(int filaEditar, String peleador1, String peleador2,
                                  String hora, String lugar) {

        Combate combate = listaCombates.get(filaEditar);
        String id = combate.getId();

        String sql = "UPDATE Combates SET luchador1 = ?, luchador2 = ?, hora = ?, lugar = ? WHERE id = ?";

        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, peleador1);
            pstmt.setString(2, peleador2);
            pstmt.setString(3, hora);
            pstmt.setString(4, lugar);
            pstmt.setString(5, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error BBDD: " + e.getMessage());
            return;
        }

        combate.setLuchador1(peleador1);
        combate.setLuchador2(peleador2);
        combate.setFecha(hora);
        combate.setLugar(lugar);

        modeloCombates.setValueAt(peleador1, filaEditar, 1);
        modeloCombates.setValueAt(peleador2, filaEditar, 2);
        modeloCombates.setValueAt(hora, filaEditar, 3);
        modeloCombates.setValueAt(lugar, filaEditar, 4);
    }

    private void eliminarCombate() {

        int fila = tablaCombates.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un combate");
            return;
        }

        Combate combate = listaCombates.get(fila);
        String id = combate.getId();

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres eliminar el combate " + id + "?",
                "Confirmar eliminar",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM Combates WHERE id = ?";

            try (Connection conn = obtenirConexio();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, id);
                pstmt.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error BBDD: " + e.getMessage());
                return;
            }

            listaCombates.remove(fila);
            modeloCombates.removeRow(fila);
        }
    }

    private void cargarCombatesDeDB() {

        listaCombates.clear();

        String sql = "SELECT id, luchador1, luchador2, hora, lugar FROM Combates ORDER BY id";

        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String id = rs.getString("id");
                String luchador1 = rs.getString("luchador1");
                String luchador2 = rs.getString("luchador2");
                String hora = rs.getString("hora");
                String lugar = rs.getString("lugar");

                Combate combate = new Combate(id, luchador1, luchador2, lugar, hora);
                listaCombates.add(combate);

                modeloCombates.addRow(new Object[]{
                    id, luchador1, luchador2, hora, lugar
                });
            }

        } catch (SQLException e) {
            System.out.println("Error carregant combates: " + e.getMessage());
        }
    }
}