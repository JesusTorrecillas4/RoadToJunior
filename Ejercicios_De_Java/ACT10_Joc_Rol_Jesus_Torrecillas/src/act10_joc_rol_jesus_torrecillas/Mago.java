/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */
public class Mago extends Personaje {
    
    private int mana;
    private String hechizo;
    
    private Mago(String nombre, int nivel, int vida, int mana, String hechizo){
        
        super(nombre, nivel, vida);
        this.mana = mana;
        this.hechizo = hechizo;
    }
    
    //Getters y setters
    public int getMana(){
        return this.mana;
    }
    public String getHechizo(){
        return this.hechizo;
    }
    public void setMana(int mana){
        this.mana = mana;
    }
    public void setHechizo(String hechizo){
        this.hechizo = hechizo;
    }
    
    public void Ataquemagico(){
        
        System.out.println("Ataqueee "+ hechizo);
        
    }
}
