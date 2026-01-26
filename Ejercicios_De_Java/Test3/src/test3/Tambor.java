/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test3;

/**
 *
 * @author jesus
 */
public class Tambor extends Instrumento{
    
    public Tambor(String nombre, String tipo){
        
        super(nombre, "Percusion");
    }
    
    public Tambor(String nombre){
        
        super(nombre, "Percusion");
    }
    
    @Override
    public void tocar(){
        
        System.out.println("Pom pom poooooooooom");
    }
    
    
    
    
    
    
    
}
