package soccerteam;

import java.time.LocalDate;

public class Utils {
  // Generate a random birth date for a player between 0 and 10 years old
  public static LocalDate genBirthDate() {
    return LocalDate.now().minusYears(10).plusDays((long) (Math.random() * 365 * 10));
  }
}
