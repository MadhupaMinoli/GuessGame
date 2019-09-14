package GuessGame;

import GuessGame.Entity.Word;
import GuessGame.Levels.Level;
import GuessGame.Levels.LevelFactory;
import GuessGame.WordRepository.Datasource;
import GuessGame.WordRepository.HTTPDatasource;

import java.io.IOException;
import java.util.*;


/**
 *
 * @author User
 */
public class GameState extends Observable {
   private String secretWord;
   private final String[] possibleWords;
   private Set<Character> secretWordLetters;
   private int guessesLeft;
   public static final String ALL_POSSIBLE_LETTERS="abcdefghijklmnopqrstuvwxyz";
   private Set<Character> unguessedLetters;
   private final int initialLevel=1;
   private int wordlength;
   private int level;
   private final Datasource DS;

   
   
   public GameState() throws IOException {

    DS = new HTTPDatasource("http://localhost:8080/AllFiles/wordSet2.txt");
    possibleWords = DS.getWordList();
   
    resetGame();


   }
   
   
   public void resetGame() {
    Level startLevel = LevelFactory.create(initialLevel);
    guessesLeft = startLevel.getNoOfAttempts();
    level=startLevel.getLevelNo();
    wordlength=startLevel.getWordLength();
    refresh();

    setChanged();
    notifyObservers();
  }

    
   
   public void refresh(){
    secretWord = DS.randomWord(possibleWords);
    System.out.println("Secret word is "+secretWord);

    while (secretWord.length()!= wordlength){
        secretWord = DS.randomWord(possibleWords);
        System.out.println("Secret word is "+secretWord);
    }
    Word sW= new Word(secretWord);
    secretWordLetters = sW.stringToCharSet(secretWord);
    this.secretWordLetters=secretWordLetters;
    secretWordLetters.remove(secretWord.charAt(0));
    unguessedLetters  = sW.stringToCharSet(ALL_POSSIBLE_LETTERS);
    unguessedLetters.remove(secretWord.charAt(0));
   
   }
   public void guessed(char character) {
       
  
    
    if (wins()||lost() || !unguessedLetters.contains(character)) {
      return;
    }
  
    
    if (secretWordLetters.contains(character)) {
      secretWordLetters.remove(character);
      unguessedLetters.remove(character);
    } else {
      guessesLeft--;
    }
    
    if(!finalWin() && wins()){
     level++;
     Level nextLevel = LevelFactory.create(level);
     guessesLeft = nextLevel.getNoOfAttempts();
     wordlength=nextLevel.getWordLength();

     levelUp();
    }
    setChanged();
    notifyObservers();
  }    
    
    
   public boolean wins() {
      
        return secretWordLetters.isEmpty();
    }
   
    public boolean lost() {
       return guessesLeft == 0;
    }
    
    public boolean finalWin(){
     return level == 5 && wins();
    }
    
    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public void setGuessesLeft(int guessesLeft) {
        this.guessesLeft = guessesLeft;
    }

    public Set<Character> getUnguessedLetters() {
        return unguessedLetters;
    }

    public void setUnguessedLetters(Set<Character> unguessedLetters) {
        this.unguessedLetters = unguessedLetters;
    }
    
     public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

            
    public Set<Character> getSecretWordLetters() {
        return secretWordLetters;
    }

    public void setSecretWordLetters(Set<Character> secretWordLetters) {
        this.secretWordLetters = secretWordLetters;
    }

    private void levelUp() {
        refresh();
    }

    
  
  
}
