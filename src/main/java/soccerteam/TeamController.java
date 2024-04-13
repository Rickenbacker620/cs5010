package soccerteam;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TeamController {
  private Team team;
  private SoccerTeamView view;
  private GetTeamListener getTeamListener;
  private GetStartLineListener getStartLineListener;
  private TeamUpListener teamUpListener;

  public TeamController(SoccerTeamView soccerTeamView) {
    this.view = soccerTeamView;
    this.getTeamListener = new GetTeamListener();
    this.getStartLineListener = new GetStartLineListener();
    this.teamUpListener = new TeamUpListener();
    this.view.onGetTeamMembersButtonClicked(getTeamListener);
    this.view.onShowStartingLineUpButtonClicked(getStartLineListener);
    this.view.onTeamUpButtonClicked(teamUpListener);
  }

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

  private class TeamUpListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        List<Player> players = view.getSelectedPlayers();
        team = new Team(players.size(), players);
        team.generateJerseyNumber();
        team.selectStartingLineup();
        view.displayMessage("Team created successfully!");
      } catch (IllegalArgumentException ex) {
        view.displayError("Failed to add create team: " + ex.getMessage());
      }
    }
  }
}
