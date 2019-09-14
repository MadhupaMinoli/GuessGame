package GuessGame.UI.Label;

import GuessGame.GameState;



public class LabelSecretWord extends LabelGameInfo {
  private static final char UNGUESSED_SIGN = '?';

  /**
   * Creates the secret word label given the current game state.
   *
   * @param game the current game state
   */
  public LabelSecretWord(GameState game) {
    this.setFont(LABEL_TEXT_FONT);

    StringBuilder secretString = new StringBuilder();
   secretString.append(game.getSecretWord().charAt(0));
    for (int i = 1; i < game.getSecretWord().length(); i++) {
      secretString.append(UNGUESSED_SIGN);
    }
    
    this.setText("Guess the word : "+ secretString.toString());
  }

  @Override
  public void update(GameState game) {
    StringBuilder secretString = new StringBuilder();
       
    for (char wordLetter : game.getSecretWord().toCharArray()) {
      char character = game.getUnguessedLetters().contains(wordLetter) ? UNGUESSED_SIGN : wordLetter;
      secretString.append(character);
    }

    this.setText("Guess the word : "+ secretString.toString());
  }
}
