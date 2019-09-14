/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessGame.Levels;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class LevelTest {
    Level level1=new LevelOne();
    Level level2=new LevelTwo();
    Level level3=new LevelThree();
    Level level4=new LevelFour();
    Level level5=new LevelFive();
    public LevelTest() {
    }

    /**
     * Test of getNoOfAttempts method, of class Level.
     */
    @Test
    public void testGetNoOfAttempts() {
        assertEquals(level1.getNoOfAttempts(), 10);
         assertEquals(level2.getNoOfAttempts(), 8);
          assertEquals(level3.getNoOfAttempts(), 6);
           assertEquals(level4.getNoOfAttempts(), 5);
            assertEquals(level5.getNoOfAttempts(), 3);
    }

    /**
     * Test of getLevelNo method, of class Level.
     */
    @Test
    public void testGetLevelNo() {
         assertEquals(level1.getLevelNo(), 1);
           assertEquals(level2.getLevelNo(), 2);
             assertEquals(level3.getLevelNo(), 3);
               assertEquals(level4.getLevelNo(), 4);
                 assertEquals(level5.getLevelNo(), 5);
    }

    public class LevelImpl extends Level {

        public int getNoOfAttempts() {
            return 0;
        }

        public int getLevelNo() {
            return 0;
        }
    }
    
}
