/**
 * 
 */


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import model.Case;
import model.Map;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  MapTest<br>
 * <b>NOM</b> : MapTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 17:50:07 $
 */
class MapTest {

	@Test
	public void testConstructorAndGetters() {
		int width = 3;
		int height = 4;

		Map testMap = new Map(width, height);

		assertEquals(width, testMap.getWidth());
		assertEquals(height, testMap.getHeight());
	}

	@Test
	public void testGetCase() {
		Map testMap = new Map(3, 4);

		Case caseAtPosition00 = testMap.getCase(0, 0);
		Case caseAtPosition22 = testMap.getCase(2, 2);

		assertNotNull(caseAtPosition00);
		assertNotNull(caseAtPosition22);
	}

	@Test
	public void testGetCaseOutOfBounds() {
		Map testMap = new Map(3, 4);

		assertThrows(IllegalArgumentException.class, () -> {
			testMap.getCase(5, 5);
		});
	}

}
