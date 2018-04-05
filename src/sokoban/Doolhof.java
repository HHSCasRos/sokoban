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
public class Doolhof {
    private Level level;
    
    private int size;
    private int eindVelden = 0;
    private Tile[][] tiles;

    public Doolhof(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
    
    public Tile[][] getField(){
        return tiles;
    }
    
    public void setField(Tile[][] tiles){
        this.tiles = tiles;
    }
    
    public Tile getTile(Coordinaat crd){

        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                if(crd.compareTo(tiles[X][Y].getCoordinaat()) == 0){
                    return tiles[X][Y];
                }
            }
        }
        
        return null;
    }
    
    public void fillField(Tile[] t, int size){
        this.size = size;
        tiles = new Tile[size][size];
        
        int count = 0;
        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                tiles[X][Y] = t[count];
                
                if(tiles[X][Y] instanceof EindVeld){
                    eindVelden++;
                }
                count++;
            }
        }
    }
    
    public void completed(){
        int count = 0;
        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                if(tiles[X][Y] instanceof EindVeld){
                    EindVeld tmp = (EindVeld)tiles[X][Y];
                    if(tmp.hasDoos())
                        count++;
                }
            }
        }
        
        if(eindVelden == count){
            System.out.println("DOOLHOF COMPLEET !!!");
        }
    }
    
    public void printDoolhof(){
        System.out.println();
        System.out.println(this.toString());
    }
    
    @Override
    public String toString(){
        String field = "";
        String row = "";
        
        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                row = row +" | "+ tiles[X][Y].toString();
            }
            field = field+ row + " | " + "\n" ;
            row = "";
        }
        
        return field;
    }
}
