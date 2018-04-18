/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import sistema.pantallas.Inicio;

/**
 *
 * @author ALBER
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sistem = new Sistema ();
        Inicio in = new Inicio(sistem);
        in.setVisible(true);
    }
    
}
