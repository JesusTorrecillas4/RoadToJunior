/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alltest;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        
        JPanel pPrincipal = new JPanel(new GridLayout(4,2,10,10));
        
        setLayout(new BorderLayout());
        
        pPrincipal.add(lName);
        pPrincipal.add(tName);
        pPrincipal.add(lAge);
        pPrincipal.add(tAge);
        pPrincipal.add(btnCreate);
        pPrincipal.add(btnDelete);
        pPrincipal.add(btnModify);  
        
        modeloTabla = new DefaultTableModel(new Object[]{"Name", "Age"},0);
        JTable tabla = new JTable(modeloTabla);
        
        JPanel pBtn = new JPanel();
        pBtn.setBackground(Color.blue);
        pBtn.add(btnPantalla2);
        
        JScrollPane pMedio = new JScrollPane(tabla);
        
        
        add(pMedio, BorderLayout.CENTER);
        add(pPrincipal, BorderLayout.NORTH);
        add(pBtn, BorderLayout.SOUTH);
        
        
       
        
        btnCreate.addActionListener(e->addUser(tName, tAge));
        btnDelete.addActionListener(e->deleteUser(tabla));
        btnModify.addActionListener(e ->{
        
             int seleccion = tabla.getSelectedRow();
            
             if(seleccion < 0){
                
                 JOptionPane.showMessageDialog(this, "Select a an user please","User Error",JOptionPane.WARNING_MESSAGE);
                 return;
                }
           
            modify(seleccion);
        });
        btnPantalla2.addActionListener(e -> {
        
                 pag2 pant = new pag2(this);
                 pant.setVisible(true);
        });
        
        
    }
    
    private void addUser(JTextField tName, JTextField tAge){
        
        try{
            int age = Integer.parseInt(tAge.getText().trim());
            
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(this,
                    "This age is invalid you need use a real age",
                    "Invalid Age", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String name = tName.getText().trim();
        int age = Integer.parseInt(tAge.getText().trim());
        
        Usuario usu = new Usuario(name,age);
        
        Usuarios.add(usu);
        modeloTabla.addRow(new Object[]{name,age});
    }
    
    private void deleteUser(JTable tabla){
        
        int seleccionado = tabla.getSelectedRow();
        
        Usuarios.remove(seleccionado);
        modeloTabla.removeRow(seleccionado);
    }
   
    private void modify(int seleccion){
        
        Usuario usuario = Usuarios.get(seleccion);
        
        modificar mod = new modificar(this, usuario, Usuarios,         
        modeloTabla, seleccion);
        
        mod.setVisible(true);
    }
  
    public static void main(String[] args) {
       
        
        new AllTest();
        
    }
    
}
