/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act16;

/**
 *
 * @author jesus
 */
abstract class LibroMadre {

    private String titulo;
    private String autor;
    private int fehcaPubli;
    private Boolean estado;
    
    public LibroMadre(String titulo, String autor, int fehcaPubli,
            Boolean estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.fehcaPubli = fehcaPubli;
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFehcaPubli() {
        return fehcaPubli;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFehcaPubli(int fehcaPubli) {
        this.fehcaPubli = fehcaPubli;
    }
    
    
    
}
