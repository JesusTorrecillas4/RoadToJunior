/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesus_torrecillas_act18;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VentanaEditar extends JDialog {

    private static final String URL = "jdbc:mysql://localhost:3306/act18";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection obtenirConexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private JTextField tNombre;
    private JTextField tEmail;
    private JTextField tEdad;

    private final ArrayList<Usuario> listaUsuarios;
    private final DefaultTableModel modeloTabla;
    private final int filaSeleccionada;

    public VentanaEditar(JFrame padre, Usuario usuario, ArrayList<Usuario> listaUsuarios,
            DefaultTableModel modeloTabla, int filaSeleccionada) {

        super(padre, "Edit user " + usuario.getNombre(), true);

        this.listaUsuarios = listaUsuarios;
        this.modeloTabla = modeloTabla;
        this.filaSeleccionada = filaSeleccionada;

        setSize(350, 220);
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        crearFormulario(usuario);
    }

    private void crearFormulario(Usuario usuario) {

        JLabel lNombre = new JLabel("Name: ");
        JLabel lEmail = new JLabel("Email: ");
        JLabel lEdad = new JLabel("Age: ");

        tNombre = new JTextField(10);
        tEmail = new JTextField(10);
        tEdad = new JTextField(10);

        JButton btnGuardar = new JButton("Save");
        JButton btnSalir = new JButton("Exit");

        JPanel pFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        pFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pFormulario.add(lNombre);
        pFormulario.add(tNombre);
        pFormulario.add(lEmail);
        pFormulario.add(tEmail);
        pFormulario.add(lEdad);
        pFormulario.add(tEdad);
        pFormulario.add(btnGuardar);
        pFormulario.add(btnSalir);

        add(pFormulario);

        tNombre.setText(usuario.getNombre());
        tEmail.setText(usuario.getEmail());
        tEdad.setText(String.valueOf(usuario.getEdad()));

        btnGuardar.addActionListener(e -> guardarInfo());
        btnSalir.addActionListener(e -> dispose());
    }

    private void guardarInfo() {

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
        int edad = Integer.parseInt(tEdad.getText().trim());

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields",
                    "Empty fields", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreOriginal = listaUsuarios.get(filaSeleccionada).getNombre();

        Usuario usuario = listaUsuarios.get(filaSeleccionada);
        usuario.setNombre(name);
        usuario.setEmail(email);
        usuario.setEdad(edad);

        modeloTabla.setValueAt(name, filaSeleccionada, 0);
        modeloTabla.setValueAt(email, filaSeleccionada, 1);
        modeloTabla.setValueAt(edad, filaSeleccionada, 2);

        String sql = "UPDATE Usuaris SET nombre = ?, email = ?, edad = ? WHERE nombre = ?";
        try (Connection conn = obtenirConexio();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, edad);
            pstmt.setString(4, nombreOriginal);
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("UPDATE: " + filasAfectadas + " filas modificadas");
        } catch (SQLException e) {
            System.out.println("Error en el update: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Error DB: " + e.getMessage(),
                    "ERROR BBDD", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();
    }
}
