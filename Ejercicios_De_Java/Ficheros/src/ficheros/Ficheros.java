/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author jesus
 */
public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Como escribir en un fichero
        try{
            
            //La clase predefinica FileWriter
            // al hacer new es como open
            FileWriter escritura = new FileWriter("fichero.txt");
            
            escritura.write("Hola Jesus \n");
            escritura.write("Esto es un .write");
            
            // Lo cerramos para que se cree
            escritura.close();
            System.out.println("Fichero creado correctamente");
        }catch(IOException e){
            
            System.out.println("Error: "+e.getMessage());
        }
        
        // Leer un fichero
        try{
            
            
            File fitxer = new File("fichero.txt");
            
            //Creamos un objeto de tipo scaneer para 
            //leer de linea a linea para leer el fitchero
            Scanner leer = new Scanner(fitxer);
            
            //Mientras haya lineas para leer, iremos mostrando las lineas en pantalla
            while(leer.hasNextLine()){
                System.out.println(leer.nextLine());
            }
           leer.close();
           
        }catch(FileNotFoundException e){
            
            System.out.println("ERROR: "+ e.getMessage());
        }
        
        
        try{
            
            FileWriter tabla = new FileWriter("tabla_multiplicar.txt");
            
            for(int i = 1; i<=10; i++){
                
                tabla.write("Tabla del:"+i+"\n");
                
                for(int j = 1; j<=10; j++){
                    
                   int a = i * j; 
                    
                    tabla.write(i+ " X "+ j+"= "+ a+"\n");
                }
            }
            
            tabla.close();
            
            
        }catch(IOException e){
            
            System.out.println("Error:"+e.getMessage());
        }
        
        try{
            
            File leerM = new File("tabla_multiplicar.txt");
            
            Scanner sc = new Scanner(leerM);
            
            
            while(sc.hasNextLine()){
                
                System.out.println(sc.nextLine());
            }
            
            sc.close();
            
        }catch(FileNotFoundException e){
            
            System.out.println("Error :"+ e.getMessage());
        }
      
    }
    
}
