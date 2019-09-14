package GuessGame.UI.Frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
  /**
   * Creates a frame container for the game where all components inside live.
   *
   * @param componentList a list of components that live inside
   */
 public GameFrame(List<Component> componentList) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setContentPane(Box.createVerticalBox());
    this.setTitle("Word Guessing Game");

    for (Component component : componentList) {
      this.add(component);
    }

    this.getContentPane().setBackground(Color.WHITE);
    this.pack();
    this.setVisible(true);
  }
}
