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
public class LevelTwo extends Level {

    public LevelTwo() {
    }

    @Override
    public int getNoOfAttempts() {
        return 8;    }

    @Override
    public int getLevelNo() {
        return 2;    }

    @Override
    public int getWordLength() {
        return 5;
    }

}
