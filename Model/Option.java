package Model;
import java.util.Scanner;
import History.History;

public interface Option {

    abstract void operate(Employee user, Scanner scanner, Database database, History history);

    abstract String getOption();    
}
