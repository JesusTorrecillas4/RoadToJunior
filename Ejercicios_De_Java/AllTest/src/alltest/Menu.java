/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alltest;

import java.awt.BorderLayout;
import java.awt.*;
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
        JMenu Modificar = new JMenu("Modificar");
        
        JMenuItem Guardar = new JMenuItem("Guardar");
        JMenuItem Abrir = new JMenuItem("Abrir");
        JMenuItem Salir = new JMenuItem("Salir");
        
        JMenuItem cColor = new JMenuItem("Cambiar Color");
        JMenuItem cFuente = new JMenuItem("Cambiar Fuente");
        
        menuBar.add(Opciones);
        menuBar.add(Modificar);
        
        Opciones.add(Guardar);
        Opciones.add(Abrir);
        Opciones.add(Salir);
        
        Modificar.add(cColor);
        Modificar.add(cFuente);
        
        Guardar.addActionListener(this);
        Abrir.addActionListener(this);
        Salir.addActionListener(this);
        
        cColor.addActionListener(this);
        cFuente.addActionListener(this);
        
        
        
        
        
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
            case "Salir":
                dispose();
                break;
            case "Cambiar Color":
                changeColor();
                break;
            case "Cambiar Fuente":
                changeFuente();
                break;
            default:
                
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
    
    public void changeColor(){
        
        Color cNuevo = JColorChooser.showDialog(this, "Elige un color",
                areaTexto.getForeground());
        
        if(cNuevo != null){
            areaTexto.setForeground(cNuevo);
        }
    }
    
    public void changeFuente(){
        
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        String fuenteSeleccionada = (String) JOptionPane.showInputDialog(this,"Elige una fuente", "Fuente", JOptionPane.PLAIN_MESSAGE, null,fuentes, areaTexto.getFont().getFamily());
        
        if(fuenteSeleccionada != null){
            
            String tFuente = JOptionPane.showInputDialog(this,"Introduce el tamaño",
                    areaTexto.getFont().getSize());
                    
                    try{
                        
                        int tam = Integer.parseInt(tFuente);
                        
                        areaTexto.setFont(new Font(fuenteSeleccionada, Font.PLAIN, tam));
                    }catch(NumberFormatException e){
                        
                        JOptionPane.showMessageDialog(this, "Tamaño no valido", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
        }
    }
}
