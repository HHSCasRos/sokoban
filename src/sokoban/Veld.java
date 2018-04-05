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
    
    public Veld(Coordinaat c){
        super(c);
    }

    public Doos getDoos() {
        return doos;
    }

    public void setDoos(Doos doos) {
        this.doos = doos;
        super.setNavigateable(false);
    }
    
    public void removeDoos(){
        this.doos = null;
        super.setNavigateable(true);
    }
    
    public boolean hasDoos(){
        if(doos == null){
            return false;
        }else{
            return true;
        }
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
    
    public void removeSpeler(){
        this.speler = null;
    }
    
    public boolean hasSpeler(){
        if(speler == null){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public String toString(){
        if(hasDoos()){
            return "D";
        }else if(hasSpeler()){
            return "S"; 
        }else{
            return "V";
        }
    }
}
