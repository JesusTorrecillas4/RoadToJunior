/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alltest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jesus
 */
public class Menu extends JDialog{
    
    private JTextArea areaTexto;
    
    private JFileChooser fileSelector;
    
    public Menu(JFrame dad){
        
        super(dad,"Menu",true);
        
        areaTexto = new JTextArea();
        
        JScrollPane scrollpane = new JScrollPane(areaTexto);
        
        add(scrollpane);
        componentes();
    }
    
     public void componentes(){
        
        setTitle("Pagina 2");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu Opciones = new JMenu("Opciones");
        
        JMenuItem Guardar = new JMenuItem("Guardar");
        
        menuBar.add(Opciones);
        
        Opciones.add(Guardar);
        
       setJMenuBar(menuBar);
    }
    
  
}
