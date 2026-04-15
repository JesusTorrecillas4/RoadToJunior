/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act15;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class joc extends JFrame{
    
    
    
    public joc(){
         
        setTitle("Simon Dice");
        setSize(800,900);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
        
        setVisible(true);
    }
    
     public void componentes(){
        
        JButton btnVermell = new JButton("Vermell");
        JButton btnVerd = new JButton("Verd");
        JButton btnBlau = new JButton("Blau");
        JButton btnGroc = new JButton("Groc");
        
        JPanel pPrin = new JPanel();
        
        setLayout(new GridLayout());
        
        pPrin.add(btnVermell);
        pPrin.add(btnVerd);
        pPrin.add(btnBlau);
        pPrin.add(btnGroc);
        
        add(pPrin, BorderLayout.CENTER);
    }
     
     
}
