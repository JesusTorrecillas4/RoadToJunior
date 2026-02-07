/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiculos;

/**
 *
 * @author jesus
 */
public class Vehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creamos array de vehiculos 3 posiciones
        Vehiculo[] v = new Vehiculo[3];
        
        //Creamos los constructores en su posicion del array
        v[0] = new Coche("KIA", 2020);
        v[1] = new Bicicleta("BMX", 2025);
        v[2] = new Coche("Seat", 2009);
        
        //Recorrer el array
        for(int i=0; i < 3; i++){
            //Llamar a los metodos de:
            v[i].mostrarInfo();
            v[i].mover();
            
            // funcion instanceof que nos dice si un objeto es
            // "instancua de" algo (interface)
            if(v[i] instanceof Motorizado motor){
                
                motor.arrancar();
                motor.parar();
            }
        }
        
    }
    
}
