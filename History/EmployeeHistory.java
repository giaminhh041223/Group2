package History;

import java.util.Calendar;
import Model.Employee;

public class EmployeeHistory extends Action {
    private Employee employee;

    public EmployeeHistory(String action, Calendar date, Employee employee) {
        super(action, date);
        this.employee = employee;
    }

    @Override
    public String toString() {
        return action;
    }
}
