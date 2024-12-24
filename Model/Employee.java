package Model;

public abstract class Employee {
    protected String name;
    protected String email;
    protected String password;
    protected double salary;
    protected Option[] options;

    public Employee() {

    }

    public Employee(String name, String email, String password, double salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Option[] getOptions() {
		return options;
	}

	public void setOptions(Option[] options) {
		this.options = options;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getSalary() {
        return salary;
    }
}
