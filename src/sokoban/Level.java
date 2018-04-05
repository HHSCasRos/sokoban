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
public class Level {
    private int aantalStappen;
    private Doolhof[] doolhoven;
    private String idLevel;
    
    public void Level(String idLevel){
        this.idLevel = idLevel;
    }
    
    public void loadDoolhof(){
        
    }
    
    public void loadNextDoolhof(){
        
    }

    public String getIdLevel() {
        return idLevel;
    }
}
