import java.util.ArrayList;
import java.util.List;

import model.Adventurer;
import model.Map;
import parser.InputParser;
import parser.OutputParser;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  Main<br>
 * <b>NOM</b> : Main.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:23:08 $
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// Read input data from file
		List<Object> inputObjects = InputParser.parseInput("input.txt");

		// Process read objects (map and adventurers)
		Map map = null;
		List<Adventurer> adventurers = new ArrayList<>();
		for (Object obj : inputObjects) {
			if (obj instanceof Map) {
				map = (Map) obj;
			} else if (obj instanceof Adventurer) {
				adventurers.add((Adventurer) obj);
			}
		}

		// Process write output file
		OutputParser.parseOutput(map, adventurers, "output.txt");
	}

}
