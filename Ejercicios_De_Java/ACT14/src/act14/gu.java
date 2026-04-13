/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

import java.awt.BorderLayout;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;





public class gu extends JFrame{
    
    private DefaultTableModel modeloTabla;
    private ArrayList<Usuari> Usuarios = new ArrayList<>();
    private JFileChooser fileSelector;
    
    public gu(){
        
        setTitle("Gestió d'Usuaris");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        crearComponentes();
        setVisible(true);
        
    }
    
    private void crearComponentes(){
        
         JLabel lGdu = new JLabel("Gestió d'Usuaris");
         
         JPanel pPrincipal = new JPanel();
         
         JButton btnAfalumne = new JButton("Afegir alumne");
         JButton btnAfprofe = new JButton("Afegir professor");
         JButton btnEdit = new JButton("Editar usuari");
         /*
         JButton btnCerca = new JButton("Cerca");
         */
         JButton btnGuardar = new JButton("Guardar");
         JButton btnCarregar = new JButton("Carregar");
         modeloTabla = new DefaultTableModel(new Object[]{"Nom","Email",
         "Tipo","Info extra","Info extra"},0);
         
          JPanel pBtn = new JPanel();
          
          pBtn.add(btnAfalumne);
          pBtn.add(btnAfprofe);
          pBtn.add(btnEdit);
          pBtn.add(btnGuardar);
          pBtn.add(btnCarregar);
          
          setLayout(new BorderLayout());
          
          JTable tabla = new JTable(modeloTabla);
          JScrollPane scroll = new JScrollPane(tabla);
         
         add(scroll, BorderLayout.CENTER);
         add(pBtn, BorderLayout.SOUTH);
         
         fileSelector = new JFileChooser();
         
         btnAfalumne.addActionListener(e -> addUser(this,Usuarios, modeloTabla));
         btnAfprofe.addActionListener(e-> addProfessor(this,Usuarios, modeloTabla));
         btnEdit.addActionListener(e ->{
         
              int seleccionado = tabla.getSelectedRow();
              
              editUser(seleccionado);
              
         });
         
         btnGuardar.addActionListener(e ->guardarArchivo());
    }
    
    public void addUser(JFrame padre,ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla){
        
        addUsersV addusV = new addUsersV(padre,Usuarios, modeloTabla);
        
        addusV.setVisible(true);
        
    }
    
    public void addProfessor(JFrame padre, ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla){
        
        addProfe profPag = new addProfe(padre,Usuarios, modeloTabla);
        
        profPag.setVisible(true);
    }
    
    public void editUser(int seleccionado){
        
        
        Usuari usu = Usuarios.get(seleccionado);
        
        editUsuari edUs = new editUsuari(this,usu,Usuarios,modeloTabla,seleccionado);
        
        edUs.setVisible(true);
    }
    
    public void guardarArchivo(){
        
        int opcion = fileSelector.showSaveDialog(this);
        
        if(opcion == JFileChooser.APPROVE_OPTION){
            
            File arx = fileSelector.getSelectedFile();
            
            try(BufferedWriter write = new BufferedWriter(new FileWriter(arx))){
                
                //modeloTabla.write(write);
            
            }catch(IOException e){
                
                JOptionPane.showMessageDialog(this, "Error al guardar el fichero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
            
            
        }
    }
    
    
}
