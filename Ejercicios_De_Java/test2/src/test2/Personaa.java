/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Personaa {
    //atributos
    
    private String nom;
    private Integer edad;
    
    //Getter y los Setter
    
    // CONSTRUCTOR
    // Metodo que siempre se ejecuta si o si cuadno creamos
    //objeto de la clase peronaa
    public Personaa(String nom, Integer edad){
        
        this.nom = nom;
        this.edad = edad;   
    }
    
    
    public Personaa(String nom){
        this.nom = nom;
        this.edad = 0;
    }
    //Getter Nom
    public String getNom(){
        return this.nom;
    }
    
    //Setter nom
    public void setNom(String nom){
        this.nom = nom;
    }
    
    //Getter Edad
    public Integer getEdad(){
        return this.edad;
    }
    
    //Setter Edad
    public void setEdad(Integer edad){
        this.edad = edad;
    }
    
    //Metodod caminar
    public void caminar(){
        System.out.println("Persona " + this.getNom()+ " Estoy caminando");
    }
}