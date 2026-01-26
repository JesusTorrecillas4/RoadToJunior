/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class Coche extends Vehiculo {
    
    private String color;
    private Integer puertas;
    
    public Coche(String marca, String matricula, Integer potencia, Integer velocidad,
            String color, Integer puertas){
        
        super(marca, matricula, potencia, velocidad);
        this.color = color;
        this.puertas = puertas;
    }
    
    //Getters
    public String getColor(){
        return this.color;
    }
    public Integer getPuertas(){
        return this.puertas;
    }
    //Setters
    public void setColor(String color){
        this.color = color;
    }
    
    public void setPuertas(Integer puertas){
        this.puertas = puertas;
    }
    Scanner scanner = new Scanner(System.in);
    public void pintar(String colorCambio){
        
        //Esto seria para pediro aqui en la funcion pero mejor lo pido en el main
        //System.out.println("Intoduce el nuevo color del coche: ");
        //String colorCambio = scanner.nextLine();
        //this.color = colorCambio;
        System.out.println("La nueva pintura es " + this.color);
    }
    
    public void abrirMaletero(){
        System.out.println("Abriendo maletero");
    }
}
