/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtestpestanyas;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    ArrayList<Instrumento>Instrumentos = new ArrayList<>();
    public Instrumentos(){
        
        setTitle("Instrumentos");
        
        setSize(400,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel titulo = new JLabel("Instrumentos");
        
        JLabel nombre = new JLabel("Nombre del instrumento");
        TextField nombre1 = new TextField(20);
        String[] tipo ={"Flauta","Tambor","Piano"};
        
        JComboBox comboTipo = new JComboBox(tipo);
        JLabel sonido = new JLabel("Sonido del instrumetno");
        TextField sonido1 = new TextField(15);
        JButton btnGuardar = new JButton("Guardar");
       
        btnGuardar.addActionListener(new ActionListener(){
        
            @Override
                public void actionPerformed(ActionEvent e){
                  
                    
                    
                    System.out.println("EL nombre del instrumento es: "+ nombre1.getText());
                    System.out.println("El tipo del instrumetno es: "+ comboTipo.getSelectedItem());
                    System.out.println("El sonido del instrumento es: " +sonido1.getText());
                    
                    String nombreA = nombre1.getText();
                    String tipoA = comboTipo.getSelectedItem().toString();
                    String sonidoA = sonido1.getText();
                    
                    
                    if(nombreA.equals("Flauta")){
                        Instrumentos.add(new Flauta(nombreA,tipoA,sonidoA));
                    }else if(nombreA.equals("Tambor")){
                        Instrumentos.add(new Tambor(nombreA,tipoA,sonidoA));
                    }else{
                        Instrumentos.add(new Piano(nombreA,tipoA,sonidoA));
                    }
          
                    //Crear el objeto correspondiente
                    //Calse Instrumenots > Flauta, Tambor y Piano
                    //New Flauta(...)
                   
                   
                }
        });
        
        JButton btnCrear = new JButton("Instrumetnos creados");
        btnCrear.addActionListener(new ActionListener(){
        
        @Override
             public void actionPerformed(ActionEvent e){
                   
                    for(Instrumento ins : Instrumentos){
                        
                        
                        System.out.println("El nombre es: "+ins.getNombre());
                        System.out.println("El tipo es de: "+ ins.getTipo());
                        System.out.println("El sonido es: "+ ins.getSonido());
                        
                        
                    }
                   
            }
        });
        
        JLabel mensajeSalir = new JLabel("Si sales se borraran los datos");
        JButton btnSalir = new JButton("Salir");
            btnSalir.addActionListener(new ActionListener(){

               @Override
                    public void actionPerformed(ActionEvent e){


                        dispose();
                        new Inicio();
                    }
            });
            
        panel.add(titulo);
        panel.add(nombre);
        panel.add(nombre1);
        panel.add(comboTipo);
        panel.add(sonido);
        panel.add(sonido1);
        panel.add(btnGuardar);
        panel.add(btnCrear);
        panel.add(mensajeSalir);
        panel.add(btnSalir);
        
        add(panel);
        setVisible(true);
    }
    
}
