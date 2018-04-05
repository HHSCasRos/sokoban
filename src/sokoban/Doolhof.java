/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.HashMap;

/**
 *
 * @author tgrja
 */
public class Doolhof {
    private Level level;
    //lijst / map
    private HashMap TileList = new HashMap();
    
    private int size;
    private int eindVelden = 0;
    private Tile[][] tiles;

    public Doolhof(Level level) {
        this.level = level;
    }
    
    public Tile getTile(Coordinaat crd){
        if(!TileList.isEmpty()){
            Object[] cords = TileList.keySet().toArray();
            for(Object o : cords){
                crd.compareTo((Coordinaat)o);
                if(crd.compareTo((Coordinaat)o) == 0){
                    return (Tile)TileList.get(o);
                }
            }
        }else{
            for(int Y=0; Y<size; Y++){
                for(int X=0; X<size; X++){
//                    tiles[X][Y].getCoordinaat();
//                    crd.compareTo(tiles[X][Y].getCoordinaat());
                    if(crd.compareTo(tiles[X][Y].getCoordinaat()) == 0){
                        return tiles[X][Y];
                    }
                }
            }
        }
        return null;
    }
    
    public void fillField( Coordinaat[] c, Tile[] t){
        if(c.length == t.length){
            int count = 0;
            for(Coordinaat crd : c){    
                TileList.put(crd, t[count]);
                count++;
            }
        }else{
            //throw exception.
            
        } 
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
