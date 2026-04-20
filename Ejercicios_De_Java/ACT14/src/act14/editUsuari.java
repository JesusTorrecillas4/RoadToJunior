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
public class editUsuari extends JDialog {
    
     private ArrayList<Usuari> Usuarios;
     private DefaultTableModel modeloTabla;
     private int seleccionado;
     
     
    public editUsuari(JFrame padre,Usuari usu, ArrayList<Usuari> Usuarios, DefaultTableModel modeloTabla,
        int seleccionado){
        
        super(padre, true);
        this.Usuarios = Usuarios;
        this.modeloTabla = modeloTabla;
        this.seleccionado = seleccionado;
        
        setTitle("Gestió d'Alumne");
        setSize(300,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        if(usu instanceof Alumne){
            componentesAlumno(seleccionado);
        }else if(usu instanceof Professor){
            componentesProfessor();
        }
        
        
    }
    
    public void componentesAlumno(int seleccionado){
        
        JLabel lnom = new JLabel("Nom");
        JTextField tnom = new JTextField(10);
        JLabel lemail = new JLabel("Email");
        JTextField temail = new JTextField(10);
        JLabel lcurs = new JLabel("Curs");
        JTextField tcurs = new JTextField(10);
        JLabel lnota = new JLabel("Nota");
        JTextField tnota = new JTextField(10);
        
        JButton btnEditar = new JButton("Editar");
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
        
        pBtn.add(btnEditar);
        pBtn.add(btnSalir);
        
        add(pPrin);
        add(pBtn, BorderLayout.SOUTH);
               
        Alumne alum = (Alumne) Usuarios.get(seleccionado);

        tnom.setText(alum.getNom());
        temail.setText(alum.getEmail());
        tcurs.setText(alum.getCurs());
        tnota.setText(String.valueOf(alum.getNota()));
        
        btnEditar.addActionListener(e -> editarAlumne(tnom, temail, tcurs, tnota));
        btnSalir.addActionListener(e -> dispose());
        
    }
    
    public void editarAlumne(JTextField tnom, JTextField temail,
                JTextField tcurs, JTextField tnota){
        
        String nom = tnom.getText();
        String email = temail.getText();
        String curs = tcurs.getText();
        int nota = (int) Double.parseDouble(tnota.getText());
        
        Alumne alum = (Alumne) Usuarios.get(seleccionado);

        alum.setNom(nom);
        alum.setEmail(email);
        alum.setCurs(curs);
        alum.setNota(nota);
        
        modeloTabla.setValueAt(nom, seleccionado, 0);
        modeloTabla.setValueAt(email, seleccionado, 1);
        modeloTabla.setValueAt(curs, seleccionado, 3);
        modeloTabla.setValueAt(nota, seleccionado, 4);
    }
    
    
    public void componentesProfessor(){
        
         JLabel lnom = new JLabel("Nom");
        JTextField tnom = new JTextField(10);
        JLabel lemail = new JLabel("Email");
        JTextField temail = new JTextField(10);
        JLabel ldepartament = new JLabel("Departament");
        JTextField tdepartament = new JTextField(10);
        JLabel lassigantures = new JLabel("Assigantures");
        JTextField tassigantures = new JTextField(10);
        
        JButton btnCrear = new JButton("Crear");
        JButton btnSalir = new JButton("Salir");
        
        setLayout(new BorderLayout());
        
        JPanel pPrin = new JPanel();
        JPanel pBtn = new JPanel();
        
        pPrin.add(lnom);
        pPrin.add(tnom);
        pPrin.add(lemail);
        pPrin.add(temail);
        pPrin.add(ldepartament);
        pPrin.add(tdepartament);
        pPrin.add(lassigantures);
        pPrin.add(tassigantures);
        
        pBtn.add(btnCrear);
        pBtn.add(btnSalir);
        
        add(pPrin);
        add(pBtn, BorderLayout.SOUTH);
        
        Professor profe = (Professor) Usuarios.get(seleccionado);
        
        tnom.setText(profe.getNom());
        temail.setText(profe.getEmail());
        tdepartament.setText(profe.getDepartament());
        tassigantures.setText(String.valueOf(profe.getAssigantures()));
        
        
        btnCrear.addActionListener(e -> editarProfessor(tnom, temail, tdepartament, tassigantures));
        btnSalir.addActionListener(e -> dispose());
    }
    
    public void editarProfessor(JTextField tnom, JTextField temail,
                JTextField tdepartament, JTextField tassigantures){
        
        
         
        String nom = tnom.getText();
        String email = temail.getText();
        String depa = tdepartament.getText();
        int assi = Integer.parseInt(tassigantures.getText());
        
        Professor profe = (Professor) Usuarios.get(seleccionado);
        
        profe.setNom(nom);
        profe.setEmail(email);
        profe.setDepartament(depa);
        profe.setAssigantures(assi);
        
        modeloTabla.setValueAt(nom, seleccionado, 0);
        modeloTabla.setValueAt(email, seleccionado, 1);
        modeloTabla.setValueAt(depa, seleccionado, 3);
        modeloTabla.setValueAt(assi, seleccionado, 4);
    }
}
