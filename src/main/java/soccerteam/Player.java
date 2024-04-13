package soccerteam;

import java.time.LocalDate;

/**
 * Class that describe a player
 */
public class Player {
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private Position preferredPosition;
  private int skillLevel;
  private int jerseyNumber;

  /**
   * Constructor.
   *
   * @param firstName         is the first name of the player.
   * @param lastName          is the last name of the player.
   * @param dateOfBirth       is the date of birth of the player.
   * @param preferredPosition is the preferred position of the player.
   * @param skillLevel        is the skill level of the player.
   * @throws IllegalArgumentException if the player is older than 10 years old or
   *                                  the skill level is not between 1 and 5.
   */
  public Player(String firstName, String lastName, LocalDate dateOfBirth, Position preferredPosition, int skillLevel)
      throws IllegalArgumentException {
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be between 1 and 5");
    }

    if (dateOfBirth.plusYears(10).isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Player must be under 10 years old");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
  }

  /**
   * Get the first name of the player.
   *
   * @return the first name of the player.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the player.
   *
   * @param firstName is the first name of the player.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the last name of the player.
   *
   * @return the last name of the player.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the player.
   *
   * @param lastName is the last name of the player.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get the date of birth of the player.
   *
   * @return the date of birth of the player.
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Set the date of birth of the player.
   *
   * @param dateOfBirth is the date of birth of the player.
   * @throws IllegalArgumentException if the player is less than 10 years old.
   */
  public void setDateOfBirth(LocalDate dateOfBirth) throws IllegalArgumentException {
    if (dateOfBirth.plusYears(10).isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Player must be at least 10 years old");
    }
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Get the preferred position of the player.
   *
   * @return the preferred position of the player.
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  /**
   * Set the preferred position of the player.
   *
   * @param preferredPosition is the preferred position of the player.
   */
  public void setPreferredPosition(Position preferredPosition) {
    this.preferredPosition = preferredPosition;
  }

  /**
   * Get the skill level of the player.
   *
   * @return the skill level of the player.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Set the skill level of the player.
   *
   * @param sillLevel is the skill level of the player.
   */
  public void setSkillLevel(int sillLevel) {
    this.skillLevel = sillLevel;
  }

  /**
   * Get the jersey number of the player.
   *
   * @return the jersey number of the player.
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  /**
   * Set the jersey number of the player.
   *
   * @param jerseyNumber is the jersey number of the player.
   */
  public void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Return the player's information.
   *
   * @return the player's information.
   */
  @Override
  public String toString() {
    return firstName + " " + lastName + ", Date of birth: " + dateOfBirth + ", Position: " + preferredPosition+", Skill Level: "+skillLevel;
  }
}
