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
public class Doolhof {
    
    public Tile getTile(Coordinaat crd){
        return null;
    }
    
    public boolean completed(Veld[] eindVelden){
        int completedDozen = 0;
        
        for(Veld v: eindVelden){
            if(v.hasDoos())
                completedDozen += 1;
        }
        if(completedDozen == eindVelden.length){
            System.out.println("ALL COMPLETED");
            return true;
        }else{
            System.out.println(completedDozen + " / " + eindVelden.length + " COMPLETED");
            return false;
        }
    }
}
