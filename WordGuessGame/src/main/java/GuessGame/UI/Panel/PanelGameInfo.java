package GuessGame.UI.Panel;

import GuessGame.GameState;
import GuessGame.UI.Label.LabelGameInfo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class PanelGameInfo extends JPanel implements Observer {
  private GameState game;
  private List<LabelGameInfo> labels;

  /**
   * Creates the game info panel given the current game state,
   * secret word label, guesses left label and guessed letters label.
   *
   * @param game                the current game state
   * @param secretWordLabel     the secret word label
   * @param guessesLeftLabel    the guesses left label
   * @param guessedLettersLabel the guessed letters label
   */
  public PanelGameInfo(GameState game, LabelGameInfo secretWordLabel,
                LabelGameInfo guessesLeftLabel, LabelGameInfo guessedLettersLabel,LabelGameInfo currentLevel) {
    this.game = game;
    labels = new ArrayList<>();
    labels.add(currentLevel);
    labels.add(secretWordLabel);
    labels.add(guessesLeftLabel);
    labels.add(guessedLettersLabel);
    

    for (JLabel label : labels) {                     // Seems that the first alignment only
      this.add(label);                              // works on plain text string, while the
      label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // second one works only for html based string.
      label.setHorizontalAlignment(JLabel.CENTER);  // Don't know if there's better way to do this
    }                                                 // except wrapping all of those in html

    this.setBackground(Color.cyan);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(100, 100, 100, 100), null));
  
    game.addObserver(this);
  }

  @Override
  public void update(Observable obj, Object arg) {
    for (LabelGameInfo label : labels) {
      label.update(game);
    }
  }
}
