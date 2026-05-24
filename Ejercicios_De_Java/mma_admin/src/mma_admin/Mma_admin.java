package mma_admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Mma_admin extends JFrame {

    ArrayList<Luchador> listaLuchadores = new ArrayList<>();
    ArrayList<Combate> listaCombates = new ArrayList<>();

    DefaultTableModel modeloTabla;
    JTable tabla;

    String[] categoriasUFC = {
        "Peso mosca",
        "Peso gallo",
        "Peso pluma",
        "Peso ligero",
        "Peso welter",
        "Peso medio",
        "Peso semipesado",
        "Peso pesado"
    };

    String[] rankings = {
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "10"
    };

    public Mma_admin() {

        setTitle("MMA ADMIN");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearMenu();
        crearComponentes();

        setVisible(true);
    }

    private void crearMenu() {

        JMenuBar barraMenu = new JMenuBar();

        JMenu menuGestion = new JMenu("Gestión");
        JMenuItem itemCombates = new JMenuItem("Combates");

        itemCombates.addActionListener(e -> abrirVentanaCombates());

        menuGestion.add(itemCombates);
        barraMenu.add(menuGestion);

        setJMenuBar(barraMenu);
    }

    private void crearComponentes() {

        JLabel lNombre = new JLabel("Nombre:");
        JLabel lCategoria = new JLabel("Categoría:");
        JLabel lPeso = new JLabel("Peso:");
        JLabel lVictorias = new JLabel("Victorias:");
        JLabel lDerrotas = new JLabel("Derrotas:");
        JLabel lRanking = new JLabel("Ranking:");

        JTextField tNombre = new JTextField();
        JComboBox<String> cbCategoria = new JComboBox<>(categoriasUFC);
        JTextField tPeso = new JTextField();
        JTextField tVictorias = new JTextField();
        JTextField tDerrotas = new JTextField();
        JComboBox<String> cbRanking = new JComboBox<>(rankings);

        JButton bCrear = new JButton("Crear");
        JButton bModificar = new JButton("Modificar");
        JButton bEliminar = new JButton("Eliminar");

        JPanel pFormulario = new JPanel(new GridLayout(6, 2, 10, 10));

        pFormulario.add(lNombre);
        pFormulario.add(tNombre);

        pFormulario.add(lCategoria);
        pFormulario.add(cbCategoria);

        pFormulario.add(lPeso);
        pFormulario.add(tPeso);

        pFormulario.add(lVictorias);
        pFormulario.add(tVictorias);

        pFormulario.add(lDerrotas);
        pFormulario.add(tDerrotas);

        pFormulario.add(lRanking);
        pFormulario.add(cbRanking);

        modeloTabla = new DefaultTableModel(
                new Object[]{"Nombre", "Categoría", "Peso", "Victorias", "Derrotas", "Ranking"}, 0
        );

        tabla = new JTable(modeloTabla);

        JPanel pBotones = new JPanel();
        pBotones.add(bCrear);
        pBotones.add(bModificar);
        pBotones.add(bEliminar);

        setLayout(new BorderLayout());

        add(pFormulario, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        bCrear.addActionListener(e -> {

            try {
                String nombre = tNombre.getText().trim();
                String categoria = cbCategoria.getSelectedItem().toString();
                double peso = Double.parseDouble(tPeso.getText().trim());
                int victorias = Integer.parseInt(tVictorias.getText().trim());
                int derrotas = Integer.parseInt(tDerrotas.getText().trim());
                int ranking = Integer.parseInt(cbRanking.getSelectedItem().toString());

                Luchador luchador = new Luchador(nombre, categoria, peso, victorias, derrotas, ranking);

                listaLuchadores.add(luchador);

                modeloTabla.addRow(new Object[]{
                    nombre, categoria, peso, victorias, derrotas, ranking
                });

                limpiarFormulario(tNombre, tPeso, tVictorias, tDerrotas);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Introduce datos válidos");
            }
        });

        bModificar.addActionListener(e -> {

            int filaSeleccionada = tabla.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this,
                        "Selecciona un luchador para modificar",
                        "No selection",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            abrirVentana(filaSeleccionada);

            limpiarFormulario(tNombre, tPeso, tVictorias, tDerrotas);
        });

        bEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un luchador");
                return;
            }

            listaLuchadores.remove(fila);
            modeloTabla.removeRow(fila);
        });
    }

    private void abrirVentana(int filaSeleccionada) {

        VentanaModificarLuchador ventana = new VentanaModificarLuchador(
                this,
                listaLuchadores,
                modeloTabla,
                filaSeleccionada,
                categoriasUFC,
                rankings
        );

        ventana.setVisible(true);
    }

    private void abrirVentanaCombates() {

        JFrame ventanaCombates = new JFrame("Combates");
        ventanaCombates.setSize(800, 400);
        ventanaCombates.setLocationRelativeTo(this);
        ventanaCombates.setLayout(new BorderLayout());

        DefaultTableModel modeloCombates = new DefaultTableModel(
                new Object[]{"ID", "Peleador 1", "Peleador 2", "Hora", "Lugar"}, 0
        );

        JTable tablaCombates = new JTable(modeloCombates);

        for (Combate c : listaCombates) {
            modeloCombates.addRow(new Object[]{
                c.getId(),
                c.getLuchador1(),
                c.getLuchador2(),
                c.getFecha(),
                c.getLugar()
            });
        }

        JButton bCrearCombate = new JButton("Crear combate");
        JButton bModificarCombate = new JButton("Modificar combate");
        JButton bEliminarCombate = new JButton("Eliminar combate");

        JPanel pBotones = new JPanel();
        pBotones.add(bCrearCombate);
        pBotones.add(bModificarCombate);
        pBotones.add(bEliminarCombate);

        ventanaCombates.add(new JScrollPane(tablaCombates), BorderLayout.CENTER);
        ventanaCombates.add(pBotones, BorderLayout.SOUTH);

        bCrearCombate.addActionListener(e -> {

            if (listaLuchadores.size() < 2) {
                JOptionPane.showMessageDialog(ventanaCombates, "Necesitas mínimo 2 luchadores");
                return;
            }

            crearOModificarCombate(ventanaCombates, modeloCombates, -1);
        });

        bModificarCombate.addActionListener(e -> {

            int fila = tablaCombates.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(ventanaCombates, "Selecciona un combate");
                return;
            }

            crearOModificarCombate(ventanaCombates, modeloCombates, fila);
        });

        bEliminarCombate.addActionListener(e -> {

            int fila = tablaCombates.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(ventanaCombates, "Selecciona un combate");
                return;
            }

            listaCombates.remove(fila);
            modeloCombates.removeRow(fila);
        });

        ventanaCombates.setVisible(true);
    }

    private void crearOModificarCombate(JFrame ventanaCombates, DefaultTableModel modeloCombates, int filaEditar) {

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
                ventanaCombates,
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
                JOptionPane.showMessageDialog(ventanaCombates, "No puede luchar contra sí mismo");
                return;
            }

            if (filaEditar == -1) {

                String id = "C" + (listaCombates.size() + 1);

                Combate combate = new Combate(id, peleador1, peleador2, lugar, hora);
                listaCombates.add(combate);

                modeloCombates.addRow(new Object[]{
                    id, peleador1, peleador2, hora, lugar
                });

            } else {

                Combate combate = listaCombates.get(filaEditar);

                combate.setLuchador1(peleador1);
                combate.setLuchador2(peleador2);
                combate.setFecha(hora);
                combate.setLugar(lugar);

                modeloCombates.setValueAt(peleador1, filaEditar, 1);
                modeloCombates.setValueAt(peleador2, filaEditar, 2);
                modeloCombates.setValueAt(hora, filaEditar, 3);
                modeloCombates.setValueAt(lugar, filaEditar, 4);
            }
        }
    }

    private void limpiarFormulario(JTextField tNombre, JTextField tPeso,
                                   JTextField tVictorias, JTextField tDerrotas) {

        tNombre.setText("");
        tPeso.setText("");
        tVictorias.setText("");
        tDerrotas.setText("");
    }

    public static void main(String[] args) {
        new Mma_admin();
    }
}