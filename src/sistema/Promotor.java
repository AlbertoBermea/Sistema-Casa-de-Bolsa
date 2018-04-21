/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.ArrayList;

/**
 *
 * @author ALBER
 */
public class Promotor extends Persona {
    private Sistema sistem;
    private double TotalComisiones;
    private ArrayList<Integer> idInversiones;
    
    public Promotor(String nombre, int id, String contra,double TotalComisiones,Sistema sistem) {
        super(nombre, id, contra);
        this.sistem = sistem;
        this.TotalComisiones = TotalComisiones;
    }

    public Sistema getSistem() {
        return sistem;
    }

    public void setSistem(Sistema sistem) {
        this.sistem = sistem;
    }

    public double getTotalComisiones() {
        return TotalComisiones;
    }

    public void setTotalComisiones(double TotalComisiones) {
        this.TotalComisiones = TotalComisiones;
    }

    public ArrayList<Integer> getIdInversiones() {
        return idInversiones;
    }

    public void setIdInversiones(ArrayList<Integer> idInversiones) {
        this.idInversiones = idInversiones;
    }
    
}
