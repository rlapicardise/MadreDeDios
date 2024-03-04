import java.util.ArrayList;
import java.util.List;

import model.Adventurer;
import model.Map;
import model.Movement;
import parser.InputParser;
import parser.OutputParser;
import service.MovementService;

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
		
		// Iterate through each movement turn
        for (int turn = 0; turn < getMaximumTurns(adventurers); turn++) {
            // Move each adventurer for the current turn
        	for (Adventurer adventurer : adventurers) {
        		if (turn >= adventurer.getMovements().size()) {
        			// The adventurer finished his movements
        			continue;
        		}
        		Movement move = adventurer.getMovements().get(turn);
        		// Process the movement for the current adventurer
        		MovementService.move(map, adventurers, adventurer, move);
        		displayCurrentRepresentation(map, adventurers);
        	}
        }

		// Process write output file
		OutputParser.parseOutput(map, adventurers, "output.txt");
	}
	
	/**
	 * Find the maximum number of movements among all adventurers
	 * @param adventurers
	 * @return
	 */
	private static int getMaximumTurns(List<Adventurer> adventurers) {
        int maxTurns = 0;
        for (Adventurer adventurer : adventurers) {
            maxTurns = Math.max(maxTurns, adventurer.getMovements().size());
        }
        return maxTurns;
    }
	
	/**
	 * @param map
	 * @param adventurers
	 */
	private static void displayCurrentRepresentation(Map map, List<Adventurer> adventurers) {
		for (int y=0 ; y<map.getHeight() ; y++) {
			for (int x=0 ; x<map.getWidth() ; x++) {
        		if(map.getCase(x,y).isMountain()) {
        			System.out.print(" M ");
        		} else if (MovementService.getAdventurerOfThisCase(adventurers, x, y) != null) {
        			System.out.print(" "+MovementService.getAdventurerOfThisCase(adventurers, x, y).getOrientation()+" ");
        		} else if (map.getCase(x,y).getNumberOfTreasures() > 0) {
        			System.out.print(" "+map.getCase(x,y).getNumberOfTreasures()+" ");
        		} else {
        			System.out.print(" . ");
        		}
        	}
			System.out.println();
    	}
		System.out.println();
	}

}
