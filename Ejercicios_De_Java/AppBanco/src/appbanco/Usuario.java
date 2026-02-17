/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbanco;

/**
 *
 * @author jesus
 */
abstract class Usuario {
    
    private String nombre;
    private String password;
    private int edad;
    private int numCuenta;
    private int dinero;
    
    //Creamos un atributo statico como identifiaador unico cada vez ques e cree un usuario
    private static int id = 0;
    
    
    //Constructor de Usuario
    public Usuario(String nombre,String password, int edad, int numCuenta, int dinero){
        
        this.nombre = nombre;
        this.password = password;
        this.edad = edad;
        this.numCuenta = numCuenta;
        this.dinero = dinero;
        id ++;
    }
    
    //Getters para recibir la informacion de los atributos
    public String getNombre(){
    
        return this.nombre;
    }
    public String getPassword(){
        return this.password;
    }
    public int getEdad(){
        return this.edad;
    }
    public int getNumCuenta(){
        return this.numCuenta;
    }
    public int getDinero(){
        return this.dinero;
    }
    
    public static int getId(){
        return id;
    }
    
    //Setters para modificar los atributos 
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNumCuetna(int numCuenta){
        this.numCuenta = numCuenta;
    }
    public void setDinero(int dinero){
        this.dinero = dinero;
    }
    
}
