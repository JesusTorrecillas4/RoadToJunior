/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act11_gymapp_jt;

import java.util.ArrayList;
/**
 *
 * @author jesus
 */
public class ACT11_GymApp_JT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creamos el arraylist de la classe Activitat
        ArrayList<Activitat> activitats = new ArrayList();
        
        activitats.add(new Ioga("Princpipiante", "Pepe",15.5));
        activitats.add(new Ioga("Avanzado","Juana", 25.5));
        activitats.add(new CrossFit(6,"Roberto",10.5));
        activitats.add(new CrossFit(10,"Lucas", 20.5));
        
        for(Activitat act : activitats){
            
            act.mostrarDetalls();
            
            
            // funcion instanceof que nos dice si un objeto es
            // "instancua de" algo (interface)
            if(act instanceof Promocionable promo){
                
                promo.aplicarDescompte();
                
            }else{
                act.calcularPreuFinal();
            }
            
            
        }

        
    }
    
}

/*
    1. Què passaria si intentéssim instanciar la classe Activitat? Per què? 
    Daria error porque en la classe Activitat no hay ninguna intanceof y esos metodos no se pueden heredar si no se hace in implements

    2. Si haguéssim de crear una activitat de "Zumba" que també accepta descomptes, quins passos hauríem 
    de seguir per reutilitzar el codi existent? 

    Instanciarle el Promocionable y ya hay esta el metodo

    3. Per què Ioga no implementa Promocionable en aquest disseny?

    Porque hacemos otras cosas con el precio como sumarle 5 y asi en el for tenemos que hacer un if para los que si tienen promocion

*/