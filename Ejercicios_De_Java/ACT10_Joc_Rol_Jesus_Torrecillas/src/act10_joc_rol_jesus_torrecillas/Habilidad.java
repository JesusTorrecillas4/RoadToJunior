/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */
public class Habilidad {
    
    //Creamos las varaibles
    private String nombre;
    private int damage;
    
    //Creamos el constructor
    public Habilidad(String nombre, int damage){
        
        this.nombre = nombre;
        this.damage = damage;
    }
    
    //Getters y setters
    public String getNombre(){
        return this.nombre;
    }
    public Integer getDamage(){
        return this.damage;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    //Creamos el metodo de habilidad
    public void usarHabilidad(){
        System.out.println("Super habilidadddd "+ nombre + " quitadnooo"
        +damage+" de damageee");
    }
}
