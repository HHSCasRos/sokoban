package sokoban;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel restartPanel;
    private JPanel scorePanel;
    private JLabel displayedScore;
    
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
        createRestartPanel();
        
        KeyListener listener = new PlayerControlsKeyListener(this, homeScreen);
        this.addKeyListener(listener);
        
        add(scorePanel, BorderLayout.NORTH);
        add(restartPanel, BorderLayout.SOUTH);
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
    public void createRestartPanel(){
        restartPanel = new JPanel();
        restartPanel.setLayout(new BoxLayout(restartPanel, BoxLayout.X_AXIS));
        
        JLabel restartInstructions = new JLabel("restart: R");
        
        restartPanel.add(restartInstructions);
        add(restartPanel);
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
                doolhofCopy.getSpeler().move("Boven");
                break;
            case KeyEvent.VK_DOWN:
                doolhofCopy.getSpeler().move("Onder");
                break;
            case KeyEvent.VK_LEFT:
                doolhofCopy.getSpeler().move("Links");
                break;
            case KeyEvent.VK_RIGHT :
                doolhofCopy.getSpeler().move("Rechts");
                break;
            case KeyEvent.VK_R :
                restart(doolhofCopy, homeScreen);
                break;
            }
            updateScorePanel(doolhofCopy.getScore());
            component.repaint();
        }
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
    
    public void restart(Doolhof currentDoolhof, HomeScreen homeScreen){
        JFrame restartFrame = new GameFieldViewer(currentDoolhof,homeScreen);
        restartFrame.setVisible(true);
        restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}