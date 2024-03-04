package parser;
/**
 * 
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Adventurer;
import model.Map;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  InputParserTest<br>
 * <b>NOM</b> : InputParserTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 18:03:07 $
 */
class InputParserTest {

	@Test
    public void testParseInput() throws Exception {
        String filename = "testInput.txt";
        List<Object> inputObjects = InputParser.parseInput(filename);

        assertEquals(2, inputObjects.size());

        // Check if the first object is an Adventurer
        assertTrue(inputObjects.get(0) instanceof Adventurer);
        Adventurer adventurer = (Adventurer) inputObjects.get(0);
        assertEquals("Lara", adventurer.getName());
        assertEquals(1, adventurer.getPosX());
        assertEquals(1, adventurer.getPosY());
        assertEquals('S', adventurer.getOrientation());
        assertEquals(9, adventurer.getMovements().size());
        
        // Check if the second object is a Map
        assertTrue(inputObjects.get(1) instanceof Map);
        Map map = (Map) inputObjects.get(1);
        assertEquals(3, map.getWidth());
        assertEquals(4, map.getHeight());
        
        // Check if mountains are correctly set
        assertTrue(map.getCase(1, 0).isMountain());
        assertTrue(map.getCase(2, 1).isMountain());

        // Check if treasures are correctly set
        assertEquals(2, map.getCase(0, 3).getNumberOfTreasures());
        assertEquals(3, map.getCase(1, 3).getNumberOfTreasures());
    }

    @Test
    public void testParseInputInvalidFilename() {
        String filename = "invalidFile.txt";

        assertThrows(Exception.class, () -> {
            InputParser.parseInput(filename);
        });
    }

}
