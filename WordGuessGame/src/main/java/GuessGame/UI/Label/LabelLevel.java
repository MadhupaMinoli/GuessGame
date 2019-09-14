package GuessGame.UI.Label;

import GuessGame.GameState;



public  class LabelLevel extends LabelGameInfo {

  /**
   * Creates the guesses left label given the current game state.
   *
   * @param game the current game state
   */
  public LabelLevel(GameState game) {
    this.setFont(LABEL_TEXT_FONT1);

    int levels = game.getLevel();
    String message = String.format("Level %s ", levels);
    this.setText(message);
  }

  @Override
  public void update(GameState game) {
    
    int nextLevel= game.getLevel();
    String message = String.format("Level %s ", nextLevel);
    this.setText(message);
  }
}
