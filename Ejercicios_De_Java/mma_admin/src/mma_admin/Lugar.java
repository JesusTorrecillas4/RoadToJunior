/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mma_admin;

/**
 *
 * @author jesus
 */
public class Lugar {
    
    private String nombre;
    private String ciudad;
    private int capacidad;

    public Lugar(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCapacidad(int capacidad) {

        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }

        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
