/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */
public class Arquero extends Personaje{
    
    private String tipoFlecha;
    
    private Arquero(String nombre, int nivel, int vida, String tipoFlecha){
        
        super(nombre, nivel, vida);
        this.tipoFlecha = tipoFlecha;
    }
    
    //getter y setter
    public String getTipoFlecha(){
        return this.tipoFlecha;
    }
    
    public void setTipoFlecha(){
        this.tipoFlecha = tipoFlecha;
    }
    
    public void Disapro(){
        
        System.out.println("Disparo con la flechaaa "+ tipoFlecha);
    }
    
}
