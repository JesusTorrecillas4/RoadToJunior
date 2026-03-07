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
    private JButton btnSumar, btnResta,btnDivi, btnMulti, btnIgual, btnReset; 
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    
    private boolean segundaOperacion = false;
    
    private int resultado;
    private String operacion;
    
    public Calculadora2(){
        
        setTitle("Calculadora 2");
        setSize(500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Layout Grid, 4 filas de 4 columnas
        setLayout(new GridLayout(7, 4, 10, 10));
        
        
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
        
        btn1.addActionListener((e) -> numeros("1"));
        btn2.addActionListener((e) -> numeros("2"));
        btn3.addActionListener((e) -> numeros("3"));
        btn4.addActionListener((e) -> numeros("4"));
        btn5.addActionListener((e) -> numeros("5"));
        btn6.addActionListener((e) -> numeros("6"));
        btn7.addActionListener((e) -> numeros("7"));
        btn8.addActionListener((e) -> numeros("8"));
        btn9.addActionListener((e) -> numeros("9"));
        btn0.addActionListener((e) -> numeros("0"));
        
        
        
        
        add(new JLabel(""));
        btnSumar = new JButton("+");
        add(btnSumar);
        
        btnSumar.addActionListener((e) -> calculo("+"));
        
        add(new JLabel(""));
        btnResta = new JButton("-");
        add(btnResta);
        
        btnResta.addActionListener(e -> calculo("-"));
        
        add(new JLabel(""));
        btnDivi = new JButton("/");
        add(btnDivi);
        
        btnDivi.addActionListener(e -> calculo("/"));
        
        add(new JLabel(""));
        btnMulti = new JButton("X");
        add(btnMulti);
        
        btnMulti.addActionListener(e -> calculo("x"));
        
        add(new JLabel(""));
        btnIgual = new JButton("=");
        add(btnIgual);
        
        btnIgual.addActionListener(e -> resultado());
        
        add(new JLabel(""));
        btnReset = new JButton("C");
        add(btnReset);
        
        btnReset.addActionListener(e -> resetear());
        
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
    
    
    private void numeros(String numero){
        
        if(segundaOperacion == false){
            
             num1.setText(num1.getText() + numero);
             
        }else{
            
             num2.setText(num2.getText() + numero);
        }
        
    }
    
    private void calculo(String op){
        
        operacion = op;
        segundaOperacion = true;
        
    }
    
    private void resultado() {
        
          
        Integer num1I = Integer.parseInt(num1.getText());
        Integer num2I = Integer.parseInt(num2.getText());
        
        if(operacion.equals("+")){
            
              resultado = num1I + num2I;
        }else if(operacion.equals("-")){
              resultado = num1I - num2I;
        }else if(operacion.equals("/")){
            resultado = num1I / num2I;
        }else{
            resultado = num1I * num2I;
        }
    
        total.setText(String.valueOf(resultado));
    }
    
    private void resetear(){
        
        num1.setText("");
        num2.setText("");
        total.setText("");
        segundaOperacion = false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        new Calculadora2();
    }

    

   
    
}
