/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alltest;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

/**
 *
 * @author jesus
 */
public class AllTest extends JFrame{

    private ArrayList<Usuario> Usuarios = new ArrayList<>();
    
    private DefaultTableModel modeloTabla;
    
    public AllTest(){
        
        setTitle("Test Java");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
        
        componentes();
      
        setVisible(true);
    }
    
    private void componentes(){
        
        
        JLabel lName = new JLabel("Name");
        JLabel lAge = new JLabel("Age");
       
        JTextField tName = new JTextField(10);
        JTextField tAge = new JTextField(10);
        
        JButton btnCreate = new JButton("Crear");
        JButton btnDelete = new JButton("Delete");
        JButton btnModify = new JButton("Modify");
        JButton btnPantalla2 = new JButton("Pag 2");
        JButton btnMenu = new JButton("Menu");
        //Panel principal
        JPanel pPrincipal = new JPanel(new GridLayout(4,2,10,10));
        
         //Declaro set layout para luego definir en que lugar poner el panel 
        setLayout(new BorderLayout());
        
        //Añado los componentes al panel
        pPrincipal.add(lName);
        pPrincipal.add(tName);
        pPrincipal.add(lAge);
        pPrincipal.add(tAge);
        pPrincipal.add(btnCreate);
        pPrincipal.add(btnDelete);
        pPrincipal.add(btnModify);  
        
        //Esto es para el border MARGIN 
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         
        // Cambaismo la font para que sea mas guay
        tName.setFont(new Font("Consolas",Font.BOLD, 28));
        tName.setBackground(new Color(169, 237, 252));
        
        // Cambiamos el color del texto
        tName.setForeground(Color.black);
        
        // Para el border entre los botones
        tName.setBorder(BorderFactory.createCompoundBorder(
        
                BorderFactory.createLineBorder(new Color(0, 191, 255), 1),
                BorderFactory.createEmptyBorder(10, 5, 10, 5)
        ));
        
        //Creo un deafultTablemodel que es lo que ba dentro de la tabla (la info)
        modeloTabla = new DefaultTableModel(new Object[]{"Name", "Age"},0);
        
        //Añado la info a la tabla
        JTable tabla = new JTable(modeloTabla);
        
        //Creo un panel para los botones
        JPanel pBtn = new JPanel();
        
        //Defino el color de fondo del boton
        pBtn.setBackground(Color.blue);
        pBtn.add(btnPantalla2);
        pBtn.add(btnMenu);
        //Creo un JScroll como panel para la tabla
        //Sine esto no funciona
        JScrollPane pMedio = new JScrollPane(tabla);
        
        //Añado los paneles al JFrame y les pongo en su posicion
        add(pMedio, BorderLayout.CENTER);
        add(pPrincipal, BorderLayout.NORTH);
        add(pBtn, BorderLayout.SOUTH);
        
        
       
        //Las acciones de los botones
        btnCreate.addActionListener(e->addUser(tName, tAge));
        btnDelete.addActionListener(e->deleteUser(tabla));
        
        //Esto abre otra pantalla JDialog
        btnModify.addActionListener(e ->{
        
             int seleccion = tabla.getSelectedRow();
            
             //Comprovacion de errores si no seleccionas nada
             if(seleccion < 0){
                
                 JOptionPane.showMessageDialog(this, "Select a an user please","User Error",JOptionPane.WARNING_MESSAGE);
                 return;
                }
           
            //Si has seleccionado un usuario entras al metodo
            modify(seleccion);
        });
        
        //Otro metodo para abrir otra pantalla
        btnPantalla2.addActionListener(e -> {
        
                //Creo un objeto de la nueva ventana y le paso este JFrame
                 pag2 pant = new pag2(this);
                 
                 //Lo hago visible aqui para que cuadno clique se abra y se vea
                 pant.setVisible(true);
        });
        
        btnMenu.addActionListener(e -> {
        
                Menu m = new Menu(this);
                
                m.setVisible(true);
        
        
        });
        
        
    }
    
    //Metodo para añadir usuarios
    private void addUser(JTextField tName, JTextField tAge){
        
        //Comprobamos que la edad sea un numero
        try{
            int age = Integer.parseInt(tAge.getText().trim());
            
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(this,
                    "This age is invalid you need use a real age",
                    "Invalid Age", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        //Paso los JTextField a String e integer
        String name = tName.getText().trim();
        int age = Integer.parseInt(tAge.getText().trim());
        
        //Esto es para abrir un archivo y meter dentro el nombre y la edad
        try{
            FileWriter escritura = new FileWriter("usuarios.txt", true);
            
            escritura.write("Name: "+name+ " \n");
            escritura.write("Age: "+age);
            
            escritura.close();
            
        }catch(IOException e){
            
            System.out.println("Error: "+e.getMessage());
        }
        //Creo un objeto con los parametros que avabo de transformar
        Usuario usu = new Usuario(name,age);
        
        //Añado el objeto al ArrayList
        Usuarios.add(usu);
        
        //Añado Creo el Objeto en la info de la tabla
        modeloTabla.addRow(new Object[]{name,age});
    }
    
    //Metodo para eliminar user, le pasamos la tabla
    private void deleteUser(JTable tabla){
        
        
        
        //Comprobamos cual esta seleccioando
        int seleccionado = tabla.getSelectedRow();
            
        if(seleccionado == -1){
            
            JOptionPane.showMessageDialog(this,"Error you need select an user",
            "Invalid method",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        //Lo eliminamos del arryList
        Usuarios.remove(seleccionado);
        //Lo eliminamos de la tabla
        modeloTabla.removeRow(seleccionado);
        
        
       
    }
   
    //Metodo de  modificar que abre un JDialog, se le pasa la seleccion
    private void modify(int seleccion){
        
        //Cojo el usuario que ha seleccionado el usuario en la tabla
        Usuario usuario = Usuarios.get(seleccion);
        
        //Creamos un objeto para la ventana en el que le pasamos
        //this - la ventana padre
        //usuario - el usuario a modifi
        //Usuarios - lista completa
        //modeloTabla - para actualizar la Tabla
        //seleccion - posicio del usuario
        modificar mod = new modificar(this, usuario, Usuarios,         
        modeloTabla, seleccion);
        
        mod.setVisible(true);
    }
  
    public static void main(String[] args) {
       
        
        new AllTest();
        
    }
    
}
