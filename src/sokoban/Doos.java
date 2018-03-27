/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author tgrja
 */
public class Doos {
    
    private Veld isOpVeld;
    
    public void schuiven(String richting){
        switch(richting){
            case "Links" : 
                System.out.println("Doos naar links verschoven.");
                break;
            case "Rechts": 
                System.out.println("Doos naar Rechts verschoven.");
                break;
            case "Boven" : 
                System.out.println("Doos naar boven verschoven.");
                break;
            case "Onder" : 
                System.out.println("Doos naar onder verschoven.");
                break;
            default : 
                System.out.println("De doos bleek zwaarder dan verwacht en is niet verschoven.");
                break;
        }
    }
}
