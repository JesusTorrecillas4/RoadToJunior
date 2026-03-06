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

    private JTextField total,num1,num2;
    private JButton btnSumar, btnResta, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    
    public Calculadora2(){
        
        setTitle("Calculadora 2");
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Layout Grid, 4 filas de 4 columnas
        setLayout(new GridLayout(4, 4, 10, 10));
        
        /*
        JButton[] btnNumeros = new JButton[10]; 
        for(int i = 0;i<10;i++){
            btnNumeros[i] = new JButton(String.valueOf(i));
            add(btnNumeros[i]);
        }*/
        
        add(new JLabel(""));
        btn1 = new JButton("1");
        add(btn1);
        add(new JLabel(""));
        btn2 = new JButton("2");
        add(btn2);
        add(new JLabel(""));
        btn3 = new JButton("3");
        add(btn3);
        add(new JLabel(""));
        btn4 = new JButton("4");
        add(btn4);
        add(new JLabel(""));
        btn5 = new JButton("5");
        add(btn5);
        add(new JLabel(""));
        btn6 = new JButton("6");
        add(btn6);
        add(new JLabel(""));
        btn7 = new JButton("7");
        add(btn7);
        add(new JLabel(""));
        btn8 = new JButton("8");
        add(btn8);
        add(new JLabel(""));
        btn9 = new JButton("9");
        add(btn9);
        add(new JLabel(""));
        btn0 = new JButton("0");
        add(btn0);
        
        btn1.addActionListener((e) -> sumar("1"));
        btn2.addActionListener((e) -> sumar("2"));
        btn3.addActionListener((e) -> sumar("3"));
        btn4.addActionListener((e) -> sumar("4"));
        btn5.addActionListener((e) -> sumar("5"));
        btn6.addActionListener((e) -> sumar("6"));
        btn7.addActionListener((e) -> sumar("7"));
        btn8.addActionListener((e) -> sumar("8"));
        btn9.addActionListener((e) -> sumar("9"));
        btn0.addActionListener((e) -> sumar("0"));
        
        
        
        
        add(new JLabel(""));
        btnSumar = new JButton("+");
        add(btnSumar);
        
        btnSumar.addActionListener((e) -> sumar("+"));
        
        add(new JLabel(""));
        btnResta = new JButton("-");
        add(btnResta);
        
        add(new JLabel("num1"));
        num1 = new JTextField(5);
        add(num1);
        
        add(new JLabel("num2"));
        num2 = new JTextField(5);
        add(num2);
        
        add(new JLabel("total"));
        total = new JTextField(5);
        add(total);
        
        
        
        
        
        
        
        setVisible(true);
    }
    Integer numerosGuardados1 =  Integer.parseInt(num1.getText());
    private void sumar(String num){
        
        numerosGuardados1 =  Integer.parseInt(num1.getText());
        
        
    }
     private void calcular() {
        
         Integer numerosGuardados2 =  Integer.parseInt(num2.getText());
         
         Integer total = numerosGuardados1 + numerosGuardados2;
        
         //Integer resultado = numerosGuardados1 + numerosGuardados2;
         
    }
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        new Calculadora2();
    }

   
    
}
