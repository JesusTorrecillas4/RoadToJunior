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

    private final ArrayList<Usuario> Usuarios;
    private final DefaultTableModel modeloTabla;
    private final int seleccion;
    
    
    public modificar(JFrame padre, Usuario usuario, ArrayList<Usuario>Usuarios,
            DefaultTableModel modeloTabla, int seleccion){
        
        
        super(padre,"Editando al suauario " + usuario.getName(), true);
        
        this.Usuarios = Usuarios;
        this.modeloTabla = modeloTabla;
        this.seleccion = seleccion;
        
        setSize(padre.getSize());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Componentes(usuario);
        
    }
    
    private void Componentes(Usuario Usuarios){
        
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
        
        btnSave.addActionListener(e->guardar(mtName, mtAge));
        btnExit.addActionListener(e->salir());
        mtName.setText(Usuarios.getName());
        mtAge.setText(String.valueOf(Usuarios.getAge()));
         
    }
    
    private void guardar(JTextField mtName, JTextField mtAge){
        
        try{
            
            int age = Integer.parseInt(mtAge.getText());
            
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(this, "Invalid age please put a valid nuber",
                    "Invaliod Age", JOptionPane.WARNING_MESSAGE);
        }
        
        String nam = mtName.getText();
        int age = Integer.parseInt(mtAge.getText());
        
        Usuario usu = Usuarios.get(seleccion);
        
        usu.setName(nam);
        usu.setAge(age);
        
        Usuarios.set(seleccion, usu);
        
        modeloTabla.setValueAt(nam, seleccion, 0);
        modeloTabla.setValueAt(age, seleccion, 1);
        
        dispose();
    }
   
    private void salir(){
        
        dispose();
    }
}
