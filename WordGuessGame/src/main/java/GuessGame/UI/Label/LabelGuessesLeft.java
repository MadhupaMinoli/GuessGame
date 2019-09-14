package GuessGame.UI.Label;

import GuessGame.GameState;



public  class LabelGuessesLeft extends LabelGameInfo {

  /**
   * Creates the guesses left label given the current game state.
   *
   * @param game the current game state
   */
  public LabelGuessesLeft(GameState game) {
    this.setFont(LABEL_TEXT_FONT);

    int guesses = game.getGuessesLeft();
    String message = String.format("Remaining Attempts : %s", guesses);
    this.setText(message);
  }

  @Override
  public void update(GameState game) {
    
    int guesses = game.getGuessesLeft();
    String message = String.format("Remaining Attempts : %s", guesses);
    if (game.lost()) {
      message = String.format("You lost! (%s)", game.getSecretWord());
    }else if (game.wins()) {
        if(game.getLevel()==5){
        message = String.format("You won the game");
        }
        else{
         message = String.format("Level upgraded!");
        }
     
    }

    this.setText(message);
  }
}
