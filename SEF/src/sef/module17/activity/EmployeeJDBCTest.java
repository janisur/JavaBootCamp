package sef.module17.activity;
//Needs to be completed
import java.sql.Connection;
import java.util.ArrayList;

import junit.framework.TestCase;

public class EmployeeJDBCTest extends TestCase {

	EmployeeJDBC emp;
	
	protected void setUp() throws Exception {
	//setUp() is used to initialize member data which would be used by all/most of its methods
		emp = new EmployeeJDBC();
	}

	public void testCreateConnection() {
		Connection con = emp.createConnection();
		assertNotNull(con);
		
	}

	public void testFindEmployeeById_MatchFound() {
		//complete the code here
		
		Employee e = emp.findEmployeeById("1");
		assertEquals("Andris", e.getFirstName());
		assertEquals("Lakstins", e.getLastName());
		assertEquals(1200, e.getSalary());
	}

	public void testFindEmployeeById_NoMatchFound() {
		//complete the code here
		
		Employee e1 = emp.findEmployeeById("5");
		assertNull(e1);
	}
	
	
	public void testFindEmployeeByName_MatchFound() {
		
		//complete the code here
		
		ArrayList<Employee> list = emp.findEmployeesByName("Andris");
		assertEquals(1, list.size());
	
	}
	
	public void testFindEmployeeByName_NoMatchFound() {
		//complete the code here
		
		ArrayList<Employee> list = emp.findEmployeesByName("Edgars");
		assertEquals(0, list.size());
	}

	public void testFindEmployeeBySalary_MatchFound() {
		//complete the code here
		
		ArrayList<Employee> list = emp.findEmployeesBySalary(1200);
		assertEquals(1, list.size());
	}

	public void testFindEmployeeBySalary_NoMatchFound() {
		//complete the code here
		
		ArrayList<Employee> list = emp.findEmployeesBySalary(200);
		assertEquals(0, list.size());
	}
	
	public void testInsertEmployee(){
		//complete the code here
		Employee e4 = new Employee();
		e4.setId("4");
		e4.setFirstName("Augusts");
		e4.setLastName("Zemgals");
		e4.setSalary(3500);
		
		emp.insertEmployee(e4);
		
		Employee e2 = emp.findEmployeeById("2");
		assertEquals("Janis", e2.getFirstName());
		assertEquals("Berzins", e2.getLastName());
		assertEquals(1500, e2.getSalary());
	}
}
