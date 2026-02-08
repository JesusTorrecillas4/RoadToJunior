/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act11_gymapp_jesus_torrecillas;

/**
 *
 * @author jesus
 */
//Heredamos la clase activitat
public class Ioga extends Activitat {
    
    //Creamos la varaible de nivel
    private String nivell;
    
    //El constructor de Ioga heredando los atributos de activitat
    public Ioga(String nivell, String nom, Double preuBase){
        
        super(nom,preuBase);
        this.nivell = nivell;
    }
    //Getter
    public String getNivell(){
        return this.nivell;
    }
    //Setter
    public void setNivell(String nivell){
        this.nivell = nivell;
    }
    
    //Hadcemos polimorfismo con la funcion de activitat
    @Override
    public void calcularPreuFinal(){
        
        System.out.println("La activitat de Ioga te un preu base de "+ getPreuBase() +
                " euros, mes un suplement de 5 per lloguer de material, en total"
                        + "serien " +(getPreuBase() + 5));
    }
    
    @Override
    public void mostrarDetalls(){
        
    }
    
    
    
}
