/**
 * 
 */
package service;

import model.Adventurer;
import model.Case;
import model.Map;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  Shifting<br>
 * <b>NOM</b> : Shifting.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:19:45 $
 */
public class Shifting {
	
	/**
	 * Constants of shifting indications
	 */
	static final char CHAR_FORWARD = 'A';

	static final char CHAR_LEFT = 'G';

	static final char CHAR_RIGHT = 'D';
	
	/**
	 * Constants of orientations
	 */
	static final char CHAR_NORD = 'N';

	static final char CHAR_SOUTH = 'S';

	static final char CHAR_EAST = 'E';

	static final char CHAR_WEST = 'W';
	
	/**
	 * Constructor
	 */
	public Shifting() {
		
	}

	/**
	 * Method for moving the adventurer according to the sequence of movements
	 * @param shifts
	 * @throws Exception 
	 */
	public void move(Map map, Adventurer adventurer) throws Exception {
        for (char shift : adventurer.getShifts()) {
            switch (shift) {
                case CHAR_FORWARD:
                    moveForward(map, adventurer);
                    break;
                case CHAR_LEFT:
                    turnLeft(adventurer);
                    break;
                case CHAR_RIGHT:
                    turnRight(adventurer);
                    break;
                default:
                	throw new Exception("Move incorrect");
            }
        }
    }
	
	/**
	 * Method to move forward
	 * @param adventurer
	 * @throws Exception
	 */
	private static void moveForward(Map map, Adventurer adventurer) throws Exception {
		int newX = adventurer.getPosX();
        int newY = adventurer.getPosY();

        // Determine the new coordinates based on orientation
        switch (adventurer.getOrientation()) {
            case CHAR_NORD:
                newY++;
                break;
            case CHAR_EAST:
                newX++;
                break;
            case CHAR_SOUTH:
                newY--;
                break;
            case CHAR_WEST:
                newX--;
                break;
        }

        // Check if the new coordinates are valid on the map
        if (isValidPosition(map, newX, newY)) {
            Case newCase = map.getCase(newX, newY);
            if (!newCase.isMountain()) {
                adventurer.setPosX(newX);
                adventurer.setPosY(newY);
                collectTreasure(newCase, adventurer);
            }
        }
    }

    /**
     * Method for turning left
     * @param adventurer
     * @throws Exception
     */
    private static void turnLeft(Adventurer adventurer) throws Exception {
        switch (adventurer.getOrientation()) {
        case CHAR_NORD:
        	adventurer.setOrientation(CHAR_WEST);
            break;
        case CHAR_EAST:
        	adventurer.setOrientation(CHAR_NORD);
            break;
        case CHAR_SOUTH:
        	adventurer.setOrientation(CHAR_EAST);
            break;
        case CHAR_WEST:
        	adventurer.setOrientation(CHAR_SOUTH);
            break;
        default:
        	throw new Exception("Move incorrect");
        }
    }

    /**
     * Method for turning right
     * @param adventurer
     * @throws Exception
     */
    private static void turnRight(Adventurer adventurer) throws Exception {
    	switch (adventurer.getOrientation()) {
    	case CHAR_NORD:
    		adventurer.setOrientation(CHAR_EAST);
    		break;
    	case CHAR_EAST:
    		adventurer.setOrientation(CHAR_SOUTH);
    		break;
    	case CHAR_SOUTH:
    		adventurer.setOrientation(CHAR_WEST);
    		break;
    	case CHAR_WEST:
    		adventurer.setOrientation(CHAR_NORD);
    		break;
    	default:
    		throw new Exception("Move incorrect");
    	}
    }
    
    /**
     * Check is the position is valid (in the map)
     * @param map
     * @param x
     * @param y
     * @return
     */
    private static boolean isValidPosition(Map map, int x, int y) {
        return x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight();
    }

    /**
     * Collect the treasure of the case for the adventurer
     * @param newCase
     * @param adventurer
     */
    private static void collectTreasure(Case newCase, Adventurer adventurer) {
        int numberOfTreasures = newCase.getNumberOfTreasures();
        if (numberOfTreasures > 0) {
            adventurer.setNumberOfTreasure(adventurer.getNumberOfTreasure() + numberOfTreasures);
            newCase.setNumberOfTreasures(0);
        }
    }
}
