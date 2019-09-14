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
public class LevelFactory {
    public static Level create(int level) {
        switch (level) {
            case 1:
                return new LevelOne();
            case 2:
                return new LevelTwo();
            case 3:
                return new LevelThree();
            case 4:
                return new LevelFour();
            case 5:
                return new LevelFive();
            default:
                break;
        }
        throw new LevelNotFoundException(level);

    }
}
