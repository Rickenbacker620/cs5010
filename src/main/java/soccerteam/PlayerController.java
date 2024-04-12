package soccerteam;

import java.time.LocalDate;
import java.time.Period;

public class PlayerController {
  private Team team;
  private SoccerTeamView view;

  public PlayerController(Team team, SoccerTeamView view) {
    this.team = team;
    this.view = view;
  }

  public void addPlayer(String firstName, String lastName, LocalDate dateOfBirth, Position preferredPosition, int skillLevel) {
    if (skillLevel < 1 || skillLevel > 5) {
      view.displayError("Skill level must be between 1 and 5.");
      return;
    }

    if (Period.between(dateOfBirth, LocalDate.now()).getYears() >= 10) {
      view.displayError("Player must be under 10 years old.");
      return;
    }
    try {
      Player newPlayer = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      this.team.addPlayer(newPlayer);
      view.displayMessage("Player added successfully!");
    }catch (IllegalArgumentException e) {
      view.displayError("Failed to add player: " + e.getMessage());
    }
  }

  public void displayAllPlayers() {
    String allPlayers = team.getPlayerList();
    if (allPlayers.isEmpty()) {
      view.displayError("No players in the team.");
    } else {
      view.displayPlayers(allPlayers);
    }
  }

  // This method returns the starting lineup
  public void displayStartingLineup() {
    String lineup = team.getStartingLineup();
    if (lineup.isEmpty()) {
      view.displayError("Starting lineup has not been set.");
    } else {
      view.displayStartingLineup(lineup);
    }
  }
}
