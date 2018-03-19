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
public class Field extends Tile{
    private Box box;
    private boolean goalField;

    public Field(boolean goal) {
        this.goalField = goal;
    }
    public Field(Box box) {
        this.box = box;
    }
}