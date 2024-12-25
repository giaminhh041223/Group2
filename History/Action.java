package History;

import java.util.Calendar;

public class Action {
    protected String action;
    protected Calendar date;

    // Constructor to initialize action and date
    public Action(String action, Calendar date) {
        this.action = action;
        this.date = date;
    }

    // Overloaded constructor to initialize with current date
    public Action(String action) {
        this.action = action;
        this.date = Calendar.getInstance(); // Sets to the current date and time
    }

    // Getter for action
    public String getAction() {
        return action;
    }

    // Setter for action
    public void setAction(String action) {
        this.action = action;
    }

    // Getter for date
    public Calendar getDate() {
        return date;
    }

    // Setter for date
    public void setDate(Calendar date) {
        this.date = date;
    }

}
