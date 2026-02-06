/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testarraylist;

/**
 *
 * @author jesus
 */
public class VideoJuego {
    
    private String nombre;
    private int horasJugadas;
    
    public VideoJuego(String nombre, int horasJugadas){
        this.nombre = nombre;
        this.horasJugadas = horasJugadas;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getHorasJugadas(){
        return horasJugadas;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setHorasJugadas(int horasJugadas){
        this.horasJugadas = horasJugadas;
    }
    
    
}
