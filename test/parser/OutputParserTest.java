package parser;
/**
 * 
 */


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Adventurer;
import model.Map;

/**
 * ***************************************************************<br>
 * <b>iGDA - Projet MadreDeDios</b><br>
 * <b>TYPE</b> :  OutputParserTest<br>
 * <b>NOM</b> : OutputParserTest.java<br>
 * <b>SUJET</b> : <br>
 * <b>COMMENTAIRE</b> : <br>
 * **************************************************************
 * 
 * @author romain.lapicardise
 * @version $Revision: 1.0 $ $Date: 4 mars 2024 21:51:00 $
 */
class OutputParserTest {

	@Test
    public void testParseOutput() throws Exception {
        // Création d'une carte
        Map map = new Map(3, 3);
        map.getCase(1, 1).setMountain(true); // Montagne à la position (1, 1)
        map.getCase(2, 2).setNumberOfTreasures(2); // 2 trésors à la position (2, 2)

        // Création d'une liste d'aventuriers
        List<Adventurer> adventurers = new ArrayList<>();
        Adventurer adventurer1 = new Adventurer("Indiana", 0, 0, 'N', new ArrayList<>());
        adventurer1.setNumberOfTreasure(3); // Indiana a collecté 3 trésors
        adventurers.add(adventurer1);

        // Appel de la méthode parseOutput
        String filename = "output_test.txt";
        OutputParser.parseOutput(map, adventurers, filename);

        // Vérification du contenu du fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            assertEquals("C - 3 - 3", reader.readLine()); // Vérifie les dimensions de la carte
            assertEquals("M - 1 - 1", reader.readLine()); // Vérifie la montagne à la position (1, 1)
            assertEquals("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}", reader.readLine()); // Vérifie le commentaire pour les trésors
            assertEquals("T - 2 - 2 - 2", reader.readLine()); // Vérifie les trésors restants à la position (2, 2)
            assertEquals("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}", reader.readLine()); // Vérifie le commentaire pour les aventuriers
            assertEquals("A - Indiana - 0 - 0 - N - 3", reader.readLine()); // Vérifie les détails de l'aventurier Indiana
        }

        // Suppression du fichier après les tests
        java.io.File file = new java.io.File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

}
