/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class Juego{
    
   
    Scanner scanner = new Scanner(System.in);
   
    //Creamos un objeto de personaje con array de 3
    Personaje[] personaje = new Personaje[3];
    
    
    //Metodo para crear persoanjes
    public void crearPersonaje(){
        
    
        //For para crear hasa la longitud del array
        for(int i = 0; i < personaje.length;i++){
            
            //Contador de persoanjes
            System.out.println("El total de personajes: " + Personaje.getContador());
            
            //Control de errores por si tienes el array lleno
            if (personaje[i].getContador() == personaje.length){
                System.out.println("Maximo de personajes implementados");
                return;
            }

            System.out.println("Que tipo de personaje quieres implementar?\n");
            System.out.println("1. Guerro\n");
            System.out.println("2. Mago\n");
            System.out.println("3. Arquero\n");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {

                case 1:
                    
                    //Pedimos datos para el persoanje
                    System.out.println("Personaje clase Guerrero\n");
                    System.out.println("Intoduce el nombre del personaje: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduce el nivel del persoanje: ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la vida del personaje: ");
                    int vida = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el damage a mele personaje: ");
                    int damageamele = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el nivel de escudo del personaje: ");
                    int escudo = scanner.nextInt();
                    scanner.nextLine();

                    //Creamos en el array persoanje un objeto guerrero con los datos intoducidos
                    personaje[i] = new Guerrero(nombre, nivel, vida,
                            damageamele, escudo);

                    break;

                case 2:

                    System.out.println("Personaje clase Mago\n");
                    System.out.println("Intoduce el nombre del personaje: ");
                    String nombre1 = scanner.nextLine();
                    System.out.println("Introduce el nivel del persoanje: ");
                    int nivel1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la vida del personaje: ");
                    int vida1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el mana del personaje: ");
                    int mana = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el nombre del hechizo: ");
                    String hechizo = scanner.nextLine();

                    //Creamos en el array persoanje un objeto mago con los datos intoducidos
                    personaje[i] = new Mago(nombre1, nivel1, vida1, mana, hechizo);

                    break;

                case 3:
                    System.out.println("Personaje clase Arquero\n");
                    System.out.println("Intoduce el nombre del personaje: ");
                    String nombre2 = scanner.nextLine();
                    System.out.println("Introduce el nivel del persoanje: ");
                    int nivel2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la vida del personaje: ");
                    int vida2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la punteria del personaje: ");
                    int punteria = scanner.nextInt();
                    scanner.nextLine();

                    //Creamos en el array persoanje un objeto arquero con los datos intoducidos
                    personaje[i] = new Arquero(nombre2, nivel2, vida2, punteria);

                    break;

                default:

                    System.out.println("Numero incorrecto");

                    break;

            }
        }
        
      
    }
    
    //Mostramos la informacion de los persoanjes llamadno a sus metodos
    public void muestraPersonajes(){
        
        for(int i = 0; i < personaje.length;i++){
            
            personaje[i].mostrarInfo();
            
        }
    }
    
    //Los persoanjes luchasn usando su metodo
    public void luchar(){
        
        for(int i = 0; i< personaje.length;i++){
            
            personaje[i].accionEspecial();
        }
    }
    
  //Este metodo sube el nivel de los personajes
    public void subirNivel(){
          for(int i = 0; i< personaje.length;i++){
            
            personaje[i].subirNivel();
        }
    }
    
  
    
    
}
