/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class Calculadora extends JFrame {

   private JTextField textA, textB, textResultado;
   private JButton btnSuma, btnResta, btnDivi, btnMulti, btnNumero;
   
   public Calculadora(String titulo){
       
       setTitle(titulo);
       setSize(300, 200);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       
       
       //Layout Grid
       setLayout(new GridLayout(4, 2, 10, 10));
       
       //Etiqueta del primer valor
       add(new JLabel("Valor A:"));
       textA = new JTextField(5);
       add(textA);
       
       //Etiqueta del segudno valor
       add(new JLabel("Valor B:"));
       textB = new JTextField(5);
       add(textB);
       
       add(new JLabel(""));
       btnSuma = new JButton("+");
       add(btnSuma);
       
       /*btnSuma.addActionListener(e -> calcularSuma());*/
       btnSuma.addActionListener(e -> calcular("+"));
       
       add(new JLabel(""));
       btnResta = new JButton("-");
       add(btnResta);
        btnResta.addActionListener(e -> calcular("-"));
       
        add(new JLabel(""));
       btnDivi = new JButton("/");
       add(btnDivi);
       
       btnDivi.addActionListener(e -> calcular("/"));
       
        add(new JLabel(""));
       btnMulti = new JButton("X");
       add(btnMulti);
       
       btnMulti.addActionListener(e -> calcular("*"));
         
       add(new JLabel("Resultado: "));
       textResultado = new JTextField(5);
       add(textResultado);
       
       
       setVisible(true);
   }
   
   private void calcular(String op){
       
       
       
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado;
       switch(op){
           
           case "+":
               
                resultado = numA + numB;
                textResultado.setText(String.valueOf(resultado));
               break;
            case "-":
               
               resultado = numA - numB;
               textResultado.setText(String.valueOf(resultado));
               break;
            case "/":
               
               resultado = numA / numB;
               textResultado.setText(String.valueOf(resultado));
               break;
            case "*":
               
               resultado = numA * numB;
               textResultado.setText(String.valueOf(resultado));
               break;
            default:
                
                System.out.println("Operacion Incorrecta");
                break;
                 
       }
   }
   
   /*
   private void calcularSuma() {
        
       //Convertimos (parseamos/casteamos) el texto del JTextField a Integer
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado = numA + numB;
       
       // Como tenemos que añadir el resulatdo que es integer a un JTextField
       // que es un String
       textResultado.setText(String.valueOf(resultado));
    }
   
   private void calcularResta() {
        
       //Convertimos (parseamos/casteamos) el texto del JTextField a Integer
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado = numA - numB;
       
       // Como tenemos que añadir el resulatdo que es integer a un JTextField
       // que es un String
       textResultado.setText(String.valueOf(resultado));
    }
   
   private void calcularDivi() {
        
       //Convertimos (parseamos/casteamos) el texto del JTextField a Integer
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado = numA / numB;
       
       // Como tenemos que añadir el resulatdo que es integer a un JTextField
       // que es un String
       textResultado.setText(String.valueOf(resultado));
    }
   
     private void calcularMulti() {
        
       //Convertimos (parseamos/casteamos) el texto del JTextField a Integer
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado = numA * numB;
       
       // Como tenemos que añadir el resulatdo que es integer a un JTextField
       // que es un String
       textResultado.setText(String.valueOf(resultado));
    }
      */   
    public static void main(String[] args) {
        new Calculadora("Calculadora");
        
    }

    
    
}
