/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtest2;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;


/**
 *
 * @author jesus
 */
public class Inicio extends JFrame {
    
    //Creamos el constructor
    public Inicio(){
        
        // Titulo
        setTitle("Programa principal");
        
        //Tamaño
        setSize(300,200);
        
        //Se acabe el programa con la "X" de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creamos in JPanel para añadir los elementos
        JPanel panel = new JPanel();
        
        JLabel etiqueta = new JLabel("Bienvenido a mi programa");
        
        JButton botonIr = new JButton("Ir al formulario");
        
        //El evento para el clic del boton
        botonIr.addActionListener(new ActionListener(){
            
            //ActionPerformed
            @Override
            public void actionPerformed(ActionEvent e){
                    //ACCION DE CLICAR EL BOTON
                    //SE CIERRA LA VENTANA ACTIAL
                    dispose();
                    new Formulario();
            }
        });
        
        //Añadimos los elementos al panel
        panel.add(etiqueta);
        panel.add(botonIr);
        
        
        
        add(panel);
        setVisible(true);
    }
}
