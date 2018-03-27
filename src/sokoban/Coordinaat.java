/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author tgrja
 */
public class Coordinaat {
    private int x;
    private int y;
    
    public Coordinaat(int horizontaal,int verticaal){
        this.x = horizontaal;
        this.y = verticaal;
    }
    
    @Override
    public String toString(){
        return(/*"(X,Y) */"(" + this.x + "," + this.y + ")");
    }
}

