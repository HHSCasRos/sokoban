/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author tgrja
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Level lvl = new Level("test level");
        Doolhof dh = new Doolhof(lvl,"Test Hof","TxtHofs/Test.txt");
        Doolhof dh1 = new Doolhof(lvl,"Wiki Hof","TxtHofs/WikipediaLevel.txt");

        ArrayList<Level> levels = new ArrayList();
        levels.add(lvl);
        
        loadinterface(levels);
    }
    
    static public void loadinterface(ArrayList<Level> levels){
        JFrame frame = new HomeScreen(levels);
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}
