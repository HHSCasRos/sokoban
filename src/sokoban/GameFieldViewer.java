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
    private Doolhof dh;
    
    public GameFieldViewer(Doolhof doolhof, HomeScreen homeScreen) {
        this.setLayout(new BorderLayout());
        this.dh = doolhof;
        
        this.component = new GameField(this.dh);
        
        //define and set framesize based on the required size of GameField
        this.tileSize = component.getTileSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = tileSize * gameFieldSize + 2 * tileSize;
        this.FRAME_HEIGHT = tileSize * gameFieldSize + 2 * tileSize;
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 89);

        
        createScorePanel();
        createMenuPanel();
        
        KeyListener listener = new PlayerControlsKeyListener(this, homeScreen);
        this.addKeyListener(listener);
        
        add(scorePanel, BorderLayout.NORTH);
        add(restartPanel, BorderLayout.SOUTH);
        add(component, BorderLayout.CENTER);
        
        component.setVisible(true);
        
    }
    
    public void copyField(){
        
        for(int Y=0; Y<gameFieldSize; Y++){
            for(int X=0; X<gameFieldSize; X++){
            }
        }
    }
    
    public void createScorePanel(){
        scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        
        displayedScore = new JLabel("0");
        
        scorePanel.add(displayedScore);
        add(scorePanel);
    }
    
    public void createMenuPanel(){
        restartPanel = new JPanel();
        restartPanel.setLayout(new BoxLayout(restartPanel, BoxLayout.Y_AXIS));
        
        JLabel restartInstructions = new JLabel("restart: R");
        JLabel backInstructions = new JLabel("Back: B");
        
        restartPanel.add(restartInstructions);
        restartPanel.add(backInstructions);
        add(restartPanel);
    }
    
    private void updateScorePanel(int score){
        displayedScore.setText(""+score);
    }
    
    public void restart(Doolhof currentDoolhof, HomeScreen homeScreen){
        currentDoolhof.fieldFromSrc();
        currentDoolhof.resetScore();
        JFrame restartFrame = new GameFieldViewer(currentDoolhof,homeScreen);
        restartFrame.setVisible(true);
        restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    class PlayerControlsKeyListener implements KeyListener {   
        private GameFieldViewer frame;
        private HomeScreen homeScreen;

        public PlayerControlsKeyListener(GameFieldViewer frame, HomeScreen homeScreen) {
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
                dh.getSpeler().move("Boven");
                break;
            case KeyEvent.VK_DOWN:
                dh.getSpeler().move("Onder");
                break;
            case KeyEvent.VK_LEFT:
                dh.getSpeler().move("Links");
                break;
            case KeyEvent.VK_RIGHT :
                dh.getSpeler().move("Rechts");
                break;
            case KeyEvent.VK_R :
                restart(dh, homeScreen);
                break;
            case KeyEvent.VK_B :
                JFrame home = homeScreen;
                home.setVisible(true);
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();
                break;
            }
            
            if(dh.completed()){
                JFrame victory = new VictoryScreen(homeScreen);
                victory.setVisible(true);
                victory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();
            }
            
            updateScorePanel(dh.getScore());
            component.repaint();
        }
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}