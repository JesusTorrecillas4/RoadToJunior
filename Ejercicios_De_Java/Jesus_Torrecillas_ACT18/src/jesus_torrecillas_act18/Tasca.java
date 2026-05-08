/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jesus_torrecillas_act18;

/**
 *
 * @author jesus
 */
public class Tasca {
    private String descripcio;
    private String id;
    private String usuariAsignat; 

    public Tasca(String id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
        this.usuariAsignat = null;
    }

    public String getId() { 
        return id; 
    }
    
    public String getDescripcio() { 
        return descripcio;
    }
    
    public String getUsuariAsignat() { 
        return usuariAsignat; 
    }

    public void setDescripcio(String descripcio) { 
        this.descripcio = descripcio;  
    }
    
    public void setUsuariAsignat(String usuariAsignat) { 
        this.usuariAsignat = usuariAsignat; 
    }

    public boolean isAsignada() { 
        return usuariAsignat != null; 
    }

    @Override
    public String toString() {
        return "Tasca{id=" + id + ", descripcio=" + descripcio + ", usuari=" + usuariAsignat + "}";
    }
}
