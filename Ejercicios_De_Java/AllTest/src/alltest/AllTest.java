/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alltest;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class AllTest extends JFrame{

    ArrayList<Usuario> Usuarios = new ArrayList<>();
    
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
        
        JPanel pPrincipal = new JPanel(new GridLayout(2,2,10,10));
        
        setLayout(new BorderLayout());
        
        pPrincipal.add(lName);
        pPrincipal.add(tName);
        pPrincipal.add(lAge);
        pPrincipal.add(tAge);
        
        add(pPrincipal, BorderLayout.CENTER);
        
        
    }
    
    public static void main(String[] args) {
       
        
        new AllTest();
        
    }
    
}
