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
   private JButton btnSuma;
   
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
       
       btnSuma.addActionListener(e -> calcular());
       
       add(new JLabel("Resultado: "));
       textResultado = new JTextField(5);
       add(textResultado);
       
       
       setVisible(true);
   }
   
   private void calcular() {
        
       //Convertimos (parseamos/casteamos) el texto del JTextField a Integer
       int numA = Integer.parseInt(textA.getText());
       int numB = Integer.parseInt(textB.getText());
       
       int resultado = numA + numB;
       
       // Como tenemos que añadir el resulatdo que es integer a un JTextField
       // que es un String
       textResultado.setText(String.valueOf(resultado));
    }
   
   
    public static void main(String[] args) {
        new Calculadora("Calculadora Molona");
        
    }

    
    
}
