package soccerteam;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * MainFrame class.
 */
public class MainFrame extends JFrame {
  private SoccerTeamView view = new SoccerTeamView();

  public MainFrame() {
    setTitle("Soccer Team Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 600);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(1, 3, 5, 5));

    new SoccerTeamController(view);

    add(view);

    setVisible(true);
  }

  public static void main(String[] args) {
    new MainFrame();
  }
}
