/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swingtest;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class SwingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // JFrame: Ventana Principal, tiene que estar SIEMPRE
        JFrame ventana = new JFrame("Titulo de la ventana");
        
        // setSize: Tamaño de la ventana (w,h)
        ventana.setSize(300, 150);
        
        //Cerrar la aplicacion cuando le damos a la "X" de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JPanel: contenedores(<div>)
        JPanel panel = new JPanel();
        
        // Creamos nu array para añadirlo para añadirlo a un JComboBox
        String[] opciones ={"Manzana","Naranja","Platano"};
        
        //JComoboBox: select opction del html
        JComboBox frutas = new JComboBox(opciones);
        
        //JButton: boton
        JButton boton = new JButton("Enviar");
        
        // JCheckBox: casilla de verificacion
        JCheckBox casilla1 = new JCheckBox("Opcion A");
        JCheckBox casilla2 = new JCheckBox("Opcion B");
        
        // JRadioButton siempre va casado con ButtonGroup
        JRadioButton rb1 = new JRadioButton("Rojo");
        JRadioButton rb2 = new JRadioButton("Verde");
        JRadioButton rb3 = new JRadioButton("Amarillo");
        JRadioButton rb4 = new JRadioButton("Negro");
        
        // ButtonGroup: para agrupar los JRadioButton
        ButtonGroup gColores = new ButtonGroup();
        gColores.add(rb1);
        gColores.add(rb2);
        gColores.add(rb3);
        gColores.add(rb4);
       
        
        // JLabel: texto (<p>)
        JLabel label = new JLabel("Holaa me llamo Jesus");
        JLabel nom = new JLabel("Nombre");
        JLabel Apellido = new JLabel("Apellido");
        
        
        //JTextField
        JTextField nombre = new JTextField(15);
        JTextField apellido = new JTextField(15);
    
        nombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        // Añadir una imagen
        ImageIcon icon = new ImageIcon("src/swingtest/foto1.jpg");
        JLabel labelIcon = new JLabel(icon);
       
        
         //Tenemos que añadirlo el JComboBox al panel y hacerlo visible
        panel.add(frutas);
        panel.add(boton);
        panel.add(casilla1);
        panel.add(casilla2);
        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);
        panel.add(rb4);
        panel.add(label);
        panel.add(labelIcon);
        panel.add(nom);
        panel.add(nombre);
        panel.add(Apellido);
        panel.add(apellido);
        //Añadir el panel  a la ventana
        ventana.add(panel);
        
        
        //setVisible(true): para visibilizar o no la ventana, ESTO SIEMPRE VA AL FINAL
        ventana.setVisible(true);
       
        
    }
    
}
