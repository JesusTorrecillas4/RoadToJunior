/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    private DefaultTableModel modeloBus;
    private ArrayList<LibroMadre>lista;
    private JTable tabla;
    
    
    public buscar(JDialog padre, ArrayList<LibroMadre>lista,
            DefaultTableModel modeloTabla){
        
        super(padre, true);
        this.lista = lista;
        this.modeloTabla = modeloTabla;
        this.modeloBus = modeloBus;
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
        this.modeloTabla = modeloTabla;
        this.modeloBus = modeloBus;
        setTitle("Buscador");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    
    public void componentes(){
        
        JLabel lbus = new JLabel("Buscador");
        JTextField tbus = new JTextField(15);
        JButton btnBus = new JButton("Buscar");
        
        JButton btnExit = new JButton("Salir");
        
         modeloBus = new DefaultTableModel(
        new Object[]{"Ttitulo","Autor",
         "Fecha de Publicacion","Estado","Tipo"}, 0);
        tabla = new JTable(modeloBus);
        JScrollPane scr = new JScrollPane(tabla);
       
       JPanel pPri = new JPanel();
       
       pPri.setLayout(new GridLayout(2,2));
       pPri.add(lbus);
       pPri.add(tbus);
       pPri.add(btnBus);
       pPri.add(btnExit);
       
       add(pPri, BorderLayout.NORTH);
       add(scr, BorderLayout.CENTER);
       
       btnBus.addActionListener(e -> buscar(tbus));
       btnExit.addActionListener(e->dispose());
    }
    
    public void buscar(JTextField tbus){

    String buscar = tbus.getText().toLowerCase();

    modeloBus.setRowCount(0);

    for(LibroMadre item : lista){

        if(item.getTitulo().toLowerCase().contains(buscar)){

            String titulo = item.getTitulo();
            String autor = item.getAutor();
            int fecha = item.getFehcaPubli();
            Boolean estado = item.getEstado();

            String tipo;

            if(item instanceof mangas){
                tipo = "Manga";
            } else {
                tipo = "Libro";
            }

            modeloBus.addRow(new Object[]{
                titulo, autor, fecha, estado, tipo
            });
        }
    }
}
}
