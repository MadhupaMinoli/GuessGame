/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.WordRepository;

import GuessGame.Entity.Word;
import java.util.List;

/**
 *
 * @author User
 */
public interface Datasource {
    public String[] getWordList();

    public  String randomWord(String[] possibleWords);
}
