package model;
/**
 * 
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Case;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  CaseTest<br>
 * <b>NOM</b> : CaseTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 17:49:44 $
 */
class CaseTest {

	@Test
    public void testDefaultValues() {
        Case testCase = new Case();

        assertFalse(testCase.isMountain());
        assertEquals(0, testCase.getNumberOfTreasures());
    }

    @Test
    public void testSettersAndGetters() {
        Case testCase = new Case();

        testCase.setMountain(true);
        testCase.setNumberOfTreasures(5);

        assertTrue(testCase.isMountain());
        assertEquals(5, testCase.getNumberOfTreasures());
    }

    @Test
    public void testSetMountain() {
        Case testCase = new Case();

        assertFalse(testCase.isMountain());
        testCase.setMountain(true);
        assertTrue(testCase.isMountain());
        testCase.setMountain(false);
        assertFalse(testCase.isMountain());
    }

    @Test
    public void testSetNumberOfTreasures() {
        Case testCase = new Case();

        assertEquals(0, testCase.getNumberOfTreasures());
        testCase.setNumberOfTreasures(10);
        assertEquals(10, testCase.getNumberOfTreasures());
        testCase.setNumberOfTreasures(0);
        assertEquals(0, testCase.getNumberOfTreasures());
    }

}
