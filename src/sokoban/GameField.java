/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Cas_Ros
 */
public class GameField extends JComponent{
    private int size;
    private Tile[][] tiles;
    private Doolhof doolhof;
    private int tileSize;

    public GameField(Doolhof doolhof) {
        this.doolhof = doolhof;
        tiles = doolhof.getField();
        this.size = tiles.length;
        this.tileSize = 25;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                switch(tiles[i][j].toString()){
                    case "V" :
                        g.setColor(Color.GRAY);
                        break;
                    case "M" :
                        g.setColor(Color.DARK_GRAY);
                        break;
                    case "D" :
                        g.setColor(Color.ORANGE);
                        break;
                    case "E" :
                        g.setColor(Color.GREEN);
                        break;
                    case "S" :
                        g.setColor(Color.BLUE);
                        break;
                    case "F" :
                        g.setColor(Color.WHITE);
                        break;
                    default :
                        g.setColor(Color.BLACK);
                        break;
                }
                g.fillRect( tiles[i][j].getCoordinaat().getX() * tileSize, tiles[i][j].getCoordinaat().getY() * tileSize, tileSize, tileSize);
            }
        }
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getGameFieldSize() {
        return this.size;
    }
}