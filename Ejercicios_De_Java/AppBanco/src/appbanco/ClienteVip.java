/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbanco;

/**
 *
 * @author jesus
 */
public class ClienteVip extends Usuario implements Bonus {

    private String acciones;
    private String cryptos;
    
    public ClienteVip(String nombre,String password, int edad, int numCuenta, int dinero, 
            String acciones, String cryptos){
        super(nombre, password, edad, numCuenta, dinero);
        this.acciones = acciones;
        this.cryptos = cryptos;
        
    }
    
    //Getter
    public String getAcciones(){
        return this.acciones;
    }
    public String getCryptos(){
        return this.cryptos;
    }
    //Setters
    public void setAcciones(String acciones){
        this.acciones = acciones;
    }
    public void setCryptos(String cryptos){
        this.cryptos = cryptos;
    }
    
    //Hacemos polimorfismo con los metodos del interface, eso significa que un
    //cliente VIP siempre va a tener activos y pasivos moviendo si dinero
    @Override
    public void pasivos(){
        
    }
    
    @Override 
    public void activos(){
        
    }
    
}
