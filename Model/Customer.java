package Model;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Customer implements UserType {
    private String name;
    private String email;
    private String password;
    private Option[] options;

    public Customer() {
        generateOptions();
    }

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        generateOptions();
    }

    private void generateOptions() {
        this.options = new Option[] {
            new ViewStore(),
            new 
        };
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void showOptions(Scanner scanner, Database database) {
        System.out.println("Customer options:");
    }
}
