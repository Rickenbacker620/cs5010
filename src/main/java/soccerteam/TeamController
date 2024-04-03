package soccerteam;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TeamController {
  private Team team;
  private SoccerTeamView view; // Assuming SoccerTeamView is the name of the view class

  public TeamController(SoccerTeamView view) {
    this.team = new Team(11, new ArrayList<>()); // Assuming a team size of 11 for U10 soccer
    this.view = view;
  }

  public void addPlayer(String firstName, String lastName, String dob, String position, int skillLevel) {
    try {
      LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      Position preferredPosition = Position.valueOf(position.toUpperCase());
      Player newPlayer = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      team.addPlayer(newPlayer);
      view.displayMessage("Player added successfully!");
    } catch (IllegalArgumentException e) {
      view.displayError("Failed to add player: " + e.getMessage());
    }
  }

  public void createTeam() {
    if (team.getPlayers().size() < 11) {
      view.displayError("Not enough players to create a team.");
      return;
    }
    team.generateJerseyNumber();
    team.selectStartingLineup();
    view.displayMessage("Team created successfully!");
  }

  public void showTeamPlayers() {
    view.displayPlayers(team.getPlayerList());
  }

  public void showStartingLineup() {
    view.displayPlayers(team.getStartingLineup());
  }
}
