package soccerteam;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
  private AddPlayerView addPlayerView = new AddPlayerView();
  private PlayerListView playerListView = new PlayerListView();
  private TeamInfoView teamInfoView = new TeamInfoView();

  public MainFrame() {
    setTitle("Soccer Team Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 600);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(1, 3, 5, 5));

    new TeamController(addPlayerView, playerListView, teamInfoView);

    add(addPlayerView);
    add(playerListView);
    add(teamInfoView);

    setVisible(true);
  }

  public static void main(String[] args) {
  }

}
