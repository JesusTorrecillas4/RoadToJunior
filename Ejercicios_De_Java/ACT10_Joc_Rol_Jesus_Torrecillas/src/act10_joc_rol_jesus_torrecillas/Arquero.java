/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */

//Llamamos a la clase personaje
public class Arquero extends Personaje{
    
     //Creamos las varaibles
    private int punteria;
    
    //Creamos el constructor de arquero
    public Arquero(String nombre, int nivel, int vida, int punteria){
        
        super(nombre, nivel, vida);
        this.punteria = punteria;
    }
    
    //getter y setter
    public Integer getPunteria(){
        return this.punteria;
    }
    
    public void setPunteria( int punteria){
       this.punteria = punteria;
    }
     @Override
    public void accionEspecial(){
        
        System.out.println("Disparo con la flechaaa "+ punteria);
    }
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos la informacion del arquero
     @Override
    public void mostrarInfo(){
        
        super.mostrarInfo();
        System.out.println("Su punteria es de: "+punteria);
        
        
    }
    
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos el mensaje del arquero al subir de nivel
    @Override
    public void subirNivel(){
       
        System.out.println(this.getNombre()+" Ahora tu nivel es de: " +super.getNivel()+ " Y tu vida a "
                + "subido a: " + super.getVida() + " hp");
        
    }
    
}
