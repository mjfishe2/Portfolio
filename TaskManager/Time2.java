import java.io.Serializable;

/**
*    @author: Dr. Christopher Summa
*    @see   : Class Time2 from the textbook - this is based on that code
*
*    A universal time representation (24-hour)
*
*
*/
public class Time2 implements Serializable {

    private int hour;
    private int minute;
    private int second;

    public Time2() {
        this(0,0,0);
    }

    public Time2(int hour) {
        this(hour,0,0);
    }

    public Time2(int hour, int minute) {
        this(hour,minute,0);
    }

    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >=24)
            throw new IllegalArgumentException("Hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time2(Time2 anotherTime) {
        this(anotherTime.getHour(), anotherTime.getMinute(), anotherTime.getSecond());
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >=24) 
            throw new IllegalArgumentException("Hour must be 0-23");
        this.hour = hour;
    }
    
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >=24)
            throw new IllegalArgumentException("Hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("Minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("Second must be 0-59");

        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }    

    // returns a string representation in unversal time format
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
    }

    // returns a string representation in the standard US time format
    public String toString() {
        return String.format("%d:%02d:%02d %s",
          ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
          getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

} // end class
