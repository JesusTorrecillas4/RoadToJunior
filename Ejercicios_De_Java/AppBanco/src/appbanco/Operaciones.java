/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbanco;



/**
 *
 * @author jesus
 */
public class Operaciones {
    
     
    
   /* private Operaciones(String nombre, int edad, int numCuenta, int dinero){
        super(nombre, edad, numCuenta, dinero);
    }*/
    
    
    
    
    public void mostrarDinero(Usuario usuarios){
        System.out.println("Tu saldo acutal es de "+ usuarios.getDinero());
    }
    
    public void mostrarAcciones(ClienteVip clienteVip){
        System.out.println("Tu saldo acutal es de "+ clienteVip.getAcciones());
    }
    
    
    
}
