/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mma_admin;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class VentanaModificarLuchador extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/mma_admin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public VentanaModificarLuchador(JFrame padre, ArrayList<Luchador> listaLuchadores,
            DefaultTableModel modeloTabla, int filaSeleccionada, String[] categoriasUFC,
            String[] rankings) {

        setTitle("Modificar luchador");
        setSize(400, 350);
        setLocationRelativeTo(padre);
        setLayout(new GridLayout(7, 2, 10, 10));

        Luchador luchador = listaLuchadores.get(filaSeleccionada);

        String nombreAntiguo = luchador.getNombre();

        JTextField tNombre = new JTextField(luchador.getNombre());
        JComboBox<String> cbCategoria = new JComboBox<>(categoriasUFC);
        JTextField tPeso = new JTextField(String.valueOf(luchador.getPeso()));
        JTextField tVictorias = new JTextField(String.valueOf(luchador.getVictorias()));
        JTextField tDerrotas = new JTextField(String.valueOf(luchador.getDerrotas()));
        JComboBox<String> cbRanking = new JComboBox<>(rankings);

        cbCategoria.setSelectedItem(luchador.getCategoria());
        cbRanking.setSelectedItem(String.valueOf(luchador.getRanking()));

        JButton bGuardar = new JButton("Guardar");
        JButton bCancelar = new JButton("Cancelar");

        add(new JLabel("Nombre:"));
        add(tNombre);

        add(new JLabel("Categoría:"));
        add(cbCategoria);

        add(new JLabel("Peso:"));
        add(tPeso);

        add(new JLabel("Victorias:"));
        add(tVictorias);

        add(new JLabel("Derrotas:"));
        add(tDerrotas);

        add(new JLabel("Ranking:"));
        add(cbRanking);

        add(bGuardar);
        add(bCancelar);

        bGuardar.addActionListener(e -> {

            try {
                String nombre = tNombre.getText().trim();
                String categoria = cbCategoria.getSelectedItem().toString();
                double peso = Double.parseDouble(tPeso.getText().trim());
                int victorias = Integer.parseInt(tVictorias.getText().trim());
                int derrotas = Integer.parseInt(tDerrotas.getText().trim());
                int ranking = Integer.parseInt(cbRanking.getSelectedItem().toString());

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
                    return;
                }

                String sql = "UPDATE Luchadores SET nombre = ?, categoria = ?, peso = ?, "
                        + "victorias = ?, derrotas = ?, ranking = ? WHERE nombre = ?";

                try (Connection conn = obtenirConexio();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, categoria);
                    pstmt.setDouble(3, peso);
                    pstmt.setInt(4, victorias);
                    pstmt.setInt(5, derrotas);
                    pstmt.setInt(6, ranking);
                    pstmt.setString(7, nombreAntiguo);

                    pstmt.executeUpdate();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error BBDD: " + ex.getMessage(),
                            "ERROR BBDD",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                luchador.setNombre(nombre);
                luchador.setCategoria(categoria);
                luchador.setPeso(peso);
                luchador.setVictorias(victorias);
                luchador.setDerrotas(derrotas);
                luchador.setRanking(ranking);

                modeloTabla.setValueAt(nombre, filaSeleccionada, 0);
                modeloTabla.setValueAt(categoria, filaSeleccionada, 1);
                modeloTabla.setValueAt(peso, filaSeleccionada, 2);
                modeloTabla.setValueAt(victorias, filaSeleccionada, 3);
                modeloTabla.setValueAt(derrotas, filaSeleccionada, 4);
                modeloTabla.setValueAt(ranking, filaSeleccionada, 5);

                JOptionPane.showMessageDialog(this, "Luchador modificado correctamente");

                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Peso, victorias y derrotas deben ser números");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Introduce datos válidos");
            }
        });

        bCancelar.addActionListener(e -> dispose());
    }
}