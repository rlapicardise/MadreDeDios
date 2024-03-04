/**
 * 
 */
package model;

 /**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  Case<br>
 * <b>NOM</b> : Case.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 12:44:51 $
 */
public class Case {
	/**
	 * Is it a mountain ?
	 */
	private boolean mountain;
	
	/**
	 * Number of treasures
	 */
	private int numberOfTreasures;

	/**
	 * @return the mountain
	 */
	public boolean isMountain() {
		return mountain;
	}
	/**
	 * @param mountain the mountain to set
	 */
	public void setMountain(boolean mountain) {
		this.mountain = mountain;
	}
	/**
	 * @return the numberOfTreasures
	 */
	public int getNumberOfTreasures() {
		return numberOfTreasures;
	}
	/**
	 * @param numberOfTreasures the numberOfTreasures to set
	 */
	public void setNumberOfTreasures(int numberOfTreasures) {
		this.numberOfTreasures = numberOfTreasures;
	}

}
