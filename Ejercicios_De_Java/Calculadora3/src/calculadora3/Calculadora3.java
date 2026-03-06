/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author jesus
 */
//implements ActionListener
public class Calculadora3 extends JFrame{

    /* Componente de la interfaz calculadora*/
    private JTextField pantalla;
    
    /*Array con los botones*/
    private JButton[] botonesNumeros;
    
    /*Botones de las operaciones*/
    private JButton botonSuma;
    private JButton botnResta;
    private JButton igual;
    
    /* Boton para limpiar el resultado*/
    private JButton botonLimpiar;
    
    /* Para guardar el primer numero introducido antes de clicar el siguiente*/
    private double primerNumero;
    
    /* Para guardar la operacion seleccionada*/
    private char operacionSeleccionada;
    
    /* Para guardar si el usuario ha clicado el operador y el nuemro*/
    private boolean esperandoSegundoNuemro;
    
    /* Constructor*/
    public void Calculadora3(){
        
        // Configuracion basica de la ventana
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        /* Para que no se pueda modificar el tamaño*/
        setResizable(false);
        
        //Incicializamos las variables
        primerNumero = 0;
        operacionSeleccionada = ' ';
        
        //Metodo para construir la interfaz
        inicializarComponentes();
        
        // Ajustar el tamaño de la ventant al contenido y lo centramos
        pack();
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new Calculadora3();
    }

    private void inicializarComponentes() {
        
        // Panel de la calculadora
        JPanel panelPrincipal = new JPanel(new BorderLayout(5, 5));
        
        //Paddind del 10 px (the same)
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Background color oscuro
        panelPrincipal.setBackground(new Color(45, 45, 48));
        
        // Configuramos la pantalla princiapl
        pantalla = new JTextField("0");
        
        // Para alinear los numeros a la derecha
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        
        // Deshabilitar el JTextField de resultado
        pantalla.setEditable(false);
        
        // Cambaismo la font para que sea mas guay
        pantalla.setFont(new Font("Consolas",Font.BOLD, 28));
        pantalla.setBackground(new Color(30, 30, 30));
        
        // Cambiamos el color del texto
        pantalla.setForeground(Color.WHITE);
        // Para el border entre los botones
        pantalla.setBorder(BorderFactory.createCompoundBorder(
        
                BorderFactory.createLineBorder(new Color(80, 80, 80), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        // Tamaño predeterminado maximo
        pantalla.setPreferredSize(new Dimension(300, 55));
        
        // Añadir pantalla al panel principal
        
        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        
    }
    
}
