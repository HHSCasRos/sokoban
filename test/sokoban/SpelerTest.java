/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cas_Ros
 */
public class SpelerTest {
    
    public SpelerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Speler.
     */
    @Test
    public void Should_Move_When_Destination_Tile_Is_Veld_Without_Doos() {
        Level testLevel = new Level("testLevel");
        Doolhof dh = new Doolhof(testLevel, "testDoolhof");
        Coordinaat[] crds = new Coordinaat[9];
        Tile[] tiles = new Tile[crds.length];
        
        Coordinaat C_00 = new Coordinaat(0,0);      crds[0]= C_00;        Tile t_00 = new Veld(C_00);        tiles[0] = t_00;
        Coordinaat C_10 = new Coordinaat(1,0);      crds[1]= C_10;        Tile t_10 = new Veld(C_10);        tiles[1] = t_10;
        Coordinaat C_20 = new Coordinaat(2,0);      crds[2]= C_20;        Tile t_20 = new Veld(C_20);        tiles[2] = t_20;
        
        Coordinaat C_01 = new Coordinaat(0,1);      crds[3]= C_01;        Tile t_01 = new Veld(C_01);        tiles[3] = t_01;
        Coordinaat C_11 = new Coordinaat(1,1);      crds[4]= C_11;        Tile t_11 = new Veld(C_11);        tiles[4] = t_11;
        Coordinaat C_21 = new Coordinaat(2,1);      crds[5]= C_21;        Tile t_21 = new Veld(C_21);        tiles[5] = t_21;
        
        Coordinaat C_02 = new Coordinaat(0,2);      crds[6]= C_02;        Tile t_02 = new Veld(C_02);       tiles[6] = t_02;
        Coordinaat C_12 = new Coordinaat(1,2);      crds[7]= C_12;        Tile t_12 = new Veld(C_12);       tiles[7] = t_12;
        Coordinaat C_22 = new Coordinaat(2,2);      crds[8]= C_22;        Tile t_22 = new Veld(C_22);       tiles[8] = t_22;
        
        dh.fillField(tiles, 3);
        
        Speler sp = new Speler(new Coordinaat(1, 1),dh);
        
        Veld destination;
        
        sp.move("Rechts");
        destination = (Veld) dh.getTile(new Coordinaat(2, 1));
        assertTrue(destination.hasSpeler());
        
        sp.move("Links");
        destination = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(destination.hasSpeler());
        
        sp.move("Links");
        destination = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(destination.hasSpeler());
        
        sp.move("Boven");
        destination = (Veld) dh.getTile(new Coordinaat(0, 0));
        assertTrue(destination.hasSpeler());
        
        sp.move("Onder");
        destination = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(destination.hasSpeler());
        
        sp.move("Onder");
        destination = (Veld) dh.getTile(new Coordinaat(0, 2));
        assertTrue(destination.hasSpeler());
    }

    /**
     * Test of move method, of class Speler.
     */
    @Test
    public void Should_Not_Move_When_Destination_Tile_Is_Muur() {
        Level testLevel = new Level("testLevel");
        Doolhof dh = new Doolhof(testLevel, "testDoolhof");
        Coordinaat[] crds = new Coordinaat[9];
        Tile[] tiles = new Tile[crds.length];
        
        Coordinaat C_00 = new Coordinaat(0,0);      crds[0]= C_00;        Tile t_00 = new Muur(C_00);        tiles[0] = t_00;
        Coordinaat C_10 = new Coordinaat(1,0);      crds[1]= C_10;        Tile t_10 = new Muur(C_10);        tiles[1] = t_10;
        Coordinaat C_20 = new Coordinaat(2,0);      crds[2]= C_20;        Tile t_20 = new Muur(C_20);        tiles[2] = t_20;
        
        Coordinaat C_01 = new Coordinaat(0,1);      crds[3]= C_01;        Tile t_01 = new Muur(C_01);        tiles[3] = t_01;
        Coordinaat C_11 = new Coordinaat(1,1);      crds[4]= C_11;        Tile t_11 = new Veld(C_11);        tiles[4] = t_11;
        Coordinaat C_21 = new Coordinaat(2,1);      crds[5]= C_21;        Tile t_21 = new Muur(C_21);        tiles[5] = t_21;
        
        Coordinaat C_02 = new Coordinaat(0,2);      crds[6]= C_02;        Tile t_02 = new Muur(C_02);       tiles[6] = t_02;
        Coordinaat C_12 = new Coordinaat(1,2);      crds[7]= C_12;        Tile t_12 = new Muur(C_12);       tiles[7] = t_12;
        Coordinaat C_22 = new Coordinaat(2,2);      crds[8]= C_22;        Tile t_22 = new Muur(C_22);       tiles[8] = t_22;
        
        dh.fillField(tiles, 3);
        
        Speler sp = new Speler(new Coordinaat(1, 1),dh);
        
        Veld expectedDestination;
        expectedDestination = (Veld) dh.getTile(new Coordinaat(1, 1));
        
        sp.move("Rechts");
        assertTrue(expectedDestination.hasSpeler());
        
        sp.move("Links");
        assertTrue(expectedDestination.hasSpeler());
        
        sp.move("Links");
        assertTrue(expectedDestination.hasSpeler());
        
        sp.move("Boven");
        assertTrue(expectedDestination.hasSpeler());
        
        sp.move("Onder");
        assertTrue(expectedDestination.hasSpeler());
        
        sp.move("Onder");
        assertTrue(expectedDestination.hasSpeler());
    }
}
