/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @authors tgrja, Cas Ros
 */
public class Speler extends MoveAble{
    
    public Speler(Coordinaat c, Doolhof dh){
        super(c,dh);
    }
    
    @Override
    public boolean beweeg(String richting){
        boolean move = super.beweeg(richting);
        if(!move){
            Tile[] surroundings = super.getSurroundings();
            switch(richting){
                case "Links" : 
                    if(!neigbourIsMuur(surroundings[4])){
                        duwen(richting);
                    } else {
                        return false;
                    }
                    System.out.println("Naar links gelopen.");
                    break;
                case "Rechts": 
                    if(!neigbourIsMuur(surroundings[2])){
                        duwen(richting);
                    } else {
                        return false;
                    }
                    System.out.println("Naar Rechts gelopen.");
                    break;
                case "Boven" : 
                    if(!neigbourIsMuur(surroundings[1])){
                        duwen(richting);
                    } else {
                        return false;
                    }
                    System.out.println("Naar boven gelopen.");
                    break;
                case "Onder" : 
                    if(!neigbourIsMuur(surroundings[3])){
                        duwen(richting);
                    } else {
                        return false;
                    }
                    System.out.println("Naar onder gelopen.");
                    break;
                default : 
                    System.out.println("Je twijvelt nog over je beweging.");
                    break;
            }
        }
        return move;
    }
    
    public void duwen(String richting){
        if(/*neighbourVeld's neighbour = Muur */ false){
            
        }else if(/*neighbourVeld's neigbour = Veld met doos */ false){
            
        }else{
            //Doos.schuiven(richting);
        }
    }
    
    public boolean neigbourIsMuur(Tile neighbour){
        try{
            Muur muur = (Muur)neighbour;
            return true;
        } catch(ClassCastException c){
            return false;
        }
    }
}
