/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class addProfe extends JDialog {
    
      private ArrayList<Usuari> Usuarios;
      private DefaultTableModel modeloTabla;
    
    public addProfe(ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla){
        
        this.Usuarios = Usuarios;
        this.modeloTabla = modeloTabla;
        
        setTitle("Gestió de Profe");
        setSize(300,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
    }
    
    public void componentes(){
        
        JLabel lnom = new JLabel("Nom");
        JTextField tnom = new JTextField(10);
        JLabel lemail = new JLabel("Email");
        JTextField temail = new JTextField(10);
        JLabel ldepa = new JLabel("Departament");
        JTextField tdepa = new JTextField(10);
        JLabel lassi = new JLabel("Assignatura");
        JTextField tassi = new JTextField(10);
        
        JButton btnCrear = new JButton("Crear");
        JButton btnSalir = new JButton("Salir");
        
        setLayout(new BorderLayout());
        
        JPanel pPrin = new JPanel();
        JPanel pBtn = new JPanel();
        
        pPrin.add(lnom);
        pPrin.add(tnom);
        pPrin.add(lemail);
        pPrin.add(temail);
        pPrin.add(ldepa);
        pPrin.add(tdepa);
        pPrin.add(lassi);
        pPrin.add(tassi);
        
        pBtn.add(btnCrear);
        pBtn.add(btnSalir);
        
        add(pPrin);
        add(pBtn, BorderLayout.SOUTH);
               
        btnCrear.addActionListener(e -> crearprof(tnom, temail, tdepa, tassi));
        btnSalir.addActionListener(e -> dispose());
    }
    
      public void crearprof(JTextField tnom, JTextField temail,
                JTextField tdepa, JTextField tassi){
        
        String nom = tnom.getText();
        String email = temail.getText();
        String depa = tdepa.getText();
        int assig = Integer.parseInt(tassi.getText());
        
        Alumne alum = new Alumne(nom,email,"Professor",depa,assig);
        
        Usuarios.add(alum);
        
        modeloTabla.addRow(new Object[]{nom,email,"Professor",depa,assig});
    }
}
