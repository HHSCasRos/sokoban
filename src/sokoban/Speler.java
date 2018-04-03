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
public class Speler extends MoveAble{
    
    public Speler(Coordinaat c, Doolhof dh){
        super(c,dh);
    }
    
    @Override
    public void beweeg(String richting){
        if(/*neighbourVeld = Muur */false){
            return;
        }else if(/*neighbourVeld = Veld met doos */ false){
            duwen(richting);
        }else{
            switch(richting){
                case "Links" : 
                    System.out.println("Naar links gelopen.");
                    break;
                case "Rechts": 
                    System.out.println("Naar Rechts gelopen.");
                    break;
                case "Boven" : 
                    System.out.println("Naar boven gelopen.");
                    break;
                case "Onder" : 
                    System.out.println("Naar onder gelopen.");
                    break;
                default : 
                    System.out.println("Je twijvelt nog over je beweging.");
                    break;
            }
        }
    }
    
    public void duwen(String richting){
        if(/*neighbourVeld's neighbour = Muur */ false){
            return;
        }else if(/*neighbourVeld's neigbour = Veld met doos */ false){
            return;
        }else{
            //Doos.schuiven(richting);
        }
    }
}
