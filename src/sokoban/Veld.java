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
        super.setNavigateable(true);
    }

    //zorgt er voor dat andere kunnen zien welke doos op het veld staat
    public Doos getDoos() {
        return doos;
    }

    //zorgt er voor dat een doos op het veld wordt gezet
    public void setDoos(Doos doos) {
        this.doos = doos;
        super.setNavigateable(false);
    }
    
    //zorgt er voor dat een doos van het veld wordt afgehaald.
    public void removeDoos(){
        this.doos = null;
        super.setNavigateable(true);
    }
    
    //Kijkt of er een doos op het veld aanwezig is.
    public boolean hasDoos(){
        if(doos == null){
            return false;
        }else{
            return true;
        }
    }
    
    //zorgt er voor dat een speler op het veld wordt gezet
    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
    
    //zorgt er voor dat een speler van het veld wordt afgehaald.
    public void removeSpeler(){
        this.speler = null;
    }
    
    //Kijkt of er een speler op het veld aanwezig is.
    public boolean hasSpeler(){
        if(speler == null){
            return false;
        }else{
            return true;
        }
    }
    
    //zorgt er voor een textuele representatie van het object.
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
