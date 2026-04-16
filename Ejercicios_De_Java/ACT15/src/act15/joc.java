/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act15;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author jesus
 */
public class joc extends JFrame{
    
    // Array con los colors (estado normal de los botones)
    // 0: verde, 1: rojo, 2: Aul, 3: Amarillo
    private static final Color[] COLOR_BTN = {
    
        new Color(0, 150, 0),
        new Color(100, 0 ,0),
        new Color(0, 0, 100),
        new Color(100, 160, 0)
            
    };
    
    
    //Array con los colores para definir la secuendia del juego
       private static final Color[] COLOR_BRILLANTES= {
    
        new Color(0, 255, 80),
        new Color(255, 80 ,80),
        new Color(80, 80, 255),
        new Color(255, 230, 0)
    };
       
       
    // COMPONENTES DE LA UI
       
       private JButton[] botonesColores;
       private JLabel lEstado;
       private JLabel lNivel;
       private JButton bEmpezar;
       
    /*
       ArrayList para la secuencia de colores genereada por el juego
       Cada elemento es un unide (0,1,2,3) que representa un color
       Ejemplo: Si tenemos la secuednia (0,2,1) --> verde -->azul --> rojo
    */
       
    private ArrayList<Integer> secuencia = new ArrayList<>();
    /*  TODO  */   
    /*
      -Declarar un atributo que nos indica el proximo color que ha de clickar el jugador
      -Declarar un atributo para el nivel actual
      -Declarar un atributo para guardar el record o puntuacion maxima 
    */   
    
    //Generar random para generar colores
    private Random random = new Random();
       
       
       
    public joc(){
         
        setTitle("Simon Dice");
        setSize(800,900);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
        
        setVisible(true);
    }
    
     public void componentes(){
        
        JButton btnVermell = new JButton("Vermell");
        JButton btnVerd = new JButton("Verd");
        JButton btnBlau = new JButton("Blau");
        JButton btnGroc = new JButton("Groc");
        
        JPanel pPrin = new JPanel();
        
        setLayout(new GridLayout());
        
        pPrin.add(btnVermell);
        pPrin.add(btnVerd);
        pPrin.add(btnBlau);
        pPrin.add(btnGroc);
        
        add(pPrin, BorderLayout.CENTER);
    }
     
     
}
