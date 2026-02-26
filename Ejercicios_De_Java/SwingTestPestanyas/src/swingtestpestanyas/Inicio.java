/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtestpestanyas;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class Inicio extends JFrame {
    
    
    public Inicio(){
        
        setTitle("Seccion de Inicio");
        
        setSize(400,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JButton botonInstrumentos = new JButton("Ir a Instrumentos");
        
        botonInstrumentos.addActionListener(new ActionListener(){
        
            @Override
             public void actionPerformed(ActionEvent e){
                    //ACCION DE CLICAR EL BOTON
                    //SE CIERRA LA VENTANA ACTIAL
                    dispose();
                    new Instrumentos();
            }
    });
        
        JButton btnAnimal = new JButton("Ir a Animales");
        
        btnAnimal.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                
                dispose();
                new Animal();
                
            }
   
        });
        
        JButton btnSalir = new JButton("Salir");
       
        btnSalir.addActionListener(new ActionListener(){
        
            @Override
             public void actionPerformed(ActionEvent e){
                    //ACCION DE CLICAR EL BOTON
                    //SE CIERRA LA VENTANA ACTIAL
                    dispose();
                    
            }
    });
        
        panel.add(botonInstrumentos);
        panel.add(btnAnimal);
        panel.add(btnSalir);
        add(panel);
        setVisible(true);
    }
    
    
    
    
    
    
}
