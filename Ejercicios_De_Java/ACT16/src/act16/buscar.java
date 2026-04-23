/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class buscar extends JDialog{
      
    private DefaultTableModel modeloTabla;
    private ArrayList<LibroMadre>lista;
    private JTable tabla;
    
    
    public buscar(JDialog padre, ArrayList<LibroMadre>lista,
            DefaultTableModel modeloTabla){
        
        super(padre, true);
        this.lista = lista;
        setTitle("Biblio");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
     public buscar(JFrame padre, ArrayList<LibroMadre>lista,
            DefaultTableModel modeloTabla){
        
        super(padre, true);
        this.lista = lista;
        setTitle("Buscador");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    
    public void componentes(){
        
        JLabel lbus = new JLabel("Buscador");
        JTextField tbus = new JTextField();
        JButton btnBus = new JButton("Buscar");
        
       JScrollPane scr = new JScrollPane(tabla);
       
       JPanel pPri = new JPanel();
       
    }
}
