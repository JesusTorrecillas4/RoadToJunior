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
        JLabel lcurs = new JLabel("Curs");
        JTextField tcurs = new JTextField(10);
        JLabel lnota = new JLabel("Nota");
        JTextField tnota = new JTextField(10);
        
        JButton btnCrear = new JButton("Crear");
        JButton btnSalir = new JButton("Salir");
        
        setLayout(new BorderLayout());
        
        JPanel pPrin = new JPanel();
        JPanel pBtn = new JPanel();
        
        pPrin.add(lnom);
        pPrin.add(tnom);
        pPrin.add(lemail);
        pPrin.add(temail);
        pPrin.add(lcurs);
        pPrin.add(tcurs);
        pPrin.add(lnota);
        pPrin.add(tnota);
        
        pBtn.add(btnCrear);
        pBtn.add(btnSalir);
        
        add(pPrin);
        add(pBtn, BorderLayout.SOUTH);
               
        btnCrear.addActionListener(e -> crearus(tnom, temail, tcurs, tnota));
        btnSalir.addActionListener(e -> dispose());
    }
}
