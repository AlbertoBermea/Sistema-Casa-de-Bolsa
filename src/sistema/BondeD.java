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
public class BondeD extends Inversion {
    private double tasaActual;

    public BondeD(int idCliente, int idPromotor, double valorNominal, int id, int plazo,  int diaInicio,  int diasTranscurridos, boolean reinversion,double tasaActual, Sistema sistem) {
        super(idCliente, idPromotor, valorNominal, id, plazo, diaInicio, diasTranscurridos, reinversion, sistem);
        this.tasaActual = tasaActual;

    }

    public double getTasaActual() {
        return tasaActual;
    }

    public void setTasaActual(double tasaActual) {
        this.tasaActual = tasaActual;
    }
}
