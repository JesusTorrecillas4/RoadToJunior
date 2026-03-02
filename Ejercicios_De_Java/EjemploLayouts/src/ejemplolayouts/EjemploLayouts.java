/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplolayouts;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class EjemploLayouts extends JFrame{

    //Donde van a ir todos los botones
    JPanel panelBotones;
    
    public EjemploLayouts(){
        
        setTitle("Demo Layouts en vivo");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Para que la pantalla este en el centro
        setLocationRelativeTo(null);
        
        //Panel principal dividido en dos partes
        setLayout(new BorderLayout());
        
        //Panel superior con los botones de seleccion de layout
        JPanel panelControles = new JPanel();
        JButton btnFlow = new JButton("FlowLayout");
        JButton btnBorder = new JButton("BorderLayout");
        JButton btnGrid = new JButton("GridLayout");
        JButton btnBox = new JButton("BoxLayout (Y)");
        
        panelControles.add(btnFlow);
        panelControles.add(btnBorder);
        panelControles.add(btnGrid);
        panelControles.add(btnBox);
        
        add(panelControles, BorderLayout.NORTH);
        
        //Panel donde van los botones que se moveran segun el layout
        panelBotones = new JPanel();
        add(panelBotones, BorderLayout.CENTER);
        
        //Añadimos algunos botones de prueba
        for(int i = 1; i <= 5; i++){
            panelBotones.add(new JButton("Boton "+ i));
        }
        
        //Acciones a todos los botones para cambiar el layout
        // lambda
        btnFlow.addActionListener(e -> aplicarFlowLayout());
        btnBorder.addActionListener(e -> aplicarBorderLayout());
        btnGrid.addActionListener(e -> aplicarGridLayout());
        btnBox.addActionListener(e -> aplicarBoxLayout());
        
        
        setVisible(true);
    }
  
    private void aplicarFlowLayout() {
        
        //Quita componentes anteriores
        panelBotones.removeAll();
        
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        for(int i = 1;i <= 5; i++){
            panelBotones.add(new JButton("Boton " + i));
        }
        
        refrescar();
    }
    
    private void aplicarBorderLayout() {
       
        //Quitar componentes anteriores
        panelBotones.removeAll();
        
        panelBotones.setLayout(new BorderLayout(30,40));
        panelBotones.add(new JButton("NORTE"), BorderLayout.NORTH);
        panelBotones.add(new JButton("SUR"), BorderLayout.SOUTH);
        panelBotones.add(new JButton("ESTE"), BorderLayout.EAST);
        panelBotones.add(new JButton("OESTE"), BorderLayout.WEST);
        panelBotones.add(new JButton("CENTET"), BorderLayout.CENTER);
    }

     private void aplicarGridLayout() {
       
        //Quitar componentes anteriores
        panelBotones.removeAll();
        
        panelBotones.setLayout(new GridLayout(2, 3, 10, 10));
        
        //2 filas, 3 columnas y padding de 10
        for(int i = 1;i <= 6; i++){
            panelBotones.add(new JButton("Boton "+1));
            
        }
        
        refrescar();
         
         
    }
     
     private void aplicarBoxLayout() {
        
        //Quitar componentes anteriores
        panelBotones.removeAll();
        
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        for(int i = 1;i <= 5; i++){
            panelBotones.add(new JButton("Boton "+1));
            //Espacio Vertcial de separacion
            panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        
        refrescar();
    }
     
     
    private void refrescar() {
       
        //Recalcular el layout
        panelBotones.revalidate();
        //Repinta la ventana
        panelBotones.repaint();
    }
    
    public static void main(String[] args) {
        
        new EjemploLayouts();
        
    }

    
}
