/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blocnotas;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
       
/**
 *
 * @author jesus
 */
public class BlocNotas extends JFrame implements ActionListener{

    private JTextArea areaTexto;
    //Ventana emergente para seleccionar el fichero
    private JFileChooser fileSelector;
    
    public BlocNotas(){
        
        //Configuracion de la ventana
        setTitle("Bloc de Notas");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Creacion del area de texto
        areaTexto = new JTextArea();
        // TODO: cambiar la fuente
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        //aÑADIR SCROOL AL TEXTAREA
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        
        add(scrollPane);
        
        //Funcion para crear el Menu
        crearMenu();
        setVisible(true);
    }
    
    public  void crearMenu(){
        
        //Barra del menu
        JMenuBar barraMenu = new JMenuBar();
        
        //Menus principales
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuFormato = new JMenu("Formato");
        
        //Añadir items al menu
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");
        
        
        JMenuItem cambiarFuente = new JMenuItem("Cambiar Fuente");
        JMenuItem cambiarColor = new JMenuItem("Cambiar Color");
        
        //Añadir los items al menu
        menuArchivo.add(abrir);
        menuArchivo.add(guardar);
        menuArchivo.add(salir);
        
        
  
        
        menuFormato.add(cambiarFuente);
        menuFormato.add(cambiarColor);
        
        //Añadir eventos a los items del menu
        abrir.addActionListener(this);
        guardar.addActionListener(this);
        salir.addActionListener(this);
        cambiarFuente.addActionListener(this);
        cambiarColor.addActionListener(this);
        
        
        //Añadir a la barra los menus
        barraMenu.add(menuArchivo);
        barraMenu.add(menuFormato);
        
        // Añadir la barra a la ventana
        setJMenuBar(barraMenu);
    }
    
    public void actionPerformed(ActionEvent e){
        
        // TODO OBLIGADO menu para los eventos
        String evento  = e.getActionCommand();
        
        switch(evento){
            
            case "Abrir":
                abrirArchivo();
            case "Guardar":
                guardarArchivo();
            case "Salir":
                salirArchivo();
            case "Cambiar Fuente":
                cFuente();
            case "Cambiar Color":
                cColor();
                
            default:
                
                break;
        }
    }
    
    private void abrirArchivo(){
        
        
    }
    
    private void guardarArchivo(){
        
    }
    
    private void salirArchivo(){
        
        
    }
    
    private void cFuente(){
        
        
    }
    
    private void cColor(){
        
        
    }
    
    
    public static void main(String[] args) {
       
        new BlocNotas();
    }
    
}
