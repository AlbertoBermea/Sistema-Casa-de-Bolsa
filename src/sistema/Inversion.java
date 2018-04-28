/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 *
 * @author ALBER
 */
public class Inversion {
    private Sistema sistem;
    private double valorNominal;
    private int id;
    private int plazo;
    private int diasTranscurridos;
    private boolean reinversion; 
    private int idCliente;
    private int idPromotor;
    private double comisionPromotor;
    private double comisionCasa;
    
    public Inversion(int idCliente,int idPromotor,double valorNominal,int id, int plazo, int diasTranscurridos, boolean reinversion,Sistema sistem){
        this.idCliente = idCliente;
        this.idPromotor = idPromotor;
        this.valorNominal = valorNominal;
        this.id = id;
        this.plazo = plazo;
        this.sistem = sistem;
        this.diasTranscurridos = diasTranscurridos;
        this.reinversion = reinversion;
    }
    
    public Inversion(int idCliente,int idPromotor,double valorNominal,int id, int plazo, int diasTranscurridos, boolean reinversion,double comisionPromotor, double comisionCasa,Sistema sistem){
        this.idCliente = idCliente;
        this.idPromotor = idPromotor;
        this.valorNominal = valorNominal;
        this.id = id;
        this.plazo = plazo;
        this.sistem = sistem;
        this.diasTranscurridos = diasTranscurridos;
        this.reinversion = reinversion;
        this.comisionCasa = comisionCasa;
        this.comisionPromotor = comisionPromotor;
    }

    public Sistema getSistem() {
        return sistem;
    }

    public void setSistem(Sistema sistem) {
        this.sistem = sistem;
    }

    public double getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(double valorNominal) {
        this.valorNominal = valorNominal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public void setDiasTranscurridos(int diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
    }

    public boolean isReinversion() {
        return reinversion;
    }

    public void setReinversion(boolean reinversion) {
        this.reinversion = reinversion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPromotor() {
        return idPromotor;
    }

    public void setIdPromotor(int idPromotor) {
        this.idPromotor = idPromotor;
    }

    public double getComisionPromotor() {
        return comisionPromotor;
    }

    public void setComisionPromotor(double comisionPromotor) {
        this.comisionPromotor = comisionPromotor;
    }

    public double getComisionCasa() {
        return comisionCasa;
    }

    public void setComisionCasa(double comisionCasa) {
        this.comisionCasa = comisionCasa;
    }
    
    
    
}
