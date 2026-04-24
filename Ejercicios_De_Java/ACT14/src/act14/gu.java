/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;





public class gu extends JFrame{
    
    private DefaultTableModel modeloTabla;
    private ArrayList<Usuari> Usuarios = new ArrayList<>();
    
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
         JButton btnDelete = new JButton("Eliminar");
         /*
         JButton btnCerca = new JButton("Cerca");
         JButton btnGuardar = new JButton("Guardar");
         JButton btnCarregar = new JButton("Carregar");*/
         modeloTabla = new DefaultTableModel(new Object[]{"Nom","Email",
         "Tipo","Info extra","Info extra"},0);
         
          JPanel pBtn = new JPanel();
          
          pBtn.add(btnAfalumne);
          pBtn.add(btnAfprofe);
          pBtn.add(btnEdit);
          pBtn.add(btnDelete);
          
          setLayout(new BorderLayout());
          
          JTable tabla = new JTable(modeloTabla);
          JScrollPane scroll = new JScrollPane(tabla);
         
         add(scroll, BorderLayout.CENTER);
         add(pBtn, BorderLayout.SOUTH);
         
         btnAfalumne.addActionListener(e -> addUser(Usuarios, modeloTabla));
         btnAfprofe.addActionListener(e-> addProfessor(Usuarios, modeloTabla));
         
         btnEdit.addActionListener(e ->{
         
              int seleccionado = tabla.getSelectedRow();
              
              editUser(seleccionado);
              
         });
         
         btnDelete.addActionListener(e -> delete(tabla));
        
        
    }
    
    public void addUser(ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla){
        
        addUsersV addusV = new addUsersV(Usuarios, modeloTabla);
        
        addusV.setVisible(true);
        
    }
    
    public void addProfessor(ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla){
        
        addProfe profPag = new addProfe(Usuarios, modeloTabla);
        
        profPag.setVisible(true);
    }
    
    public void delete(JTable tabla){
        
        int seleccionado = tabla.getSelectedRow();
        
        if(seleccionado == -1){
        JOptionPane.showMessageDialog(this, "Selecciona una fila");
        return;
        }
        
        Usuarios.remove(seleccionado);
        modeloTabla.removeRow(seleccionado);
    }
    
     public void editUser(int seleccionado){
        
        
        Usuari usu = Usuarios.get(seleccionado);
        
        editUsuari edUs = new editUsuari(this,usu,Usuarios,modeloTabla,seleccionado);
        
        edUs.setVisible(true);
    }
    
    
    
}
