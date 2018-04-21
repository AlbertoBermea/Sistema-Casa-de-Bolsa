/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ALBER
 */
public class Sistema {
    private double dineroBanco;
    private ArrayList<Cliente> cliente;
    private Director director;
    private ArrayList<Promotor> promotor;
    private int diaActual;
    private ArrayList<Cete> cetes;
    private ArrayList<BondeD> bondes;
    private int clientestotales = 0;
    private int promotorestotales = 0;
    private int cetestotales = 0;
    private int bondestotales = 0;
    
    public Sistema(){
        init();
    }
    
    public void init(){
        promotor = new ArrayList<>();
        cliente = new ArrayList<>();
        cetes = new ArrayList<>();
        bondes = new ArrayList<>();     
        director = new Director("",0,"",this);
        
       // for(int i = 0 ; i < 10;i++){
         //   System.out.println(ThreadLocalRandom.current().nextDouble(1.00, 1.009));
        //}
       
        
        Files.loadFile(this);
        
        Iterator itr = cetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            
            //System.out.println(cet.getTasaFija());
        }
        
        /*
        diaActual = 100;
        
        bondes.add( new BondeD(2,1,200, 1, 28,diaActual, 0, false, 1.003 ,this ) );
        cetes.add( new Cete(1,1,1200, 1, 28,diaActual,  0, false, 1.03 ,this ) );
        cetes.add( new Cete(2,2,1400, 2, 28, diaActual, 0, false, 1.02,this ) );
        
        
        
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

    public int getClientestotales() {
        return clientestotales;
    }

    public void setClientestotales(int clientestotales) {
        this.clientestotales = clientestotales;
    }

    public int getPromotorestotales() {
        return promotorestotales;
    }

    public void setPromotorestotales(int promotorestotales) {
        this.promotorestotales = promotorestotales;
    }

    public int getCetestotales() {
        return cetestotales;
    }

    public void setCetestotales(int cetestotales) {
        this.cetestotales = cetestotales;
    }

    public int getBondestotales() {
        return bondestotales;
    }

    public void setBondestotales(int bondestotales) {
        this.bondestotales = bondestotales;
    }
    
    public void CrearCete(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp){
        System.out.println(plazo);
        cetestotales++;
        cetes.add( new Cete(idc,idp,valor, cetestotales, plazo,diaActual,  0, false, tasa ,this ) );
    }
    
    public void CrearBonde(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp){
        bondestotales++;
        bondes.add( new BondeD(idc,idp,valor, bondestotales, plazo,diaActual,  0, false, tasa ,this ) );
    }
    
    public void eliminarCliente(int id){
        Iterator itr = cliente.iterator();
        while(itr.hasNext()){
            Cliente cli = (Cliente) itr.next();
            if( cli.getId() == id){
                cliente.remove(cli);
                break;
            }
        }
    }
    
    public void eliminarPromotor(int id){
        Iterator itr = promotor.iterator();
        while(itr.hasNext()){
            Promotor pro = (Promotor) itr.next();
            if( pro.getId() == id){
                promotor.remove(pro);
                break;
            }
        }
    }
    public void CambioDias(int dias){
        CambioDiasCetes(dias);
        CambioDiasBondes(dias);
    }
    public void CambioDiasCetes(int dias){
        Iterator itr = cetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            cet.setDiasTranscurridos(cet.getDiasTranscurridos() + dias);
            if(cet.getDiasTranscurridos() > cet.getPlazo()){
                double temp = cet.getValorNominal() * cet.getTasaFija();
                double temp2 = temp - cet.getValorNominal();
                double comision = temp * .05;
                dineroBanco = dineroBanco + comision;
                //
                Iterator itr2 = promotor.iterator();
                while(itr2.hasNext()){
                    Promotor pro = (Promotor) itr2.next();
                    if(pro.getId() == cet.getIdPromotor() ){
                        pro.setTotalComisiones(pro.getTotalComisiones() + comision);
                    }
                }
                itr2 = cliente.iterator();
                while(itr2.hasNext()){
                    Cliente cli = (Cliente) itr2.next();
                    if( cli.getId() == cet.getIdCliente() ){
                        cli.setBalance( cli.getBalance() + temp - (comision * 2) );
                    }
                }
                cetes.remove(cet);     
                itr = cetes.iterator();
            }
        }
    }
    public void CambioDiasBondes(int dias){
        for (int i = 0 ; i < dias ; i++){
            Iterator itr = bondes.iterator();
            while(itr.hasNext()){
                BondeD bon = (BondeD) itr.next();
                bon.setDiasTranscurridos(bon.getDiasTranscurridos() + 1);
                if(bon.getDiasTranscurridos() > bon.getPlazo()){
                    double temp = bon.getValorNominal() * bon.getTasaActual();
                    double temp2 = temp - bon.getValorNominal();
                    double comision = temp * .05;
                    dineroBanco = dineroBanco + comision;
                    //
                    Iterator itr2 = promotor.iterator();
                    while(itr2.hasNext()){
                        Promotor pro = (Promotor) itr2.next();
                        if(pro.getId() == bon.getIdPromotor() ){
                            pro.setTotalComisiones(pro.getTotalComisiones() + comision);
                        }
                    }
                    itr2 = cliente.iterator();
                    while(itr2.hasNext()){
                        Cliente cli = (Cliente) itr2.next();
                        if( cli.getId() == bon.getIdCliente() ){
                            cli.setBalance( cli.getBalance() + temp - (comision * 2) );
                        }
                    }
                    bondes.remove(bon);     
                    itr = bondes.iterator();
                }
                else{
                    bon.setValorNominal( bon.getValorNominal() * bon.getTasaActual() );
                    bon.setTasaActual(ThreadLocalRandom.current().nextDouble(1.00, 1.009));
                }
            }
        }
    }
}
