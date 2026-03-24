/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
       
        // Panel de formulario
        JPanel pFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        pFormulario.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pFormulario.add(lNombre);
        pFormulario.add(tNombre);
        pFormulario.add(lEmail);
        pFormulario.add(tEmail);
        pFormulario.add(lEdad);
        pFormulario.add(tEdad);
        pFormulario.setBackground(new Color(48, 184, 176));
        
        // Configurar la tabla (grid) donde vamos a mostrar los usuarios  
        modeloTabla = new DefaultTableModel(new Object[]{"Name","Email","Age"}, 0);
        
        // Grid
        JTable tabla = new JTable(modeloTabla);
        //Añadir scroll a la tabla
        JScrollPane sPane = new JScrollPane(tabla);
        
        // Añadimos los botones al formulario
        JPanel pBotones = new JPanel();
        pBotones.add(bCreate);
        pBotones.add(bUpdate);
        pBotones.add(bDelete);
        
        // Vamos a organizar los componentes
        setLayout(new BorderLayout());
        add(pFormulario, BorderLayout.NORTH);
        add(sPane, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);
        
        
        //Boton para crear un usuario
        //LLama a la funcion addUser();
        bCreate.addActionListener(e-> addUser(tNombre, tEmail, tEdad));
        
        //Boton para eliminar un usuario
        //Llama a la funcion deleteUser();
        bDelete.addActionListener(e->deleteUser(tabla));
        
        //Boton par aupdate de usuario
        //Llamar a la funcion updateUser
        //bUpdate.addActionListener(e->updateUsuario(tabla, tNombre, tEmail, tEdad));
        
        //Al clicar al boton abriremos la nueva ventana(JDialog)
        //Para poder editar los datos de la fila seleccionada
        //Primero tenemos que validar si hay una fila seleccionada
        
         bUpdate.addActionListener(e->{

             int filaSeleccionada = tabla.getSelectedRow();
             
             if(filaSeleccionada == -1){
                 JOptionPane.showMessageDialog(this,"Please select a user to modify",
                         "No selection", JOptionPane.WARNING_MESSAGE);
                 return;
                        
             }

             abrirVentana(filaSeleccionada);
             limpiarFormulario(tNombre, tEmail, tEdad);
        });          
        // Listener para la seleccion
        // Y una vez seleccion de la fila, cargaremos los datos al formulario
        tabla.getSelectionModel().addListSelectionListener(e->cargarFilaEnFormulario(tabla, tNombre, tEmail, tEdad));
        
    }
    
    // Abrir ventana de edicion
    // Crearemos la ventana "ventanaEditar" pasandole el objeto Usuario a editar
    // Cargaremos los datos al formulario
    // isGuardado() --> Metodo para controlar que todo ha salido correctamante
    private void abrirVentana(int filaSeleccionada){
        
       
        Usuario usuario = listaUsuarios.get(filaSeleccionada);
        
        VentanaEditar ventana = new VentanaEditar(this, usuario, listaUsuarios, 
                modeloTabla, filaSeleccionada);
        // La ventana se ahce visible y se queda aqui esperando
        ventana.setVisible(true);
    }
    
    private void addUser(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
        //try-catch: Control de errores
         //NumberException: para verificar que un argumento(varaible, etc)
         // un numero
         try{
             // Lo que vamos a validar
             //Si no es okey saltara el catch
             // Comprobamos que la edad sea un numero entero
             Integer.parseInt(tEdad.getText().trim());
             
         }catch(NumberFormatException ex){
             
             //Pop-up informanod de que la edad no es un numero
             JOptionPane.showMessageDialog(this,
                     "Age must be a valid integer",
                     "Invalid age", JOptionPane.WARNING_MESSAGE);
             return;
         }
         
        String name  = tNombre.getText().trim();
        String email = tEmail.getText().trim();
        int age = Integer.parseInt(tEdad.getText().trim());
        
        
        
        // Creamos el objeto usuario de la clase Uusario
        Usuario user = new Usuario(name, email, age);
        
        // Añadir el user al arry
        listaUsuarios.add(user);
        
        // Añadir el user a la tabla (grid)
        modeloTabla.addRow(new Object[]{name, email, age});
        limpiarFormulario(tNombre, tEmail, tEdad);
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
         if(!camposValidos(tNombre, tEmail, tEdad)) return;
         
         String name = tNombre.getText().trim();
         String email = tEmail.getText().trim();
         int age = Integer.parseInt(tEdad.getText().trim());
         
         //Actualizamso el array de Usuarios
         Usuario user = listaUsuarios.get(filaSeleccionada);
         
         //Actualizar datos en un array
         user.setNombre(name);
         user.setEmail(email);
         user.setEdad(age);
         
         //A(name, filaSeleccionada, 0);ctualizar la fila en el modelo de la grid(tabla)
         modeloTabla.setValueAt(name, filaSeleccionada, 0);
         modeloTabla.setValueAt(email, filaSeleccionada, 1);
         modeloTabla.setValueAt(age, filaSeleccionada, 2);
         
         //Limpiamos el formulario y deseleccionamos la fila
         limpiarFormulario(tNombre, tEmail, tEdad);
         tabla.clearSelection();
    }
    
    
    
     private boolean camposValidos(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
         //trim: para limpiar los espacios en blanco
         // Validamos que los campos no estan vacios
         if(tNombre.getText().trim().isEmpty() 
                 || tEmail.getText().trim().isEmpty()
                 || tEdad.getText().trim().isEmpty()){
             
             JOptionPane.showMessageDialog(this,
                     "Please write a little in fields",
                     "Can't field empty", JOptionPane.WARNING_MESSAGE);
             return false;
         }
         
         //try-catch: Control de errores
         //NumberException: para verificar que un argumento(varaible, etc)
         // un numero
         try{
             // Lo que vamos a validar
             //Si no es okey saltara el catch
             // Comprobamos que la edad sea un numero entero
             Integer.parseInt(tEdad.getText().trim());
             
         }catch(NumberFormatException ex){
             
             //Pop-up informanod de que la edad no es un numero
             JOptionPane.showMessageDialog(this,
                     "Age must be a valid integer",
                     "Invalid age", JOptionPane.WARNING_MESSAGE);
             return false;
         }
         
         
         return true;
         
    }
    
    private void cargarFilaEnFormulario(JTable tabla, JTextField tNombre, JTextField tEmail, JTextField tEdad){
        
        int filaSeleccionada = tabla.getSelectedRow();
        
        //Si que hay una fila seleccionada
        if(filaSeleccionada != -1){
            tNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
            tEmail.setText(modeloTabla.getValueAt(filaSeleccionada,1).toString());
            tEdad.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
        }
    }
    
    private void limpiarFormulario(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
        tNombre.setText("");
        tEmail.setText("");
        tEdad.setText("");
    }

    
    
    public static void main(String[] args) {
        new CRUD();
    }

    
   

    

    
    

    
    
}
