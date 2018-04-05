/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @authors tgrja, Cas Ros
 */
public class Speler extends MoveAble{
    
    public Speler(Coordinaat c, Doolhof dh){
        super(c,dh);
        isOpVeld.setSpeler(this);
    }
    
//    @Override
//    public boolean beweeg(String richting){
//        boolean move = super.beweeg(richting);
//        if(!move){
//            Tile[] surroundings = super.getSurroundings();
//            switch(richting){
//                case "Links" : 
//                    if(!neigbourIsMuur(surroundings[4])){
//                        duwen(richting);
//                    } else {
//                        return false;
//                    }
//                    System.out.println("Naar links gelopen.");
//                    break;
//                case "Rechts": 
//                    if(!neigbourIsMuur(surroundings[2])){
//                        duwen(richting);
//                    } else {
//                        return false;
//                    }
//                    System.out.println("Naar Rechts gelopen.");
//                    //dh.printDoolhof();
//                    break;
//                case "Boven" : 
//                    if(!neigbourIsMuur(surroundings[1])){
//                        duwen(richting);
//                    } else {
//                        return false;
//                    }
//                    System.out.println("Naar boven gelopen.");
//                    break;
//                case "Onder" : 
//                    if(!neigbourIsMuur(surroundings[3])){
//                        duwen(richting);
//                    } else {
//                        return false;
//                    }
//                    System.out.println("Naar onder gelopen.");
//                    break;
//                default : 
//                    System.out.println("Je twijvelt nog over je beweging.");
//                    break;
//            }
//        }
//        return move;
//    }
    
    @Override
    public void move(String richting){
        isOpVeld.removeSpeler();
        super.move(richting);
        isOpVeld = (Veld)dh.getTile(coordinaat);
        isOpVeld.setSpeler(this);
        dh.printDoolhof();
    }
    
    public void duwen(String richting){
        Tile[] surroundings = super.getSurroundings();
        Tile tile = null;
        boolean valid = true;
        switch(richting){
            case "Links" : 
                tile = surroundings[4];
                System.out.println("try to push " + tile.getCoordinaat());
                break;
            case "Rechts": 
                tile = surroundings[2];
                break;
            case "Boven" : 
                tile = surroundings[1];
                break;
            case "Onder" : 
                tile = surroundings[3];
                break;
            default : 
                valid = false;
                break;
        }
        
        if(valid){
            System.out.println("try to push " + tile.getCoordinaat());
            
            if(!neigbourIsMuur(tile)){
                Veld veld = (Veld) tile;
                if(veld.hasDoos()){
                    veld.getDoos().beweeg(richting);
                }
            }
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
    
    public class KeyListener{
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) { 
            case KeyEvent.VK_UP:
                beweeg("Boven");
                break;
            case KeyEvent.VK_DOWN:
                beweeg("Onder");
                break;
            case KeyEvent.VK_LEFT:
                beweeg("Links");
                break;
            case KeyEvent.VK_RIGHT :
                beweeg("Rechts");
                break;
            }
        }
    }
}
