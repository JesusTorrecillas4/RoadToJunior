/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jesus_torrecillas_act18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class Jesus_Torrecillas_ACT18 extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/act18";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private DefaultTableModel modeloTabla;

    public Jesus_Torrecillas_ACT18() {
        setTitle("CRUD de Usuarios");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        creaComponentes();
        carregarUsuarisDeDB();
        setVisible(true);
    }

    private void creaComponentes() {

        JLabel lNombre = new JLabel("Name: ");
        JLabel lEmail = new JLabel("Email: ");
        JLabel lEdad = new JLabel("Age: ");

        JTextField tNombre = new JTextField(10);
        JTextField tEmail = new JTextField(10);
        JTextField tEdad = new JTextField(10);

        JButton bCreate = new JButton("Create");
        JButton bUpdate = new JButton("Modify");
        JButton bDelete = new JButton("Delete");
        JButton bTasques = new JButton("Gestió Tasques");

        JPanel pFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        pFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pFormulario.add(lNombre);
        pFormulario.add(tNombre);
        pFormulario.add(lEmail);
        pFormulario.add(tEmail);
        pFormulario.add(lEdad);
        pFormulario.add(tEdad);
        pFormulario.setBackground(new Color(48, 184, 176));

        modeloTabla = new DefaultTableModel(new Object[]{"Name", "Email", "Age"}, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane sPane = new JScrollPane(tabla);

        JPanel pBotones = new JPanel();
        pBotones.add(bCreate);
        pBotones.add(bUpdate);
        pBotones.add(bDelete);
        pBotones.add(bTasques);

        setLayout(new BorderLayout());
        add(pFormulario, BorderLayout.NORTH);
        add(sPane, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        bCreate.addActionListener(e -> addUser(tNombre, tEmail, tEdad));

        bDelete.addActionListener(e -> deleteUser(tabla));

        bUpdate.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Please select a user to modify.",
                        "No selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            abrirVentana(filaSeleccionada);
            limpiarFormulario(tNombre, tEmail, tEdad);
        });

        bTasques.addActionListener(e -> new VentanaTasques(this, listaUsuarios));

        tabla.getSelectionModel().addListSelectionListener(
                e -> cargarFilaEnFormulario(tabla, tNombre, tEmail, tEdad));
    }

    private static void crearTaules() {

        String sqlUsuaris = "CREATE TABLE IF NOT EXISTS Usuaris ("
                + " id INT AUTO_INCREMENT PRIMARY KEY,"
                + " nombre VARCHAR(100) NOT NULL,"
                + " email VARCHAR(100) NOT NULL,"
                + " edad INT"
                + ")";

        String sqlTasques = "CREATE TABLE IF NOT EXISTS Tasques ("
                + " id VARCHAR(50) PRIMARY KEY,"
                + " descripcio VARCHAR(255) NOT NULL,"
                + " usuari_asignat VARCHAR(100)"
                + ")";

        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlUsuaris);
            System.out.println("Taula Usuaris creada correctament.");
            stmt.executeUpdate(sqlTasques);
            System.out.println("Taula Tasques creada correctament.");
        } catch (SQLException e) {
            System.out.println("Error en crear les taules: " + e.getMessage());
        }
    }

    private void carregarUsuarisDeDB() {
        String sql = "SELECT nombre, email, edad FROM Usuaris ORDER BY id";
        try (Connection conn = obtenirConexio();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                listaUsuarios.add(new Usuario(nombre, email, edad));
                modeloTabla.addRow(new Object[]{nombre, email, edad});
            }
        } catch (SQLException e) {
            System.out.println("Error carregant usuaris: " + e.getMessage());
        }
    }

    private void abrirVentana(int filaSeleccionada) {
        Usuario usuario = listaUsuarios.get(filaSeleccionada);
        VentanaEditar ventana = new VentanaEditar(this, usuario, listaUsuarios,
                modeloTabla, filaSeleccionada);
        ventana.setVisible(true);
    }

    private void addUser(JTextField tNombre, JTextField tEmail, JTextField tEdad) {

        try {
            Integer.parseInt(tEdad.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Age must be a valid integer",
                    "Invalid age", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = tNombre.getText().trim();
        String email = tEmail.getText().trim();
        int age = Integer.parseInt(tEdad.getText().trim());

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields",
                    "Empty fields", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (age < 0) {
            JOptionPane.showMessageDialog(this,
                    "Age cannot be negative",
                    "Invalid age", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "INSERT INTO Usuaris (nombre, email, edad) VALUES (?, ?, ?)";
        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage(),
                    "ERROR BBDD", JOptionPane.ERROR_MESSAGE);
            return;
        }

        listaUsuarios.add(new Usuario(name, email, age));
        modeloTabla.addRow(new Object[]{name, email, age});
        limpiarFormulario(tNombre, tEmail, tEdad);
    }

    private void deleteUser(JTable tabla) {

        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a user from table to DELETE.",
                    "No selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreUsuario = listaUsuarios.get(filaSeleccionada).getNombre();
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete user \"" + nombreUsuario + "\"?",
                "Confirm delete", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM Usuaris WHERE nombre = ?";
            try (Connection conn = obtenirConexio();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombreUsuario);
                int filasAfectadas = pstmt.executeUpdate();
                System.out.println("DELETE: " + filasAfectadas + " filas eliminadas");
            } catch (SQLException e) {
                System.out.println("Error eliminant: " + e.getMessage());
            }

            listaUsuarios.remove(filaSeleccionada);
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    private void cargarFilaEnFormulario(JTable tabla, JTextField tNombre,
            JTextField tEmail, JTextField tEdad) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            tNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
            tEmail.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
            tEdad.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
        }
    }

    private void limpiarFormulario(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        tNombre.setText("");
        tEmail.setText("");
        tEdad.setText("");
    }

    public static void main(String[] args) {
        crearTaules();
        new Jesus_Torrecillas_ACT18();
    }
}
