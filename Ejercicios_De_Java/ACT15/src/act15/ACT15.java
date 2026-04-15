/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act15;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jesus
 */
public class ACT15 extends JFrame implements ActionListener{

    
    public ACT15(){
        
        setTitle("");
        setSize(800,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        componentes();
        setVisible(true);
    }
    
    public void componentes(){
        
        JButton btnJugar = new JButton("Jugar");
        JButton btnSalir = new JButton("Salir");
        
        JPanel pPrin = new JPanel();
        
        btnJugar.addActionListener(this);
        btnSalir.addActionListener(this);
        
        pPrin.add(btnJugar);
        pPrin.add(btnSalir);
        
        add(pPrin);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        String btn =  e.getActionCommand();
        
        switch(btn){
            case "Jugar":
                jocVentanta();
                break;
            case "Salir":
                dispose();
                break;
        }
    }
    
    public void jocVentanta(){
        
        joc j1 = new joc();
        
        j1.setVisible(true);
    }
    
    
    public static void main(String[] args) {
       new ACT15();
    }
    
}
