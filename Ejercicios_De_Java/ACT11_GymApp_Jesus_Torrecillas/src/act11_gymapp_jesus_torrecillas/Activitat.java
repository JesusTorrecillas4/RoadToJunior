/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act11_gymapp_jesus_torrecillas;

/**
 *
 * @author jesus
 */

//Lo hacemos abstract para tener ya una plantilla pre-definida
abstract class Activitat {
    
    //Declaramos las variables
    private String nom;
    private Double preuBase;
    
    //Cremos el constructor
    public Activitat(String nom, Double preuBase){
        
        this.nom = nom;
        this.preuBase = preuBase;
    }
    
    //Getters
    
    public String getNom(){
        return this.nom;
    }
    
    public Double getPreuBase(){
        return this.preuBase;
    }
    
    //Funciones que se llamaran con Override en otras clases
    abstract void calcularPreuFinal();
    
    public void mostrarDetalls(){
        
        System.out.println("La activitat "+ nom + " te un preu base de "
                + preuBase + " euros");
    }
    
}
