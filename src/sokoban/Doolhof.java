/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tgrja
 */
public class Doolhof {
    final private String NAAM;
    final private String RESOURCE;
    
    private Level level;
    
    private Speler sp;
    private int size;
    private int eindVelden = 0;
    private Tile[][] tiles;


    private int score = 0;
    
    Doolhof(Level level, String naam, String resource) {
        this.level = level;
        this.NAAM = naam;
        this.RESOURCE = resource;
        this.level.addDoolhof(this);
        this.fieldFromSrc();
    }

    public String getNaam() {
        return NAAM;
    }

    public Speler getSpeler() {
        return sp;
    }
    public void setSpeler(Speler sp) {
        this.sp = sp;
    }

    public Level getLevel() {
        return level;
    }
    
    public Tile[][] getField(){
        return tiles;
    }
    
    //geeft de tile terug dat zig op het megegeven coordinaat bevindt.
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
    
    public void resetScore() {
        this.score = 0;
    }
    
    public int getScore() {
        return score;
    }
    
    public void upScore() {
        this.score++;
    }

    public String getResource() {
        return RESOURCE;
    }
    
    //zet alle regels van het text bestand in een List van Strings.
    private List<String> readSrc(){
        //daclarations
        InputStream stream;
        List<String> lines;
        String input;
        BufferedReader reader;
        StringBuilder buf;

        //Inlezen van bestand
        stream = this.getClass().getResourceAsStream(RESOURCE);
        lines = new LinkedList<>();

        // laad de tekst in 
        reader = new BufferedReader(new InputStreamReader(stream));
        buf = new StringBuilder();

        if(stream != null){
            try{
                while((input = reader.readLine()) != null){
                    buf.append(input);
                    System.out.println(input);
                    lines.add(input);
                }
            } catch(IOException ex){
                System.out.println(ex);// anders schreeuwt hij in mijn gezicht:
            }
        }
        return lines;
    }
    
    //Maakt van het gegeven txt bestand een Doolhof veld en alle moveables op de gegeven locaties
    final public void fieldFromSrc(){
        List<String> lines = readSrc();
        size = Integer.parseInt(lines.get(0));
        Tile[] tiles = new Tile[size*size];
        int count = 0;
        Tile t;
        
        char[][] fieldChars = new char[size][size];
        
        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                try{
                    fieldChars[X][Y] = lines.get(Y+1).charAt(X);
                }catch(StringIndexOutOfBoundsException e){
                    System.out.println(e);
                }
            }
        }
        
        for(int Y=0; Y<size; Y++){
            for(int X=0; X<size; X++){
                Coordinaat C = new Coordinaat(X,Y); 
                switch(fieldChars[X][Y]){
                    case 'M' :         
                        t = new Muur(C);       
                        break;
                    case 'V' :
                        t = new Veld(C);
                        break;
                    case 'E' :
                        t = new EindVeld(C);
                        break;
                    default :
                        t = new Tile(C);
                        break;
                }
                tiles[count] = t;
                count++;
            }
        }
        
        fillField(tiles,size);
        createMoveAbles(lines.subList(size+2, lines.size()));
    }
    
    //zorgt er voor dat alle moveables gemaakt worden
    //en op de juiste posities worden gezet.
    public void createMoveAbles(List<String> lines){
        int regelNr = 0;
        int aantalSpelers = Integer.parseInt(lines.get(regelNr));
        while(regelNr<aantalSpelers){
            String[] crds = lines.get(regelNr+1).split(",");
            int xCoord = Integer.parseInt(crds[0]);
            int yCoord = Integer.parseInt(crds[1]);
            this.sp = new Speler(new Coordinaat(xCoord,yCoord),this);
            regelNr++;
        }

        regelNr += (2);
        int aantalDozen = Integer.parseInt(lines.get(regelNr));
        while(regelNr<(aantalSpelers+aantalDozen+2)){
            String[] crds = lines.get(regelNr+1).split(",");
            int xCoord = Integer.parseInt(crds[0]);
            int yCoord = Integer.parseInt(crds[1]);
            new Doos(new Coordinaat(xCoord,yCoord),this);
            regelNr++;
        }
    }
    
    //Zorgt er voor dat het textuele doelhof veld wordt omgezet in daadwerkelijke objectvelden.
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
    
    //controleerdt of alle eindvelden een doos hebben,
    //en dus het level compleet is.
    public boolean completed(){
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
            return true;
        }else{
            return false;
        }
    }
}
