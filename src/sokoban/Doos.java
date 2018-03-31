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
public class Doos extends MoveAble{
    
    public Veld isOpVeld;
    
    public Doos(Coordinaat c){
        this.coordinaat = c;
        isOpVeld = (Veld)Doolhof.getTile(coordinaat);
    }
    
    @Override
    public void beweeg(String richting){
        isOpVeld.removeDoos();
        
        super.beweeg(richting);
        
        Veld naar = (Veld)Doolhof.getTile(coordinaat);
        naar.setDoos(this);
    }
    
      
}
