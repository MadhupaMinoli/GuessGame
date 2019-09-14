/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.WordRepository;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TextDatasourceTest {
    Datasource txtDS = new TextDatasource();
    String fileName="C:\\Users\\User\\Documents\\NetBeansProjects\\wordGuessGame\\src\\GuessGame\\TxtFiles\\words.txt";

            
    public TextDatasourceTest() {
    }

    /**
     * Test of readWordsFromFile method, of class TextDatasource.
     */
    @Test
    public void testReadWordsFromFile() {
        String[] readWordsFromFile = txtDS.readWordsFromFile(fileName);
        String[] expected = new String[]{"world","hello"};
        assertArrayEquals(expected, readWordsFromFile);
    }
    

    /**
     * Test of randomWord method, of class TextDatasource.
     */
    @Test
    public void testRandomWord() {
        String[] possible = new String[]{"world","hello"};
        String randomWord = txtDS.randomWord(possible);
        assertThat(randomWord, Is.is("hello"));
       // assertThat(randomWord, Is.is("world"));

      
    }
    
}
