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
public class Veld extends Tile{
    private Speler speler;
    private Doos doos;

    public Doos getDoos() {
        return doos;
    }

    public void setDoos(Doos doos) {
        this.doos = doos;
    }
    
    public Tile getNeighbour(String richting){
        return this; //dit moet anderes
    }
    
    public boolean hasDoos(){
        if(doos == null){
            return false;
        }else{
            return true;
        }
    }
}
