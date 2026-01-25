/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Persona {
    
    private String nom;
    private Integer edad;
    
    //Getter y los Setter
    
    //CONSTRUCTOR
    //Metodo que siempre s ejecuta si o si cuadno creamos
    //objeto de la clase Persona
    public Persona(String nom, Integer edad){
        
        this.nom = nom;
        this.edad = edad;
    }
    
    public Persona(String nom) {

        this.nom = nom;
        this.edad = 0;
    }
    
    
    
    //Getter Nom
    public String getNom(){
        
        return this.nom;
    }
    
    
    //Setter Nom
    public void setNom(String nom){
        
        this.nom = nom;
    }
    
    //Getter edad
    public Integer getEdad(){
        return this.edad;
        
    }
    
    //Setter Edad
    public void setEdad(Integer edad){
        
        this.edad = edad;
    }
    
    //Metdodo caminar
    public void caminar(){
        System.out.println("La persona "+ this.getNom() + " esta caminando");
    }
    
    
    
    
    
}
