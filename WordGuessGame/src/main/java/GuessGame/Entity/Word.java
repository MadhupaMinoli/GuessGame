/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class Word {

    private String fullWord;
   

    public Word(String word) {
        this.fullWord = word;
        
    }
   
    public Set<Character> stringToCharSet(String str) {
        this.fullWord=str;
        Set<Character> res = new HashSet<>();
        for (char character : str.toCharArray()) {
        res.add(character);}
        return res;
    }
    

    
    }

