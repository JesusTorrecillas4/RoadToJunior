/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbanco;

import java.util.Scanner;



/**
 *
 * @author jesus
 */
public class Operaciones {
    
     
    
   /* private Operaciones(String nombre, int edad, int numCuenta, int dinero){
        super(nombre, edad, numCuenta, dinero);
    }*/
    
    
    Scanner scanner = new Scanner(System.in);
    
    public void mostrarDinero(Usuario usuarios){
        System.out.println("Tu saldo acutal es de "+ usuarios.getDinero());
    }
    
    public void retirarDinero(Usuario usuarios){
        
        System.out.println("Cuanto dinero quieres retirar?");
        int dineroRetiro = scanner.nextInt();
        
        if(dineroRetiro > usuarios.getDinero()){
            System.out.println("Saldo insuficiente");
            
        }else{
            
            dineroRetiro -= usuarios.getDinero();
            System.out.println("Se han retirado "+dineroRetiro+" euros ");
        }
    }
    
    
    
    
    public void mostrarAcciones(ClienteVip clienteVip){
        System.out.println("Tu saldo acutal es de "+ clienteVip.getAcciones());
    }
    
    
    
}
