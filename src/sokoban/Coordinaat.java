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
public class Coordinaat implements Comparable<Coordinaat>{
    private int x;
    private int y;
    
    public Coordinaat(int horizontaal,int verticaal){
        this.x = horizontaal;
        this.y = verticaal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    //een functie om te kijken of de inhoud van twee verschillende object coordinaten het zelfde zijn,
    //zodat we coordinaten op inhoud kunnen vergelijken.
    @Override
    public int compareTo( final Coordinaat other) {
        int same;
        if(Integer.compare(this.x, other.x) == 0 && Integer.compare(this.y, other.y) == 0){
            same = 0;
        }else if(Integer.compare(this.y, other.y) == -1){
            same = -1;
        }else if(Integer.compare(this.y, other.y) == 1){
            same = 1;
        }else if(Integer.compare(this.x, other.x) == -1){
            same = -1;
        }else{
            same = 1;
        }
        
        return same;
    }
}

