/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

//Ventana que se abre al hacer clic al boton de modificar

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

//Mostrara un formulario con los datos del usuario seleccionado
//para poderlos editar

//JDialog en cambio de JFrame:
// Es una ventana secundaraia que depende de la ventana principal
//con modal = true bloqueamos la pantalla principal

public class VentanaEditar extends JDialog{
    
    //Campos nuevos modificados de formulario
    private JTextField tNombre;
    private JTextField tEmail;
    private JTextField tEdad;

    //Componentes pasados por parametros
    private final ArrayList<Usuario> listaUsuarios;
    private final DefaultTableModel modeloTabla;
    private final int filaSeleccionada;
    
    
    private void crearFormulario(Usuario usuario) {
       
        
       JLabel lNombre = new JLabel("Name: ");
       JLabel lEmail = new JLabel("Email: ");
       JLabel lEdad = new JLabel("Age");
       
       // Campo texto
       tNombre = new JTextField(10);
       tEmail = new JTextField(10);
       tEdad = new JTextField(10);
       
       
       //Botones
       JButton btnGuardar = new JButton("Save");
       JButton btnSalir = new JButton("Exit");
       
        // Panel de formulario
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
        btnSalir.addActionListener(e-> exit());
        
        
        
    }
    
    private void guardarInfo(){
        
        try{
            
            Integer.parseInt(tEdad.getText().trim());
            
        }catch(NumberFormatException ex){
            
                JOptionPane.showMessageDialog(this,
                     "Age must be a valid integer",
                     "Invalid age", JOptionPane.WARNING_MESSAGE);
             return;
            
            
        }
        String name = tNombre.getText().trim();
        String email = tEmail.getText().trim();
        int edad = Integer.parseInt(tEdad.getText());
        
        //Modificamos usuario en el ArrayList original
        Usuario usuario = listaUsuarios.get(filaSeleccionada);
        usuario.setNombre(name);
        usuario.setEmail(email);
        usuario.setEdad(edad);
        
        //Modificar los datos de la tabla para que se vean correctamente
        modeloTabla.setValueAt(name, filaSeleccionada, 0);
        modeloTabla.setValueAt(email, filaSeleccionada, 1);
        modeloTabla.setValueAt(edad, filaSeleccionada, 2);

        dispose();
        
    }
    
    
    private void exit(){
        
        dispose();
    }
    
    
    // Constructor que le pasamos la ventana madre y el usuario seleccionado
    public VentanaEditar(JFrame padre, Usuario usuario, ArrayList<Usuario> listaUsuarios, 
            DefaultTableModel modeloTabla, int filaSeleccionada){
        
        //Llamamos al constructor de JDialog
        //padre --> JFrame
        //titulo
        //true ---> modal: bloqueamos la ventana principal mientras el JDialog
        // este abierta
        
        super(padre, "Edit user "+usuario.getNombre(), true);
        
        this.listaUsuarios = listaUsuarios;
        this.modeloTabla = modeloTabla;
        this.filaSeleccionada = filaSeleccionada;
                
        setSize(350,220);
        //hija
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // fUNCION PARA DELCARARA EL FORMULARIO
        crearFormulario(usuario);
    }

   
}
