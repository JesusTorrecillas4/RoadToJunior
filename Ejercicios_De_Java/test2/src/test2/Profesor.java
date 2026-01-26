/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Profesor extends Personaa {
    
    private Integer aula;
    
    public Profesor(String nom, Integer edad, Integer aula){
        // Para llamar al constructor de su superior , es decir, de persona
        // lo llamaremos con super
        super(nom, edad);
        this.aula = aula;
        
        
    }
    public Integer getAula(){
        
        return this.aula;
    }
    
    public void setAula(Integer aula){
        
        this.aula = aula;
    }
    
    public void corregir(){
        
        System.out.println("Estoy harto de corregir");
    }
}
