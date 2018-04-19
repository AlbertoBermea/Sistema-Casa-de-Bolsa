/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.Calendar;

/**
 *
 * @author ALBER
 */
public class Cete extends Inversion{
    private double tasaFija;

    public Cete(double valorNominal, int id, int plazo, int yearInicio, int diaInicio, int yearTermino, int diaTermino, int diasTranscurridos, boolean reinversion, double tasaFija, Sistema sistem) {
        super(valorNominal, id, plazo, yearInicio, diaInicio, yearTermino, diaTermino, diasTranscurridos, reinversion, sistem);
        this.tasaFija = tasaFija;

    }

    

    public double getTasaFija() {
        return tasaFija;
    }

    public void setTasaFija(double tasaFija) {
        this.tasaFija = tasaFija;
    }
    
    
}
