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
    
    //crear un atributo static contador
    private static int contador = 0;
    
    public Instrumento(String nombre, String tipo){
        
        this.nombre = nombre;
        this.tipo = tipo;
        //Incrematna en +1 en cada new de Instrumento
        contador ++;
    }
    
    //Getter
    public String getNombre(){
        return this.nombre;
    }
    //Getter para static
    public static int getContador(){
        return contador;
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
