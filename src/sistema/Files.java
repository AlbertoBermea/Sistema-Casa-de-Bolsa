/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ALBER
 */
public class Files {
    public static void saveFile(Sistema sistem){
        //define objects
        PrintWriter printWriter;
        try{
            printWriter = new PrintWriter(new FileWriter("data.txt"));
            
            printWriter.close();
        } catch (IOException ioe){
            System.out.println("Se te lleno el pedo" + ioe.toString());
        }
    }
    public static void loadFile(Sistema sistem){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("data.txt"));
            
        } catch (IOException ioe) {
            System.out.println("Juego no ha sido guardado " + ioe.toString());
        }        
    }
}