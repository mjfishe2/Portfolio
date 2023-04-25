import java.io.Serializable;

public class MyDate implements Comparable<MyDate>, Serializable {
  private static final int MIN_YEAR = 1763;    // minimum year allowed for a Date
  private static final int JAN = 1;
  private static final int FEB = 2;
  private static final int DEC = 12;
  private static String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  private static final int[] daysInMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
  
  private int day;
  private int month;
  private int year;
  private boolean isLeapYear;
  
  /**
   * Creates new MyDate object.
   * 
   * @custom.require day > 0;
   *                 month > 0 && month <= 12;
   *                 year > 1763;
   * 
   * @custom.ensure  this.day = day;
   *          this.month = month;
   *          this.year = year;
   */
  public MyDate(int day, int month, int year) {
    assert isValidDate(day,month,year);
    this.day = day;
    this.month = month;
    this.year = year;
    this.isLeapYear = isLeapYear(year);
    int daysInThisMonth = daysInMonth[month];
    if (month == FEB && isLeapYear)
      daysInThisMonth = daysInThisMonth + 1;
  }
  
  /**
   * Checks if values of MyDate lie within range of Dates according to reality.
   * 
   * @custom.require day > 0
   *          month > 0 && month <= 12
   *          year > 1763
   * 
   * @custom.ensure isValid == true
   */
  public static boolean isValidDate (int day, int month, int year) {
    int maxDay; //maximum day in the month.
    boolean isValid;
    if (year >= MIN_YEAR && 1 <= month && month <= DEC) {
      //year and month are valid; check day.
      maxDay = daysInMonth[month];
      //leap year exception.
      if (month == FEB && isLeapYear(year))
        maxDay = maxDay + 1;
      isValid = (1<= day && day <= maxDay);
    } else
      //year or month are invalid.
      isValid = false;
    return isValid;
  }
  
  /**
   * Checks to see if year is leap year.
   * 
   * @require  year > 1763
   */
  public static boolean isLeapYear (int year) {
    if ((year % 4) == 0 && (year % 100) != 0)
      return true;
    return false;
  }
  
  /**
   * Returns the day of MyDate.
   */
  public int getDay () {
    return day;
  }
  
  /**
   * Returns the month of MyDate.
   */
  public int getMonth () {
    return month;
  }
  
  /**
   * Returns the year of MyDate.
   */
  public int getYear () {
    return year;
  }
  
  /**
   * Returns if this object MyDate is equal to otherDate.
   * 
   * @require   otherDate != null
   */
  @Override
  public boolean equals (Object otherDate) {
    if (otherDate instanceof MyDate) {
      if (this.day == ((MyDate)otherDate).getDay() &&
          this.month == ((MyDate)otherDate).getMonth() &&
          this.year == ((MyDate)otherDate).getYear())
        return true;
    }
    return false;
  }
  
  /**
   * Returns an integer based upon values of both Dates.
   * 
   * @return 0, 1, or -1
   */
  @Override
  public int compareTo (MyDate otherDate) {

    if (this.equals(otherDate))
      return 0;
    if (this.year < otherDate.getYear())
      return -1;
    if (this.year == otherDate.getYear()) {
      if (this.month < otherDate.getMonth())
        return -1;
      if (this.month == otherDate.getMonth()) {
        if (this.day < otherDate.getDay())
          return -1;
      }
    }
    return 1;
  }
  
  // String representation of Date.
  @Override
  public String toString() {
    String string = MyDate.months[month] + " " + day + ", " + year;
    return string;
  }
}
