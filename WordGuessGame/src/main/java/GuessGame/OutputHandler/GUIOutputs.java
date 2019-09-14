/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.OutputHandler;

import GuessGame.UI.Frame.GameFrame;
import GuessGame.GameState;
import GuessGame.UI.Label.LabelGameInfo;
import GuessGame.UI.Label.LabelGuessedLetters;
import GuessGame.UI.Label.LabelGuessesLeft;
import GuessGame.UI.Label.LabelLevel;
import GuessGame.UI.Label.LabelSecretWord;
import GuessGame.UI.Panel.PanelGameInfo;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class GUIOutputs implements Outputs{

    private GameFrame gameFrame;
    private ArrayList<Component> components;

    @Override
    public void initiateUI(GameState game) {
        
       components = new ArrayList<>(); 
        LabelGameInfo secretWordLabel = new LabelSecretWord(game);
        LabelGameInfo guessedLettersLabel = new LabelGuessedLetters(game);
        LabelGameInfo guessesLeftLabel = new LabelGuessesLeft(game);
        LabelGameInfo currentLevel = new LabelLevel(game);
        JPanel gameInfoPanel = new PanelGameInfo(game, secretWordLabel, guessesLeftLabel,guessedLettersLabel,currentLevel);
        components.add(gameInfoPanel);
        gameFrame = new GameFrame(components);
    
    
    }
    
}
