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
        
        Doolhof dh = new Doolhof();
        
        Coordinaat cord_0 = new Coordinaat(0,1);
        Coordinaat cord_1 = new Coordinaat(1,1);
        Coordinaat cord_2 = new Coordinaat(2,1);
        
        System.out.println(cord_1.toString());
        System.out.println(cord_2.toString());
        System.out.println(cord_1==(new Coordinaat(2,1)));
        System.out.println(cord_1.compareTo(new Coordinaat(1,1)));
        System.out.println(cord_1.compareTo(new Coordinaat(0,1)));
        
        Veld V_1 = new Veld();
        V_1.setCoordinaat(cord_1);

        
        EindVeld EV_1 = new EindVeld();
        EV_1.setCoordinaat(cord_2);
        
        Coordinaat[] c = new Coordinaat[] {cord_1, cord_2};
        Tile[] t = new Tile[]{V_1,EV_1};
        dh.fillField(c, t);
        
        Doos d = new Doos(cord_1,dh);
        V_1.setDoos(d);

        //false omdat het niet in het zelfde doolhof zit.
        System.out.println(d.isOpVeld != null);
        
        EV_1.msg();
        
        d.beweeg("Rechts");

        EV_1.msg();
    }
    
}
