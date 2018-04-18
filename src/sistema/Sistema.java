/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ALBER
 */
public class Sistema {

    private ArrayList<Cliente> cliente;
    private ArrayList<Director> director;
    private ArrayList<Promotor> promotor;
    
    public Sistema(){
        init();
    }
    
    public void init(){
        promotor = new ArrayList<>();
            
        promotor.add(new Promotor("Juan",1,"yolo",this) );
        promotor.add(new Promotor("Pepe",1,"esa",this) );
        promotor.add(new Promotor("Jose",1,"ese",this) );
        promotor.add(new Promotor("Jocho",1,"ere",this) );
        
        
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Director> getDirector() {
        return director;
    }

    public void setDirector(ArrayList<Director> director) {
        this.director = director;
    }

    public ArrayList<Promotor> getPromotor() {
        return promotor;
    }

    public void setPromotor(ArrayList<Promotor> promotor) {
        this.promotor = promotor;
    }
    
    
}
