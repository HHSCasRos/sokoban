
package sokoban;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VictoryScreen extends JFrame{
    
    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT  = 720;
    
    private GameField component;
    private Doolhof dh;
    
    public VictoryScreen(HomeScreen homeScreen){
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 89);
        this.dh = new Doolhof(new Level("Victory"), "WellSHIT", "TxtHofs/Victory.txt");
        this.component = new GameField(dh);
        JPanel restartPanel = new JPanel();
        JLabel backInstructions = new JLabel("Back: B");
        restartPanel.add(backInstructions);

        KeyListener listener = new VictoryScreen.PlayerControlsKeyListener(this, homeScreen);
        this.addKeyListener(listener);
        
        add(restartPanel, BorderLayout.SOUTH);
        add(component, BorderLayout.CENTER);
        this.component.setVisible(true);
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
            case KeyEvent.VK_B :
                JFrame home = homeScreen;
                home.setVisible(true);
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();
                break;
            }
            component.repaint();
        }
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}
