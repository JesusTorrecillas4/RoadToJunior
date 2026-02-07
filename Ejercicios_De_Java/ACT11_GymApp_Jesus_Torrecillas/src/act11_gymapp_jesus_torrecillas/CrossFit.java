/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act11_gymapp_jesus_torrecillas;

/**
 *
 * @author jesus
 */

//Heredamos activitat e implementamos la promocion
public class CrossFit extends Activitat implements Promocionable {
    
    private int intensitat;
    
    public CrossFit(int intensitat,String nom, Double preuBse){
        super(nom,preuBse);
        this.intensitat = intensitat;
    }
    
    
}
