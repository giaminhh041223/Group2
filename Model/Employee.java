package Model;

public abstract class Employee {
	protected String ID;
    protected String name;
    protected String email;
    protected String password;
    protected int department;
    protected Option[] options;

    public Employee() {

    }

    public Employee(String ID,String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.department=department;
    }
    
    public abstract void generateOptions();

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

	public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public abstract int getDepartment();
	// 0 ==> Admin
	// 1 ==> Cashier
	// 2 ==> Storekeeper
    
    public String getDepartmentToString() {
		String dept;
		switch (getDepartment()) {
		case 0:
			dept = "Manager";
			break;
		case 1:
			dept = "Cashier";
			break;
		case 2:
			dept = "Storekeeper";
			break;
			default:
				dept = "Invalid";
				break;
		}
		return dept;
	}
    public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void print() {
		System.out.println("--------------------------------");
		System.out.println("ID:\t\t"+getID());
		System.out.println("First Name:\t"+getName());
		System.out.println("Email:\t\t"+getEmail());
		System.out.println("Department:\t"+getDepartmentToString());
	}


}
