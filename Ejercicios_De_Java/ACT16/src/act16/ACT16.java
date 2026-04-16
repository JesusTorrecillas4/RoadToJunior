/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act16;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class ACT16 extends JFrame{

    private ArrayList<LibroMadre>lista = new ArrayList<>();
    
    public ACT16(){
        
        setTitle("Biblio");
        setSize(600,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        compon();
        setVisible(true);
    }
    
    public void compon(){
        
        JLabel lGest = new JLabel("Gestionar libros");
        JButton btnGest = new JButton("Gestionar");
        
        JLabel lCons = new JLabel("Consultar libros");
        JButton btnCons = new JButton("Consultar");
        
        JPanel pPrin = new JPanel();
        
        pPrin.add(lGest);
        pPrin.add(btnGest);
        pPrin.add(lCons);
        pPrin.add(btnCons);
        
        btnGest.addActionListener(e -> gestionar(this,lista));
        add(pPrin);
        
    }
    
    public void gestionar(JFrame padre,ArrayList<LibroMadre>lista){
        
        Gestion ge = new Gestion(padre, lista);
        
        ge.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new ACT16();
    }
    
}
