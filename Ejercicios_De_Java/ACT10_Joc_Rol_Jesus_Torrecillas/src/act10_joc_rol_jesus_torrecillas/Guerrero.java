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
public class Guerrero extends Personaje {
    
     //Creamos las varaibles
    private int damageamele;
    private int escudo;
    
    //Creamos el constructor de guerrero
    public Guerrero(String nombre, Integer nivel, Integer vida, 
            int damageamele, int escudo){
        
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
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y añadimos la accion especial del guerrero
     @Override
    public void accionEspecial(){
        
        //System.out.println("Le has infringido" + this.getDamageamele());
        System.out.println("Le has infringido " + damageamele + " puntos de ataque");
        
    }
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos la informacion del guerrero
    @Override
    public void mostrarInfo(){
        
        super.mostrarInfo();
        System.out.println("El damage a mele es de: "+damageamele);
        System.out.println("Su escudo es de: "+escudo);
        
    }
    
    //Hacemos el polimorfismo osea sobreescribir el metodo de la madre
    //Y modificamos el mensaje del guerrero al subir de nivel
    @Override
    public void subirNivel(){
       
        System.out.println(this.getNombre()+" Ahora tu nivel es de: " +super.getNivel()+ " Y tu vida a "
                + "subido a: " + super.getVida() + " hp");
        
    }
    
    
}
