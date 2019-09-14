/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.Entity;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class WordTest {
    Word word = new Word("madhupa");
    public WordTest() {
    }

    /**
     * Test of stringToCharSet method, of class Word.
     */
    @Test
    public void testStringToCharSet() {
        String str = "mad";
        Set<Character> result = word.stringToCharSet(str);
        Set<Character> expected = new HashSet<>();
        expected.add('m');
        expected.add('a');
        expected.add('d');
        assertEquals(expected, result);
    }
    
}
