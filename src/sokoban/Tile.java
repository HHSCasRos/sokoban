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
    
    public Coordinaat getCoordinaat(){
        return this.coordinaat;
    }
    
    public void setCoordinaat(Coordinaat c){
        this.coordinaat = c;
    }
}
