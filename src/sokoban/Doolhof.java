/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.HashMap;

/**
 *
 * @author tgrja
 */
public class Doolhof {
    Level level;
    //lijst / map
    private HashMap TileList = new HashMap();

    public Doolhof(Level level) {
        this.level = level;
    }
    
    public Tile getTile(Coordinaat crd){

        Object[] cords = TileList.keySet().toArray();
        for(Object o : cords){
            crd.compareTo((Coordinaat)o);
            if(crd.compareTo((Coordinaat)o) == 0){
                return (Tile)TileList.get(o);
            }
        }
        return null;
    }
    
    public void fillField( Coordinaat[] c, Tile[] t){
        if(c.length == t.length){
            int count = 0;
            for(Coordinaat crd : c){    
                TileList.put(crd, t[count]);
                count++;
            }
        }else{
            //throw exception.
            return;
        } 
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
