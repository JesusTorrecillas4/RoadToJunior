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
public class Animal extends JFrame {
    
    public Animal(){
        
        setTitle("Animales");
        setSize(400,500);
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel Animales = new JLabel("Animales");
        
        JLabel nombre = new JLabel("Nombre del animal");
        TextField nombre1 = new TextField(15);
        
        String[] tipoAnimales={"Volador","Mamifero","Herbivoro"};
        
        JComboBox comboAnimales = new JComboBox(tipoAnimales);
        
        JLabel edad = new JLabel("Edad del animal");
        TextField edad1 = new TextField(15);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener(){
        
            @Override
             public void actionPerformed(ActionEvent e){
                    //ACCION DE CLICAR EL BOTON
                    //SE CIERRA LA VENTANA ACTIAL
                    dispose();
                    new Inicio();
                    System.out.println("El nombre del animal es: "+ nombre1.getText());
                    System.out.println("El tipo de animal es: "+ comboAnimales.getSelectedItem());
                    System.out.println("La edad del animal es: "+ edad1.getText());
            }
    });
        panel.add(Animales);
        panel.add(nombre);
        panel.add(nombre1);
        panel.add(comboAnimales);
        panel.add(edad);
        panel.add(edad1);
        panel.add(btnGuardar);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        add(panel);
        setVisible(true);
    }
    
}
