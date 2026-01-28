/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author jesus
 */
public class Vehiculo {
    //Crea una clase llamada Vehiculo que tenga atributios:
    //Marca, matricuila ,potencia, velocidad
    //Tenesi que ahcer los getter y los setter de todos
    //Metodos acelerar --> sera sumar 120 a velocidad
    //Metodos frenar --> sera menos 1 a la velocidad
    //Metodo aparcar si la velocidad es 0 se puede aparcar sino
    //mensaje de que "tiene que frenar primero alma de cantaro"
    private String marca;
    private String matricula;
    private Integer potencia;
    private Integer velocidad;
    
    public Vehiculo(String marca, String matricula, Integer potencia, Integer velocidad){
    
    this.marca = marca;
    this.matricula = matricula;
    this.potencia = potencia;
    this.velocidad = velocidad;
    
    
    }
    
    //Getter
    public String getMarca(){
        return this.marca;
    }
    //Setter
    public void setMarca(String marca){
        this.marca = marca;
    }
    //Getter
    public String getMatricula(){
        return this.matricula;
    }
    //Setter
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    //Getter
    public Integer getPotencia(){
        return this.potencia;
    }
    //Setter
    public void setPotencia(Integer potencia){
        this.potencia = potencia;
    }
    //Getter
    public Integer getVelocidad(){
        return this.velocidad;
    }
    //Setter
    public void setVelocidad(Integer velocidad){
        this.velocidad = velocidad;
    }
     //Metodos acelerar --> sera sumar 120 a velocidad
    public void acelerar(){
        velocidad += 120;
        
    }
    
    //Metodos frenar --> sera menos 1 a la velocidad
    public void frenar(){
        
        velocidad -= 1;
    }
    
    //Metodo aparcar si la velocidad es 0 se puede aparcar sino
    //mensaje de que "tiene que frenar primero alma de cantaro"
    public void aparcar(){
        
        if(velocidad == 0){
            
            System.out.println(getMarca() + " Aparcando");
        }else{
            
            System.out.println(getMarca()+ " Tiene que frenar primero alma de cantaro");
        }
        
    }
    
    
    
    
}
