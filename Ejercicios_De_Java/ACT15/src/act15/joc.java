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
import javax.swing.Timer;

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
    
    private int indexJugador;
    private int nivell;
    private int record;
    
    //Atribuyo private boolean pra saber a quein le toca maquina o humano
    private boolean tornJugador;
    
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
        
         setLayout(new BorderLayout());
         
         JPanel pInfo = new JPanel(new GridLayout(2,1));
         lEstado = new JLabel("Pulsa comenzar", SwingConstants.CENTER);
         lNivel = new JLabel("Nivell: 0 | Record: 0", SwingConstants.CENTER);
         pInfo.add(lEstado);
         pInfo.add(lNivel);
         
         JPanel pBtn = new JPanel(new GridLayout(2,2,8,8));
         pBtn.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
         
         
         
         
         //para printar botones
         botonesColores = new JButton[4];
         for(int i = 0; i < 4; i++){
             botonesColores[i] = crearBoton(i);
             pBtn.add(botonesColores[i]);
         }
         
         bEmpezar = new JButton("Comenzar");
         
        bEmpezar.addActionListener(e -> iniciar());
        
        //Eventos de los 4 colores
        for(int i = 0; i < 4; i++){
            final int index = i;
            botonesColores[i].addActionListener(e -> jugarPrema(index));
            
        }
        
        add(pInfo, BorderLayout.NORTH);
        add(pBtn, BorderLayout.CENTER);
        add(bEmpezar, BorderLayout.SOUTH);
       
    }
     
     public JButton crearBoton(int index){
         JButton boto = new JButton();
         boto.setOpaque(true);
         boto.setContentAreaFilled(true);
         boto.setBorderPainted(false);
         boto.setFocusPainted(false);
         boto.setBackground(COLOR_BTN[index]);
         boto.setPreferredSize(new Dimension(150,150));
         boto.setCursor(new Cursor(Cursor.HAND_CURSOR));
         boto.setEnabled(false); //Desactivat fins que comenci la partida
         return boto;
           
     }
     
     /*
     
      1. Buidar el array (array.clear())
      2. Posar indeJugador, nivell i tornaJugador als seus valors iniials
      3. Canviar el text del boton bComenxar a "Reiniciar" --> OPCIONAL
      4. Desactivar els botons de colr (activarBotonsColor(false))
      5. Cridar seguentRonda() per  comenzar la primera ronda 
     */
     public void iniciar(){
         
         secuencia.clear();
         indexJugador = 0;
         nivell = 0;
         tornJugador = false;
         
         bEmpezar.setText("Reiniciar");
         activarBotonsColor(false);
         actualizarEtiquetes("Comença la partida");
         seguentRonda();
     }
     /*
     
        1.Incrementar el nivell en 1 nivel++
        2.Reiniciar indexJugador a 0
        3.Posar tornJUgador a false
        4.Afegir un color aleatori a la array:
            array.add(random.nexInt(4))
            -> nextInt(4) genera un numero entre 0 i 3 
        5.Actualizar el misatge: ActualizarEtiquetas()
        6.Desactivar els botons de color --> Opcional
        7.Cridar mostrarSequencia() per mostrar la sequencia animada   
     */
     public void seguentRonda(){
         
         nivell++;
         indexJugador = 0;
         tornJugador = false;
         secuencia.add(random.nextInt(4));
         actualizarEtiquetes("Mira la seqüència...");
         activarBotonsColor(false);
         mostrarsequencia();
     }
     
     /*
     
     Copm funciona timer a swing
        Timer timer = new Timer(900, null);
        timer.addActionListener(e ->{
        //aquei va el codigo que se ejectura cada 900ms
     })
     
     
     1.Crea un array d'un element per controlar l0index actual:
        final int[] index = 0;
        
     2.Crear un timer que s'executi cada 900ms i faci
        si idex[0] < sequencia.size():
            iluminarBoton(sequencia.get(index[0]), 500)
            index[0]++
        si NO (ja hem mostrat tot els color){
        timer.stop
        turnJugador = true
        activarBotonesColors(true)
        actualizarEtiquetas()
     
     3. Iniciarl el timer , timer.start
     
     */
     public void mostrarsequencia(){
         
         final int[] index = {0};
         
         Timer timer = new Timer(900, null);
         timer.addActionListener(e ->{
             
             if(index[0] < secuencia.size()){
                 iluminarBtn(secuencia.get(index[0]), 500);
                 index[0]++;
             }else{
                 ((Timer)e.getSource()).stop();
                 tornJugador = true;
                 activarBotonsColor(true);
                 actualizarEtiquetes("Torn del jugador");
             }
         });
         
         timer.setInitialDelay(500);
         timer.start();
     }
     /*
        1.cANVIAR EL COLOR A color_brillantes[INDEX]
            botonsColors[index].setBackGround(COLOR_BRILLANTES[index])
        2.Crear un timer que s'executi UNA SOLA VEGADA despres de duracionsMs:
            Timer timerApagar = new Timer(duracionMs, e ->
        botonsColors[index].setBackground(COLORS_NORMAL[index]));
        timerApagar.setREPATS(false)
        timerApagar.start();
     */
     private void iluminarBtn(int index, int duracionMs){
     
         botonesColores[index].setBackground(COLOR_BRILLANTES[index]);
         
         Timer timerApagar = new Timer(duracionMs, e ->
             botonesColores[index].setBackground(COLOR_BTN[index]));
         
         timerApagar.setRepeats(false);
         timerApagar.start();
     
     }
     
     /*
     1.Si NO es el torn del jugador (torJugador == false), sortir if(!tornJugador) return;
     2.Iluminar el boton premut visualment: iluminarBoto(index, 400)
     3Comporvar si el color es correcte
        sequencia.get(indexJugador) -> color que tocava premer
        index -> color que ha premut el jugador
     
        SI ES CORRECTE:
            - incrementa indesJugador
            - comprovar si ha completat tota la sequencia
            if(indexJugador == sequencia.size())
               Si l'ha completat
                -torJugador = false
                -Desactivar botons
                - Mostrar missatge "molt be"
                - crear un timer d'1 segon (setRepeats(false))
     Si es incorrecte
        -Cridar fiDeJoc();
     
     */
     
     
     public void jugarPrema(int i){
         
         if(!tornJugador) return;
         
         iluminarBtn(i, 400);
         
         if(secuencia.get(indexJugador) == i){
             indexJugador++;
             
             if(indexJugador == secuencia.size()){
                 tornJugador = false;
                 activarBotonsColor(false);
                 actualizarEtiquetes("Molt bé! Següent ronda...");
                 
                 Timer timer = new Timer(1000, e -> seguentRonda());
                 timer.setRepeats(false);
                 timer.start();
             }
             
         }else{
             fiDeJoc();
         }
     }
     
     /*
        1. tornJugador = false i desactivar els botons
        2. Actualizar el record si el nivell actual es mes gran
                if(nivell > record) record = nivell;
        3. Actualizar el missatges: "Has fallat puntuacion" +nivell
        4. Animacion de derrota: posar tots el botons en Color.RED
            for(JButton boto : boronsColors)
                boto.setBackground(ColorRed)
            Crear un Timer (setRepeats(false)) de 600ms que torni
            cada boto al seu COLORS_NORMALS[i]
        5. Crear un Timer (setREPEATS(false)) de 1200ms que cridi mostrarDigi
     
     */
     
     private void fiDeJoc(){
         
         tornJugador = false;
         activarBotonsColor(false);
         
         if(nivell > record){
             record = nivell;
         }
         
         actualizarEtiquetes("Has fallat. Puntuació: " + nivell);
         
         for(JButton boto : botonesColores){
             boto.setBackground(Color.RED);
         }
         
         Timer timerColors = new Timer(600, e ->{
             for(int i = 0; i < botonesColores.length; i++){
                 botonesColores[i].setBackground(COLOR_BTN[i]);
             }
         });
         timerColors.setRepeats(false);
         timerColors.start();
         
         Timer timerFi = new Timer(1200, e -> mostrarDialogFiDeJoc());
         timerFi.setRepeats(false);
         timerFi.start();
     }
     
     
     /*
        1. Crear el missatge amb el nivell assolit i el record
        2.Mostrar un JOprionPane.showConfirmDialog amb opciones YES/NO
        3. Si respon YES -> iniciarPartida()
           Si respon NO -> System.exit(0)
     */
     
     private void mostrarDialogFiDeJoc(){
         
         String missatge = "Has arribat al nivell " + nivell + ".\nRecord: " + record + "\n\nVols jugar de nou?";
         
         int opcio = JOptionPane.showConfirmDialog(
                 this,
                 missatge,
                 "Fi del joc",
                 JOptionPane.YES_NO_OPTION
         );
         
         if(opcio == JOptionPane.YES_OPTION){
             iniciar();
         }else{
             System.exit(0);
         }
         
     }
     
     
     private void activarBotonsColor(boolean activar){
         for(JButton boto : botonesColores){
             boto.setEnabled(activar);
         }
     }
     
     
     
     
     private void actualizarEtiquetes(String missatge){
         
         lEstado.setText(missatge);
         lNivel.setText("Nivell:" +nivell+ " | Record:"+record);
     }
}