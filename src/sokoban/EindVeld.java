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
    
    
    public void changeDoos(){
        
    }
    
    public void msg(){
        if(hasDoos()){
            System.out.println("Box on endfield " + this.getCoordinaat().toString());
        }
    }
}
