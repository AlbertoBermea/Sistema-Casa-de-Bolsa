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
    private ArrayList<Cete> historialCetes;
    private ArrayList<BondeD> historialBondes;
    
    public Sistema(){
        init();
    }
    
    public void init(){
        promotor = new ArrayList<>();
        cliente = new ArrayList<>();
        cetes = new ArrayList<>();
        bondes = new ArrayList<>();     
        director = new Director("",0,"",this);
        historialCetes = new ArrayList<>();
        historialBondes = new ArrayList<>();
        
        Files.loadFile(this);
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

    public double getDineroBanco() {
        return dineroBanco;
    }

    public void setDineroBanco(double dineroBanco) {
        this.dineroBanco = dineroBanco;
    }

    public ArrayList<Cete> getHistorialCetes() {
        return historialCetes;
    }

    public void setHistorialCetes(ArrayList<Cete> historialCetes) {
        this.historialCetes = historialCetes;
    }

    public ArrayList<BondeD> getHistorialBondes() {
        return historialBondes;
    }

    public void setHistorialBondes(ArrayList<BondeD> historialBondes) {
        this.historialBondes = historialBondes;
    }
    
    public void CrearCete(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp){
        cetestotales++;
        cetes.add( new Cete(idc,idp,valor, cetestotales, plazo,  0, reinversion, tasa ,this ) );
    }
    
    public void CrearBonde(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp){
        bondestotales++;
        bondes.add( new BondeD(idc,idp,valor, cetestotales, plazo,  0, reinversion, tasa ,this ) );
    }
    
    public void CrearHistorialCete(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp, int id,double com1,double com2){
        historialCetes.add( new Cete(idc,idp,valor, id, plazo,  0, reinversion, tasa,com1,com2 ,this ) );
    }
    
    public void CrearHistorialBonde(double valor,int idc,int plazo, double tasa, boolean reinversion, int idp, int id,double com1,double com2){
        historialBondes.add( new BondeD(idc,idp,valor, id, plazo, 0, reinversion, tasa ,com1,com2,this ) );
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
        CambioDiasHistorial(dias);
    }
    
    public void CambioDiasCetes(int dias){
        Iterator itr = cetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            cet.setDiasTranscurridos(cet.getDiasTranscurridos() + dias);
        }
        
        itr = cetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            if(cet.getDiasTranscurridos() > cet.getPlazo()){
                double temp = cet.getValorNominal() * cet.getTasaFija();
                double temp2 = temp - cet.getValorNominal();
                double comision = temp2 * .05;
                //System.out.println(temp + "     " + temp2 + "       " + comision);
                dineroBanco = dineroBanco + comision;
                Iterator itr2 = promotor.iterator();
                while(itr2.hasNext()){
                    Promotor pro = (Promotor) itr2.next();
                    if(pro.getId() == cet.getIdPromotor() ){
                        pro.setTotalComisiones(pro.getTotalComisiones() + comision);
                    }
                }
                if(cet.isReinversion()){
                    CrearCete(temp - (comision * 2), cet.getIdCliente(), cet.getPlazo(),cet.getTasaFija(),cet.isReinversion(),cet.getIdPromotor() );
                }
                else{
                    itr2 = cliente.iterator();
                    while(itr2.hasNext()){
                        Cliente cli = (Cliente) itr2.next();
                        if( cli.getId() == cet.getIdCliente() ){
                            cli.setBalance( cli.getBalance() + temp - (comision * 2) );
                        }
                    }
                }
                CrearHistorialCete( cet.getValorNominal() ,cet.getIdCliente(), cet.getPlazo() ,cet.getTasaFija() ,cet.isReinversion(),cet.getIdPromotor(), cet.getId(),comision,comision );
                
                cetes.remove(cet);     
                itr = cetes.iterator();
            }
        }
    }
    
    public void CambioDiasBondes(int dias){
        for (int i = 0 ; i < dias ; i++ ){
            Iterator itr = bondes.iterator();
            while(itr.hasNext()){
                BondeD bon = (BondeD) itr.next();
                if(bon.getDiasTranscurridos() < bon.getPlazo() ){
                    bon.setDiasTranscurridos(bon.getDiasTranscurridos() + 1);
                }                
            }
        }          
        
        for (int i = 0 ; i < dias ; i++ ){
            Iterator itr = bondes.iterator();
            while(itr.hasNext()){
                BondeD bon = (BondeD) itr.next();
                if(bon.getDiasTranscurridos() > bon.getPlazo()){
                    double temp = bon.getValorNominal() * bon.getTasaActual();
                    double temp2 = temp - bon.getValorNominal();
                    double comision = temp2 * .05;
                    dineroBanco = dineroBanco + comision;
                    
                    //
                    Iterator itr2 = promotor.iterator();
                    while(itr2.hasNext()){
                        Promotor pro = (Promotor) itr2.next();
                        if(pro.getId() == bon.getIdPromotor() ){
                            pro.setTotalComisiones(pro.getTotalComisiones() + comision);
                        }
                    }
                    
                    if(bon.isReinversion()){
                        CrearBonde(temp - (comision * 2), bon.getIdCliente(), bon.getPlazo(),bon.getTasaActual(),bon.isReinversion(),bon.getIdPromotor() );
                    }
                    else{
                        itr2 = cliente.iterator();
                        while(itr2.hasNext()){
                            Cliente cli = (Cliente) itr2.next();
                            if( cli.getId() == bon.getIdCliente() ){
                                cli.setBalance( cli.getBalance() + temp - (comision * 2) );
                            }
                        }
                    }            
                    CrearHistorialBonde( bon.getValorNominal() ,bon.getIdCliente(),  bon.getPlazo()  ,bon.getTasaActual() ,bon.isReinversion(),bon.getIdPromotor(),bon.getId(),comision,comision);

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
    public void CambioDiasHistorial(int dias){
        Iterator itr = historialBondes.iterator();
        while(itr.hasNext()){
            BondeD bon = (BondeD) itr.next();
            bon.setDiasTranscurridos(bon.getDiasTranscurridos() + dias);
        }
        itr = historialCetes.iterator();
        while(itr.hasNext()){
            Cete cet = (Cete) itr.next();
            cet.setDiasTranscurridos(cet.getDiasTranscurridos() + dias);
        }
    }
}
