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

public class PlayerListView extends JPanel {
  private DefaultListModel<Object[]> playerListModel = new DefaultListModel<>();
  private JList<Object[]> playerList = new JList<>(playerListModel);
  private JScrollPane scrollPane = new JScrollPane(playerList);
  private JButton teamUpButton = new JButton("Team Up");

  public PlayerListView() {
    setLayout(new GridLayout(2, 1, 5, 5));
    add(scrollPane, BorderLayout.NORTH);
    add(teamUpButton, BorderLayout.SOUTH);
    playerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  }

  public void addPlayer(Object[] player) {
    playerListModel.addElement(player);
  }

  public void onTeamUpButtonClicked(ActionListener listener) {
    teamUpButton.addActionListener(listener);
  }

  public List<Object[]> getSelectedPlayers() {
    return playerList.getSelectedValuesList();
  }

  // // FIXME Temporarily added for testing purposes
  // public Player generateMockPlayer() {
  //   return new Player("John", "Doe", LocalDate.now().minusYears(4), Position.FORWARD, 4);
  // }

  // public static void main(String[] args) {
  //   JFrame frame = new JFrame("Player List View");
  //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //   frame.setSize(1000, 400);
  //   frame.setLocationRelativeTo(null);
  //   frame.setLayout(new GridLayout(1, 2, 5, 5));

  //   PlayerListView playerListView = new PlayerListView();
  //   AddPlayerView addPlayerView = new AddPlayerView();
  //   frame.add(addPlayerView);
  //   frame.add(playerListView);

  //   for (int i = 0; i < 20; i++) {
  //     playerListView.addPlayer(playerListView.generateMockPlayer());
  //   }

  //   frame.setVisible(true);

  //   playerListView.onTeamUpButtonClicked(e -> {
  //     playerListView.getSelectedPlayers().forEach(player -> System.out.println(player));
  //     List<Player> selectedPlayers = playerListView.getSelectedPlayers();
  //     Team team = new Team(selectedPlayers.size(), selectedPlayers);
  //     System.out.println(team.getStartingLineup());
  //   });
  // }

}
