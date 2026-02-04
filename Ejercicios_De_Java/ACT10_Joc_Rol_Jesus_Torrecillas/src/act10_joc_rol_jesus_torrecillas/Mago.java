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
public class Mago extends Personaje {
    
     //Creamos las varaibles
    private int mana;
    private String hechizo;
    
    //Creamos el constructor de mago
    public Mago(String nombre, int nivel, int vida, int mana, String hechizo){
        
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
     @Override
    public void accionEspecial(){
        
        System.out.println("Ataqueee "+ hechizo);
        
    }
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos la informacion del mago
     @Override
    public void mostrarInfo(){
        
        super.mostrarInfo();
        System.out.println("El mana es de: "+mana);
        System.out.println("Su hechizo se llama: "+hechizo);
        
    }
    
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos el mensaje del mago al subir de nivel
    @Override
    public void subirNivel(){
       
        System.out.println(this.getNombre()+" Ahora tu nivel es de: " +super.getNivel()+ " Y tu vida a "
                + "subido a: " + super.getVida() + " hp");
        
    }
}
