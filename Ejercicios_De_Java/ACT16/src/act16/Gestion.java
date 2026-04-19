/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class Gestion extends JDialog implements ActionListener{
    
    
    private DefaultTableModel modeloTabla;
    private ArrayList<LibroMadre>lista;
    
    public Gestion(JFrame padre, ArrayList<LibroMadre>lista){
        
        
        super(padre, true);
        this.lista = lista;
        setTitle("Biblio");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    public void componentes(){
       
        setLayout (new BorderLayout());
         modeloTabla = new DefaultTableModel(new Object[]{"Ttitulo","Autor",
         "Fecha de Publicacion","Estado","Tipo"},0);
         
        JMenuBar menuBar = new JMenuBar();
        
        JMenu opciones = new JMenu("Opciones");
        
        JMenuItem iVolver = new JMenuItem("Volver");
        JMenuItem iBuscar = new JMenuItem("Buscar");
        
        
        menuBar.add(opciones, BorderLayout.CENTER);
        
        opciones.add(iVolver);
        opciones.add(iBuscar);
        
        
        add(menuBar, BorderLayout.NORTH);
        
        
        JButton btnAdd = new JButton("Añadir");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        
        JPanel pBtn = new JPanel();
        btnAdd.setOpaque(true);
        btnAdd.setContentAreaFilled(true);
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setBackground(Color.cyan);
        btnAdd.setPreferredSize(new Dimension(150,150));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
         
        pBtn.add(btnAdd);
        pBtn.add(btnEditar);
        pBtn.add(btnEliminar);
        
        
        add(pBtn, BorderLayout.SOUTH);
        
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        
         
        iVolver.addActionListener(this);
        iBuscar.addActionListener(this);
        btnAdd.addActionListener(this);
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        
        
        add(scroll, BorderLayout.CENTER);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        String eve = e.getActionCommand();
        
        switch(eve){
            
            case "Volver":
                dispose();
                break;
            case "Buscar":
                
                break;
            case "Añadir":
                 add(this,lista, modeloTabla);
                break;
            case "Editar":
                
                break;
            case "Eliminar":
                
                break;
            
            
        }
    }
    
    public void add(JDialog padre,ArrayList<LibroMadre>lista,DefaultTableModel modeloTabla){
        
        addContenido ac = new addContenido(padre,lista, modeloTabla);
        
        ac.setVisible(true);
    }
}
