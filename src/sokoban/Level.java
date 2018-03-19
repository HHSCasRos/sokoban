/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

/**
 *
 * @author Cas_Ros
 */
public class Level {
    private Player player;
    private Tile[][] level;
    
    public Level(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
    public Tile getTile(int[] coordinates) throws NoTileException{
        //check if requested coordinates are withing te level bounds
        if((coordinates[0] < this.level.length && coordinates[1] < this.level[0].length) && coordinates[0] >= 0 && coordinates[1] >= 0){
            return this.level[coordinates[0]][coordinates[1]];
        } else {
            throw new NoTileException("No tile at these coordinates");
        }
    }
    
    public int getAmountOfBoxes(){
        int numberOfBoxes = 0;
        
        
        
        return numberOfBoxes;
    }
    public int getAmountOfGoalFields(){
        int numberOfGoalFields = 0;
        
        
        
        return numberOfGoalFields;
    }
}