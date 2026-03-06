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
        
        bCreate.addActionListener(e-> addUser(tNombre, tEmail, tEdad));
        
        
        
        
        
        
    }
    
    private void addUser(JTextField tNombre, JTextField tEmail, JTextField tEdad) {
        
        String name  = tNombre.getText();
        String email = tEdad.getText();
        int age = Integer.parseInt(tEdad.getText());
        
        // Creamos el objeto usuario de la clase Uusario
        Usuario user = new Usuario(name, email, age);
        
        // Añadir el user al arry
        listaUsuarios.add(user);
        
        // Añadir el user a la tabla (grid)
        modeloTabla.addRow(new Object[]{name, email, age});
    }
    
    
    public static void main(String[] args) {
        new CRUD();
    }

    

    
    
}
