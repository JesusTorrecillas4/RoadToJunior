/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

//Ventana que se abre al hacer clic al boton de modificar

import javax.swing.*;
import java.awt.*;

//Mostrara un formulario con los datos del usuario seleccionado
//para poderlos editar

//JDialog en cambio de JFrame:
// Es una ventana secundaraia que depende de la ventana principal
//con modal = true bloqueamos la pantalla principal

public class VentanaEditar extends JDialog{
    
     private void crearFormulario(Usuario usuario) {
       
        
       JLabel lNombre = new JLabel("Name: ");
       JLabel lEmail = new JLabel("Email: ");
       JLabel lEdad = new JLabel("Age");
       
       // Campo texto
       JTextField tNombre = new JTextField(10);
       JTextField tEmail = new JTextField(10);
       JTextField tEdad = new JTextField(10);
       
       
       //Botones
       JButton btnGuardar = new JButton("Save");
       JButton btnSalir = new JButton("Exit");
       
        // Panel de formulario
        JPanel pFormulario = new JPanel();
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
        
        
        
    }
    
    
    private void exit(){
        
        dispose();
    }
    // Constructor que le pasamos la ventana madre y el usuario seleccionado
    public VentanaEditar(JFrame padre, Usuario usuario){
        
        //Llamamos al constructor de JDialog
        //padre --> JFrame
        //titulo
        //true ---> modal: bloqueamos la ventana principal mientras el JDialog
        // este abierta
        
        super(padre, "Edit user "+usuario.getNombre(), true);
        
        setSize(350,220);
        //hija
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // fUNCION PARA DELCARARA EL FORMULARIO
        crearFormulario(usuario);
    }

   
}
