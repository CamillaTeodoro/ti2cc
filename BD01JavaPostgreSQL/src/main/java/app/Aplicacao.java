package app;

import java.util.List;

import dao.DAO;
import dao.EmployeeDAO;
import model.Employee;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		EmployeeDAO EmployeeDAO = new EmployeeDAO();
		
		
		
		System.out.println("\n\n==== Inserir usuário === ");
		Employee Employee = new Employee(1, "Pablo", "Engineering", 15000);
		if(EmployeeDAO.insert(Employee) == true) {
			System.out.println("Inserção com sucesso -> " + Employee.toString());
		}
		/*
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Usuário (" + Employee.getname() + "): " + EmployeeDAO.autenticar("pablo", "pablo"));
		*/
		/*	
		System.out.println("\n\n==== Mostrar usuários do salary masculino === ");
		List<Employee> Employees = EmployeeDAO.getsalaryMasculino();
		for (Employee u: Employees) {
			System.out.println(u.toString());
		}
		

		System.out.println("\n\n==== Atualizar department (código (" + Employee.getid() + ") === ");
		Employee.setdepartment(DAO.toMD5("pablo"));
		EmployeeDAO.update(Employee);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Usuário (" + Employee.getname() + "): " + EmployeeDAO.autenticar("pablo", DAO.toMD5("pablo")));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Usuário (" + Employee.getname() + "): " + EmployeeDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
		Employees = EmployeeDAO.getOrderByid();
		for (Employee u: Employees) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir usuário (código " + Employee.getid() + ") === ");
		EmployeeDAO.delete(Employee.getid());
		
		System.out.println("\n\n==== Mostrar usuários ordenados por name === ");
		Employees = EmployeeDAO.getOrderByname();
		for (Employee u: Employees) {
			System.out.println(u.toString());
		}
		*/
	}
}