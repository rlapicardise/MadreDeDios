/**
 * 
 */


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Adventurer;
import model.Map;
import model.Movement;
import service.MovementService;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  MovementServiceTest<br>
 * <b>NOM</b> : MovementServiceTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 21:26:53 $
 */
class MovementServiceTest {

	@Test
    public void testMoveForward() throws Exception {
        Map map = new Map(5, 5);
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Indiana", 1, 1, 'N', new ArrayList<>());
        adventurers.add(adventurer);

        // Test moving forward from (1,1) facing North
        MovementService.move(map, adventurers, adventurer, Movement.FORWARD);
        assertEquals(1, adventurer.getPosX());
        assertEquals(0, adventurer.getPosY());

        // Test moving forward from (1,1) facing East
        adventurer.setPosX(1);
        adventurer.setPosY(1);
        adventurer.setOrientation('E');
        MovementService.move(map, adventurers, adventurer, Movement.FORWARD);
        assertEquals(2, adventurer.getPosX());
        assertEquals(1, adventurer.getPosY());
    }

    @Test
    public void testTurnLeft() throws Exception {
        Adventurer adventurer = new Adventurer("Lara", 1, 1, 'N', new ArrayList<>());

        // Test turning left when facing North
        MovementService.turnLeft(adventurer);
        assertEquals('W', adventurer.getOrientation());

        // Test turning left when facing West
        adventurer.setOrientation('W');
        MovementService.turnLeft(adventurer);
        assertEquals('S', adventurer.getOrientation());
    }

    @Test
    public void testTurnRight() throws Exception {
        Adventurer adventurer = new Adventurer("Nathan", 1, 1, 'N', new ArrayList<>());

        // Test turning right when facing North
        MovementService.turnRight(adventurer);
        assertEquals('E', adventurer.getOrientation());

        // Test turning right when facing East
        adventurer.setOrientation('E');
        MovementService.turnRight(adventurer);
        assertEquals('S', adventurer.getOrientation());
    }
    
    @Test
    public void testMoveForwardWithMountain() throws Exception {
        Map map = new Map(5, 5);
        map.getCase(1, 0).setMountain(true); // Place a mountain at (1, 0)
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Indiana", 1, 1, 'N', new ArrayList<>());
        adventurers.add(adventurer);

        // Test moving forward from (1,1) facing North with a mountain at (1,0)
        MovementService.move(map, adventurers, adventurer, Movement.FORWARD);
        assertEquals(1, adventurer.getPosX());
        assertEquals(1, adventurer.getPosY()); // Adventurer should not move because of the mountain
    }

    @Test
    public void testMoveForwardWithAnotherAdventurer() throws Exception {
        Map map = new Map(5, 5);
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer1 = new Adventurer("Lara", 1, 1, 'N', new ArrayList<>());
        Adventurer adventurer2 = new Adventurer("Nathan", 1, 0, 'S', new ArrayList<>());
        adventurers.add(adventurer1);
        adventurers.add(adventurer2);

        // Test moving forward from (1,1) facing North with another adventurer at (1,0)
        MovementService.move(map, adventurers, adventurer1, Movement.FORWARD);
        assertEquals(1, adventurer1.getPosX());
        assertEquals(1, adventurer1.getPosY()); // Adventurer should not move because of another adventurer
    }

    @Test
    public void testMoveForwardOutOfMap() throws Exception {
        Map map = new Map(5, 5);
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Indiana", 4, 4, 'E', new ArrayList<>());
        adventurers.add(adventurer);

        // Test moving forward from (4,4) facing East (boundary case)
        MovementService.move(map, adventurers, adventurer, Movement.FORWARD);
        assertEquals(4, adventurer.getPosX());
        assertEquals(4, adventurer.getPosY()); // Adventurer should not move out of the map
    }
    
    @Test
    public void testMoveForwardWithTreasure() throws Exception {
        Map map = new Map(5, 5);
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer = new Adventurer("Indiana", 1, 1, 'N', new ArrayList<>());
        adventurers.add(adventurer);

        // Place a treasure at (1,0) with 2 treasures
        map.getCase(1, 0).setNumberOfTreasures(2);

        // Test moving forward from (1,1) facing North with a treasure at (1,0)
        MovementService.move(map, adventurers, adventurer, Movement.FORWARD);
        assertEquals(1, adventurer.getPosX());
        assertEquals(0, adventurer.getPosY());
        assertEquals(1, adventurer.getNumberOfTreasure()); // Adventurer should collect 1 treasure
        assertEquals(1, map.getCase(1, 0).getNumberOfTreasures()); // 1 treasure should remain on the case
    }

}
