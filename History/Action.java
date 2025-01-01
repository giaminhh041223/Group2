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

    public Action(String action) {
        this.action = action;
        this.date = Calendar.getInstance();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}
