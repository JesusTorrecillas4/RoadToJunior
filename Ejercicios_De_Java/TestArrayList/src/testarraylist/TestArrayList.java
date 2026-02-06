/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testarraylist;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class TestArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Creamos un ArrayList de tipo String
        
        ArrayList<String> jocs = new ArrayList();
        
        // Añadir un juego
        jocs.add("Minecraft");
        jocs.add("Lol");
        
        System.out.println("En la posicion 0: "+ jocs.get(0));
        System.out.println("En la posicion 1: "+ jocs.get(1));
        
        //Quiero añadir un juego en la posicion uno (0)
        jocs.add(0, "Tetris");
        
        System.out.println("Despues de añadir en la poscion 0: ");
        System.out.println("En la posicion 0: "+ jocs.get(0));
        System.out.println("En la posicion 1: "+ jocs.get(1));
       /* System.out.println("En la posicion 2: "+ jocs.get(2));*/
        
        // Set: Modificar el valor pasandole el index
        jocs.set(0, "Pacman");
         System.out.println("Despues de modificar en la poscion 0: ");
        System.out.println("En la posicion 0: "+ jocs.get(0));
        System.out.println("En la posicion 1: "+ jocs.get(1));
        /*System.out.println("En la posicion 2: "+ jocs.get(2));
        System.out.println("En la posicion 3: "+ jocs.get(3));*/
        
        // Remove: eliminar un elemento del array
        //jocs.remove(0);
        System.out.println("Despues de eliminar en la poscion 0: ");
        System.out.println("En la posicion 0: "+ jocs.get(0));
        System.out.println("En la posicion 1: "+ jocs.get(1));
        
        // Size: Tamaño del array
        int total = jocs.size();
        System.out.println("El tamaño del array es:"+ total);
        
        // Leer los datos
        // De forma antigua
        for(int i=0; i < jocs.size(); i++){
        
            System.out.println("El contenido en posicion i: " + i + " es:" +
                    jocs.get(i));
        }
        
        System.out.println("--- FOR EACH ---");
        // For each (Por cada)
        for(String joc : jocs){
            System.out.println("El contenido es: " + joc);
        }
        
        // Contains: Buscamos
        if(jocs.contains("Minecraft")){
            System.out.println("El Minecraft si que esta!!!!!");
        }else{
            System.out.println("No estaaa");
        }
        
        
        // indexOf: Para saber EL INDEX
        int posicion = jocs.indexOf("Minecraft");
        if(posicion != -1){
            System.out.println("El index de Minecraft es: " + posicion);
        }else{
            System.out.println("No estaaaaa");
        }
        
        // isEmpty() Para saber si el array esat vacio o no?
        System.out.println("El array esta vacio?? "  + jocs.isEmpty());
        
        // clear() Limpiando los arrays (Liberar memoria)
        jocs.clear();
        
        
        // Creamos un array de objetos de tipo VideoJuego
        // Clase en singular / ararys en plural
        ArrayList<VideoJuego> videojuegos = new ArrayList<>();
        
        // Guardar datos añadir objetos
        videojuegos.add(new VideoJuego("Minecraft", 509));
        videojuegos.add(new VideoJuego("Lol", 241));
        videojuegos.add(new VideoJuego("GTA", 913));
        
        // Buscar y modificar un atributo
        // Supongamos que queremos buscar Lol y modificar las horas de juego
        String nombreABuscar = "Lol";
        
        //Recorremos el array videojuegos de tipo VideoJuegos
        // y en cada iteracion lo combertimos en vj
        for(VideoJuego vj : videojuegos){
            
            if(vj.getNombre().equalsIgnoreCase(nombreABuscar)){
                System.out.println("Nombre encontradooooo");
                vj.setHorasJugadas(vj.getHorasJugadas() + 100);
                System.out.println("Las horas actualizadas de "+ nombreABuscar + ""
                        + " son: " +vj.getHorasJugadas());
            }else{
                System.out.println("Nombre no encontrado :C");
            }
        }
        
        //Queremos actualizar el nobre del objeto Minecraft
        videojuegos.get(0).setNombre("Minecraft Second Edition");
        
    }
    
}
