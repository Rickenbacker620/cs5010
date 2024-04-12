package soccerteam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SoccerTeamView extends JFrame {
  private JTextField firstNameField, lastNameField, dobField, positionField, skillLevelField;
  private JTextArea outputArea;
  private TeamController controller;

  public SoccerTeamView() {
//    this.controller = controller;
    initComponents();
  }

  private void initComponents() {
    // Initialize components (text fields, buttons, etc.) and set up the GUI layout
    // Add action listeners to buttons to call controller methods

    setTitle("U10 Soccer Team Manager");
    setSize(400, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Assuming JButton for adding a player, creating a team, showing team players, and the starting lineup
    // JTextField for player input, JTextArea for output

    setVisible(true);
  }

  // Methods to display messages and errors
  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  // Method to display players
  public void displayPlayers(String players) {
    outputArea.setText(players);
  }

  public void displayStartingLineup(String players) {
    outputArea.setText(players);
  }
}
