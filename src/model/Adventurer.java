/**
 * 
 */
package model;

import java.util.List;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  Adventurer<br>
 * <b>NOM</b> : Adventurer.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:16:56 $
 */
public class Adventurer {
	
	/**
	 * Name of the adventurer
	 */
	private String name;
	
	/**
	 * Position X of the adventurer
	 */
	private int posX;
	
	/**
	 * Position Y of the adventurer
	 */
	private int posY;
	
	/**
	 * Orientation of the adventurer
	 */
	private char orientation;
	
	/**
	 * Shifts of the adventurer
	 */
	private List<Character> shifts;
	
	
	/**
	 * Number of treasure
	 */
	private int numberOfTreasure;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the orientation
	 */
	public char getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return the shifts
	 */
	public List<Character> getShifts() {
		return shifts;
	}

	/**
	 * @param shifts the shifts to set
	 */
	public void setShifts(List<Character> shifts) {
		this.shifts = shifts;
	}

	
	/**
	 * @return the numberOfTreasure
	 */
	public int getNumberOfTreasure() {
		return numberOfTreasure;
	}

	/**
	 * @param numberOfTreasure the numberOfTreasure to set
	 */
	public void setNumberOfTreasure(int numberOfTreasure) {
		this.numberOfTreasure = numberOfTreasure;
	}

	/**
	 * Constructor
	 */
	public Adventurer(String name, int posX, int posY, char orientation, List<Character> shifts) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.orientation = orientation;
		this.shifts = shifts;
	}
	
	/**
	 * Resume of the adventurer
	 * @return resume of the adventurer
	 */
	public String display() {
        return "{A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}" + "\n" +
                "A - " + name + " - " + posX + " - " + posY + " - " + orientation + " - " + numberOfTreasure;
    }

}
