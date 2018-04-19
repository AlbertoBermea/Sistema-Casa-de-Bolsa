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
            
            //datos director
            printWriter.println("" + sistem.getDirector().getNombre() + "," + sistem.getDirector().getContra() + "," + sistem.getDirector().getId() + ""  );
             
            //datos promotores
            printWriter.println("" + sistem.getPromotor().size());
            for(Promotor promo : sistem.getPromotor() ){
                printWriter.println("" + promo.getNombre() + "," + promo.getContra() + "," + promo.getId() + "");
            }
            
            //datos clientes
            printWriter.println("" + sistem.getCliente().size());
            for(Cliente clien : sistem.getCliente()){
                printWriter.println("" + clien.getNombre() + "," + clien.getContra() + "," + clien.getId() + "");
            }
            
            //datos inversiones
            printWriter.println("" + sistem.getCetes().size() );
            for(Cete cet : sistem.getCetes()){
                printWriter.println("" + cet.getId() + "," + cet.getPlazo() + "," + cet.getValorNominal() + "," + cet.getTasaFija() + "," + cet.getDiaInicio() + "," + cet.getYearInicio() +"," + cet.getDiaTermino()+"," + cet.getYearTermino() + "," + cet.getDiasTranscurridos() + "," + cet.isReinversion() + "");
            }
            
            
            
            printWriter.close();
        } catch (IOException ioe){
            System.out.println("Se te lleno el pedo" + ioe.toString());
        }
    }
    public static void loadFile(Sistema sistem){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("data.txt"));
            
            //get the first line
            String line = bufferedReader.readLine();
            //getting every token from the line
            String[] tokens = line.split(",");
            
            //posicion del personaje
            sistem.getDirector().setNombre(tokens[0]);
            sistem.getDirector().setContra(tokens[1]);
            sistem.getDirector().setId(Integer.parseInt(tokens[2]));
            
            //enemies
            int promotores = Integer.parseInt(bufferedReader.readLine());
            //clearing enemies
            sistem.getPromotor().clear();
            //adding enemies
            for (int i = 0; i < promotores; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                String nom = tokens[0];
                String contra = tokens[1];
                int id = Integer.parseInt(tokens[2]);
                
                Promotor promo = new Promotor(nom,id,contra,sistem);
                sistem.getPromotor().add(promo);
            }
            
            //enemies
            int clientes = Integer.parseInt(bufferedReader.readLine());
            //clearing enemies
            sistem.getCliente().clear();
            //adding enemies
            for (int i = 0; i < clientes; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                String nom = tokens[0];
                String contra = tokens[1];
                int id = Integer.parseInt(tokens[2]);
                
                Cliente clien = new Cliente(nom,id,contra,sistem);
                sistem.getCliente().add(clien);
            }
            
            //enemigos
            int cetes = Integer.parseInt(bufferedReader.readLine());
            sistem.getCetes().clear();
            //adding enemies
            for (int i = 0; i < cetes
                    ; i++){
                //getting the next line
                line = bufferedReader.readLine();
                //getting every token from the line
                tokens = line.split(",");
                //Defining score and lives
                String nom = tokens[0];
                String contra = tokens[1];
                int id = Integer.parseInt(tokens[0]);
                int plazo = Integer.parseInt(tokens[1]);
                double valor = Double.parseDouble(tokens[2]) ;
                double tasa = Double.parseDouble(tokens[3]);
                int diaInicio = Integer.parseInt(tokens[4]);
                int yearInicio = Integer.parseInt(tokens[5]);
                int diaTermino = Integer.parseInt(tokens[6]);
                int yearTermino = Integer.parseInt(tokens[7]);
                int diasTranscurridos = Integer.parseInt(tokens[8]);
                boolean reinversion = Boolean.parseBoolean(tokens[9]);
                      
                Cete cet = new Cete(valor, id, plazo, yearInicio, diaInicio, yearTermino, diaTermino, diasTranscurridos, reinversion,tasa,sistem);
                sistem.getCetes().add(cet);
            }
            
            
            
        } catch (IOException ioe) {
            System.out.println("Juego no ha sido guardado " + ioe.toString());
        }        
    }
}