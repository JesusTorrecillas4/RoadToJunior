/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtestpestanyas;

/**
 *
 * @author jesus
 */
public class Instrumento {
    
    private String nombre;
    private String tipo;
    private String sonido;
    
    public Instrumento(String nombre, String tipo, String sonido){
        
        this.nombre = nombre;
        this.tipo = tipo;
        this.sonido = sonido;
        
    }
    
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getSonido(){
        return this.sonido;
    }
    
}
