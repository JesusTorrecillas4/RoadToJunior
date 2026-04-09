/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package errores;

/**
 *
 * @author jesus
 */
public class Errores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Try-catch se utiliza para comprobar qu el flijo del programa
        //funciona correctamante. Si se produce un error, gracias al 
        //try-catch haremos que no finalice el programa.
        
        // Vamos a generar un error artitmetico
        
        // try: pondremos el codigo que queremos validar
        // catch: pondremos las excepciones que puede genarar el codigo de try
        
        //Valida el calculo
        try{
            
            int a= 10;
            int b = 0;
            int resultado= a/b;
            
           
            System.out.println("El resultado es:"+ resultado);
            System.out.println("FINAL");
            
        }catch(ArithmeticException e){
            
            //Error al dividir entre "0"
            System.out.println("ERROR: No se puede dividir entre 0");
            System.out.println("El objeto e:" +e.getMessage());
        }finally{
            
            //El codigo de aqui seimpre se ejectua con error o sin
            System.out.println("Esto siempre se ejecutara");
        }
        
        //Vlidar el inidce
        try{
        
            int[] numeros = {1,2,3};
            System.out.println("El valor del indice 5 es:"+ numeros[5]);
            
        }catch(IndexOutOfBoundsException e){
            
            System.out.println("ERROR: No se puede acceder al indice 5");
            System.out.println("El objeto e:"+ e.getMessage());
        }
        
        
        validarNumero(5);
        validarNumero(-5);
    }//fin main
    
    public static void validarNumero(int numero){
        
        // Throe: Otra forma de validar errores
        if(numero < 0){
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }
        System.out.println("El numero es positivo");
    }
    
}
