/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mma_admin;

/**
 *
 * @author jesus
 */
public class Luchador {
    
     private String nombre;
    private String categoria;
    private double peso;
    private int victorias;
    private int derrotas;
    private int ranking;

    public Luchador(String nombre, String categoria, double peso, int victorias, int derrotas, int ranking) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.peso = peso;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPeso() {
        return peso;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getRanking() {
        return ranking;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
        this.peso = peso;
    }

    public void setVictorias(int victorias) {
        if (victorias < 0) {
            throw new IllegalArgumentException("Las victorias no pueden ser negativas");
        }
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        if (derrotas < 0) {
            throw new IllegalArgumentException("Las derrotas no pueden ser negativas");
        }
        this.derrotas = derrotas;
    }

    public void setRanking(int ranking) {
        if (ranking < 0) {
            throw new IllegalArgumentException("El ranking no puede ser negativo");
        }
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Luchador{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", peso=" + peso +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", ranking=" + ranking +
                '}';
    }
}
