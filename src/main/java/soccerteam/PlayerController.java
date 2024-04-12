package soccerteam;

import java.time.LocalDate;
import java.time.Period;

public class PlayerController {
  private SoccerTeamView view;

  public PlayerController(SoccerTeamView view) {
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
//      TODO
//      this.team.addPlayer(newPlayer);
      view.displayMessage("Player added successfully!");
    }catch (IllegalArgumentException e) {
      view.displayError("Failed to add player: " + e.getMessage());
    }
  }
}
