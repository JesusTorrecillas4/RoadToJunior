/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author jesus
 */

// CRUD: CREATE READ UPDATE DELETE
public class CRUD extends JFrame {

    // Creamos el Array de Usuarios
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    // Definimos el modelo que vamos a utilizar en la futura tabla 
    private DefaultTableModel modeloTabla;
    
    public CRUD(){
        
       setTitle("CRUD de Usuarios");
       setSize(500,500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       
       // Creamos los componentes
       creaComponentes();
      
        setVisible(true);
    }
    
    private void creaComponentes() {
        
        // Componentes
        // Etiquetas
        
        JLabel lNombre = new JLabel("Name: ");
        JLabel lEmail = new JLabel("Email: ");
        JLabel lEdad = new JLabel("Age");
        
        // Campo texto
        JTextField tNombre = new JTextField(10);
        JTextField tEmail = new JTextField(10);
        JTextField tEdad = new JTextField(10);
        
        // Botones
        JButton bCreate = new JButton("Create");
        JButton bUpdate = new JButton("Modify");
        JButton bDelete = new JButton("Delete");
       
        // Configurar la tabla (grid) donde vamos a mostrar los usuarios  
        modeloTabla = new DefaultTableModel(new Object[]{"Name","Email","Age"}, 0);
        
        // Grid
        JTable tabla = new JTable(modeloTabla);
        //Añadir scroll a la tabla
        JScrollPane sPane = new JScrollPane(tabla);
        
        // Panel de formulario
        JPanel pFormulario = new JPanel();
        pFormulario.add(lNombre);
        pFormulario.add(tNombre);
        pFormulario.add(lEmail);
        pFormulario.add(tEmail);
        pFormulario.add(lEdad);
        pFormulario.add(tEdad);
        
        // Añadimos los botones al formulario
        pFormulario.add(bCreate);
        pFormulario.add(bUpdate);
        pFormulario.add(bDelete);
        
        // Vamos a organizar los componentes
        setLayout(new BorderLayout());
        add(pFormulario, BorderLayout.NORTH);
        add(sPane, BorderLayout.CENTER);
        
        
        //Boton para crear un usuario
        //LLama a la funcion addUser();
        bCreate.addActionListener(e-> addUser(tNombre, tEmail, tEdad));
        
        //Boton para eliminar un usuario
        //Llama a la funcion deleteUser();
        bDelete.addActionListener(e->deleteUser(tabla));
        
        //Boton par aupdate de usuario
        //Llamar a la funcion updateUser
        bUpdate.addActionListener(e->updateUsuario(tabla, tNombre, tEmail, tEdad));
        
        // Listener para la seleccion
        // Y una vez seleccion de la fila, cargaremos los datos al formulario
        tabla.getSelectionModel().addListSelectionListener(e->cargarFilaEnFormulario(tabla, tNombre, tEmail, tEdad));
        
    }
    
    private void addUser(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
        String name  = tNombre.getText();
        String email = tEmail.getText();
        int age = Integer.parseInt(tEdad.getText());
        
        // Creamos el objeto usuario de la clase Uusario
        Usuario user = new Usuario(name, email, age);
        
        // Añadir el user al arry
        listaUsuarios.add(user);
        
        // Añadir el user a la tabla (grid)
        modeloTabla.addRow(new Object[]{name, email, age});
    }
    
    private void deleteUser(JTable tabla) {
        
        //Creamos variable para guardarnos la fila seleccionada
        int filaSeleccionada = tabla.getSelectedRow();
        
        //Control de errores: mostraremos un pop-up (MessageDaialogo)
        //para si no hay ninguna fila seleccionada que sale el mensaje
        
        if(filaSeleccionada == -1){
            //Mostrar el pop-up
            JOptionPane.showMessageDialog(this, 
                    "Please select a user from table to DELETE.",
                    "No selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Confiramcion de que el usuario SI que quiere borrar el usuario
        //Cogemos el nombre de la fila seleccioanda
        String nombreUsuario = listaUsuarios.get(filaSeleccionada).getNombre();
        
        // Tenemos que guardarnos si el usuario ha clicado SI o NO (True o False)
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "are you sure you want to delete user \""+nombreUsuario +"\"?",
                "Confirm to delete", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        //Solo borramos si es YES
        if(confirmacion == JOptionPane.YES_OPTION){
            //Eliminamos primero del ArryList
            listaUsuarios.remove(filaSeleccionada);
            
            //Elimminamos de la tabla
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    
    // Funcion para modificar
    private void updateUsuario(JTable tabla, JTextField tNombre, JTextField tEmail, JTextField tEdad) {
       
         //Fila seleccionada con el index del array (grid)
         int filaSeleccionada = tabla.getSelectedRow();
         
         //Control de errores
         if(filaSeleccionada == -1){
             
             JOptionPane.showMessageDialog(this,
                     "Please select a user from the table to modify",
                     "Selection chato",
                     JOptionPane.WARNING_MESSAGE);
         }
         
         //control de errores
         //Validar que los campos del formulario no esten vacios
         //if(!camposValidos(tNombre, tEmail, tEdad)) return;
    }
    
     /*private boolean camposValidos(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
    }*/
    
    private void cargarFilaEnFormulario(JTable tabla, JTextField tNombre, JTextField tEmail, JTextField tEdad){
        
        int filaSeleccionada = tabla.getSelectedRow();
        
        //Si que hay una fila seleccionada
        if(filaSeleccionada != -1){
            tNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
            tEmail.setText(modeloTabla.getValueAt(filaSeleccionada,1).toString());
            tEdad.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
        }
    }
    
    
    
    
    public static void main(String[] args) {
        new CRUD();
    }

   

    

    
    

    
    
}
