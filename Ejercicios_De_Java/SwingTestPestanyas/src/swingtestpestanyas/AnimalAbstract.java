/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingtestpestanyas;

/**
 *
 * @author jesus
 */
abstract class AnimalAbstract {
    
    private String nombre;
    private String tipo;
    private int edad;
    
    public AnimalAbstract(String nombre, String tipo, int edad){
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }
    
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public int getEdad(){
        return this.edad;
    }
}
