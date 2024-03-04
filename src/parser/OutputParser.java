/**
 * 
 */
package parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Adventurer;
import model.Map;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  OutputParser<br>
 * <b>NOM</b> : OutputParser.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:17:38 $
 */
public class OutputParser {
	
	/**
	 * Constructor
	 */
	private OutputParser() {}
	
	/**
	 * Method to write output data in a file
	 * @param map
	 * @param adventurers
	 * @param filename
	 * @throws IOException 
	 * @throws Exception
	 */
	public static void parseOutput(Map map, List<Adventurer> adventurers, String filename) throws IOException  {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write map dimensions
            writer.write("C - " + map.getWidth() + " - " + map.getHeight());
            writer.newLine();

            // Write mountains
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    if (map.getCase(x, y).isMountain()) {
                        writer.write("M - " + x + " - " + y);
                        writer.newLine();
                    }
                }
            }

            // Write remaining treasures
            writer.write("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}");
            writer.newLine();
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    int numberOfTreasures = map.getCase(x, y).getNumberOfTreasures();
                    if (numberOfTreasures > 0) {
                        writer.write("T - " + x + " - " + y + " - " + numberOfTreasures);
                        writer.newLine();
                    }
                }
            }

            // Write adventurers
            writer.write("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}");
            writer.newLine();
            for (Adventurer adventurer : adventurers) {
                writer.write("A - " + adventurer.getName() + " - " + adventurer.getPosX() + " - " + adventurer.getPosY() + " - " + adventurer.getOrientation() + " - " + adventurer.getNumberOfTreasure());
                writer.newLine();
            }
        }
	}
}
