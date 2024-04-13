package soccerteam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddPlayerView extends JPanel {
  private JTextField firstNameField = new JTextField(20);
  private JTextField lastNameField = new JTextField(20);
  private JTextField dobField = new JTextField(20);
  private JComboBox<Position> positionSelector = new JComboBox<>(Position.values());
  private JTextField skillLevelField = new JTextField(20);
  private JButton addPlayerButton = new JButton("Add Player");

  /**
   * Constructor to create an AddPlayerView object.
   */
  public AddPlayerView() {
    // Creating panel for organizing input components
    setLayout(new GridLayout(6, 2, 5, 5));

    // Adding input components to panel
    add(new JLabel("First Name:"));
    add(firstNameField);
    add(new JLabel("Last Name:"));
    add(lastNameField);
    add(new JLabel("Date of Birth:"));
    add(dobField);
    add(new JLabel("Position:"));
    add(positionSelector);
    add(new JLabel("Skill Level:"));
    add(skillLevelField);
    add(addPlayerButton);
  }

  /**
   * Get the player details from the input fields.
   *
   * @return Player object
   */
  public Player getPlayer() {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String dobRaw = dobField.getText();
    LocalDate dob = LocalDate.parse(dobRaw);
    Position position = (Position) positionSelector.getSelectedItem();
    int skillLevel = Integer.parseInt(skillLevelField.getText());
    return new Player(firstName, lastName, dob, position, skillLevel);
  }

  /**
   *
   * Clear the input fields.
   */
  public void clearFields() {
    firstNameField.setText("");
    lastNameField.setText("");
    dobField.setText("");
    positionSelector.setSelectedIndex(0); // Set default selection
    skillLevelField.setText("");
  }

  /**
   * Add an action listener to the add player button.
   *
   * @param listener ActionListener object
   */
  public void onAddPlayerButtonClicked(ActionListener listener) {
    addPlayerButton.addActionListener(listener);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Add Player View");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);

    AddPlayerView addPlayerView = new AddPlayerView();
    addPlayerView.onAddPlayerButtonClicked(e -> {
      Player player;
      try {
        player = addPlayerView.getPlayer();
      } catch (Exception ex) {
        return;
      }
      System.out.println(player);
      addPlayerView.clearFields();
    });
    frame.add(addPlayerView);

    frame.setVisible(true);
  }
}
