/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mma_admin;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaModificarLuchador extends JFrame {

    public VentanaModificarLuchador(JFrame padre,ArrayList<Luchador> listaLuchadores,
        DefaultTableModel modeloTabla,int filaSeleccionada,String[] categoriasUFC,
         String[] rankings) {

        setTitle("Modificar luchador");
        setSize(400, 350);
        setLocationRelativeTo(padre);
        setLayout(new GridLayout(7, 2, 10, 10));

        Luchador luchador = listaLuchadores.get(filaSeleccionada);

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

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Introduce datos válidos");
            }
        });

        bCancelar.addActionListener(e -> dispose());
    }
}