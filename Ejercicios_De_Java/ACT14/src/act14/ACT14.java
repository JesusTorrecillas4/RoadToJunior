/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act14;

import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author jesus
 */
public class ACT14 extends JFrame {
    
    
    public ACT14(){
        
        setTitle("Gestió d'Usuaris");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        crearComponentes();
        setVisible(true);
    }
    
    private void crearComponentes(){
        
         JLabel lGdu = new JLabel("Gestió d'Usuaris");
         
         JButton btnGU = new JButton("Gestió d'Usuaris");
         JButton btnExit = new JButton("Sortir");
         
         JPanel pPrincipal = new JPanel();
         
         pPrincipal.add(lGdu);
         pPrincipal.add(btnGU);
         pPrincipal.add(btnExit);
         
         btnGU.addActionListener(e -> gesUsu());
         btnExit.addActionListener(e -> dispose());
         add(pPrincipal);
    }
    
    public void gesUsu(){
        
        gu pagGu = new gu();
        
        pagGu.setVisible(true);
    }
    
    
    public static void main(String[] args) {
       
        new ACT14();
        
    }
    
}
