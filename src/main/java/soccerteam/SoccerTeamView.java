package soccerteam;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class SoccerTeamView extends JPanel {
  private AddPlayerView addPlayerView = new AddPlayerView();
  private PlayerListView playerListView = new PlayerListView();
  private TeamInfoView teamInfoView = new TeamInfoView();

  public SoccerTeamView() {
    setLayout(new GridLayout(1, 3, 5, 5));

    add(addPlayerView);
    add(playerListView);
    add(teamInfoView);

    addPlayerView.onAddPlayerButtonClicked(e -> {
      Player player = addPlayerView.getPlayer();
      playerListView.addPlayer(player);
      addPlayerView.clearFields();
    });

    setVisible(true);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
  }

  public void onGetTeamMembersButtonClicked(ActionListener listener) {
    teamInfoView.onGetTeamMembersButtonClicked(listener);
  }

  public void onShowStartingLineUpButtonClicked(ActionListener listener) {
    teamInfoView.onShowStartingLineUpButtonClicked(listener);
  }

  public void onTeamUpButtonClicked(ActionListener listener) {
    playerListView.onTeamUpButtonClicked(listener);
  }

  public void showInfo(String info) {
    teamInfoView.showInfo(info);
  }

  public List<Player> getSelectedPlayers() {
    return playerListView.getSelectedPlayers();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Soccer Team Management");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1200, 600);
    frame.setLocationRelativeTo(null);

    SoccerTeamView soccerTeamView = new SoccerTeamView();
    frame.add(soccerTeamView);
    soccerTeamView.onGetTeamMembersButtonClicked(e -> soccerTeamView.showInfo("Team Members: John Doe, Jane Doe, ..."));
    soccerTeamView.onShowStartingLineUpButtonClicked(e -> soccerTeamView.showInfo("Starting Lineup: John Doe, Jane Doe, ..."));

    frame.setVisible(true);
  }
}
