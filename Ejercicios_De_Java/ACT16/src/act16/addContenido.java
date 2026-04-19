/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class addContenido extends JDialog{
    
    private ArrayList<LibroMadre>lista;
    private DefaultTableModel modeloTabla;
    
    public addContenido(JDialog padre,ArrayList<LibroMadre>lista, DefaultTableModel modeloTabla){
        
        super(padre, true);    
        this.lista = lista;
        this.modeloTabla = modeloTabla;
        
        setTitle("Añadir");
        setSize(300,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        compon();
        
    }
    
    public void compon(){
        
        JLabel lTitulo = new JLabel("Titulo");
        JTextField tTitulo = new JTextField(10);
        
        JLabel lAutor = new JLabel("Autor");
        JTextField tAutor = new JTextField(10);
        
        JLabel lFecha = new JLabel("Fecha de Publicacion");
        JTextField tFecha = new JTextField(10);
        
        JRadioButton chEstadoDis = new JRadioButton("Disponible");
        JRadioButton chEstadoPres = new JRadioButton("Prestado");
        
        ButtonGroup btnGrp = new ButtonGroup();
        
        String tipo[]={"Libro","Manga"};
        JComboBox cmTipo = new JComboBox(tipo);
        
        btnGrp.add(chEstadoDis);
        btnGrp.add(chEstadoPres);
        
        JPanel pPr = new JPanel();
        JPanel pBtn = new JPanel();
        
        JButton btnAdd = new JButton("Añadir");
        
        setLayout(new BorderLayout());
        
        pPr.add(lTitulo);
        pPr.add(tTitulo);
        pPr.add(lAutor);
        pPr.add(tAutor);
        pPr.add(lFecha);
        pPr.add(tFecha);
        pPr.add(chEstadoDis);
        pPr.add(chEstadoPres);
        pPr.add(cmTipo);
        
        pBtn.add(btnAdd);
        
        add(pPr, BorderLayout.CENTER);
        add(pBtn, BorderLayout.SOUTH);
        
        btnAdd.addActionListener(e -> addCon(tTitulo,tAutor,tFecha,chEstadoDis,chEstadoPres,cmTipo));
    }
    
    public void addCon(JTextField tTitulo,JTextField tAutor, JTextField tFecha,
            JRadioButton chEstadoDis, JRadioButton chEstadoPres,JComboBox cmTipo
    ){
        
        
        String titulo = tTitulo.getText();
        String Autor = tAutor.getText();
        int fecha = Integer.parseInt(tFecha.getText());
        Boolean estado = chEstadoDis.isSelected();
        
        if (cmTipo.getSelectedItem().equals("Libro")) {
            Libros li = new Libros(titulo,Autor,fecha,estado);
            lista.add(li);
            modeloTabla.addRow(new Object[]{titulo,Autor,fecha,estado,"Libro"});

        }else{
            mangas man = new mangas(titulo,Autor,fecha,estado);
            lista.add(man);
            modeloTabla.addRow(new Object[]{titulo,Autor,fecha,estado,"Manga"});
        }
        
        
                
        
        
    }
}
