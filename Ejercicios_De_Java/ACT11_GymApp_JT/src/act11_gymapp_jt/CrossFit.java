/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act11_gymapp_jt;

/**
 *
 * @author jesus
 */
//Heredamos activitat e implementamos la promocion
public class CrossFit extends Activitat implements Promocionable{
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
        
        Double descuento = getPreuBase() * 0.20;
        System.out.println("El preu inicial es de "+ getPreuBase() + " i la "
                + "seva inetnsitat es de " + intensitat);
        this.setPreuBase(this.getPreuBase() - descuento);
        System.out.println("El descuento es de: "+ descuento);
        System.out.println("El preu final amb descompte es de "+ getPreuBase() );
    }
    
    @Override
    public Double calcularPreuFinal(){
        
        
        this.intensitat *= 2;
        //System.out.println("El preu inicial es de "+ getPreuBase() + " i la "
          //      + "seva inetnsitat es de " + intensitat);
        
        aplicarDescompte();
        System.out.println("El preu final de crosfit es de "+ (getPreuBase() + intensitat));
       
        return this.getPreuBase();
    }
    
    
    @Override
    public void mostrarDetalls(){
        super.mostrarDetalls();
        //System.out.println("La activitat CROSSFIT");
    }
    
}
