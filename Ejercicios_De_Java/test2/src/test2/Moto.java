/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Moto extends Vehiculo {
    
private String tipo;

public Moto(String marca, String matricula, Integer potencia, Integer velocidad, String tipo){
    

    
    super(marca, matricula, potencia, velocidad);
    this.tipo = tipo;
    
    }

    //Getter
    public String getTipo(){
        
        return this.tipo;
    }
    //Setter
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void caballito(){
        System.out.println("La moto "+tipo+ " esta "
                + "Levantadno rueda");
    }
}
