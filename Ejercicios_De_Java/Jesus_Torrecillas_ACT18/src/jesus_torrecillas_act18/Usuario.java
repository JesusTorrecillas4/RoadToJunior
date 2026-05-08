/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesus_torrecillas_act18;

/**
 *
 * @author jesus
 */
public class Usuario {
    
    //private int id;
     private String nombre;
    private String email;
    private int edad;

    public Usuario(String nombre, String email, int edad) {
        
        //this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    /*public int getId() { 
        return id; 
    }*/
    
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEdad(int edad) {
        
        if(edad<0){
            throw new IllegalArgumentException("La edad no puede ser menro a 0");
         }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario " + "nombre=" + nombre + ", email=" + email + ", edad=" + edad;
    }
}
