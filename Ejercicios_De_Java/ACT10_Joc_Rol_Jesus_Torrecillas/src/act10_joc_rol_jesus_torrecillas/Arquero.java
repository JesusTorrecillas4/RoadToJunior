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
    
    private int punteria;
    
    public Arquero(String nombre, int nivel, int vida, int punteria){
        
        super(nombre, nivel, vida);
        this.punteria = punteria;
    }
    
    //getter y setter
    public Integer getPunteria(){
        return this.punteria;
    }
    
    public void setPunteria(){
       this.punteria = punteria;
    }
    
    public void Disapro(){
        
        System.out.println("Disparo con la flechaaa "+ punteria);
    }
    
     @Override
    public void mostrarInfo(){
        
        super.mostrarInfo();
        System.out.println("Su punteria es de: "+punteria);
        
        
    }
    
}
