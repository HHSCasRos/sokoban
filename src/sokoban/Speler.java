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
        isOpVeld.setSpeler(this);
        dh.setSpeler(this);
    }
    
    @Override
    public void move(String richting){
        super.move(richting);
        dh.upScore();
        if(isOpVeld != (Veld)dh.getTile(coordinaat)){
            isOpVeld.removeSpeler();
        isOpVeld = (Veld)dh.getTile(coordinaat);
        isOpVeld.setSpeler(this);
        
        }else{
            duwen(richting);
        }
    }
    
    public void duwen(String richting){
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
        if(t[to] instanceof Veld){
            Veld tmp = (Veld)t[to];
            if(tmp.hasDoos()){
                System.out.println("Probeert doos te duwen!");
                tmp.getDoos().move(richting);
            }
        }else{
            System.out.println("Dat is een muur!");
        }
    }
}
