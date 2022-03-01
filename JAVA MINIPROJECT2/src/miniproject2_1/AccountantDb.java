package miniproject2_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountantDb {
	String n,p;
	String dbURL = "jdbc:mysql://localhost/feereport";
	 String username = "root";
	 String password = "shivam@123";
	public AccountantDb  () throws SQLException
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  Connection conn = DriverManager.getConnection(dbURL, username, password);
	         Statement stmt = conn.createStatement();
	}
	boolean c=false;
	public boolean credential(String w,String y) throws SQLException {
		String q="SELECT *from Accountant where Name='"+w+"' and Password='"+y+"'  ";
		Connection	conn = DriverManager.getConnection(dbURL, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(q);
		if(rs.next())
		{
			String[] g={"(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4))"};
			c=true;
		}
		else
		{
			System.out.println("Enter Valid Credentials");
		}
		return c;
	
	}

}
