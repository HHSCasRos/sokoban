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
    
    @Override
    public String toString(){
        if(hasDoos()){
            return "F";
        }else if(hasSpeler()){
            return "S"; 
        }else{
            return "E";
        }
    }
}
