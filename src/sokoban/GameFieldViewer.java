/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cas_Ros
 */
public class GameFieldViewer extends JFrame{
    private GameField component;
    private JPanel pausePanel;
    private JPanel messagePanel;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int fieldSize;
    private int gameFieldSize;
    private Doolhof level;
    private Doolhof levelCopy;
    private Tile[][] fields;
    private JLabel label;
}