/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alltest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class Menu extends JDialog implements ActionListener{
    
    private JTextArea areaTexto;
    
    private JFileChooser fileSelector;
    
    public Menu(JFrame dad){
        
        super(dad,"Menu",true);
        
        areaTexto = new JTextArea();
        
        JScrollPane scrollpane = new JScrollPane(areaTexto);
        
        add(scrollpane);
        componentes();
        
        fileSelector = new JFileChooser();
    }
    
     public void componentes(){
        
        setTitle("Pagina 2");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu Opciones = new JMenu("Opciones");
        
        JMenuItem Guardar = new JMenuItem("Guardar");
        JMenuItem Abrir = new JMenuItem("Abrir");
        
        menuBar.add(Opciones);
        
        
        Opciones.add(Guardar);
        Opciones.add(Abrir);
        
        
        Guardar.addActionListener(this);
        Abrir.addActionListener(this);
        
        setJMenuBar(menuBar);
       
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        String evento = e.getActionCommand();
        
        switch(evento){
            
            case "Guardar":
                guardarArchivo();
                break;
            case "Abrir":
                    abrirArchivo();
                break;
        }
    }
  
    public void guardarArchivo(){
        
        int opcion = fileSelector.showSaveDialog(this);
        
        if(opcion == JFileChooser.APPROVE_OPTION){
            
            File arx = fileSelector.getSelectedFile();
            
            try(BufferedWriter write = new BufferedWriter(new FileWriter(arx))){
                
                areaTexto.write(write);
            }catch(IOException e){
                
                JOptionPane.showMessageDialog(this, "Error al guardar el fichero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    public void abrirArchivo(){
        
        
        
        int opcion = fileSelector.showOpenDialog(this);
        
        if(opcion == JFileChooser.APPROVE_OPTION){
            
            
            File arx = fileSelector.getSelectedFile();
            
            try(BufferedReader read = new BufferedReader(new FileReader(arx))){
                
                areaTexto.read(read, null);
                
                
            }catch(IOException e){
                
                JOptionPane.showMessageDialog(this, "Error al guardar el fichero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }
}
