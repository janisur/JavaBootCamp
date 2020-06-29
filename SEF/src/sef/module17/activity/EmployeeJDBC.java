package sef.module17.activity;
//Needs to be completed
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeJDBC {
	
	public static void main(String arg[]) {
		Connection con = createConnection();
		System.out.println(con);
		
		/*Employee e1 = new Employee();
		e1.setId("1");
		e1.setFirstName("Andris");
		e1.setLastName("Lakstins");
		e1.setSalary(1200);
		
		insertEmployee(e1);
		
		
		Employee e2 = new Employee();
		e2.setId("2");
		e2.setFirstName("Janis");
		e2.setLastName("Berzins");
		e2.setSalary(1500);
		
		insertEmployee(e2);
		
		Employee e3 = new Employee();
		e3.setId("3");
		e3.setFirstName("Ivo");
		e3.setLastName("Birzes");
		e3.setSalary(1500);
		
		insertEmployee(e3);
		*/
		
		
		//find Employee by the Id
		
		Employee test1 = new Employee();
		test1 = findEmployeeById("3");
		System.out.println(test1.getFirstName());
				
		System.out.println("---------------------------------------------");
		
		//find Employee by the Name
		
		List<Employee> test2 = new ArrayList<Employee>();
		test2 = findEmployeesByName("ndr");
		
		for(int i = 0; i < test2.size(); i++) {
	        System.out.println(test2.get(i).getFirstName());
	        }
			
		System.out.println("---------------------------------------------");
				
		//find Employee by the Salary
		
		List<Employee> test3 = new ArrayList<Employee>();
		test3 = findEmployeesBySalary(1500);
		
		for(int i = 0; i < test3.size(); i++) {
        System.out.println(test3.get(i).getFirstName());
        }
		
		
	 }
		
	
	

	public static Connection createConnection()
	{
		Connection con=null;
		String url = "jdbc:mysql://localhost/activity";
		String user = "root";
		String pass = "ridefree2014";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successfully established!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Employee findEmployeeById(String id)
	{
		Connection con = createConnection();
		Employee emp=null;
		try {
		// 1 - Create a PreparedStatement with a query
			
		PreparedStatement pStmt = con.prepareStatement("select * from employee where id = ?");
		

		// 2 - Search for the given id
		pStmt.setString(1,  id);;
			
	

		// 3 - Execute this query
		
		ResultSet rs = pStmt.executeQuery();
		
		
		// 4 - If resultset is not null, then initialize emp object with data 
		
		if(rs.next()) {
			emp = new Employee();
			emp.setId(rs.getString(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			emp.setSalary(Integer.parseInt(rs.getString(4)));
			
		}
		
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	public static ArrayList<Employee> findEmployeesByName(String name)
	{
		Connection con = createConnection();
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
		// 1 - Create a PreparedStatement with a query
		PreparedStatement pStmt = con.prepareStatement("select * from employee where firstName like ? or lastName like ?");

		// 2 - Search for the given id
		
		pStmt.setString(1, "%" + name + "%");
		pStmt.setString(2, "%" + name + "%");
		
		// 3 - Execute this query
		
		ResultSet rs = pStmt.executeQuery();
		
		// 4 - While there are some records, continue 
		
		while(rs.next()) {
			
			Employee emp = new Employee();
			emp.setId(rs.getString(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			emp.setSalary(Integer.parseInt(rs.getString(4)));
			
			list.add(emp);
			
		}
		
		
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static ArrayList<Employee> findEmployeesBySalary(int salary)
	{
		Connection con = createConnection();
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
		// 1 - Create a PreparedStatement with a query
			PreparedStatement pStmt = con.prepareStatement("select * from employee where salary = ? ");
		

		// 2 - Search for the given salary
					
			pStmt.setInt(1, salary);
		

		// 3 - Execute this query
			
			ResultSet rs = pStmt.executeQuery();

		
		// 4 - While there are records, continue 
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(Integer.parseInt(rs.getString(4)));
				
				list.add(emp);
			}

		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static void insertEmployee(Employee emp)
	{
		Connection con = createConnection();
		
		//1 - Create a PreparedStatement with a query "insert into employee values(?,?,?,?)" 
		
		try {
		PreparedStatement pStmt = con.prepareStatement("insert into employee values(?,?,?,?)");	
		
		
		
		con.setAutoCommit(false);

		//	Substitute the ? now.
		
		pStmt.setString(1,emp.getId());
		pStmt.setString(2,emp.getFirstName());
		pStmt.setString(3,emp.getLastName());
		pStmt.setInt(4,emp.getSalary());
		
		
		//2 - Execute this query using executeUpdate()
		
		int rows = pStmt.executeUpdate();
			
		System.out.println(rows + " row(s) added!");
		con.commit();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
