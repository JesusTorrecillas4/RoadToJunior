/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

/**
 *
 * @author jesus
 */
public class Professor extends Usuari{
    
    private String departament;
    private int assigantures;
    
    public Professor(String nom, String email, String tipo){
        
        super(nom,email,tipo);
        this.departament = departament;
        this.assigantures = assigantures;
        
    }
    
     public String getDepartament(){
        return departament;
    }
    
    public void setDepartament(String departament){
        this.departament = departament;
    }
    
     public double getAssigantures(){
        return assigantures;
    }
    
    public void setAssigantures(int assigantures){
        this.assigantures = assigantures;
    }
}
