package soccerteam;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TeamController {
  private Team team;
  private SoccerTeamView view; // Assuming SoccerTeamView is the name of the view class

  public TeamController(SoccerTeamView view) {
    this.team = new Team(11, new ArrayList<>()); // Assuming a team size of 11 for U10 soccer
    this.view = view;
  }

  public void addPlayer(Player p) {
    try {
      team.addPlayer(p);
      view.displayMessage("Player added successfully!");
    } catch (IllegalArgumentException e) {
      view.displayError("Failed to add player: " + e.getMessage());
    }
  }

  public void createTeam(List<Player> players) {
    try {
      team = new Team(players.size(), players);
      team.generateJerseyNumber();
      team.selectStartingLineup();
      view.displayMessage("Team created successfully!");
    } catch (IllegalArgumentException e) {
      view.displayError("Failed to add create team: " + e.getMessage());
    }
  }

  public void showTeamPlayers() {
    String allPlayers = team.getPlayerList();
    if (allPlayers.isEmpty()) {
      view.displayError("No players in the team.");
    } else {
      view.displayPlayers(allPlayers);
    }
  }

  public void showStartingLineup() {
    String lineup = team.getStartingLineup();
    if (lineup.isEmpty()) {
      view.displayError("Starting lineup has not been set.");
    } else {
      view.displayStartingLineup(lineup);
    }
  }
}
