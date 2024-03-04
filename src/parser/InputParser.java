/**
 * 
 */
package parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Adventurer;
import model.Map;

 /**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  InputParser<br>
 * <b>NOM</b> : InputParser.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:17:23 $
 */
public class InputParser {
	
	/**
	 * Consatnts of inputs symbols
	 */
	static final char CHAR_ADVENTURER = 'A';

	static final char CHAR_MAP = 'C';

	static final char CHAR_MOUNTAIN = 'M';

	static final char CHAR_TREASURE = 'T';
	
	/**
	 * Constructor
	 */
	private InputParser() {}
	
	/**
	 * Method to read input data from a file
	 * @param filename
	 * @return
	 * @throws Exception
	 */
    public static List<Object> parseInput(String filename) throws Exception {
        List<Object> inputObjects = new ArrayList<>();
    	Map map = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#")) { // It's not comments
                    String[] parts = line.split(" - ");
                    if (parts.length > 0) {
                        char type = parts[0].charAt(0);
                        switch (type) {
                            case CHAR_MAP:
                                map = parseMap(parts);
                                break;
                            case CHAR_MOUNTAIN:
                                parseMountain(map, parts);
                                break;
                            case CHAR_TREASURE:
                                parseTreasure(map, parts);
                                break;
                            case CHAR_ADVENTURER:
                                inputObjects.add(parseAdventurer(parts));
                                break;
                            default:
                                throw new Exception("Unrecognized type");
                        }
                    }
                }
            }
        }
        inputObjects.add(map);
        return inputObjects;
    }
    
    /**
     * Parser of a map
     * @param parts
     * @return
     */
    private static Map parseMap(String[] parts) {
        int largeur = Integer.parseInt(parts[1]);
        int hauteur = Integer.parseInt(parts[2]);
        return new Map(largeur, hauteur);
    }

    /**
     * Parser of a mountain
     * @param map
     * @param parts
     * @throws Exception
     */
    private static void parseMountain(Map map, String[] parts) throws Exception {
    	if (map == null) {
    		throw new Exception("Map sould be defined.");
    	}
    	int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        map.getCase(x, y).setMountain(true);
    }

    /**
     * Parser of treasure
     * @param map
     * @param parts
     * @throws Exception
     */
    private static void parseTreasure(Map map, String[] parts) throws Exception {
    	if (map == null) {
    		throw new Exception("Map sould be defined.");
    	}
    	int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int nbTreasure = Integer.parseInt(parts[3]);
        map.getCase(x, y).setNumberOfTreasures(nbTreasure);
    }

    /**
     * Parser of adventurer
     * @param parts
     * @return
     */
    private static Adventurer parseAdventurer(String[] parts) {
        String nom = parts[1];
        int x = Integer.parseInt(parts[2]);
        int y = Integer.parseInt(parts[3]);
        char orientation = parts[4].charAt(0);
        List<Character> mouvements = new ArrayList<>();
        for (char c : parts[5].toCharArray()) {
            mouvements.add(c);
        }
        return new Adventurer(nom, x, y, orientation, mouvements);
    }
}
