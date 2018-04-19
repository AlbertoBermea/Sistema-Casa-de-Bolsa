/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author ALBER
 */
public class Sistema {
    private ArrayList<Cliente> cliente;
    private Director director;
    private ArrayList<Promotor> promotor;
    private int diaActual;
    private int yearActual;
    private ArrayList<Cete> cetes;
    private ArrayList<BondeD> bondes;
    
    public Sistema(){
        init();
    }
    
    public void init(){
        promotor = new ArrayList<>();
        cliente = new ArrayList<>();
        cetes = new ArrayList<>();
        bondes = new ArrayList<>();     
        director = new Director("",0,"",this);
        
       
        
        Files.loadFile(this);
        
        
        Iterator itr = cetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            
            //System.out.println(cet.getTasaFija());
        }
        
        /*
        bondes.add( new BondeD(2,1,200, 1, 28,yearActual,diaActual, 0, 0 , 0, false, 1.003 ,this ) );
        cetes.add( new Cete(1,1,1200, 1, 28,yearActual,diaActual, 0, 0 , 0, false, 1.03 ,this ) );
        cetes.add( new Cete(2,2,1400, 2, 28,yearActual, diaActual,0,0, 0, false, 1.02,this ) );
        yearActual = 2018;
        diaActual = 100;
        
        
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

    public int getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }

    public int getYearActual() {
        return yearActual;
    }

    public void setYearActual(int yearActual) {
        this.yearActual = yearActual;
    }

    public ArrayList<Cete> getCetes() {
        return cetes;
    }

    public void setCetes(ArrayList<Cete> cetes) {
        this.cetes = cetes;
    }

    public ArrayList<BondeD> getBondes() {
        return bondes;
    }

    public void setBondes(ArrayList<BondeD> bondes) {
        this.bondes = bondes;
    }
    
    
}
