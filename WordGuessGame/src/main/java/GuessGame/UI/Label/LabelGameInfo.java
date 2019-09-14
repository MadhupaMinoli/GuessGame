package GuessGame.UI.Label;

import GuessGame.GameState;
import java.awt.Font;
import javax.swing.JLabel;


public abstract class LabelGameInfo extends JLabel {
  protected static final Font LABEL_TEXT_FONT1 = new Font(Font.SERIF, Font.BOLD, 24);
  protected static final Font LABEL_TEXT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 16);

  /**
   * Updates the label given the current game state.
   *
   * @param game the current game state
   */
  public abstract void update(GameState game);
}
