/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtest2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jesus
 */
public class Formulario extends JFrame{
    
    public Formulario(){
        setTitle("Formulario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel etiqueta = new JLabel("Formulario");
        
        JLabel nombre = new JLabel("Nombre: ");
        JTextField tNombre = new JTextField(15);
        
        JLabel tuNombre = new JLabel("Intoduce tu nombre: ");
        JTextField tuNombreIn = new JTextField(15);
        
        JLabel apellido = new JLabel("Introduce tu apellido: ");
        JTextField tuApellido = new JTextField(15);
        
       
        JLabel fruta = new JLabel("Tu fruta favorita");
        String[] frutas ={"Manzana", "Mandarina", "Platano", "Fresa"};
        
        JComboBox comboFrutas = new JComboBox(frutas);
        
        JLabel nivel = new JLabel("Tu nivel: ");
        
        // Barrita
        JSlider sNivel = new JSlider(0, 10, 2);
        sNivel.setMajorTickSpacing(2);
        sNivel.setMinorTickSpacing(1);
        sNivel.setPaintTicks(true);
        sNivel.setPaintLabels(true);
        
        JLabel edad = new JLabel("Tu edad");
        JSlider sEdad = new JSlider(0, 100);
        sEdad.setMajorTickSpacing(20);
        sEdad.setMinorTickSpacing(1);
        sEdad.setPaintTicks(true);
        sEdad.setPaintLabels(true);
        
       
        JButton botonVolver = new JButton("Volver al Inicio");
        
        //Evento clic del boton
        botonVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cerrar ventana actual
                
                 String recoger =  tNombre.getText();
                 System.out.println("Lo de dentro es: "+ recoger);
                 System.out.println("Tu nombre es "+ tuNombreIn.getText());
                 System.out.println("Tu apellido es "+tuApellido.getText());
                 System.out.println("Tu edad es " + sEdad.getValue());
                dispose();
                new Inicio();
            }
       
        });
        
        //Evento cambio de estado del slider
        sNivel.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                // Actualizamos el valor de la etiqueta JLabel etiqueta con
                // la cadena de texto "El valor del nivel: " y con el
                // valor del slider
                etiqueta.setText("El valir del nivel es: "+ sNivel.getValue());
            }
        
            
        });
        
        
        //Añadimos los elementos
        panel.add(etiqueta);
        panel.add(nombre);
        panel.add(tNombre);
        panel.add(fruta);
        panel.add(comboFrutas);
        panel.add(nivel);
        panel.add(sNivel);
        panel.add(tuNombre);
        panel.add(tuNombreIn);
        panel.add(apellido);
        panel.add(tuApellido);
        panel.add(edad);
        panel.add(sEdad);
        panel.add(botonVolver);
        
        
        add(panel);
        
        setVisible(true);
        
        
        
    }
}
