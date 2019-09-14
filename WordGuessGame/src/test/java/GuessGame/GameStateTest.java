/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame;

import GuessGame.Entity.Word;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class GameStateTest {

    private int level;
     
    String fileName="C:\\Users\\User\\Documents\\NetBeansProjects\\wordGuessGame\\src\\GuessGame\\TxtFiles\\words.txt";
    GameState game = new GameState(fileName);
    
    public GameStateTest() {
    }

    /**
     * Test of resetGame method, of class GameState.
     */
    @Test
    public void testResetGame() {
    }

    

    /**
     * Test of guessed method, of class GameState.
     */
    @Test
    public void testGuessedLetterIsNotInSecretWord() {
        char input='M';
        Set<Character> secretWordLetters = new HashSet<>();
        secretWordLetters.add('B');
        game.setSecretWordLetters(secretWordLetters);
        game.setGuessesLeft(2);
        game.guessed(input);
        assertEquals(1,game.getGuessesLeft());
    }
    @Test
    public void testGuessedLetterIsInSecretWord() {
        char input='M';
        Set<Character> secretWordLetters = new HashSet<>();
        secretWordLetters.add('M');
        
        game.setSecretWordLetters(secretWordLetters);
        game.guessed(input);
        Set<Character> secretWordLetters1 = game.getSecretWordLetters();
        Set<Character> secretWordLettersExpected = new HashSet<>();
        assertEquals(secretWordLettersExpected,secretWordLetters1);
        
    }
    

    /**
     * Test of wins method, of class GameState.
     */
    @Test
    public void testWins_whenNotEmptyOfSecretWordLetterArray() {
        Set<Character> secretWordLetters = new HashSet<>();
        secretWordLetters.add('M');
        game.setSecretWordLetters(secretWordLetters);
        assertTrue(!game.wins());
    }
     @Test
    public void LevelNoIfWins() {
        Set<Character> secretWordLetters = new HashSet<>();    
       game.setSecretWordLetters(secretWordLetters);
       game.wins();
       game.setLevel(2);
        
        int guessesleft=5;
        game.setGuessesLeft(guessesleft);
        game.lost();
        game.guessed('c');
        assertEquals(3,game.getLevel());
    }
    @Test
    public void testWins_whenEmptyOfSecretWordLetterArray() {
        Set<Character> secretWordLetters = new HashSet<>();    
        game.setSecretWordLetters(secretWordLetters);
        assertTrue(game.wins());
    }

    /**
     * Test of lost method, of class GameState.
     */
    @Test
    public void testLost_whenOutputIsTrue() {
       int guessesleft=0;
       game.setGuessesLeft(guessesleft);
        assertTrue(game.lost());
    }
    public void testLost_whenOutputIsfalse() {
       int guessesleft=5;
       game.setGuessesLeft(guessesleft);
        assertTrue(!game.lost());
    }

    /**
     * Test of finalWin method, of class GameState.
     */
    @Test
    public void testFinalWin_whenLevelsAreOverAndLastLevelWins() {
       Set<Character> secretWordLetters = new HashSet<>();    
       game.setSecretWordLetters(secretWordLetters);
       game.wins();
       game.setLevel(5);
        assertTrue(game.finalWin());
    }
    @Test
    public void testFinalWin_whenLevelsArentOverAndLastLevelWins() {
       Set<Character> secretWordLetters = new HashSet<>();    
       game.setSecretWordLetters(secretWordLetters);
       game.wins();
       game.setLevel(4);
       assertTrue(!game.finalWin());
    }
    @Test
    public void testFinalWin_whenLevelsAreOverAndLastLevellosts() {
        int guessesleft=0;
       game.setGuessesLeft(guessesleft);
       game.lost();
       game.setLevel(4);
       assertTrue(!game.finalWin());
    }

    
}
