/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mma_admin;

/**
 *
 * @author jesus
 */
public class Combate {
    
      private String id;
    private String luchador1;
    private String luchador2;
    private String lugar;
    private String fecha;

    public Combate(String id, String luchador1, String luchador2, String lugar, String fecha) {
        this.id = id;
        this.luchador1 = luchador1;
        this.luchador2 = luchador2;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public String getLuchador1() {
        return luchador1;
    }

    public String getLuchador2() {
        return luchador2;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLuchador1(String luchador1) {
        this.luchador1 = luchador1;
    }

    public void setLuchador2(String luchador2) {
        this.luchador2 = luchador2;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Combate{" +
                "id='" + id + '\'' +
                ", luchador1='" + luchador1 + '\'' +
                ", luchador2='" + luchador2 + '\'' +
                ", lugar='" + lugar + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
