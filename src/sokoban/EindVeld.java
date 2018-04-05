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
public class EindVeld extends Veld{
    
    public EindVeld(Coordinaat c){
        super(c);
    }
    
    public void msg(){
        if(hasDoos()){
            System.out.println("Box on endfield " + this.getCoordinaat().toString());
        }else{
            System.out.println("Box not on endfield " + this.getCoordinaat().toString());
        }
    }
    
    @Override
    public String toString(){
        msg();
        if(hasDoos()){
            return "F";
        }else if(hasSpeler()){
            return "S"; 
        }else{
            return "E";
        }
    }
}
