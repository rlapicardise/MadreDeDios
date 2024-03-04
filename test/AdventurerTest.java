/**
 * 
 */


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Adventurer;
import model.Movement;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  AdventurerTest<br>
 * <b>NOM</b> : AdventurerTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 17:05:29 $
 */
class AdventurerTest {

	@Test
	public void testConstructorAndGetters() {
		String name = "Indiana";
		int posX = 1;
		int posY = 2;
		char orientation = 'N';
		List<Movement> movements = Arrays.asList(Movement.FORWARD, Movement.RIGHT, Movement.LEFT, Movement.FORWARD);

		Adventurer adventurer = new Adventurer(name, posX, posY, orientation, movements);

		assertEquals(name, adventurer.getName());
		assertEquals(posX, adventurer.getPosX());
		assertEquals(posY, adventurer.getPosY());
		assertEquals(orientation, adventurer.getOrientation());
		assertEquals(movements, adventurer.getMovements());
		assertEquals(0, adventurer.getNumberOfTreasure()); // Check that the number of treasures is initially 0
	}

	@Test
	public void testSetters() {
		Adventurer adventurer = new Adventurer("Lara", 0, 0, 'S', Arrays.asList(Movement.FORWARD, Movement.FORWARD, Movement.RIGHT));

		adventurer.setName("Nathan");
		adventurer.setPosX(2);
		adventurer.setPosY(3);
		adventurer.setOrientation('E');
		adventurer.setMovements(Arrays.asList(Movement.RIGHT, Movement.FORWARD));

		assertEquals("Nathan", adventurer.getName());
		assertEquals(2, adventurer.getPosX());
		assertEquals(3, adventurer.getPosY());
		assertEquals('E', adventurer.getOrientation());
		assertEquals(Arrays.asList(Movement.RIGHT, Movement.FORWARD), adventurer.getMovements());
	}

	@Test
	public void testDisplay() {
		Adventurer adventurer = new Adventurer("Lara", 1, 1, 'S', Arrays.asList(
				Movement.FORWARD, Movement.FORWARD, Movement.RIGHT, Movement.FORWARD, Movement.RIGHT, Movement.FORWARD, Movement.LEFT, Movement.LEFT, Movement.FORWARD));

		String expectedDisplay = "{A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n" +
				"A - Lara - 1 - 1 - S - 0";

		assertEquals(expectedDisplay, adventurer.display());
	}
}
