package studentdao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

	public void addstudent(Student s1) {
		// TODO Auto-generated method stub
				String lineToAppend=("\n"+s1.getrollno()+"\t\t"+s1.getname()+"\t\t"+s1.getemail()+"\t\t"+s1.getcourse()+"\t\t"+s1.getfee()+"\t\t"+s1.getpaid()+"\t\t"+s1.getdue()+"\t\t"+s1.getaddress()+"\t\t"+s1.getcity()+"\t\t"+s1.getstate()+"\t\t"+s1.getcountry()+"\t\t"+s1.getcontactno());    
				File input=new File("C:\\\\\\\\Users\\\\\\\\pcplanet\\\\\\\\eclipse-workspace\\\\\\\\JAVA MINIPROJECT2\\\\\\\\bin\\\\\\\\Accountant Details\\\\\\\\Student_Details.txt");
				  try {
					if (input.createNewFile()) {
					        System.out.println("File created: " + input.getName());
					      }
					      else {
					        System.out.println("File already exists.");
					      }
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			  	   FileWriter fw = null;
				try {
					fw = new FileWriter(input, true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			  	    BufferedWriter bw = new BufferedWriter(fw);
			  	     try {
						bw.write(lineToAppend);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			  	     try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			System.out.println("Student Added Succesfully!!");
	}

	@Override
	public void  viewstudent() {
		// TODO Auto-generated method stub 
		System.out.println("##########Student details are:Roll_No,Name,Email,Course,Fess,Paid,Due,Address,City,State,Country,Contact_no");
		FileReader fr1 = null;
		try {
			fr1 = new FileReader("C:\\\\\\\\Users\\\\\\\\pcplanet\\\\\\\\eclipse-workspace\\\\\\\\JAVA MINIPROJECT2\\\\\\\\bin\\\\\\\\Accountant Details\\\\\\\\Student_Details.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br1=new BufferedReader(fr1);
		String str1;
		try {
			while((str1=br1.readLine()) != null)
			{
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editstudent(Student  s) {
			String str5=" ";
			  String lineToAppend=("\n"+s.getname()+"\t\t"+s.getemail()+"\t\t"+s.getcourse()+"\t\t"+s.getfee()+"\t\t"+s.getpaid()+"\t\t"+s.getdue()+"\t\t"+s.getaddress()+"\t\t"+s.getcity()+"\t\t"+s.getstate()+"\t\t"+s.getcountry()+"\t\t"+s.getcontactno());    
			File myobj2=new File("C:\\\\\\\\Users\\\\\\\\pcplanet\\\\\\\\eclipse-workspace\\\\\\\\JAVA MINIPROJECT2\\\\\\\\bin\\\\\\\\Accountant Details\\\\\\\\Student_Details.txt ");
			  try {
				if (myobj2.createNewFile())
				  {
				        System.out.println("File created: " + myobj2.getName());
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fn = null;
			try {
				fn = new FileWriter(myobj2,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedWriter bw = new BufferedWriter(fn);
			try {
				bw.write(lineToAppend);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Data Updated successfully");
			}

	@Override
	public void duestudent() {
		// TODO Auto-generated method stub
		System.out.println("Due fee is");
		FileReader fr1 = null;
		try {
			fr1 = new FileReader("C:\\\\Users\\\\pcplanet\\\\eclipse-workspace\\\\JAVA MINIPROJECT2\\\\bin\\\\Accountant Details\\\\Student_Details.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br1=new BufferedReader(fr1);
		String str1;
		try {
			while((str1=br1.readLine()) != null)
			{
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public void logout() {
		// TODO Auto-generated method stub
		{
			System.out.println("logout Successfully");
		}	
	}

	String dbURL = "jdbc:mysql://localhost/feereport";
	 String username = "root";
	 String password = "shivam@123";
	public StudentDaoImpl() throws SQLException
	{
	
	  Connection conn = DriverManager.getConnection(dbURL, username, password);
	         Statement stmt = conn.createStatement();
	}


	@Override
	public void viewstudentdb() {
		// TODO Auto-generated method stub
		try {
			String q="SELECT *from student";
		Connection	conn = DriverManager.getConnection(dbURL, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next())
		{
		System.out.println("Roll_No:"+rs.getString(1)+"               Name:"+rs.getString(2)+"                 Email:"+rs.getString(3)+"            Course:"+rs.getString(4)+"            Fee:"+rs.getString(5)+"            Paid:"+rs.getString(6)+"            Due:"+rs.getString(7)+"            Address:"+rs.getString(8)+"            City:"+rs.getString(9)+"            State:"+rs.getString(10)+"            Country:"+rs.getString(11)+"            Contact_No:"+rs.getString(12));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

	public void editstudentdb(Student s1,int a) {
		// TODO Auto-generated method stub
		try {
			 Connection conn = DriverManager.getConnection(dbURL, username, password);
		String n="SELECT*From student";
			String q="UPDATE student SET Name = ?, Email= ?, Course = ?,Fee=?,Paid=?,Due=?,Address=?,City=?,State=?,Country=?,Contact_No=?"+"Where Roll_No=?";
			 PreparedStatement statement = 
				     conn.prepareStatement(q);
			 statement.setString(1, s1.getname());
			  statement.setString(2, s1.getemail());
			  statement.setString(3, s1.getcourse());
			  statement.setLong(4, s1.getfee());
			  statement.setLong(5, s1.getpaid());
			  statement.setLong(6, s1.getdue());
			  statement.setString(7, s1.getaddress());
			  statement.setString(8, s1.getcity());
			  statement.setString(9, s1.getstate());
			  statement.setString(10, s1.getcountry());
			  statement.setString(11, s1.getcontactno());
			 statement.setInt(12, a);
			  statement.executeUpdate();	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void duestudentdb() {
		// TODO Auto-generated method stub
		try {
			String q="  SELECT *from student where Due=0;";
		Connection	conn = DriverManager.getConnection(dbURL, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next())
		{
		System.out.println("Roll_No:"+rs.getString(1)+"               Name:"+rs.getString(2)+"                 Email:"+rs.getString(3)+"            Course:"+rs.getString(4)+"            Fee:"+rs.getString(5)+"            Paid:"+rs.getString(6)+"            Due:"+rs.getString(7)+"            Address:"+rs.getString(8)+"            City:"+rs.getString(9)+"            State:"+rs.getString(10)+"            Country:"+rs.getString(11)+"            Contact_No:"+rs.getString(12));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
	}

	@Override
	public int loadrecordb(int p) throws SQLException {
		// TODO Auto-generated method stub
	int c=0;
			String q="  SELECT *from student where Roll_No='"+p+"'";
			Connection	conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(q);
				 while(  rs.next())
				 {
					 System.out.println("Roll_No:"+rs.getString(1)+"               Name:"+rs.getString(2)+"                 Email:"+rs.getString(3)+"            Course:"+rs.getString(4)+"            Fee:"+rs.getString(5)+"            Paid:"+rs.getString(6)+"            Due:"+rs.getString(7)+"            Address:"+rs.getString(8)+"            City:"+rs.getString(9)+"            State:"+rs.getString(10)+"            Country:"+rs.getString(11)+"            Contact_No:"+rs.getString(12));
						 
					 c++;
				 } 

			return c;
			
	}
	

	
	

	@Override
	public void addstudentdb(Student A) {
		// TODO Auto-generated method stub
		try {
			
			 Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			stmt.executeLargeUpdate("insert into student  values('"+A.getrollno()+"','"+A.getname()+"','"+A.getemail()+"','"+A.getcourse()+"','" +A.getfee()+" ','"+A.getpaid()+"','"+A.getdue()+"','"+A.getaddress()+"','"+A.getcity()+"','"+A.getstate()+"','"+A.getcountry()+"','"+A.getcontactno()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int  loadrecord( String j) {
		// TODO Auto-generated method stub
	int c=0;
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\\\\\\\Users\\\\\\\\pcplanet\\\\\\\\eclipse-workspace\\\\\\\\JAVA MINIPROJECT2\\\\\\\\bin\\\\\\\\Accountant Details\\\\\\\\Student_Details.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br2=new BufferedReader(fr);
		String str=" ";
		try {
			try {
				while((str=br2.readLine()) != null)
				{
					if(str.startsWith(j))
					{
						System.out.println(str);
						c=1;
					}
}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}finally
		{
	
		}
		return c;
	}
}

	
