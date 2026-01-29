/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */
public class Guerrero extends Personaje {
    
    
    private int damageamele;
    private int escudo;
    
    public Guerrero(String nombre, Integer nivel, Integer vida, 
            int gamageamele, int escudo){
        
        super(nombre, nivel, vida);
        this.damageamele = damageamele;
        this.escudo = escudo;
    }
    
    //Getters y settes de los atributos
    
    public int getDamageamele(){
        return this.damageamele;
    }
    public int getEscudo(){
        return this.escudo;
    }
    public void setDamageamele(int damageamale){
        this.damageamele = damageamale;
    }
    public void setEscudo(int escudo){
        this.escudo = escudo;
    }
    
    public void ataque(){
        
        //System.out.println("Le has infringido" + this.getDamageamele());
        System.out.println("Le has infringido" + damageamele + " puntos de ataque");
        
    }
}
