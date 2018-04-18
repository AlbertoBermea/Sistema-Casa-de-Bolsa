/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.util.Date;



/**
 *
 * @author ALBER
 */
public class Inversion {
    private Sistema sistem;
    private int id;
    private int plazo;
    private int taza;
    
    public Inversion(int id, int plazo, int taza, Sistema sistem ){
        this.id = id;
        this.plazo = plazo;
        this.taza = taza;
        this.sistem = sistem;
    }
    
    
}
