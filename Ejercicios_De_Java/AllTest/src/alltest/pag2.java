/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alltest;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author jesus
 */
public class pag2 extends JDialog {
    
    public pag2(JFrame padre){
        
      super(padre, "Página 2", true); 

        componentes();
    }
    
    public void componentes(){
        
        setTitle("Pagina 2");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel pPrincipal = new JPanel(new GridLayout(4,2,10,10));
        setLayout(new BorderLayout()); 
                
        
        
        JButton btnExit = new JButton("Exit");
        JPanel pBtn = new JPanel();
        
        //String array para el JCOMBOBOX
        String[] dinero = {"500","1000","1500","2000"};
        JComboBox boxDinero = new JComboBox(dinero);
        JPanel pBox = new JPanel();
        
        pBox.add(boxDinero);
        add(pBox, BorderLayout.NORTH);
        
        //JCHECKBOX
        JCheckBox check1 = new JCheckBox("A");
        JCheckBox check2 = new JCheckBox("B");
    
        pPrincipal.add(check1);
        pPrincipal.add(check2);
        
        //JRADIOBUTTON
        JRadioButton rb1 = new JRadioButton("Blue");
        JRadioButton rb2 = new JRadioButton("Red");
        
        //LO AGRUPAMOS EN UN BUTTONGROPU PARA SOLO PODER CLICAR A 1
        ButtonGroup gColors = new ButtonGroup();
        gColors.add(rb1);
        gColors.add(rb2);
        
        //AÑADIMOS LOS BOTONES NO EL GRUPO
        pPrincipal.add(rb1);
        pPrincipal.add(rb2);
        
        //SLIDER DE EDAD
        JLabel lEdad = new JLabel("Edad:");
        JSlider sEdad = new JSlider(0,100);
        sEdad.setMajorTickSpacing(20);
        sEdad.setMinorTickSpacing(1);
        sEdad.setPaintTicks(true);
        sEdad.setPaintLabels(true);
        JLabel edad = new JLabel("La edad es - anyos");
        
        sEdad.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                // Actualizamos el valor de la etiqueta JLabel etiqueta con
                // la cadena de texto "El valor del nivel: " y con el
                // valor del slider
                edad.setText("La edad es "+ sEdad.getValue()+ " anyos");
            }
        });
        
        pPrincipal.add(lEdad);
        pPrincipal.add(sEdad);
        pPrincipal.add(edad);
        
        add(pPrincipal, BorderLayout.CENTER);
        
        pBtn.add(btnExit);
        add(pBtn, BorderLayout.SOUTH);
        
        btnExit.addActionListener(e -> Salir());
    }
    
    public void Salir(){
        dispose();
    }
}
