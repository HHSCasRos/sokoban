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
public class Tile {
    private Coordinaat coordinaat;
    private boolean navigateable;

    public Tile(Coordinaat c){
        this.coordinaat = c;
    }
    
    //kijkt of een tile navigateable is
    public boolean isNavigateable() {
        return navigateable;
    }

    //bepaald of een tile navigatable is
    public void setNavigateable(boolean navigateable) {
        this.navigateable = navigateable;
    }
    
    //voert het cordinaat van veld terug
    public Coordinaat getCoordinaat(){
        return this.coordinaat;
    }
    
    //geeft een cordinaat aan veld.
    public void setCoordinaat(Coordinaat c){
        this.coordinaat = c;
    }
    
    @Override
    public String toString(){
        return "ERROR";
    }
}
