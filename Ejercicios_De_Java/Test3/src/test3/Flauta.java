/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test3;

/**
 *
 * @author jesus
 */
public class Flauta extends Instrumento {
    
    private String material;
    
    public Flauta(String nombre, String tipo, String material){
        
        super(nombre, tipo);
        this.material = material;
    }
    
     public Flauta(String nombre, String material){
        
        super(nombre, "Viento");
        this.material = material;
    }
    
    //Get
    public String getMaterial(){
        return this.material;
    }
    
    //Set
    public void setMaterial(String material){
        this.material = material;
    }
    
    //Override / Sobreescribir el metodo tocar
    //Polimorfismo
    @Override
    public void tocar(){
        
        System.out.println("Piri piri piriiiiiiiiii ");
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
