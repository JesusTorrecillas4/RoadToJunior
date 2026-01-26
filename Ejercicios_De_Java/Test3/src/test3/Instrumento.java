/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test3;

/**
 *
 * @author jesus
 */
public class Instrumento {
    
    private String nombre;
    private String tipo;
    
    public Instrumento(String nombre, String tipo){
        
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    //Getter
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
    }
    //Setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void tocar(){
        
        System.out.println("Tocando el instrumento:" + nombre);
    }
    
    
}
