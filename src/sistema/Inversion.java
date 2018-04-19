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
    private int yearInicio;
    private int diaInicio;
    private int yearTermino;
    private int diaTermino;
    private boolean reinversion; 
    
    public Inversion(double valorNominal,int id, int plazo, int yearInicio,int diaInicio,int yearTermino,int diaTermino, int diasTranscurridos, boolean reinversion,Sistema sistem){
        this.valorNominal = valorNominal;
        this.id = id;
        this.plazo = plazo;
        this.sistem = sistem;
        this.diasTranscurridos = diasTranscurridos;
        this.yearInicio = yearInicio;
        this. diaInicio = diaInicio;
        this.yearTermino = yearTermino;
        this.diaTermino = diaTermino;
        this.reinversion = reinversion;
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

    public int getYearInicio() {
        return yearInicio;
    }

    public void setYearInicio(int yearInicio) {
        this.yearInicio = yearInicio;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getYearTermino() {
        return yearTermino;
    }

    public void setYearTermino(int yearTermino) {
        this.yearTermino = yearTermino;
    }

    public int getDiaTermino() {
        return diaTermino;
    }

    public void setDiaTermino(int diaTermino) {
        this.diaTermino = diaTermino;
    }


    public boolean isReinversion() {
        return reinversion;
    }

    public void setReinversion(boolean reinversion) {
        this.reinversion = reinversion;
    }
    
}
