/**
 * 
 */
package service;

import model.Adventurer;

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
	 * Constructor
	 */
	public Shifting() {
		
	}

	/**
	 * Method for moving the adventurer according to the sequence of movements
	 * @param shifts
	 * @throws Exception 
	 */
	public void move(Adventurer adventurer) throws Exception {
        for (char shift : adventurer.getShifts()) {
            switch (shift) {
                case CHAR_FORWARD:
                    moveForward(adventurer);
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
	private static void moveForward(Adventurer adventurer) throws Exception {
        switch (adventurer.getOrientation()) {
            case 'N':
            	adventurer.setPosY(adventurer.getPosY() + 1);
                break;
            case 'E':
            	adventurer.setPosX(adventurer.getPosX() + 1);
                break;
            case 'S':
            	adventurer.setPosY(adventurer.getPosY() - 1);
                break;
            case 'W':
            	adventurer.setPosX(adventurer.getPosX() - 1);
                break;
            default:
            	throw new Exception("Move incorrect");
        }
    }

    /**
     * Method for turning left
     * @param adventurer
     * @throws Exception
     */
    private static void turnLeft(Adventurer adventurer) throws Exception {
        switch (adventurer.getOrientation()) {
        case 'N':
        	adventurer.setOrientation('W');
            break;
        case 'E':
        	adventurer.setOrientation('N');
            break;
        case 'S':
        	adventurer.setOrientation('E');
            break;
        case 'W':
        	adventurer.setOrientation('S');
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
    	case 'N':
    		adventurer.setOrientation('E');
    		break;
    	case 'E':
    		adventurer.setOrientation('S');
    		break;
    	case 'S':
    		adventurer.setOrientation('W');
    		break;
    	case 'W':
    		adventurer.setOrientation('N');
    		break;
    	default:
    		throw new Exception("Move incorrect");
    	}
    }
}
