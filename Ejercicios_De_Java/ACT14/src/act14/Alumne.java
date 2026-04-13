/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

/**
 *
 * @author jesus
 */
public class Alumne extends Usuari {
    
    private String curs;
    private  double nota;
    public Alumne(String nom, String email, String tipo,String curs, int nota){
        
        super(nom, email, tipo);
        
        this.curs = curs;
        this.nota = nota;
    }
    
    public String getCurs(){
        return curs;
    }
    
    public void setCurs(String curs){
        this.curs = curs;
    }
    
     public double getNota(){
        return nota;
    }
    
    public void setNota(double nota){
        this.nota = nota;
    }
    
}
