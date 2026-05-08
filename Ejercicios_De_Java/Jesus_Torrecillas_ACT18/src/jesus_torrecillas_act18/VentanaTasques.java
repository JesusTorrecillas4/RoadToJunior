/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesus_torrecillas_act18;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class VentanaTasques extends JDialog {

    private static final String URL = "jdbc:mysql://localhost:3306/act18";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ArrayList<Tasca> listaTasques = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios;
    private DefaultTableModel modeloTabla;

    public VentanaTasques(JFrame padre, ArrayList<Usuario> listaUsuarios) {
        super(padre, "Gestió de Tasques", true);
        this.listaUsuarios = listaUsuarios;
        setSize(600, 500);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        crearComponentes();
        carregarDeDB();
        setVisible(true);
    }

    private void crearComponentes() {

        // Etiquetas y campos
        JLabel lId = new JLabel("ID:");
        JLabel lDesc = new JLabel("Descripció:");
        JTextField tId = new JTextField(10);
        JTextField tDesc = new JTextField(10);

        // Panel formulario
        JPanel pFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        pFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pFormulario.add(lId);
        pFormulario.add(tId);
        pFormulario.add(lDesc);
        pFormulario.add(tDesc);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Descripció", "Usuari Asignat"}, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane sPane = new JScrollPane(tabla);

        // ComboBox usuarios
        JComboBox<String> cbUsuaris = new JComboBox<>();
        for (Usuario u : listaUsuarios) cbUsuaris.addItem(u.getNombre());

        // Botones
        JButton bAfegir = new JButton("Afegir");
        JButton bEliminar = new JButton("Eliminar");
        JButton bAssignar = new JButton("Assignar a usuari");

        JPanel pBotones = new JPanel();
        pBotones.add(bAfegir);
        pBotones.add(bEliminar);
        pBotones.add(new JLabel("Usuari:"));
        pBotones.add(cbUsuaris);
        pBotones.add(bAssignar);

        // Layout
        setLayout(new BorderLayout());
        add(pFormulario, BorderLayout.NORTH);
        add(sPane, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        // Listeners
        bAfegir.addActionListener(e -> afegirTasca(tId, tDesc));
        bEliminar.addActionListener(e -> eliminarTasca(tabla));
        bAssignar.addActionListener(e -> assignarTasca(tabla, cbUsuaris));
    }

    private void afegirTasca(JTextField tId, JTextField tDesc) {

        String id = tId.getText().trim();
        String desc = tDesc.getText().trim();

        if (id.isEmpty() || desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Omple tots els camps.",
                    "Camps buits", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Comprobar duplicado
        for (Tasca t : listaTasques) {
            if (t.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "Ja existeix una tasca amb aquest ID.",
                        "Duplicat", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        String sql = "INSERT INTO Tasques (id, descripcio, usuari_asignat) VALUES (?, ?, NULL)";
        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, desc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error DB: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        listaTasques.add(new Tasca(id, desc));
        modeloTabla.addRow(new Object[]{id, desc, "No assignada"});
        tId.setText("");
        tDesc.setText("");
    }

    private void eliminarTasca(JTable tabla) {

        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tasca per eliminar.",
                    "Cap selecció", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idTasca = listaTasques.get(fila).getId();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Segur que vols eliminar la tasca \"" + idTasca + "\"?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM Tasques WHERE id = ?";
            try (Connection conn = obtenirConexio();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idTasca);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error eliminant: " + e.getMessage());
            }
            listaTasques.remove(fila);
            modeloTabla.removeRow(fila);
        }
    }

    private void assignarTasca(JTable tabla, JComboBox<String> cbUsuaris) {

        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una tasca per assignar.",
                    "Cap selecció", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String usuari = (String) cbUsuaris.getSelectedItem();
        if (usuari == null) {
            JOptionPane.showMessageDialog(this, "No hi ha usuaris disponibles.",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Tasca tasca = listaTasques.get(fila);

        String sql = "UPDATE Tasques SET usuari_asignat = ? WHERE id = ?";
        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuari);
            pstmt.setString(2, tasca.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error DB: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tasca.setUsuariAsignat(usuari);
        modeloTabla.setValueAt(usuari, fila, 2);

        JOptionPane.showMessageDialog(this,
                "Tasca \"" + tasca.getId() + "\" assignada a " + usuari,
                "OK", JOptionPane.INFORMATION_MESSAGE);
    }

    private void carregarDeDB() {
        String sql = "SELECT id, descripcio, usuari_asignat FROM Tasques";
        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("id");
                String desc = rs.getString("descripcio");
                String usuari = rs.getString("usuari_asignat");

                Tasca t = new Tasca(id, desc);
                if (usuari != null) t.setUsuariAsignat(usuari);
                listaTasques.add(t);
                modeloTabla.addRow(new Object[]{id, desc, usuari != null ? usuari : "No assignada"});
            }
        } catch (SQLException e) {
            System.out.println("Error carregant tasques: " + e.getMessage());
        }
    }
}