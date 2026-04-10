/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blocnotas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
        
        fileSelector = new JFileChooser();
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        // TODO OBLIGADO menu para los eventos
        String evento  = e.getActionCommand();
        
        switch(evento){
            
            case "Abrir":
                System.out.println("Abreindo...");
                abrirArchivo();
                break;
            case "Guardar":
                
                guardarArchivo();
                break;
            case "Salir":
                dispose();
                break;
            case "Cambiar Fuente":
                cFuente();
                break;
            case "Cambiar Color":
                cColor();
                break;
            default:
                
                break;
        }
    }
    
    private void abrirArchivo(){
        
        int opcion = fileSelector.showOpenDialog(this);
        
        if(opcion == JFileChooser.APPROVE_OPTION){
            File arx = fileSelector.getSelectedFile();
            
            try(BufferedReader reader = new BufferedReader(new FileReader(arx))){
                
                areaTexto.read(reader, null);
            }catch(IOException e){
                
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    private void guardarArchivo(){
        
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
    
    private void cFuente(){
        
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
    
    private void cColor(){
        
        Color cNuevo = JColorChooser.showDialog(this, "Elige un color",
                areaTexto.getForeground());
        
        if(cNuevo != null){
            areaTexto.setForeground(cNuevo);
        }
    }
    
    
    public static void main(String[] args) {
       
        new BlocNotas();
    }
    
}
