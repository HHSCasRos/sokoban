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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Coordinaat t_cord = new Coordinaat(1,1);
        System.out.println(t_cord.toString());
        
        Doos d = new Doos();
        
        EindVeld t = new EindVeld();
        t.setCoordinaat(t_cord);
        t.setDoos(d);
        
        t.msg();
    }
    
}
