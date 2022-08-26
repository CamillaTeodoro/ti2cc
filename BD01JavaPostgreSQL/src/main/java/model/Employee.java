package model;

public class Employee {
	private int id;
	private String name;
	private String department;
	private double salary;
	
	public Employee() {
		this.id = -1;
		this.name = "";
		this.department = "";
		this.salary = -1;
	}
	
	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getdepartment() {
		return department;
	}

	public void setdepartment(String department) {
		this.department = department;
	}

	public double getsalary() {
		return salary;
	}

	public void setsalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}	
}
