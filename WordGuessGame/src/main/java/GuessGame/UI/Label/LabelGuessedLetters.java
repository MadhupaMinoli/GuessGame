package GuessGame.UI.Label;

import GuessGame.GameState;
import java.util.Set;


public  class LabelGuessedLetters extends LabelGameInfo {
  private static final String color_unguessed_letter = "blue";
  private static final String color_guessed_letter = "red";

  /**
   * Creates the guessed letters label given the current game state.
   *
   * @param game the current game state
   */
  public LabelGuessedLetters(GameState game) {
    this.setFont(LABEL_TEXT_FONT);
    this.setText(htmlFlavoredText(game.getUnguessedLetters()));
  }

  @Override
  public void update(GameState game) {
    this.setText(htmlFlavoredText(game.getUnguessedLetters()));
  }

  /**
   * Given a color attribute value in HTML and a character, returns a StringBuilder object
   * containing the character surrounded by html font tag with the color attribute included.
   *
   * @param color     a color attribute value in HTML
   * @param character a character
   *
   * @return a StringBuilder object containing the character surrounded by html font tag
   *         with the color attribute included.
   */
  private StringBuilder wrapColoredTextWithHtmlTags(String color, char character) {
    StringBuilder res = new StringBuilder();
    res.append("<font color=").append(color).append(">");
    res.append(character);
    res.append("</font>");
    return res;
  }

  /**
   * Given a set of unguessed letters, returns the HTML code with each character surrounded by
   * a font tag with the color attribute included.
   *
   * @param unguessedLetters the set of unguessed letters
   *
   * @return the HTML code with each character surrounded by
   *         a font tag with the color attribute included.
   */
  private String htmlFlavoredText(Set<Character> unguessedLetters) {
    StringBuilder text = new StringBuilder();
    
    
    
    
    text.append("<html>"+"Posible Letters : ");
    for (char c : GameState.ALL_POSSIBLE_LETTERS.toCharArray()) {
      if (unguessedLetters.contains(c)) {
        text.append(wrapColoredTextWithHtmlTags(color_unguessed_letter, c));
      } else {
        text.append(wrapColoredTextWithHtmlTags(color_guessed_letter, c));
      }
    }
    text.append("</html>");
    return text.toString();
  }
}
