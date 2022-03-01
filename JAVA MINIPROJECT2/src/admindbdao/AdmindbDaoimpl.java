package admindbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AdmindbDaoimpl implements AdmindbDao{
	String dbURL = "jdbc:mysql://localhost/feereport";
	 String username = "root";
	 String password = "shivam@123";
	public AdmindbDaoimpl() throws SQLException
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


	public void viewaccounatnt() {
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
	public void addaccounatnt( Admindb  a) {
		// TODO Auto-generated method stub
		
		try {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			stmt.executeLargeUpdate("insert into accountant values('"+a.getname()+"','"+a.getpassword()+"','"+a.getemail()+"','"+a.getcontactno()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
