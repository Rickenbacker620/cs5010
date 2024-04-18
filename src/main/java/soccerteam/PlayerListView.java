package soccerteam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.util.List;

/**
 * PlayerListView class.
 */
public class PlayerListView extends JPanel {
  private DefaultListModel<String> playerListModel = new DefaultListModel<>();
  private JList<String> playerList = new JList<>(playerListModel);
  private JScrollPane scrollPane = new JScrollPane(playerList);
  private JButton teamUpButton = new JButton("Team Up");

  /**
   * Constructor to create a PlayerListView object.
   */
  public PlayerListView() {
    setLayout(new GridLayout(2, 1, 5, 5));
    add(scrollPane, BorderLayout.NORTH);
    add(teamUpButton, BorderLayout.SOUTH);
    playerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  }

  /**
   * Add a player to the player list.
   * @param player
   */
  public void addPlayer(String player) {
    playerListModel.addElement(player);
  }

  /**
   * Register an action listener for the team up button.
   * @param listener ActionListener.
   */
  public void onTeamUpButtonClicked(ActionListener listener) {
    teamUpButton.addActionListener(listener);
  }

  /**
   * Get the selected players from the player list.
   * @return List of selected players.
   */
  public List<String> getSelectedPlayers() {
    return playerList.getSelectedValuesList();
  }
}
