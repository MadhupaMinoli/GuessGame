/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.Levels;

/**
 *
 * @author User
 */
public class LevelOne extends Level {

    public LevelOne() {
    }

    @Override
    public int getNoOfAttempts() {return 10;}

    @Override
    public int getLevelNo() {
        return 1;
    }

    @Override
    public int getWordLength() {
        return 4;
    }

}
