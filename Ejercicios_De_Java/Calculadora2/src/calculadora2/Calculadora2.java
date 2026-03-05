/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class Calculadora2 extends JFrame {

    private JTextField total;
    private JButton btnSumar, btnResta;
    
    public Calculadora2(){
        
        setTitle("Calculadora 2");
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Layout Grid, 4 filas de 4 columnas
        setLayout(new GridLayout(4, 4, 10, 10));
        
        JButton[] btnNumeros = new JButton[10]; 
        for(int i = 0;i<10;i++){
            btnNumeros[i] = new JButton(String.valueOf(i));
            add(btnNumeros[i]);
           
        }
        
        
        
        add(new JLabel(""));
        btnSumar = new JButton("+");
        add(btnSumar);
        
        btnSumar.addActionListener((e) -> sumar());
        
        add(new JLabel(""));
        btnResta = new JButton("-");
        add(btnResta);
        
        add(new JLabel("total"));
        total = new JTextField(5);
        add(total);
        
        
        
        
        
        
        
        setVisible(true);
    }
    private void sumar(){
        
        Integer numerosGuardados1 =  Integer.parseInt(total.getText());
    }
     private void calcular() {
        
         Integer numerosGuardados2 =  Integer.parseInt(total.getText());
         
    }
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        new Calculadora2();
    }

   
    
}
