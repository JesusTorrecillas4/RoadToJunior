/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appbanco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class AppBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        //Creo el arraylist de los clientes para que cuadno se cree se añada automaticamente
       ArrayList<Usuario> usuarios = new ArrayList();
       
       usuarios.add(new ClienteNormal("Jesus","1234ABC",21,9808,1000));
       usuarios.add(new ClienteVip("Miguel","5678DEF",62,3141,10000,"Meta","BTN"));
       
       Operaciones op = new Operaciones();
       for(Usuario usu: usuarios){
           op.mostrarDinero(usu);
           
       }
       
        System.out.println("Intoduce el nombre de usuario");
        String nombre = scanner.nextLine();
        /*if(nombre.equals(usuarios.getNombre)){
            
        }*/
       
    }
    
}
