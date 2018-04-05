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

    @Test
    public void Should_Push_Doos_When_Destination_Tile_Contains_Doos_And_Tile_Behind_Doos_Is_Navigatable() {
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
        
        Doos D_1 = new Doos(new Coordinaat(1,1),dh);
        
        Speler sp = new Speler(new Coordinaat(0, 1),dh);
        
        Veld expectedDestinationDoos;
        
        //push box to the right
        sp.move("Rechts");
        expectedDestinationDoos = (Veld) dh.getTile(new Coordinaat(2, 1));
        assertTrue(expectedDestinationDoos.hasDoos());
        
        //move player above box and push it down
        sp.move("Boven");
        sp.move("Rechts");
        sp.move("Rechts");
        sp.move("Onder");
        expectedDestinationDoos = (Veld) dh.getTile(new Coordinaat(2, 2));
        assertTrue(expectedDestinationDoos.hasDoos());
        
        //attempt to push bos of the field
        sp.move("Onder");
        expectedDestinationDoos = (Veld) dh.getTile(new Coordinaat(2, 2));
        assertTrue(expectedDestinationDoos.hasDoos());
    }

    @Test
    public void Doos_Should_Not_Move_When_Pushed_Onto_Tile_Thats_Not_Navigatable() {
        Level testLevel = new Level("testLevel");
        Doolhof dh = new Doolhof(testLevel, "testDoolhof");
        Coordinaat[] crds = new Coordinaat[16];
        Tile[] tiles = new Tile[crds.length];
        
        Coordinaat C_00 = new Coordinaat(0,0);      crds[0]= C_00;        Tile t_00 = new Veld(C_00);        tiles[0] = t_00;
        Coordinaat C_10 = new Coordinaat(1,0);      crds[1]= C_10;        Tile t_10 = new Veld(C_10);        tiles[1] = t_10;
        Coordinaat C_20 = new Coordinaat(2,0);      crds[2]= C_20;        Tile t_20 = new Veld(C_20);        tiles[2] = t_20;
        Coordinaat C_30 = new Coordinaat(3,0);      crds[3]= C_20;        Tile t_30 = new Veld(C_30);        tiles[3] = t_30;
        
        Coordinaat C_01 = new Coordinaat(0,1);      crds[4]= C_01;        Tile t_01 = new Veld(C_01);        tiles[4] = t_01;
        Coordinaat C_11 = new Coordinaat(1,1);      crds[5]= C_11;        Tile t_11 = new Veld(C_11);        tiles[5] = t_11;
        Coordinaat C_21 = new Coordinaat(2,1);      crds[6]= C_21;        Tile t_21 = new Veld(C_21);        tiles[6] = t_21;
        Coordinaat C_31 = new Coordinaat(3,1);      crds[7]= C_31;        Tile t_31 = new Veld(C_31);        tiles[7] = t_31;
        
        Coordinaat C_02 = new Coordinaat(0,2);      crds[8]= C_02;        Tile t_02 = new Veld(C_02);       tiles[8] = t_02;
        Coordinaat C_12 = new Coordinaat(1,2);      crds[9]= C_12;        Tile t_12 = new Veld(C_12);       tiles[9] = t_12;
        Coordinaat C_22 = new Coordinaat(2,2);      crds[10]= C_22;        Tile t_22 = new Veld(C_22);       tiles[10] = t_22;
        Coordinaat C_32 = new Coordinaat(3,2);      crds[11]= C_32;        Tile t_32 = new Veld(C_32);       tiles[11] = t_32;
        
        Coordinaat C_03 = new Coordinaat(0,3);      crds[12]= C_03;        Tile t_03 = new Veld(C_03);       tiles[12] = t_03;
        Coordinaat C_13 = new Coordinaat(1,3);      crds[13]= C_13;        Tile t_13 = new Muur(C_13);       tiles[13] = t_13;
        Coordinaat C_23 = new Coordinaat(2,3);      crds[14]= C_23;        Tile t_23 = new Veld(C_23);       tiles[14] = t_23;
        Coordinaat C_33 = new Coordinaat(3,3);      crds[15]= C_33;        Tile t_33 = new Veld(C_33);       tiles[15] = t_33;
        
        dh.fillField(tiles, 4);
        
        Doos D_1 = new Doos(new Coordinaat(1,2),dh);
        Doos D_2 = new Doos(new Coordinaat(3,2),dh);
        Doos D_3 = new Doos(new Coordinaat(1,1),dh);
        
        Speler sp = new Speler(new Coordinaat(1, 0),dh);
        
        Veld expectedDestinationDoosD_1;
        Veld expectedDestinationDoosD_2;
        Veld expectedDestinationDoosD_3;
        
        //player pushes D_3 into D_1
        sp.move("Onder");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(1, 2));
        expectedDestinationDoosD_2 = (Veld) dh.getTile(new Coordinaat(3, 2));
        expectedDestinationDoosD_3 = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        assertTrue(expectedDestinationDoosD_2.hasDoos());
        assertTrue(expectedDestinationDoosD_3.hasDoos());
        
        //player pushes D_1 to the right and then into D_2
        sp.move("Links");
        sp.move("Onder");
        sp.move("Onder");
        sp.move("Rechts");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(2, 2));
        expectedDestinationDoosD_2 = (Veld) dh.getTile(new Coordinaat(3, 2));
        expectedDestinationDoosD_3 = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        assertTrue(expectedDestinationDoosD_2.hasDoos());
        assertTrue(expectedDestinationDoosD_3.hasDoos());
        
        //player pushes D_3 into Muur
        sp.move("Links");
        sp.move("Boven");
        sp.move("Boven");
        sp.move("Rechts");
        sp.move("Onder");
        sp.move("Onder");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(2, 2));
        expectedDestinationDoosD_2 = (Veld) dh.getTile(new Coordinaat(3, 2));
        expectedDestinationDoosD_3 = (Veld) dh.getTile(new Coordinaat(1, 2));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        assertTrue(expectedDestinationDoosD_2.hasDoos());
        assertTrue(expectedDestinationDoosD_3.hasDoos());
        
        //player pushes D_1 of the field
        sp.move("Rechts");
        sp.move("Onder");
        sp.move("Onder");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(2, 3));
        expectedDestinationDoosD_2 = (Veld) dh.getTile(new Coordinaat(3, 2));
        expectedDestinationDoosD_3 = (Veld) dh.getTile(new Coordinaat(1, 2));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        assertTrue(expectedDestinationDoosD_2.hasDoos());
        assertTrue(expectedDestinationDoosD_3.hasDoos());
    }
}
