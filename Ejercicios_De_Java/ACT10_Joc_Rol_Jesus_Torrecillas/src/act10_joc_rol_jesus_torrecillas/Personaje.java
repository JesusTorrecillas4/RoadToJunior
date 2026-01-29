/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

/**
 *
 * @author jesus
 */
public class Personaje {
    
    //Creamos los tributos de Personaje
    private String nombre;
    private Integer nivel;
    private Integer vida;
    
    
    //Hacemos el constructor de personaje
    public Personaje(String nombre, Integer nivel, Integer vida){
        
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        
    }
    
    //Getters para obtener la informacion de los atributos
    public String getNombre(){
        
        return this.nombre;
    }
    
    public Integer getNivel(){
        return this.nivel;
    }
    
    public Integer getVida(){
        return this.vida;
    }
    
    //Ahora los setters para editar los atributos
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setNivel(Integer nivel){
        this.nivel = nivel;
    }
    
    public void setVida(Integer vida){
        this.vida = vida;
    }
    
    public void mostrarInfo(){
        
        System.out.println("El nombre del personaje es: "+nombre);
        System.out.println("Su nivel es: "+nivel);
        System.out.println("Su vida es de: "+vida+" HP");
        
    }
    
    public void subirNivel(){
        
        nivel += 1;
        vida += 10;
        
        System.out.println("Ahora tu nivel es de: " +nivel+ " Y tu vida a "
                + "subido a: " + vida + " hp");
    }
    
    public void accionEspecial(){
        
        //Aqui va la habilidad especial de cada personaje
    }
    
   
    
    
    
    
    
    
    
    
    
}
