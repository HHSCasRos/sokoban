/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cas_Ros
 */
public class LevelDoolhoven extends JFrame{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    
    //interface elements
    private JLabel label;
    private final ArrayList<JButton> button;
    private final Level level;
    private final ArrayList<Doolhof> doolhoven;
    
    private final ArrayList<ActionListener> listener;
    
    public LevelDoolhoven(Level level, HomeScreen homescreen) {
        this.level = level;
        doolhoven = new ArrayList();
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //create all buttons
        this.button = new ArrayList();
        this.listener = new ArrayList();
        this.label = new JLabel();
        
        for(int i = 0; i < this.doolhoven.size(); i++){
            button.add(new JButton());
            String j = "" + i;
            button.get(i).setActionCommand(j);
            
            listener.add(new DoolhofSelectListener(doolhoven.get(i).getNaam(), homescreen));
            button.get(i).addActionListener(listener.get(i));
        }
        
        createPanel();
    }
    
    class DoolhofSelectListener implements ActionListener{
        
        private final String idDoolhof;
        private final HomeScreen frame;
        public DoolhofSelectListener(String idDoolhof , HomeScreen f) {
            this.idDoolhof = idDoolhof;
            this.frame = f;
        }
       
        @Override
        public void actionPerformed(ActionEvent event){
            int buttonClicked;
            JFrame level;
            
            buttonClicked = Integer.parseInt(event.getActionCommand());
            
            level = new GameFieldViewer(doolhoven.get(buttonClicked), frame);
            level.setVisible(true);
            level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
        }
    }
    
    //adds all buttons to panel
    private void createPanel() {
        JPanel panel = new JPanel();
        
        for(int i = 0; i < button.size(); i++){
            panel.add(button.get(i));
        }
        panel.add(label);
        
        add(panel);
    }
}