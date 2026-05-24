/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mma_admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mma_admin extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/mma_admin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private ArrayList<Luchador> listaLuchadores = new ArrayList<>();

    private DefaultTableModel modeloTabla;

    public Mma_admin() {

        setTitle("MMA ADMIN");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearComponentes();

        setVisible(true);
    }

    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void crearComponentes() {

        JLabel lNombre = new JLabel("Nombre:");
        JLabel lCategoria = new JLabel("Categoria:");
        JLabel lPeso = new JLabel("Peso:");
        JLabel lVictorias = new JLabel("Victorias:");
        JLabel lDerrotas = new JLabel("Derrotas:");
        JLabel lRanking = new JLabel("Ranking:");

        JTextField tNombre = new JTextField();
        JTextField tCategoria = new JTextField();
        JTextField tPeso = new JTextField();
        JTextField tVictorias = new JTextField();
        JTextField tDerrotas = new JTextField();
        JTextField tRanking = new JTextField();

        JButton bCrear = new JButton("Crear");
        JButton bEliminar = new JButton("Eliminar");

        JPanel pFormulario = new JPanel(new GridLayout(6, 2, 10, 10));

        pFormulario.add(lNombre);
        pFormulario.add(tNombre);

        pFormulario.add(lCategoria);
        pFormulario.add(tCategoria);

        pFormulario.add(lPeso);
        pFormulario.add(tPeso);

        pFormulario.add(lVictorias);
        pFormulario.add(tVictorias);

        pFormulario.add(lDerrotas);
        pFormulario.add(tDerrotas);

        pFormulario.add(lRanking);
        pFormulario.add(tRanking);

        modeloTabla = new DefaultTableModel(
                new Object[]{"Nombre", "Categoria", "Peso", "Victorias", "Derrotas", "Ranking"}, 0
        );

        JTable tabla = new JTable(modeloTabla);

        JScrollPane sPane = new JScrollPane(tabla);

        JPanel pBotones = new JPanel();

        pBotones.add(bCrear);
        pBotones.add(bEliminar);

        setLayout(new BorderLayout());

        add(pFormulario, BorderLayout.NORTH);
        add(sPane, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        bCrear.addActionListener(e -> {

            try {

                String nombre = tNombre.getText();
                String categoria = tCategoria.getText();

                double peso = Double.parseDouble(tPeso.getText());

                int victorias = Integer.parseInt(tVictorias.getText());

                int derrotas = Integer.parseInt(tDerrotas.getText());

                int ranking = Integer.parseInt(tRanking.getText());

                Luchador luchador = new Luchador(
                        nombre,
                        categoria,
                        peso,
                        victorias,
                        derrotas,
                        ranking
                );

                listaLuchadores.add(luchador);

                modeloTabla.addRow(new Object[]{
                    nombre,
                    categoria,
                    peso,
                    victorias,
                    derrotas,
                    ranking
                });

                String sql = "INSERT INTO luchadores(nombre, categoria, peso, victorias, derrotas, ranking_posicion) VALUES (?, ?, ?, ?, ?, ?)";

                try (Connection conn = obtenerConexion();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, categoria);
                    pstmt.setDouble(3, peso);
                    pstmt.setInt(4, victorias);
                    pstmt.setInt(5, derrotas);
                    pstmt.setInt(6, ranking);

                    pstmt.executeUpdate();

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(this,
                            "Error DB: " + ex.getMessage());

                }

                tNombre.setText("");
                tCategoria.setText("");
                tPeso.setText("");
                tVictorias.setText("");
                tDerrotas.setText("");
                tRanking.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Introduce datos válidos");

            }

        });

        bEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {

                JOptionPane.showMessageDialog(this,
                        "Selecciona un luchador");

                return;
            }

            modeloTabla.removeRow(fila);

            listaLuchadores.remove(fila);

        });

    }

    public static void main(String[] args) {

        new Mma_admin();

    }
}
