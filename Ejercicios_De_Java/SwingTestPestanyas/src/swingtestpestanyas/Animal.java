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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
         JLabel edad1 = new JLabel("Edad del animal");
        
        JSlider sEdad = new JSlider(0,100);
        sEdad.setMajorTickSpacing(20);
        sEdad.setMinorTickSpacing(5);
        sEdad.setPaintTicks(true);
        sEdad.setPaintLabels(true);
        
        //Evento cambio de estado del slider
        sEdad.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                // Actualizamos el valor de la etiqueta JLabel etiqueta con
                // la cadena de texto "El valor del nivel: " y con el
                // valor del slider
                edad1.setText(""+ sEdad.getValue());
            }
        
            
        });
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
                    System.out.println("La edad del animal es: "+ sEdad.getValue());
            }
    });
        panel.add(Animales);
        panel.add(nombre);
        panel.add(nombre1);
        panel.add(comboAnimales);
        panel.add(edad);
        panel.add(edad1);
        panel.add(sEdad);
        panel.add(btnGuardar);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        add(panel);
        setVisible(true);
    }
    
}
