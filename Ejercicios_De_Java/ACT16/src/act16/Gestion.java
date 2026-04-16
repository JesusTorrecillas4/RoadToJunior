/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class Gestion extends JDialog {
    
    
    private DefaultTableModel modeloTabla;
    private ArrayList<LibroMadre>lista;
    
    public Gestion(JFrame padre, ArrayList<LibroMadre>lista){
        
        
        super(padre, true);
        setTitle("Biblio");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    public void componentes(){
        
         modeloTabla = new DefaultTableModel(new Object[]{"Ttitulo","Email",
         "Tipo","Info extra","Info extra"},0);
         
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        
         
          
        add(scroll);
        
    }
}
