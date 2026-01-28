/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test2;

import java.util.*;
/**
 *
 * @author jesus
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hola Mundo");
        
        //sout + tabulador
        System.out.println("Sout + tabulador");
        
        //scanf
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Intoduce tu nombre: ");
        
        String nom = scanner.nextLine();
        
        System.out.println("El nombre introducido es: "+ nom);
        
        //Creamos un objeto de clase persona
        Persona Persona1 = new Persona("Pepe", 44);
        Persona Persona2 = new Persona("Maria", 53);
        
        //Para cambiar un nombre seria
        //persona1.setNom("Juan");
        
        System.out.println("El nombre de persona1 es: "+ Persona1.getNom() + " y su edad es " + Persona1.getEdad());
        System.out.println("El nombre de persona2 es: "+ Persona2.getNom());
        
        Persona bebe = new Persona("Jaunpi");
        
        System.out.println("Este bebe se llama: "+ bebe.getNom() + " y su edad es " + bebe.getEdad()+ " anios");
        
        Persona1.caminar();
        
        Alumno alumno1 = new Alumno("Pedro",19, 9.7);
        
        alumno1.caminar();
        
        
        System.out.println("La nota del alumno1 es de: " +alumno1.getNota());   
         
        System.out.println("Intoduce el nombre del alumno3: ");
        
         String nom1 = scanner.nextLine();
         
        System.out.println("Intoduce la edad del alumno 3: ");
        
        Integer edad = scanner.nextInt();
       
        
        System.out.println("Intoduce la nota del alumno3: ");
        Double nota = scanner.nextDouble();
        
        
        Alumno alumno3 = new Alumno(nom1, edad, nota);
        
        System.out.println("El nombre del alumno3 es: "+ alumno3.getNom()+" "
                + "su edad es de "+ alumno3.getEdad()+ " y su nota es de "
            + alumno3.getNota());
     
        Vehiculo vehiculo1 = new Vehiculo("BMW","9313 BCN",225,50);
        Vehiculo vehiculo2 = new Vehiculo("Mercedes", "8723 KJA",195, 0);   
        
        System.out.println("El vehiculo1 de marca "+ vehiculo1.getMarca()+ " "
                + "va a "+ vehiculo1.getVelocidad()+ " Km por hora");
        
        vehiculo1.acelerar();
        System.out.println("Y ahora el vehiculo 1 al acelerar va a "
                + "" +vehiculo1.getVelocidad()+ " Km por hora");
        
        vehiculo1.frenar();
        System.out.println("Ahora el vehiculo ha frenado y va a" 
                +vehiculo1.getVelocidad() + " KM por hora");
        
        
        vehiculo1.aparcar();
        
        System.out.println("El vehiculo2: "+ vehiculo2.getMarca()+ " quiere"
                + " aparcar y ha recudio a 0 KM ");
        vehiculo2.aparcar();
       
        
        
        
        
        
        
    }
    
}
