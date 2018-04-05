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
    
    public Doos(Coordinaat c, Doolhof dh){
        super(c,dh);
        isOpVeld.setDoos(this);
    }
    
//    @Override
//    public boolean beweeg(String richting){
//        isOpVeld.removeDoos();
//        
//        boolean moved = super.beweeg(richting);
//        
//        Veld naar = (Veld)dh.getTile(coordinaat);
//        naar.setDoos(this);
//        return moved;
//    }

    @Override
    public void move(String richting) {
        isOpVeld.removeDoos();
        super.move(richting);
        isOpVeld = (Veld)dh.getTile(coordinaat);
        isOpVeld.setDoos(this);
        dh.printDoolhof();
        
    }
    
    
}
