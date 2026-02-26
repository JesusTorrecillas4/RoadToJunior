/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtestpestanyas;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class Instrumentos extends JFrame {
    
    public Instrumentos(){
        
        setTitle("Instrumentos");
        
        setSize(400,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel titulo = new JLabel("Instrumentos");
        
        JLabel nombre = new JLabel("Nombre del instrumento");
        TextField nombre1 = new TextField(20);
        String[] tipo ={"Viento","Percusion","Electrico"};
        
        JComboBox comboTipo = new JComboBox(tipo);
        JLabel sonido = new JLabel("Sonido del instrumetno");
        TextField sonido1 = new TextField(15);
        JButton btnGuardar = new JButton("Guardar");
       
        btnGuardar.addActionListener(new ActionListener(){
        
            @Override
             public void actionPerformed(ActionEvent e){
                    //ACCION DE CLICAR EL BOTON
                    //SE CIERRA LA VENTANA ACTIAL
                    dispose();
                    new Inicio();
                    System.out.println("EL nombre del instrumento es: "+ nombre1.getText());
                    System.out.println("El tipo del instrumetno es: "+ comboTipo.getSelectedItem());
                    System.out.println("El sonido del instrumento es: " +sonido1.getText());
            }
    });
        panel.add(titulo);
        panel.add(nombre);
        panel.add(nombre1);
        panel.add(comboTipo);
        panel.add(sonido);
        panel.add(sonido1);
        panel.add(btnGuardar);
        
        add(panel);
        setVisible(true);
    }
    
}
