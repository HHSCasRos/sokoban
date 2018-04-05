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
public class Muur extends Tile{
    public Muur(Coordinaat c){
        super(c);
        super.setNavigateable(false);
    }
    
    @Override
    public String toString(){
        return "M";
    }
}
