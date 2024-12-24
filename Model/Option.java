package Model;
import java.util.Scanner;

public interface Option {

    abstract void operate(UserType user, Scanner scanner, Database database);

    abstract String getOption();    
}
