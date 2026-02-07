/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package act11_gymapp_jesus_torrecillas;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class ACT11_GymApp_Jesus_Torrecillas {

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
        
        
    }
    
}
