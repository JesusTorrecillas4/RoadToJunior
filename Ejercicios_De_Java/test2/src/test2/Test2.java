/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test2;

import java.util.Scanner;

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
        //printf
        System.out.println("Hola mundo");
        //sout + tabulacion
        System.out.println("sout + tab");
                
        //scanf
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Intodcue tu nombre:");
        
        String nom = scanner.nextLine();
        
        
        System.out.println("El nombre introducido es: " + nom);
        // Creamos un objeto de la cñase Personaa
        Personaa persona1 = new Personaa("Pepe", 44);
        Personaa persona2 = new Personaa(nom, 44);
        persona1.setNom("Antonio");
        
        System.out.println("El nombre de perosna2 es:" +persona2.getNom());
        System.out.println("El nombre del objeto perona1 es: " + persona1.getNom());
        System.out.println("Y " + persona1.getNom()+ " tiene " + persona1.getEdad()+" anios");
               
        Personaa bebe = new Personaa("Juan");
        System.out.println("Este bebe se llama: "+ bebe.getNom()+ " Y tiene la edad de :" + bebe.getEdad()+ "anios");
        
        persona1.caminar();
        
        Alumno alumno1 = new Alumno("Jai", 18, 3.6);
        
        
        alumno1.caminar();
        System.out.println("la nota de "+ alumno1.getNom()+  " es: " + alumno1.getNota());
        
         // Crear un seguno alumo pidiendo los datos nom, edad, nota
         
         System.out.println("Intodcue el nombre del alumno3: ");
         String nom1 = scanner.nextLine();
         
         System.out.println("Intouce la edad del alumno3: ");
         Integer edad = scanner.nextInt();
  
         System.out.println("Introduce la nota del alumno3: ");
         Double nota = scanner.nextDouble();
 
         Alumno alumno3 = new Alumno(nom1,edad,nota);
         
         System.out.println("El alumno 3 se llama: " + alumno3.getNom()+ 
                 " su edad es de: "+ alumno3.getEdad()+ " y su nota es de : "
                 + alumno3.getNota());
         
         //Llamar al metodo caminar aumno3
         
         alumno3.caminar();
         alumno3.estudiar();
         
         //Crear una clase profesor que herede de persona
         //Tiene que tener un atributo que sea aula
         //Tiene que tener un metodo que sea de corregir con un menaje por pantalla
         //de , Estoy harto de corregir
         
         
         Profesor profesor1 = new Profesor("Juanpi",78,106);
         
         System.out.println("El profesor1 se llama: " + profesor1.getNom()+ 
                 " su edad es de: "+ profesor1.getEdad()+ " y su aula es la : "
                 + profesor1.getAula());
         
         profesor1.corregir();
         
         // Lunes
         //Crear una clase Vehiculo que tenga los atributos:
         // Marca, matricula, potencia, velocidad
         // Tenesi que hacer los getter y setter de todos
         //Metodos acelerar --> sera sumar 120 a velocidad
         //Metodos frenar --> sera menos 1 la velocidad 
         //Metodo aparcar que si la velocidad es 0 se puede aparcar sino
         //mensaje de que tiene que frenar primero alma de cantaro
 
         Vehiculo vehiculo1 = new Vehiculo("BMW", "9313 BCN", 225, 50);
         Vehiculo vehiculo2 = new Vehiculo("Mercedes", "8723 KJA", 195, 0);

        System.out.println("El vehiculo1 de marca " + vehiculo1.getMarca() + " "
                + "va a " + vehiculo1.getVelocidad() + " Km por hora");

        vehiculo1.acelerar();
        System.out.println("Y ahora el vehiculo 1 al acelerar va a "
                + "" + vehiculo1.getVelocidad() + " Km por hora");

        vehiculo1.frenar();
        System.out.println("Ahora el vehiculo ha frenado y va a"
                + vehiculo1.getVelocidad() + " KM por hora");

        vehiculo1.aparcar();

        System.out.println("El vehiculo2: " + vehiculo2.getMarca() + " quiere"
                + " aparcar y ha recudio a 0 KM ");
        vehiculo2.aparcar();
        //Clase Moto que hereda de vehiculo 
    //Tiene el atributo tipo (String)
    //Metodo caballito con mensaje de  "Levantadno rueda"
     Moto moto1 = new Moto("Yamaha","9242 LFS", 235, 100,"Scotter");
     
        System.out.println("La moto1 es de tipo: "+ moto1.getTipo());
       moto1.caballito();
    //Clase Coche que hereda de Vehiculo
    //Tiene los atributos color(String) y puertas (Integer)
    //Metodo pintar que se actualiza el color 
    //Metodo "abrirMaletero" con mensaje "Abriendo maletero"
    Coche coche1 = new Coche("Mercedes","9342 LFS", 190, 70,"Azul", 4);
    
        System.out.println("El coche1 es de color: "+ coche1.getColor());
      
        //Este metodo seria para pedir aqui el cambio de color
        //coche1.pintar();
        //Este es para pedirlo aqui
        System.out.println("Intoduce el nuevo color del coche: ");
        
        String colorCambio = scanner.nextLine();
        coche1.pintar(colorCambio);
        
        coche1.abrirMaletero();
        
    //Clase Camión que hereda de Vehiculo
    //Tiene el atributo carga (Integer)
    
    Camion camion1 = new Camion("Audi","3423 POD", 255,90,25000);
        System.out.println("El camion1 es de marca "+ camion1.getMarca()+ "y "
                + "transporta "+ camion1.getCarga()+ " KG");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
}
