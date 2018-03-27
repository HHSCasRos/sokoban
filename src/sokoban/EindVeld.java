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
        //de draw methode voor doos moet veranderd worden.
    }
    
    public void msg(){
        if(hasDoos()){
            System.out.println("Box on endfield " + this.getCoordinaat().toString());
        }else{
            System.out.println("Box not on endfield " + this.getCoordinaat().toString());
        }
    }
}
