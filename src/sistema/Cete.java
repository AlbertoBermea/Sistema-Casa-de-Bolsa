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

    public Cete(int idCliente, int idPromotor, double valorNominal, int id, int plazo,int diaInicio, int diasTranscurridos, boolean reinversion,double tasaFija, Sistema sistem) {
        super(idCliente, idPromotor, valorNominal, id, plazo, diaInicio, diasTranscurridos, reinversion, sistem);
        this.tasaFija = tasaFija;
    }

   

    

    public double getTasaFija() {
        return tasaFija;
    }

    public void setTasaFija(double tasaFija) {
        this.tasaFija = tasaFija;
    }
    
    
}
