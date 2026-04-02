/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alltest;

import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class modificar extends JDialog {
    
    
    
    public modificar(JFrame padre, Usuario usuario, ArrayList<Usuario>Usuarios,
            DefaultTableModel modeloTabla, int seleccion){
        
        
        super(padre,"Editando al suauario " + usuario.getName(), true);
        setSize(padre.getSize());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Componentes();
        
    }
    
    private void Componentes(){
        
        JLabel lmName = new JLabel("Name");
        JLabel lmAge = new JLabel("Age");
        
        JTextField mtName = new JTextField();
        JTextField mtAge = new JTextField();
        
        JButton btnSave = new JButton("Save");
        JButton btnExit = new JButton("Exit");
        
        setLayout(new BorderLayout());
        
        JPanel pInfo = new JPanel(new GridLayout(2,2,15,15));
        JPanel pBtn = new JPanel(new GridLayout(2,2,15,15));
        
        pInfo.add(lmName);
        pInfo.add(mtName);
        pInfo.add(lmAge);
        pInfo.add(mtAge);
        
        pBtn.add(btnSave);
        pBtn.add(btnExit);
        add(pInfo, BorderLayout.NORTH);
        add(pBtn, BorderLayout.SOUTH);
        
        cargarInfo(mtName, mtAge);
    }
    
    private void cargarInfo(JTextField mtName, JTextField mtAge){
        
       
    }
}
