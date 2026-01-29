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
    
    private String nombre;
    private int damage;
    
    private Habilidad(String nombre, int damage){
        
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
    public void setNombre(){
        this.nombre = nombre;
    }
    public void setDamage(){
        this.damage = damage;
    }
    
    public void usarHabilidad(){
        System.out.println("Super habilidadddd "+ nombre + " quitadnooo"
        +damage+" de damageee");
    }
}
