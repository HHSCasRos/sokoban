/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.ArrayList;
import javax.swing.JFrame;

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
        Level lvl = new Level("test level");
        Doolhof dh = createSpeelVeld(lvl, "test doolhof");
        addMoveAbles(dh);
        
        Speler sp = new Speler(new Coordinaat(2,1),dh);
        
/*        System.out.println(dh.toString());
        sp.move("Rechts");
        sp.move("Links");
        sp.move("Boven");
        sp.move("Links");
        sp.move("Onder");
        sp.move("Boven");
        sp.move("Rechts");
        sp.move("Rechts");
        sp.move("Onder");*/

        ArrayList<Level> levels = new ArrayList();
        levels.add(lvl);
        
        loadinterface(levels);
    }
    
    public static void addMoveAbles(Doolhof dh){
        
        
        Doos D_1 = new Doos(new Coordinaat(1,2),dh);
        Doos D_2 = new Doos(new Coordinaat(3,2),dh);
    }
    
    public static Doolhof createSpeelVeld(Level lvl, String naam){
        Doolhof dh = new Doolhof(lvl, naam);
        Coordinaat[] crds = new Coordinaat[25];
        Tile[] tiles = new Tile[crds.length];
        
        Coordinaat C_00 = new Coordinaat(0,0);      crds[0]= C_00;        Tile t_00 = new Muur(C_00);        tiles[0] = t_00;
        Coordinaat C_10 = new Coordinaat(1,0);      crds[1]= C_10;        Tile t_10 = new Muur(C_10);        tiles[1] = t_10;
        Coordinaat C_20 = new Coordinaat(2,0);      crds[2]= C_20;        Tile t_20 = new Veld(C_20);        tiles[2] = t_20;
        Coordinaat C_30 = new Coordinaat(3,0);      crds[3]= C_30;        Tile t_30 = new Muur(C_30);        tiles[3] = t_30;
        Coordinaat C_40 = new Coordinaat(4,0);      crds[4]= C_40;        Tile t_40 = new Muur(C_40);        tiles[4] = t_40;
        
        Coordinaat C_01 = new Coordinaat(0,1);      crds[5]= C_01;        Tile t_01 = new Muur(C_01);        tiles[5] = t_01;
        Coordinaat C_11 = new Coordinaat(1,1);      crds[6]= C_11;        Tile t_11 = new Veld(C_11);        tiles[6] = t_11;
        Coordinaat C_21 = new Coordinaat(2,1);      crds[7]= C_21;        Tile t_21 = new Veld(C_21);        tiles[7] = t_21;
        Coordinaat C_31 = new Coordinaat(3,1);      crds[8]= C_31;        Tile t_31 = new Veld(C_31);        tiles[8] = t_31;
        Coordinaat C_41 = new Coordinaat(4,1);      crds[9]= C_41;        Tile t_41 = new Muur(C_41);        tiles[9] = t_41;
        
        Coordinaat C_02 = new Coordinaat(0,2);      crds[10]= C_02;        Tile t_02 = new Muur(C_02);       tiles[10] = t_02;
        Coordinaat C_12 = new Coordinaat(1,2);      crds[11]= C_12;        Tile t_12 = new Veld(C_12);       tiles[11] = t_12;
        Coordinaat C_22 = new Coordinaat(2,2);      crds[12]= C_22;        Tile t_22 = new Muur(C_22);       tiles[12] = t_22;
        Coordinaat C_32 = new Coordinaat(3,2);      crds[13]= C_32;        Tile t_32 = new Veld(C_32);       tiles[13] = t_32;
        Coordinaat C_42 = new Coordinaat(4,2);      crds[14]= C_42;        Tile t_42 = new Muur(C_42);       tiles[14] = t_42;
        
        Coordinaat C_03 = new Coordinaat(0,3);      crds[15]= C_03;        Tile t_03 = new Muur(C_03);       tiles[15] = t_03;
        Coordinaat C_13 = new Coordinaat(1,3);      crds[16]= C_13;        Tile t_13 = new EindVeld(C_13);   tiles[16] = t_13;
        Coordinaat C_23 = new Coordinaat(2,3);      crds[17]= C_23;        Tile t_23 = new Muur(C_23);       tiles[17] = t_23;
        Coordinaat C_33 = new Coordinaat(3,3);      crds[18]= C_33;        Tile t_33 = new EindVeld(C_33);   tiles[18] = t_33;
        Coordinaat C_43 = new Coordinaat(4,3);      crds[19]= C_43;        Tile t_43 = new Muur(C_43);       tiles[19] = t_43;
        
        Coordinaat C_04 = new Coordinaat(0,4);      crds[20]= C_04;        Tile t_04 = new Muur(C_04);       tiles[20] = t_04;
        Coordinaat C_14 = new Coordinaat(1,4);      crds[21]= C_14;        Tile t_14 = new Muur(C_14);       tiles[21] = t_14;
        Coordinaat C_24 = new Coordinaat(2,4);      crds[22]= C_24;        Tile t_24 = new Muur(C_24);       tiles[22] = t_24;
        Coordinaat C_34 = new Coordinaat(3,4);      crds[23]= C_34;        Tile t_34 = new Muur(C_34);       tiles[23] = t_34;
        Coordinaat C_44 = new Coordinaat(4,4);      crds[24]= C_44;        Tile t_44 = new Muur(C_44);       tiles[24] = t_44;
        
        dh.fillField(tiles , 5);
        return dh;
    }
    
    static public void loadinterface(ArrayList<Level> levels){
        JFrame frame = new HomeScreen(levels);
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}
