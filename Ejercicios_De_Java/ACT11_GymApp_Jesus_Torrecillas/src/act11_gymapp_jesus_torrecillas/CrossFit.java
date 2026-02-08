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
    
    // Creamos el constructor
    public CrossFit(int intensitat,String nom, Double preuBse){
        super(nom,preuBse);
        this.intensitat = intensitat;
    }
    
    //Getter
    public int getIntesitat(){
        return this.intensitat;
    }
    
    //Setter
    public void setIntesitat(int intensitat){
        this.intensitat = intensitat;
    }
    
    
    
    @Override
    public void aplicarDescompte(){
        
       // getPreuBase *= 0.8;
       
    }
    
    public void calcularPreuFinal(){
        
        this.intensitat *= 2;
        System.out.println("El preu inicial es de "+ getPreuBase() + " i la "
                + "seva inetnsitat es de " + intensitat);
        System.out.println("El preu final de crosfit es de "+ (getPreuBase() + intensitat));
    }
    
    
    @Override
    public void mostrarDetalls(){
        
    }
    
}
