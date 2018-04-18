/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 *
 * @author ALBER
 */
public class Sistema {
    private ArrayList<Cliente> cliente;
    private Director director;
    private ArrayList<Promotor> promotor;
    private Calendar diaActual;
    private ArrayList<Inversion> inversion;
    
    public Sistema(){
        init();
    }
    
    public void init(){
        promotor = new ArrayList<>();
        cliente = new ArrayList<>();
        director = new Director("",0,"",this);
        
        Files.loadFile(this);
        
        diaActual = new GregorianCalendar(2018,11,18);
        System.out.println(diaActual.get(diaActual.YEAR) );
        System.out.println(diaActual.get(diaActual.MONTH) );
        System.out.println(diaActual.get(diaActual.DAY_OF_YEAR) );
        
        /*
        promotor = new ArrayList<>();
            
        promotor.add(new Promotor("Juan",1,"yolo",this) );
        promotor.add(new Promotor("Pepe",2,"esa",this) );
        promotor.add(new Promotor("Jose",3,"ese",this) );
        
        cliente = new ArrayList<>();
        
        cliente.add( new Cliente("Jocho",1,"yolo",this) );
        cliente.add( new Cliente("pito",2,"efe",this) );
        cliente.add( new Cliente("puta",3,"ers",this) );

        director = new Director("DonChingon",1,"yolo",this);
        Files.saveFile(this);*/
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public ArrayList<Promotor> getPromotor() {
        return promotor;
    }

    public void setPromotor(ArrayList<Promotor> promotor) {
        this.promotor = promotor;
    }
    
    public void GuardarDatos(){
        Files.saveFile(this);
    }

    public Calendar getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(Calendar diaActual) {
        this.diaActual = diaActual;
    }
}
