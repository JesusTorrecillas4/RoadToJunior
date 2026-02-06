/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

/**
 *
 * @author jesus
 */
//Hereda de Vehiculo e implementa la interface de Motorizado
public class Coche extends Vehiculo implements Motorizado {
    
    public Coche(String marca, int any){
        super(marca,any);
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
    }
    
    // metodo abstract de Vehiculo qe implementamos que en esta clase
    @Override
    public void mover(){
        System.out.println("BRRRRRRuuum bbbbrum");
    }
    
    //IMPLEMETNAMOS LOS METODOS QUE SI O SI TENEMOS QUE
    // IMPLEMENTAR DE LA INTERFACE MOTORIZADO
    @Override
    public void arrancar(){
        System.out.println("Arrancando que es tarde");
    }
    
    @Override
    public void parar(){
        System.out.println("Parando");
    }
}
