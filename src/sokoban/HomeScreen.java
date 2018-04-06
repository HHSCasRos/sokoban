/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cas_Ros
 */
public class HomeScreen extends JFrame{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    
    //interface elements
    private JLabel label;
    private final ArrayList<JButton> button;
    private final ArrayList<Level> levels;
    
    private final ArrayList<ActionListener> listener;
    
    public HomeScreen(ArrayList<Level> levels) {
        this.levels = levels;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //create all buttons
        this.button = new ArrayList();
        this.listener = new ArrayList();
        this.label = new JLabel("SOKOBAN");
        
        for(int i = 0; i < this.levels.size(); i++){
            button.add(new JButton(levels.get(i).getIdLevel()));
            String j = "" + i;
            button.get(i).setActionCommand(j);
            
            listener.add(new LevelSelectListener(levels.get(i).getIdLevel(), this));
            button.get(i).addActionListener(listener.get(i));
        }
        
        createPanels();
    }
    
    class LevelSelectListener implements ActionListener{
        private final String idLevel;
        private final HomeScreen frame;
        public LevelSelectListener(String idLevel, HomeScreen f) {
            this.idLevel = idLevel;
            this.frame = f;
        }
       
        @Override
        public void actionPerformed(ActionEvent event){
            int buttonClicked;
            JFrame level;
            
            buttonClicked = Integer.parseInt(event.getActionCommand());
            
            level = new LevelDoolhoven(levels.get(buttonClicked), frame);
            level.setVisible(true);
            level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
        }
    }
    
    //adds all buttons to panel
    private void createPanels() {
        JPanel containerPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel levelPanel = new JPanel();
        
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        
        label.setFont(new Font("Serif", Font.PLAIN, 64));
        
        titlePanel.add(label);
        for(int i = 0; i < button.size(); i++){
            levelPanel.add(button.get(i));
        }
        
        containerPanel.add(titlePanel);
        containerPanel.add(levelPanel);
        add(containerPanel);
    }
}