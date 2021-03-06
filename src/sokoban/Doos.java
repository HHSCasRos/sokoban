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

    //zorgt er voor dat de doos van het oude veld wordt afgehaald
    //en vervolgens op een nieuw veld wordt gezet.
    @Override
    public void move(String richting) {
        isOpVeld.removeDoos();
        super.move(richting);
        isOpVeld = (Veld)dh.getTile(coordinaat);
        isOpVeld.setDoos(this);        
    }
}
