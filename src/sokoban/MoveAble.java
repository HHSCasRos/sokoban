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
    
    protected Veld isOpVeld;
    protected Doolhof dh;
    protected Coordinaat coordinaat;
    
    public MoveAble(Coordinaat c, Doolhof dh){
        this.coordinaat = c;
        this.dh = dh;
        isOpVeld = (Veld)dh.getTile(c);
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
        tiles[0] = dh.getTile(coordinaat);//huidige positie
        tiles[1] = dh.getTile(new Coordinaat(coordinaat.getX(),coordinaat.getY()-1));//boven
        tiles[2] = dh.getTile(new Coordinaat(coordinaat.getX()+1,coordinaat.getY()));//rechts
        tiles[3] = dh.getTile(new Coordinaat(coordinaat.getX(),coordinaat.getY()+1));//onder
        tiles[4] = dh.getTile(new Coordinaat(coordinaat.getX()-1,coordinaat.getY()));//links     
        
        return tiles;
    }
}
