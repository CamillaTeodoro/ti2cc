package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO extends DAO {
	
	public EmployeeDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Employee Employee) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO Employee (id, name, department, salary) "
				       + "VALUES ("+Employee.getid()+ ", '" + Employee.getname() + "', '"  
				       + Employee.getdepartment() + "', " + Employee.getsalary() + ");";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Employee get(int id) {
		Employee Employee = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 Employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"), rs.getString("salary").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return Employee;
	}
	
	
	public List<Employee> get() {
		return get("");
	}

	
	public List<Employee> getOrderByid() {
		return get("id");		
	}
	
	
	public List<Employee> getOrderByname() {
		return get("name");		
	}
	
	
	public List<Employee> getOrderBysalary() {
		return get("salary");		
	}
	
	
	private List<Employee> get(String orderBy) {	
	
		List<Employee> Employees = new ArrayList<Employee>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Employee" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Employee u = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"), rs.getString("salary").charAt(0));
	            Employees.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return Employees;
	}


	public List<Employee> getsalaryMasculino() {
		List<Employee> Employees = new ArrayList<Employee>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Employee WHERE Employee.salary LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Employee u = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"), rs.getString("salary").charAt(0));
	            Employees.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return Employees;
	}
	
	
	public boolean update(Employee Employee) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE Employee SET name = '" + Employee.getname() + "', department = '"  
				       + Employee.getdepartment() + "', salary = '" + Employee.getsalary() + "'"
					   + " WHERE id = " + Employee.getid();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM Employee WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String name, String department) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Employee WHERE name LIKE '" + name + "' AND department LIKE '" + department  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}