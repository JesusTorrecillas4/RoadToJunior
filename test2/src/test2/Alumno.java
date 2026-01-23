/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */

//Clase Alumno que va a heredar de la calse Persona
//Herencia: extends

public class Alumno extends Personaa {
    
    //float de c aqui es Double
    //Atributo nuevo pata aluno
    //Nom y edad ya los hereda de Personaa
    private Double nota;
    
    //Constructor de Alumno
    public Alumno(String nom, Integer edad, Double nota){
        // Para llamar al constructor de su superior , es decir, de persona
        // lo llamaremos con super
        super(nom, edad);
        this.nota = nota;
        
        
    }
    
    //getter
     public Double getNota(){
            
            return this.nota;
        }
     //setter
     public void getNota(Double nota){
         
         this.nota = nota;
     }
     
     //Override / Sobreescribir el metodo caminar
     //Polimorfismo
     @Override
     public void caminar(){
         //Aqui llamamos la metodo de persona (Heredamos)
         super.caminar();
         System.out.println("Brooo que pasa broooo");
     }
    
     //Metodo estudiar que muestre por pantalla el mensaje
     //Estoy estduiadno mogollon y lo voy a petar
     public void estudiar(){
         
         System.out.println("Estoy estduiadno mogollon y lo voy a petar");
     }
     
     
}
