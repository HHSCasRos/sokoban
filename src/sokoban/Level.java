/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.ArrayList;

/**
 *
 * @author tgrja
 */
public class Level {
    private ArrayList<Doolhof> doolhoven;
    private String idLevel;
    
    public Level(String idLevel){
        this.idLevel = idLevel;
        this.doolhoven = new ArrayList();
    }

    //voegt een doolhof toe aan de lijst met doolhoven van dit level.
    public void addDoolhof(Doolhof dh){
        doolhoven.add(dh);
    }
    
    //haalt alle doolhoven in dit level op
    public ArrayList<Doolhof> getDoolhoven() {
        return doolhoven;
    }
    
    //voert het levelid door.
    public String getIdLevel() {
        return idLevel;
    }
}
