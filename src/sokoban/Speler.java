/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @authors tgrja, Cas Ros
 */
public class Speler extends MoveAble{
    
    public Speler(Coordinaat c, Doolhof dh){
        super(c,dh);
        isOpVeld.setSpeler(this);
        dh.setSpeler(this);
    }
    
    @Override
    public void move(String richting){
        super.move(richting);
        
        if(isOpVeld != (Veld)dh.getTile(coordinaat)){
            isOpVeld.removeSpeler();
        isOpVeld = (Veld)dh.getTile(coordinaat);
        isOpVeld.setSpeler(this);
        
        dh.printDoolhof();
        }else{
            duwen(richting);
        }
    }
    
    public void duwen(String richting){
        Tile[] t = getSurroundings();
        int to = 0;
        switch(richting){
            case "Boven" :
                to = 1;
                break;
            case "Rechts" :
                to = 2;
                break;
            case "Onder" :
                to = 3;
                break;
            case "Links" :
                to = 4;
                break;
        }
        if(t[to] instanceof Veld){
            Veld tmp = (Veld)t[to];
            if(tmp.hasDoos()){
                System.out.println("Probeert doos te duwen!");
                tmp.getDoos().move(richting);
                this.move(richting); //optioneel wel implementeren als je achter doos aan wilt.
            }
        }else{
            System.out.println("Dat is een muur!");
        }
        dh.completed();
    }
    
    public class KeyListener{
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) { 
            case KeyEvent.VK_UP:
                move("Boven");
                break;
            case KeyEvent.VK_DOWN:
                move("Onder");
                break;
            case KeyEvent.VK_LEFT:
                move("Links");
                break;
            case KeyEvent.VK_RIGHT :
                move("Rechts");
                break;
            }
        }
    }
}
