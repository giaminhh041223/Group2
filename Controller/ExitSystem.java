package Controller;

import java.util.Scanner;
import History.*;
import Model.*;

public class ExitSystem implements Option {
    
    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Exiting the system. Goodbye, " + user.getName() + "!");
        System.exit(0);
    }

    @Override
    public String getOption() {
        return "Exit System";
    }
}
