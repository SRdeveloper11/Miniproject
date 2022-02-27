package studentdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminLoginSectiondatabsedaoimpl implements AdminLogindatabasedao  {
	String dbURL = "jdbc:mysql://localhost/feereport";
	 String username = "root";
	 String password = "shivam@123";
	public AdminLoginSectiondatabsedaoimpl() throws SQLException
	{
	
	  Connection conn = DriverManager.getConnection(dbURL, username, password);
	         Statement stmt = conn.createStatement();
	}

	@Override
	public void View_Accounatnt() {
		// TODO Auto-generated method stub
try {
	String q="SELECT *from Accountant";
Connection	conn = DriverManager.getConnection(dbURL, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(q);
System.out.println("Accountant Name   Password            Email              Contact_No");
while(rs.next())
{
System.out.println(rs.getString(1)+"            "+rs.getString(2)+"       "+rs.getString(3)+"       "+rs.getString(4));
}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		System.out.println("Logout Successfully!!");
	}
	public void Add_Accounatnt( AdminLogindatabase a) {
		// TODO Auto-generated method stub
		
		try {
			 Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			stmt.executeLargeUpdate("insert into accountant values('"+a.getName()+"','"+a.getPassword()+"','"+a.getEmail()+"','"+a.getContact_NO()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
