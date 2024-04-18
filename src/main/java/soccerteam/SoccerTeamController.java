package soccerteam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller class for the GUI.
 */
public class SoccerTeamController {
  private Team team;
  private SoccerTeamView view;
  private GetTeamListener getTeamListener;
  private GetStartLineListener getStartLineListener;
  private TeamUpListener teamUpListener;
  private AddPlayerListener addPlayerListener;
  private List<Player> candidatePlayers = new ArrayList<>();

  /**
   * Constructor of the controller class. Initialize the listeners and store the view class as class
   * attribute.
   *
   * @param soccerTeamView Given view class
   */
  public SoccerTeamController(SoccerTeamView soccerTeamView) {
    this.view = soccerTeamView;
    this.getTeamListener = new GetTeamListener();
    this.getStartLineListener = new GetStartLineListener();
    this.teamUpListener = new TeamUpListener();
    this.addPlayerListener = new AddPlayerListener();
    this.view.onGetTeamMembersButtonClicked(getTeamListener);
    this.view.onShowStartingLineUpButtonClicked(getStartLineListener);
    this.view.onTeamUpButtonClicked(teamUpListener);
    this.view.onAddPlayerButtonClicked(addPlayerListener);
  }

  /**
   * Listener class for get all players in the team button
   */
  private class GetTeamListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      if (team == null) {
        view.displayError("Team not created yet.");
        return;
      }
      String allPlayers = team.getPlayerList();
      if (allPlayers.isEmpty()) {
        view.displayError("No players in the team.");
      } else {
        view.showInfo(allPlayers);
      }
    }
  }

  /**
   * Listener class for get start line players in the team button
   */
  private class GetStartLineListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      if (team == null) {
        view.displayError("Team not created yet.");
        return;
      }
      String lineup = team.getStartingLineup();
      if (lineup.isEmpty()) {
        view.displayError("Starting lineup has not been set.");
      } else {
        view.showInfo(lineup);
      }
    }
  }

  /**
   * Listener class for create team button
   */
  private class TeamUpListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        List<String> playersInfo = view.getSelectedPlayers();
        List<Player> players = new ArrayList<Player>();
        for (String info: playersInfo) {
          for (Player player: candidatePlayers) {
            if (player.toString().equals(info)) {
              players.add(player);
              break;
            }
          }
        }
        team = new Team(players.size(), players);
        team.generateJerseyNumber();
        team.selectStartingLineup();
        view.displayMessage("Team created successfully!");
      } catch (IllegalArgumentException ex) {
        view.displayError("Failed to add create team: " + ex.getMessage());
      }
    }
  }

  /**
   * Listener class for add player button
   */
  private class AddPlayerListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        Object[] info = view.getPlayer();
        String firstName = (String) info[0];
        String lastName = (String) info[1];
        LocalDate dateOfBirth = LocalDate.parse((String) info[2]);
        Position preferredPosition = (Position) info[3];
        int skillLevel = Integer.parseInt((String) info[4]);

        if (dateOfBirth.isAfter(LocalDate.now())) {
          view.displayError("Date of Birth must be before today.");
          return;
        }
        if (skillLevel < 1 || skillLevel > 5) {
          view.displayError("Failed to add player: Skill level must be between 1 and 5.");
          return;
        }

        Player newPlayer = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
        candidatePlayers.add(newPlayer);
        view.addPlayer(newPlayer.toString());
        view.displayMessage("Player added successfully!");
        view.clearFields();
      } catch (DateTimeException ex) {
        view.displayError("Failed to add player: Date format is invalid");
      } catch (NumberFormatException ex) {
        view.displayError("Failed to add player: Skill level must be a number. " + ex.getMessage());
      } catch (IllegalArgumentException ex) {
        view.displayError("Failed to add player: " + ex.getMessage());
      }
    }
  }
}
