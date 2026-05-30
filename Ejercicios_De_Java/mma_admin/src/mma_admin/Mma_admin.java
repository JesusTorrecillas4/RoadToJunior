package mma_admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Mma_admin extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/mma_admin";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

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
        carregarLuchadoresDeDB();

        setVisible(true);
    }

    private static void crearTaules() {

        String sqlLuchadores = "CREATE TABLE IF NOT EXISTS Luchadores ("
                + " id INT AUTO_INCREMENT PRIMARY KEY,"
                + " nombre VARCHAR(100) NOT NULL,"
                + " categoria VARCHAR(100) NOT NULL,"
                + " peso DOUBLE,"
                + " victorias INT,"
                + " derrotas INT,"
                + " ranking INT"
                + ")";
        
        String sqlCombates = "CREATE TABLE IF NOT EXISTS Combates ("
                + " id VARCHAR(50) PRIMARY KEY,"
                + " luchador1 VARCHAR(100) NOT NULL,"
                + " luchador2 VARCHAR(100) NOT NULL,"
                + " hora VARCHAR(20),"
                + ")";

        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sqlLuchadores);
            System.out.println("Taula Luchadores creada correctament.");
            stmt.executeUpdate(sqlCombates);
            System.out.println("Taula Combates creada correctament.");

        } catch (SQLException e) {
            System.out.println("Error en crear les taules: " + e.getMessage());
        }
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

        bCrear.addActionListener(e ->
                addLuchador(tNombre, cbCategoria, tPeso,
                        tVictorias, tDerrotas, cbRanking));

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

        bEliminar.addActionListener(e -> deleteLuchador(tabla));
    }

    private void addLuchador(JTextField tNombre,
                         JComboBox<String> cbCategoria,
                         JTextField tPeso,
                         JTextField tVictorias,
                         JTextField tDerrotas,
                         JComboBox<String> cbRanking) {

    try {
        Double.parseDouble(tPeso.getText().trim());
        Integer.parseInt(tVictorias.getText().trim());
        Integer.parseInt(tDerrotas.getText().trim());

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(this,
                "Peso, victorias y derrotas deben ser números",
                "Datos inválidos",
                JOptionPane.WARNING_MESSAGE);

        return;
    }

    String nombre = tNombre.getText().trim();
    String categoria = cbCategoria.getSelectedItem().toString();
    double peso = Double.parseDouble(tPeso.getText().trim());
    int victorias = Integer.parseInt(tVictorias.getText().trim());
    int derrotas = Integer.parseInt(tDerrotas.getText().trim());
    int ranking = Integer.parseInt(cbRanking.getSelectedItem().toString());

    if (nombre.isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "Rellena el nombre",
                "Campo vacío",
                JOptionPane.WARNING_MESSAGE);

        return;
    }

    // COMPROBAR SI EL RANKING YA EXISTE EN ESA CATEGORIA
    for (Luchador l : listaLuchadores) {

        if (l.getCategoria().equals(categoria)
                && l.getRanking() == ranking) {

            JOptionPane.showMessageDialog(this,
                    "Ese ranking ya está ocupado en " + categoria);

            return;
        }
    }

    String sql = "INSERT INTO Luchadores "
            + "(nombre, categoria, peso, victorias, derrotas, ranking) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = obtenirConexio();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, nombre);
        pstmt.setString(2, categoria);
        pstmt.setDouble(3, peso);
        pstmt.setInt(4, victorias);
        pstmt.setInt(5, derrotas);
        pstmt.setInt(6, ranking);

        pstmt.executeUpdate();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage(),
                "ERROR BBDD",
                JOptionPane.ERROR_MESSAGE);

        return;
    }

    listaLuchadores.add(
            new Luchador(nombre, categoria, peso,
                    victorias, derrotas, ranking)
    );

    modeloTabla.addRow(new Object[]{
        nombre, categoria, peso,
        victorias, derrotas, ranking
    });

    limpiarFormulario(tNombre, tPeso, tVictorias, tDerrotas);
}

    private void deleteLuchador(JTable tabla) {

        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(this,
                    "Selecciona un luchador para eliminar",
                    "No selection",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        String nombreLuchador =
                listaLuchadores.get(filaSeleccionada).getNombre();

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres eliminar a \"" + nombreLuchador + "\"?",
                "Confirmar eliminar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM Luchadores WHERE nombre = ?";

            try (Connection conn = obtenirConexio();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, nombreLuchador);

                pstmt.executeUpdate();

            } catch (SQLException e) {

                System.out.println("Error eliminant: " + e.getMessage());
            }

            listaLuchadores.remove(filaSeleccionada);
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    private void carregarLuchadoresDeDB() {

        String sql = "SELECT nombre, categoria, peso, victorias, derrotas, ranking "
                + "FROM Luchadores ORDER BY id";

        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double peso = rs.getDouble("peso");
                int victorias = rs.getInt("victorias");
                int derrotas = rs.getInt("derrotas");
                int ranking = rs.getInt("ranking");

                listaLuchadores.add(
                        new Luchador(nombre, categoria,
                                peso, victorias,
                                derrotas, ranking)
                );

                modeloTabla.addRow(new Object[]{
                    nombre, categoria, peso,
                    victorias, derrotas, ranking
                });
            }

        } catch (SQLException e) {

            System.out.println("Error carregant luchadores: "
                    + e.getMessage());
        }
    }

    private void abrirVentana(int filaSeleccionada) {

        VentanaModificarLuchador ventana =
                new VentanaModificarLuchador(
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
        
        VentanaCombates ventana = new VentanaCombates(this, listaLuchadores, listaCombates);
        ventana.setVisible(true);
    }

    private void limpiarFormulario(JTextField tNombre,
                                   JTextField tPeso,
                                   JTextField tVictorias,
                                   JTextField tDerrotas) {

        tNombre.setText("");
        tPeso.setText("");
        tVictorias.setText("");
        tDerrotas.setText("");
    }

    public static void main(String[] args) {

        crearTaules();

        new Mma_admin();
    }
}