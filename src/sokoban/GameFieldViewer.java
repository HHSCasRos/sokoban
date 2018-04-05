/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cas_Ros
 */
public class GameFieldViewer extends JFrame{
    private GameField component;
    private JPanel scorePanel;
    private JLabel displayedScore;
    
    private JPanel messagePanel;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int tileSize;
    private int gameFieldSize;
    private Doolhof doolhof;
    private Doolhof doolhofCopy;
    private Tile[][] tiles;
    
    
    public GameFieldViewer(Doolhof doolhof, HomeScreen homeScreen) {
        this.setLayout(new BorderLayout());
        this.doolhof = doolhof;
        this.doolhofCopy = new Doolhof(doolhof.getLevel(), doolhof.getNaam());
        this.doolhofCopy.setField(doolhof.getField());
        
        this.tiles = this.doolhofCopy.getField();
        this.component = new GameField(this.doolhofCopy);
        
        //define and set framesize based on the required size of GameField
        this.tileSize = component.getTileSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = tileSize * gameFieldSize;
        this.FRAME_HEIGHT = tileSize * gameFieldSize;
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 89);

        createScorePanel();
        KeyListener listener = new PlayerControlsKeyListener(this, homeScreen);
        this.addKeyListener(listener);
        
        add(scorePanel, BorderLayout.NORTH);
        add(component, BorderLayout.CENTER);
        
        component.setVisible(true);
    }
    
    public void createScorePanel(){
        scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        
        displayedScore = new JLabel("0");
        
        scorePanel.add(displayedScore);
        add(scorePanel);
    }
    
    private void updateScorePanel(int score){
        displayedScore.setText(""+score);
    }
    
    class PlayerControlsKeyListener implements KeyListener {   
        private JFrame frame;
        private HomeScreen homeScreen;

        public PlayerControlsKeyListener(JFrame frame, HomeScreen homeScreen) {
            this.frame = frame;
            this.homeScreen = homeScreen;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) { 
            case KeyEvent.VK_UP:
                doolhof.getSpeler().move("Boven");
                break;
            case KeyEvent.VK_DOWN:
                doolhof.getSpeler().move("Onder");
                break;
            case KeyEvent.VK_LEFT:
                doolhof.getSpeler().move("Links");
                break;
            case KeyEvent.VK_RIGHT :
                doolhof.getSpeler().move("Rechts");
                break;
            }
            updateScorePanel(doolhof.getScore());
            component.repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}