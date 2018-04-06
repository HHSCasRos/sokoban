package sokoban;

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
    public void Player_SHOULD_Move_WHEN_Destination_Tile_Is_Veld_Without_Doos() {
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/player_SHOULD_Move_WHEN_Destination_Tile_Is_Veld_Without_Doos.txt");

        Speler sp = dh.getSpeler();
        
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
    public void Player_SHOULD_Not_Move_WHEN_Destination_Tile_Is_Muur() {
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/Player_SHOULD_Not_Move_WHEN_Destination_Tile_Is_Muur.txt");
        
        Speler sp = dh.getSpeler();
        
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
    public void Player_SHOULD_Push_Doos_WHEN_Destination_Tile_Contains_Doos_AND_Tile_Behind_Doos_Is_Navigatable() {
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/Player_SHOULD_Push_Doos_WHEN_Destination_Tile_Contains_Doos_AND_Tile_Behind_Doos_Is_Navigatable.txt");
        
        Speler sp = dh.getSpeler();
        
        Veld expectedDestinationDoosD_1;
        Veld expectedDestinationSpeler;
        
        //push box to the right
        sp.move("Rechts");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(2, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        expectedDestinationSpeler = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(expectedDestinationSpeler.hasSpeler());
        
        //move player above box and push it down
        sp.move("Boven");
        sp.move("Rechts");
        sp.move("Rechts");
        sp.move("Onder");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(2, 2));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        expectedDestinationSpeler = (Veld) dh.getTile(new Coordinaat(2, 0));
        assertTrue(expectedDestinationSpeler.hasSpeler());
    }

    @Test
    public void Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_Thats_Not_In_Field() {
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_Thats_Not_In_Field.txt");
        
        Speler sp = dh.getSpeler();
        
        Veld expectedDestinationDoosD_1;
        Veld expectedDestinationPlayer;
        
        //player pushes D_1 out of Field
        sp.move("Rechts");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        expectedDestinationPlayer = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(expectedDestinationPlayer.hasSpeler());
        assertFalse(expectedDestinationDoosD_1.hasSpeler());
    }

    @Test
    public void Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_Thats_Muur() {
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_Thats_Muur.txt");
        
        Speler sp = dh.getSpeler();
        
        Veld expectedDestinationDoosD_1;
        Veld expectedDestinationPlayer;
        
        //player pushes D_1 into Muur
        sp.move("Rechts");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        expectedDestinationPlayer = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(expectedDestinationPlayer.hasSpeler());
        assertFalse(expectedDestinationDoosD_1.hasSpeler());
    }
    
    @Test
    public void Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_That_Contains_Doos(){
        Level testLevel = new Level("testLevel");
        
        Doolhof dh = new Doolhof(testLevel, "testDoolhof", "TestTxtHofs/Doos_And_Player_SHOULD_Not_Move_WHEN_Doos_Pushed_Onto_Tile_That_Contains_Doos.txt");
        
        Speler sp = dh.getSpeler();
        
        Veld expectedDestinationDoosD_1;
        Veld expectedDestinationDoosD_2;
        Veld expectedDestinationPlayer;
        
        //player pushes D_1 into D_2
        sp.move("Rechts");
        expectedDestinationDoosD_1 = (Veld) dh.getTile(new Coordinaat(1, 1));
        assertTrue(expectedDestinationDoosD_1.hasDoos());
        
        expectedDestinationDoosD_2 = (Veld) dh.getTile(new Coordinaat(2, 1));
        assertTrue(expectedDestinationDoosD_2.hasDoos());
        
        expectedDestinationPlayer = (Veld) dh.getTile(new Coordinaat(0, 1));
        assertTrue(expectedDestinationPlayer.hasSpeler());
        assertFalse(expectedDestinationDoosD_1.hasSpeler());
    }
}
