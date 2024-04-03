package soccerteam;

import java.time.LocalDate;

public class PlayerController {
  private Team team; // Assuming the Team class has methods to add players
  private SoccerTeamView view; // Interaction with the view for feedback

  public PlayerController(Team team, SoccerTeamView view) {
    this.team = team;
    this.view = view;
  }

  public void addPlayer(String firstName, String lastName, LocalDate dateOfBirth, Position preferredPosition, int skillLevel) {
    try {
      // Assuming validation and creation logic here, similar to the previously discussed controller logic
      Player newPlayer = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel); // Create a new player
      team.addPlayer(newPlayer); // Add player to the team
      view.displayMessage("Player added successfully!");
    } catch (IllegalArgumentException e) {
      view.displayError("Failed to add player: " + e.getMessage());
    }
  }

  // Any additional player-related functionalities can be added here
}
