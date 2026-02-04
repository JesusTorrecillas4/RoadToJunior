/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act10_joc_rol_jesus_torrecillas;

import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class ACT10_Joc_Rol_Jesus_Torrecillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
       
        //Creamos un objeto juego para llamar a su clase para usar las funciones
        Juego juego = new Juego();
        //Creamos la habilidada especial
        Habilidad habilidad = new Habilidad("Kamehame",70);
        
        int opc;
        
        //Personaje.getContador();
        
        do{
         
            //Creamos el menu
            System.out.println("----MENU---");
            System.out.println("Elige una opcion para comenzar a jugar");
            System.out.println("1. Crear personaje");
            System.out.println("2. Mostrar persoanjes");
            System.out.println("3. Lucha de persoanjes");
            System.out.println("4. Habilidad especial");
            System.out.println("5. Subir nivel");
            System.out.println("6. Salir");
            opc = scanner.nextInt();
            scanner.nextLine();
            
            //Las opciones del menu
            switch(opc){
                
                //Los metodos creados en las anteriores clases
                //en cada case se llama al objeto y luego su metodo
                case 1 :
                    juego.crearPersonaje();
                    break;
                case 2:
                    juego.muestraPersonajes();
                    break;
                    
                case 3:
                    juego.luchar();
                    break;
                case 4:   
                    
                    habilidad.usarHabilidad();
                    
                    break;
                case 5:   
                    
                   juego.subirNivel();
                    
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Numero incorrecto ");
                    break;
            }
            
            
        }while(opc != 6);
    }
    
}
