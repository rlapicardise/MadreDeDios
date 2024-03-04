/**
 * 
 */
package parser;

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
	public static void parseOutput(Map map, List<Adventurer> adventurers, String filename) throws Exception {
        if (map != null && !adventurers.isEmpty()) {

    		System.out.println("C - " + map.getWidth() + " - " + map.getHeight());
        	for (int x=0 ; x<map.getWidth() ; x++) {
            	for (int y=0 ; y<map.getHeight() ; y++) {
            		if(map.getCase(x, y).isMountain()) {            			
            			System.out.println("M - " + x + " - " + y);
            		}
            	}
        	}
        	System.out.println("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}");
        	for (int x=0 ; x<map.getWidth() ; x++) {
            	for (int y=0 ; y<map.getHeight() ; y++) {
            		int nbTreasures= map.getCase(x, y).getNumberOfTreasures();
            		if(nbTreasures > 0) {            			
            			System.out.println("T - " + x + " - " + y + " - " + nbTreasures);
            		}
            	}
        	}
        	adventurers.forEach(adv -> {
        		System.out.println(adv.display());
        	});
        } else {
            System.out.println("Erreur : les données d'entrée ne sont pas complètes.");
        }
		
	}
}
