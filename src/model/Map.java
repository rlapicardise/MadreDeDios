/**
 * 
 */
package model;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  Map<br>
 * <b>NOM</b> : Map.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 1 mars 2024 16:12:09 $
 */
public class Map {
	
	/**
	 * Cases of the map
	 */
	private Case[][] cases;	
	
	/**
	 * Constructor of the map
	 * @param width
	 * @param height
	 */
	public Map(int width, int height) {
		this.cases = new Case[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.cases[x][y] = new Case();
            }
        }
	}

	/**
	 * Get the case of this position
	 * @param x
	 * @param y
	 * @return
	 */
	public Case getCase(int x, int y) {
        return cases[x][y];
    }
	
	/**
	 * Get the width of the map
	 * @return
	 */
	public int getWidth() {
		return cases.length;
	}
	
	/**
	 * Get the height of the map
	 * @return
	 */
	public int getHeight() {
		return cases[0].length;
	}
}
