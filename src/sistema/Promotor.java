/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author ALBER
 */
public class Promotor extends Persona {
    private Sistema sistem;

    
    public Promotor(String nombre, int id, String contra,Sistema sistem) {
        super(nombre, id, contra);
        this.sistem = sistem;
    }
    
}
