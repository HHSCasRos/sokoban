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
        
        Coordinaat cord_1 = new Coordinaat(1,1);
        Coordinaat cord_2 = new Coordinaat(2,1);
        
        System.out.println(cord_1.toString());
        System.out.println(cord_2.toString()); 
        
        Veld V_1 = new Veld();
        V_1.setCoordinaat(cord_1);

        
        EindVeld EV_1 = new EindVeld();
        EV_1.setCoordinaat(cord_2);
        
        
        Doos d = new Doos(cord_1);
        V_1.setDoos(d);
        
        //false omdat het niet in het zelfde doolhof zit.
        System.out.println(d.isOpVeld != null);
        
        EV_1.msg();
        
        d.beweeg("Rechts");

        EV_1.msg();
    }
    
}
