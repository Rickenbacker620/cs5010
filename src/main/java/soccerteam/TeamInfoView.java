package soccerteam;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * TeamInfoView class.
 */
public class TeamInfoView extends JPanel {
  private JTextArea infoPanel = new JTextArea();
  private JPanel buttonPanel = new JPanel();
  private JButton getTeamMembersButton = new JButton("Show Team Members");
  private JButton getStartingLineUpButton = new JButton("Show Line Up");

  /**
   * Constructor to create a TeamInfoView object.
   */
  public TeamInfoView() {
    setLayout(new GridLayout(2, 1, 5, 5));
    buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
    infoPanel.setEditable(false);
    buttonPanel.add(getTeamMembersButton);
    buttonPanel.add(getStartingLineUpButton);
    add(infoPanel);
    add(buttonPanel);
  }

  /**
   * Register an action listener for the get team members button.
   * @param listener ActionListener.
   */
  public void onGetTeamMembersButtonClicked(ActionListener listener) {
    getTeamMembersButton.addActionListener(listener);
  }

  /**
   * Register an action listener for the show starting lineup button.
   * @param listener ActionListener.
   */
  public void onShowStartingLineUpButtonClicked(ActionListener listener) {
    getStartingLineUpButton.addActionListener(listener);
  }

  /**
   * Show the information in the info panel.
   * @param info Information to be displayed.
   */
  public void showInfo(String info) {
    infoPanel.setText(info);
  }

  /**
   * Main method to create a TeamInfoView object.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame("Team Info View");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);

    TeamInfoView teamInfoView = new TeamInfoView();
    teamInfoView.onGetTeamMembersButtonClicked(e -> teamInfoView.showInfo("Team Members: John Doe, Jane Doe, ..."));
    teamInfoView.onShowStartingLineUpButtonClicked(e -> teamInfoView.showInfo("Starting Lineup: John Doe, Jane Doe, ..."));
    frame.add(teamInfoView);
    frame.setVisible(true);
  }
}
