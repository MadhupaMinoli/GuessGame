/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.WordRepository;

import GuessGame.Entity.Word;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author User
 */
public class TextDatasource implements Datasource{

   private String[] AllWords;

    public TextDatasource(String filePath) {
        Set<String> words = new HashSet<>();
        try (BufferedReader inputFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "UTF-8"))) {
            String word;
            while ((word = inputFile.readLine()) != null) {
                word = word.trim();
                if (word.equals("")) {
                    continue;
                }
                words.add(word);
            }
        } catch (IOException ioe) {
            System.out.println("Something went wrong! : " + ioe.getMessage());
        }
        System.out.println("Successfully read the file ");


       AllWords=  words.toArray(new String[words.size()]);


    }

    @Override
    public String[] getWordList() {
        return AllWords;
    }



    @Override
    public String randomWord(String[] possibleWords) {
        Random random = new Random();
        int randomIndex = random.nextInt(possibleWords.length); 

        return possibleWords[randomIndex];    }
    
}
