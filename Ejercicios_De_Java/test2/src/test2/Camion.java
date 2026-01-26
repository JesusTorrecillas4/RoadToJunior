/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Camion extends Vehiculo{
    
    private Integer carga;
    
    public Camion(String marca, String matricula, Integer potencia, 
            Integer velocidad, Integer carga){
        
            super(marca, matricula, potencia, velocidad);
            this.carga = carga;
        
    }
    
    //Getter
    public Integer getCarga(){
        return this.carga;
    }
    
    //Setter
    public void setCarga(Integer carga){
        this.carga = carga;
    }
    
    
    
    
    
    
    
    
    
    
}
