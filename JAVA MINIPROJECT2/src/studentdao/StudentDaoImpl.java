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

	public void AddStudent(Student s1) {
		// TODO Auto-generated method stub
				String lineToAppend=("\n"+s1.getRoll_no()+"\t\t"+s1.getName()+"\t\t"+s1.getEmail()+"\t\t"+s1.getCourse()+"\t\t"+s1.getFee()+"\t\t"+s1.getPaid()+"\t\t"+s1.getDue()+"\t\t"+s1.getAddress()+"\t\t"+s1.getCity()+"\t\t"+s1.getState()+"\t\t"+s1.getCountry()+"\t\t"+s1.getContact_no());    
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
	public void  ViewStudent() {
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
	@Override
	public void EditStudent() {
		// TODO Auto-generated method stub

		boolean z=false;
		System.out.println("Enter the Roll_no of student you want to Edit");
		Scanner sc=new Scanner(System.in);
		String j=sc.nextLine();
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
			while((str=br2.readLine()) != null)
			{
				if(str.startsWith(j))
				{
					z=true;
					break;
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (z)
		{
			String str5=" ";
			System.out.println("Record is being loaded");
			System.out.println("Student details are:Roll_no,Name,Email,Course, Fee,Paid,Due,Address,City,State,Country,ContactNo");
			System.out.println(str);
			Student s=new Student();
			System.out.println("For data Updation:");
			Scanner sc51 = new Scanner(System.in);
			System.out.println("Enter Roll Number:");
			 s.setRoll_no(sc51.nextInt());
			System.out.println("Enter Name:");
			 s.setName(sc51.next());	
			System.out.println("Enter Email:");
			  s.setEmail(sc51.next());
			System.out.println("Enter Course:");
			  s.setCourse(sc51.next());
			System.out.println("Enter Total Fees:");
			s.setFee(sc51.nextInt());
			System.out.println("Enter Amount Paid:");
			s.setPaid(sc51.nextInt());
			System.out.println("Enter Due Amount:");
			s.setDue(sc51.nextInt());
			System.out.println("Enter Address:");
			  s.setAddress(sc51.next());
			System.out.println("Enter City:");
			  s.setCity(sc51.next());
			System.out.println("Enter State:");
			  s.setState(sc51.nextLine());
			System.out.println("Enter Country:");
			  s.setCountry(sc51.next());
			System.out.println("Enter Contact Number:");
			  s.setContact_no(sc51.next());
			  String lineToAppend=("\n"+s.getRoll_no()+"\t\t"+s.getName()+"\t\t"+s.getEmail()+"\t\t"+s.getCourse()+"\t\t"+s.getFee()+"\t\t"+s.getPaid()+"\t\t"+s.getDue()+"\t\t"+s.getAddress()+"\t\t"+s.getCity()+"\t\t"+s.getState()+"\t\t"+s.getCountry()+"\t\t"+s.getContact_no());    
			File myobj2=new File("C:\\\\\\\\Users\\\\\\\\pcplanet\\\\\\\\eclipse-workspace\\\\\\\\JAVA MINIPROJECT2\\\\\\\\bin\\\\\\\\Accountant Details\\\\\\\\Student_Details.txt ");
			  try {
				if (myobj2.createNewFile())
				  {
				        System.out.println("File created: " + myobj2.getName());
				   }
       else {
				        System.out.println("File already exists.");
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
		else
		{
		System.out.println("Enter valid Roll_No");
		}
		
	}

	@Override
	public void DueStudent() {
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

	@Override
	public void Logout() {
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
			 statement.setString(1, s1.getName());
			  statement.setString(2, s1.getEmail());
			  statement.setString(3, s1.getCourse());
			  statement.setLong(4, s1.getFee());
			  statement.setLong(5, s1.getPaid());
			  statement.setLong(6, s1.getDue());
			  statement.setString(7, s1.getAddress());
			  statement.setString(8, s1.getCity());
			  statement.setString(9, s1.getState());
			  statement.setString(10, s1.getCountry());
			  statement.setString(11, s1.getContact_no());
			 // statement.setInt(12, s1.getRoll_no());
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
			//String S=" SELECT COUNT(*) from student where Roll_no='"+p+"'";
			Connection	conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			//while(rs.next())
			//{   c = rs.getInt(1);
			//}
				 while(  rs.next())
				 {
					 System.out.println("Roll_No:"+rs.getString(1)+"               Name:"+rs.getString(2)+"                 Email:"+rs.getString(3)+"            Course:"+rs.getString(4)+"            Fee:"+rs.getString(5)+"            Paid:"+rs.getString(6)+"            Due:"+rs.getString(7)+"            Address:"+rs.getString(8)+"            City:"+rs.getString(9)+"            State:"+rs.getString(10)+"            Country:"+rs.getString(11)+"            Contact_No:"+rs.getString(12));
						 
					 c++;
				 } 

			return c;
			
	}
	

	
	@Override
	public void logoutdb() {
		// TODO Auto-generated method stub
		System.out.println("Logout Succesfully!!");
	}

	@Override
	public void addstudentdb(Student A) {
		// TODO Auto-generated method stub
		try {
			 Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement stmt=conn.createStatement();
			stmt.executeLargeUpdate("insert into student  values('"+A.getRoll_no()+"','"+A.getName()+"','"+A.getEmail()+"','"+A.getCourse()+"','" +A.getFee()+" ','"+A.getPaid()+"','"+A.getDue()+"','"+A.getAddress()+"','"+A.getCity()+"','"+A.getState()+"','"+A.getCountry()+"','"+A.getContact_no()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
