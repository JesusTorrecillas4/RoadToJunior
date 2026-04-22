/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class editComp extends JDialog{
    
    
    private DefaultTableModel modeloTabla;
    private ArrayList<LibroMadre>lista;
    private int seleccionado;
    private LibroMadre libroSeleccionado;
    
    public editComp(JDialog padre, LibroMadre libroSeleccionado, ArrayList<LibroMadre> lista, 
            DefaultTableModel modeloTabla, int seleccionado){
        
       
        
        super(padre, true);
        
        this.libroSeleccionado = libroSeleccionado;
        this.lista = lista;
        this.modeloTabla = modeloTabla;
        this.seleccionado = seleccionado;
    
        setTitle("Biblio");
        setSize(600,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    public void componentes(){
        
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
        
        tTitulo.setText(libroSeleccionado.getTitulo());
        tAutor.setText(libroSeleccionado.getAutor());
        tFecha.setText(String.valueOf(libroSeleccionado.getFehcaPubli()));
        
        btnAdd.addActionListener(e -> addLi(tTitulo,tAutor,tFecha,chEstadoDis,chEstadoPres,cmTipo));
        
    }
    
    public void addLi(JTextField tTitulo,JTextField tAutor, JTextField tFecha,
            JRadioButton chEstadoDis, JRadioButton chEstadoPres,JComboBox cmTipo){
        
        
         String titulo = tTitulo.getText();
        String Autor = tAutor.getText();
        int fecha = Integer.parseInt(tFecha.getText());
        Boolean estado = chEstadoDis.isSelected();
        
        if (cmTipo.getSelectedItem().equals("Libro")) {
          
            LibroMadre li = lista.get(seleccionado);
            
            li.setTitulo(titulo);
            li.setAutor(Autor);
            li.setFehcaPubli(fecha);
            li.setEstado(estado);
            
            lista.set(seleccionado, li);
            modeloTabla.setValueAt(titulo, seleccionado, 0);
            modeloTabla.setValueAt(Autor, seleccionado, 1);
            modeloTabla.setValueAt(fecha, seleccionado, 2);
            modeloTabla.setValueAt(estado, seleccionado, 3);
            
           
            
        }else{
              LibroMadre li = lista.get(seleccionado);
            
            li.setTitulo(titulo);
            li.setAutor(Autor);
            li.setFehcaPubli(fecha);
            li.setEstado(estado);
            
            lista.set(seleccionado, li);
            modeloTabla.setValueAt(titulo, seleccionado, 0);
            modeloTabla.setValueAt(Autor, seleccionado, 1);
            modeloTabla.setValueAt(fecha, seleccionado, 2);
            modeloTabla.setValueAt(estado, seleccionado, 3);
        }
        
        
    }
    
}
