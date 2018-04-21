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
public class Cliente extends Persona {
    private Sistema sistem;
    private Double balance;
    
    public Cliente(String nombre, int id, String contra, Double balance, Sistema sistem) {
        super(nombre, id, contra);
        this.sistem = sistem;
        this.balance = balance;
    }

    public Sistema getSistem() {
        return sistem;
    }

    public void setSistem(Sistema sistem) {
        this.sistem = sistem;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }    
}
