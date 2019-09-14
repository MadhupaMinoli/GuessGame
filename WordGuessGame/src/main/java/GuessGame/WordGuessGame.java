/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame;

import java.io.IOException;
import java.util.Arrays;
import GuessGame.GameState;
import GuessGame.InputHandlers.CatchInput;
import GuessGame.InputHandlers.KeyBoardInputHandler;
import GuessGame.OutputHandler.GUIOutputs;
import GuessGame.OutputHandler.Outputs;
//import GuessGame.DisplaySecretWord;


/**
 *
 * @author User
 */
public class WordGuessGame implements CatchInput{

    private GameState game; 
    private final KeyBoardInputHandler keyBoardHandler;

    private WordGuessGame() throws IOException {
        game = new GameState();
        this.keyBoardHandler = new KeyBoardInputHandler();
        keyBoardHandler.initiateInputHanler();
        keyBoardHandler.subscribeInput(this, "WordGuessGame");
        Outputs output = new GUIOutputs();
        output.initiateUI(game);

    }
    
    public static void main(String[] args) throws IOException {

        WordGuessGame wordGuessGame = new WordGuessGame();
        
    }



    @Override
    public void onInput(char inputChar) {
        game.guessed(inputChar);
    }
    
}

