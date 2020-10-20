/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * ***************************************************************************
 */

package clock;

public class ClockDisplay {
    private NumberDisplay seconds;
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00.
     */
    public ClockDisplay() {
        seconds = new NumberDisplay(60);
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the
     * parameters.
     */
    public ClockDisplay(int hour, int minute, int second) {
        seconds = new NumberDisplay(60);
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, second);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick() {
        seconds.increment();
        if (seconds.getValue() == 0) {
            minutes.increment();
            if (minutes.getValue() == 0) {  // it just rolled over!
                hours.increment();
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, int second) {
        seconds.setValue(second);
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime() {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" +
                minutes.getDisplayValue() + ":" + seconds.getDisplayValue();
    }
}
