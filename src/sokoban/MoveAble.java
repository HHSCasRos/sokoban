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
    
    public void move(String richting){       
        Tile[] t = getSurroundings();
        int to = 0;
        switch(richting){
            case "Boven" :
                to = 1;
                break;
            case "Rechts" :
                to = 2;
                break;
            case "Onder" :
                to = 3;
                break;
            case "Links" :
                to = 4;
                break;
        }
        if(t[to].isNavigateable()){
            coordinaat = t[to].getCoordinaat();
            System.out.println("Beweegt naar "+richting);
        }else{
            System.out.println("Er blokkert iets");
        }

    }
    
    public Tile[] getSurroundings(){
        Tile[] tiles = new Tile[5];
        tiles[0] = dh.getTile(coordinaat);//huidige positie
        tiles[1] = dh.getTile(new Coordinaat(coordinaat.getX(),coordinaat.getY()-1));//boven
        tiles[2] = dh.getTile(new Coordinaat(coordinaat.getX()+1,coordinaat.getY()));//rechts
        tiles[3] = dh.getTile(new Coordinaat(coordinaat.getX(),coordinaat.getY()+1));//onder
        tiles[4] = dh.getTile(new Coordinaat(coordinaat.getX()-1,coordinaat.getY()));//links     
        
        return tiles;
    }
}
