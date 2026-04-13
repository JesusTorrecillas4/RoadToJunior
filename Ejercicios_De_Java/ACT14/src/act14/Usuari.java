/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act14;

/**
 *
 * @author jesus
 */


abstract class Usuari {
    
    private String nom;
    private String email;
    private String tipo;
    
    public Usuari(String nom, String email, String tipo){
        
        this.nom = nom;
        this.email = email;
        this.tipo = tipo;
        
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        
        this.nom = nom;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        
        this.email = email;
    }
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        
        this.tipo = tipo;
    }
    
}
