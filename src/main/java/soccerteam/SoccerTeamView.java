package soccerteam;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * The view class for the GUI.
 */
public class SoccerTeamView extends JPanel {
  private AddPlayerView addPlayerView = new AddPlayerView();
  private PlayerListView playerListView = new PlayerListView();
  private TeamInfoView teamInfoView = new TeamInfoView();

  /**
   * Constructor to create a SoccerTeamView object.
   */
  public SoccerTeamView() {
    setLayout(new GridLayout(1, 3, 5, 5));

    add(addPlayerView);
    add(playerListView);
    add(teamInfoView);

    setVisible(true);
  }

  /**
   * Display an error message.
   * @param message Error message.
   */
  public void displayError(String message) {
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Display a message.
   * @param message Message.
   */
  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Register an action listener for the get team members button.
   * @param listener ActionListener.
   */
  public void onGetTeamMembersButtonClicked(ActionListener listener) {
    teamInfoView.onGetTeamMembersButtonClicked(listener);
  }

  /**
   * Register an action listener for the show starting lineup button.
   * @param listener ActionListener.
   */
  public void onShowStartingLineUpButtonClicked(ActionListener listener) {
    teamInfoView.onShowStartingLineUpButtonClicked(listener);
  }

  /**
   * Register an action listener for the team up button.
   * @param listener ActionListener.
   */
  public void onTeamUpButtonClicked(ActionListener listener) {
    playerListView.onTeamUpButtonClicked(listener);
  }

  /**
   * Register an action listener for the add player button.
   * @param listener ActionListener.
   */
  public void onAddPlayerButtonClicked(ActionListener listener) {
    addPlayerView.onAddPlayerButtonClicked(listener);
  }

  /**
   * Get the player details from the input fields.
   * @return Player object.
   */
  public Object[] getPlayer(){
    return addPlayerView.getPlayer();
  }

  /**
   * Clear the input fields.
   */
  public void clearFields(){
    addPlayerView.clearFields();
  }

  /**
   * Add a player to the player list.
   * @param p Player.
   */
  public void addPlayer(String p){
    playerListView.addPlayer(p);
  }

  /**
   * Show the team information.
   * @param info Team information.
   */
  public void showInfo(String info) {
    teamInfoView.showInfo(info);
  }

  /**
   * Get the selected players from the player list.
   * @return List of selected players.
   */
  public List<String> getSelectedPlayers() {
    return playerListView.getSelectedPlayers();
  }

  /**
   * Main method to run the application.
   * @param args Command line arguments.
   */
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
