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
public class MoveAble {
    
    Coordinaat coordinaat;
    
    public MoveAble(){
        
    }
    
    public MoveAble(Coordinaat c){
        this.coordinaat = c;
    }
    
    public void beweeg(String richting){
        Tile[] t = getSurroundings();
        //deze switch case is afhenkelijk van de getsurroundings method.
        switch(richting){
            case "Boven" :
                coordinaat = t[1].getCoordinaat();
                System.out.println("Naar boven verplaats.");
                break;
            case "Rechts": 
                coordinaat = t[2].getCoordinaat();
                System.out.println("Naar Rechts verplaats.");
                break;
            case "Onder" : 
                coordinaat = t[3].getCoordinaat();
                System.out.println("Naar onder verplaats.");
                break;
            case "Links" : 
                coordinaat = t[4].getCoordinaat();
                System.out.println("Naar links verplaats.");
                break;
            default : 
                coordinaat = t[0].getCoordinaat();
                System.out.println("Je twijvelt nog over je beweging.");
                break;
        }
        
    }
    
    public Tile[] getSurroundings(){
        //Als veld niet navigeerbaar is houd huidige positie
        Tile[] tiles = new Tile[5];
        tiles[0] = Doolhof.getTile(coordinaat);//huidige positie
        tiles[1] = Doolhof.getTile(coordinaat);//boven
        tiles[2] = Doolhof.getTile(new Coordinaat(2,1));//rechts
        tiles[3] = Doolhof.getTile(coordinaat);//onder
        tiles[4] = Doolhof.getTile(coordinaat);//links     
        
        return tiles;
    }
}
