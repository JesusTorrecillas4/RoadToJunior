/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test3;

    import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Vamos a crear una clase Intsrumento
       //Instrumento tiene los atributos: nombre,tipo
       //atributo static contador (integer)
       //Metodos: "tocar" con mesnaje de tocando el instrumento" + nombre
       //Metodo static fetcontador (retorna el contador)
       
       Instrumento instrumento1 = new Instrumento("Guitarra", "Electrico");
        System.out.println("El instrumento1 se llama: "+ instrumento1.getNombre()
        +" y es de tipo: "+instrumento1.getTipo());
        
        instrumento1.tocar();
       
       //Clase Flauta que hereda de instrumento
       //Atributo material (String)
       //Sobreescribir (Override(Polimorfismo)) el metodo "tocar" el mensje
       //"Piri piri piriiiiiiiiii"
       Flauta flauta1 = new Flauta("Flautilla", "Lengua","Madera");
        System.out.println("La flauta1 se llama: "+ flauta1.getNombre()
        +" y es de tipo: "+flauta1.getTipo()+ " y su material es de: " 
                +flauta1.getMaterial());
        
        flauta1.tocar();
       
       //Clase tambor que hereda de Instrumentos
       //Sin atributos adicionales
       //Sobreescribir (Override(Polimorfismo)) el metodo "tocar" el mensje
       //"Pom pom poooooooooom"
        Tambor tambor1 = new Tambor("Tamborillo","Cuero");
        System.out.println("El tambor1 se llama: "+ tambor1.getNombre()
        +" y es de tipo: "+tambor1.getTipo());
        
        tambor1.tocar();
        
        //Le pedimos al usuario el numero de elementos
        //Crear instrumentos:
        //- Pedir los datos al usuario
        //- Que tipo de instrumento es?
        //- Crear el instrumento
        // Poder tocar el istrumento que queramos
        //Mostrar la informacion del instrumento
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos instrumenots quieres?");
        int TotalInstrumentos = scanner.nextInt();
        scanner.nextLine(); //Para limpiar buffer
        
        //Vamos a crear un array de clase Instrumentos
        //Declaramos un array "instrumentos" del tipo de la clase
        //Instrumento y del tamaño totalInstrumenots
        Instrumento[] instrumentos = new Instrumento[TotalInstrumentos];
        
        for(int i =0; i < TotalInstrumentos; i++){
            
            System.out.println("Que intrsumentos queres crear: ");
            System.out.println("1.Flauta ");
            System.out.println("2.Tambor");
            System.out.println("Escoge una opcion: ");
            int iTipo =scanner.nextInt();
            scanner.nextLine(); //Limpiar buffer
           
            /*
            if(iTipo == 1){
                
                System.out.println("Intoduce el nombre de la faluta:");
                String nombre = scanner.nextLine();
                
                System.out.println("Intoduce el material de la faluta:");
                String material = scanner.nextLine();
                
                //Guardar el objeto Flauta en el array instrumenots
                instrumentos[i] = new Flauta(nombre, material);
            }else{
                
                System.out.println("Intoduce el nombre del tambor:");
                String nombre = scanner.nextLine();
                
                instrumentos[i] = new Tambor(nombre);
                
            }*/
            
            switch(iTipo){
                
                case 1 -> {
               
                    System.out.println("Intoduce el nombre de la faluta:");
                    String nombre = scanner.nextLine();

                    System.out.println("Intoduce el material de la faluta:");
                    String material = scanner.nextLine();

                    //Guardar el objeto Flauta en el array instrumenots
                    instrumentos[i] = new Flauta(nombre, material);
                }
                
                case 2 ->{
                    
                    System.out.println("Intoduce el nombre del tambor:");
                    String nombre = scanner.nextLine();

                    instrumentos[i] = new Tambor(nombre);
                    
                }
                
                default ->{
                    
                    System.out.println("ERROR numeor no valido");
                }
                
                
            }
 
           
        }
        
        
        for(int j = 0; j < instrumentos.length; j++){
                System.out.println("Tipo "+instrumentos[j].getTipo()
                +" tiene de nombre: "+ instrumentos[j].getNombre());
        }
    }

   
    
}
