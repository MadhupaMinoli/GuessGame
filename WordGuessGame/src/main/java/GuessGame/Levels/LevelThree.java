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
public class LevelThree extends Level{

    public LevelThree() {
    }

    @Override
     public int getNoOfAttempts() {
        return 6;    }

    @Override
    public int getLevelNo() {
        return 3;    }

    @Override
    public int getWordLength() {
        return 6;
    }

}
