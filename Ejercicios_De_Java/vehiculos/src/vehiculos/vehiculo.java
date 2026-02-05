/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

/**
 *
 * @author jesus
 */
// Clase abstract: clase que no puede instanciarse (crear un objeto de una clase)
// clase que puede contener metodos abstactos
// los cuales no estan implementados en esta clase sino que se implementaran en las clases hijas (polimorfismo)
abstract class Vehiculo {

    // Atributos
    private String marca;
    private int any;

    public Vehiculo(String marca, Integer any){
        this.marca = marca;
        this.any = any;
    }

    // Getter marca
    public String getMarca(){
        return this.marca;
    }

    // Getter any
    public Integer getAny(){
        return this.any;
    }

    // Metodo "normal"
    public void mostrarInfo(){
        System.out.println("Info del vehiculo");
    }

    // Metodo abstract
    // No tiene implementacion porque lo implementaran los hijos, hijas e hijes
    abstract void mover();

}
