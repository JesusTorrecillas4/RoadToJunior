/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */

//Clase Alumno que va a heredar de la clase Persona
//Herencia: extends
public class Alumno extends Persona {
    
    //float de c aqui es Double
    //Atributo nuevo para alumno
    //Nom y edad ya los hereda de Persona
    private Double nota;
    
    public Alumno(String nom, Integer edad, Double nota){
        
        //Para llamar al constructor de su superior, es decir de persona
        //lo llamaremos co uper
        super(nom,edad);
        this.nota = nota;
    }
    
    //getter
    
    public Double getNota(){
        
        return this.nota;
    }
    
    public void setNota(Double nota){
        
        this.nota = nota;
    }
    
    //Override / Sobreescribir el metodo caminar
    //Polimorfismo
    @Override
    public void caminar(){
        
        //Aqui llamos al metodo de persona (Herencia)
        super.caminar();
        System.out.println("Asi camina el alumno1 "+ getNom());
    }
    
    
    
    
    
    
    
    
    
    
}
