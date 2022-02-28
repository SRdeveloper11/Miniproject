package miniproject2_1;
import  studentdao.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
class AdminLogin extends AdminSection
{
	void Admin_login_details(String name,String password) throws IOException
	{
		String Name="admin";
		String Password="admin123";
		if(Name.equals(name)&& Password.equals(password))
		{
			System.out.println("Name is:"+Name);
			System.out.println("Password is:"+Password);
			System.out.println("Login Succesfully");
		do{
			System.out.println("Enter the choie: 1-Add Accountant 2-View Accountant 3-Logout");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch(n)
		   {
			case 1:
				System.out.println("Enter the number of accountant you want to add");
				Scanner sc11=new Scanner(System.in);
				int n1;
				n1=sc11.nextInt();
				int i;
				for(i=0;i<n1;i++)
				{
				Add_Accountant();
				}
				break;
			case 2:
				View_Accountant();
				break;
			case 3:
				Logout();
				default:System.out.println("Enter a valid choice");
			}
			System.out.println("Do you want to continue: y/n"); 
		    String s=sc.next(); 
		    if(s.startsWith("n")){ 
		    break;
		    }
		    
		}while(true);
		
	}
		else
		{
			System.out.println("Please eneter valid credentials");
		}
}
}
class AdminSection
{
    String Name ,Password, Email ,Contactno;
	void Add_Accountant() throws IOException
	{
		System.out.println("Enter the Accountant Details Name,Password,Email,Contact_no:");
		Scanner sc1=new Scanner(System.in);
		Name=sc1.nextLine();
		Password=sc1.nextLine();
		Email =sc1.nextLine();
		Contactno=sc1.nextLine();
		{
			File myObj = new File("C:\\\\Users\\\\pcplanet\\\\eclipse-workspace\\\\JAVA MINIPROJECT2\\\\bin\\\\Accountant Details\\\\Details.txt");
	  	      if (myObj.createNewFile()) {
	  	        System.out.println("File created: " + myObj.getName());
	  	      }
	  	      else {
	  	        System.out.println("File already exists.");
	  	      }
	  	    FileWriter fw = new FileWriter(myObj, true); 
	  	      BufferedWriter bw = new BufferedWriter(fw);
	  	      String lineToAppend=("\n"+Name+"\t\t"+Password+"\t\t"+Email+"\t\t"+Contactno+"\t\t");    
	  	      bw.write(lineToAppend);
	  	      bw.close();
		}
		System.out.println("Account  Added Successfully");
	}
	void View_Accountant() throws IOException
	{
		System.out.println("Account details are");
		FileReader fr2=new FileReader("C:\\\\Users\\\\pcplanet\\\\eclipse-workspace\\\\JAVA MINIPROJECT2\\\\bin\\\\Accountant Details\\\\Details.txt");
		BufferedReader br1=new BufferedReader(fr2);
		String str1;
		while((str1=br1.readLine()) != null)
		{
			System.out.println(str1);
		}
		Logout();
	}
	void Logout()
	{
		System.out.println("Logout Successfully");
	}
	}
class Accountant_Login_Section extends Student
{
	void display() throws IOException, SQLException
   {
		System.out.println("******************  Welcome To Accountant Section  **********************");
		System.out.println("Enter choice 1-Add student 2-View student 3-Edit Student 4-Due Fee 5-Logout");
	int s;
	Scanner sc=new Scanner(System.in);
	s=sc.nextInt();
	StudentDaoImpl  student=new StudentDaoImpl();			
	switch(s)
	{
	case 1:
		System.out.println("enter the number of student you want to add");
		Scanner sc11=new Scanner(System.in);
		int n;
		n=sc11.nextInt();
		int i;
		for(i=0;i<n;i++)
		{
			Scanner sc5=new Scanner(System.in);
        	Student s1=new Student();
			System.out.println("Enter Roll Number:");
			 s1.setRoll_no(sc5.nextInt());
			System.out.println("Enter Name:");
			 s1.setName(sc5.next());	
			System.out.println("Enter Email:");
			  s1.setEmail(sc5.next());
			System.out.println("Enter Course:");
			  s1.setCourse(sc5.next());
			System.out.println("Enter Total Fees:");
			s1.setFee(sc5.nextInt());
			System.out.println("Enter Amount Paid:");
			s1.setPaid(sc5.nextInt());
			System.out.println("Enter Due Amount:");
			s1.setDue(sc5.nextInt());
			System.out.println("Enter Address:");
			  s1.setAddress(sc5.next());
			System.out.println("Enter City:");
			  s1.setCity(sc5.next());
			System.out.println("Enter State:");
			  s1.setState(sc5.next());
			System.out.println("Enter Country:");
			  s1.setCountry(sc5.next());
			System.out.println("Enter Contact Number:");
			  s1.setContact_no(sc5.next());	  
		student.AddStudent(s1);
		student.Logout();
		}
        break;
	case 2:
		student.ViewStudent();
		student.Logout();
		break;
	case 3:
		System.out.println("Enter the Roll_no of student you want to Edit");
		Scanner sc2=new Scanner(System.in);
		String j=sc2.nextLine();
		int x=student.loadrecord(j);
		if(x==1)
		{
		student.EditStudent(j);
		}
		student.Logout();
		break;
	case 4:
		student.DueStudent();
		student.Logout();
		break;
	case 5:
		student.Logout();
		break;
	}
}
}
public class FeeReport {
	static void AdminLogin() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		String n,p;
		System.out.println("Enter Name and Password :");
		n=sc.nextLine();
		p=sc.nextLine();
		 AdminLogin admin=new  AdminLogin();
		 admin.Admin_login_details(n,p);	
	}
	static void Accountant_login_section() throws IOException, SQLException
	{
		Scanner sc1=new Scanner(System.in);
		String l,s;
		boolean q=false;
		System.out.println("Enter Name and Password");
		l=sc1.nextLine();
		s=sc1.nextLine();
		Accountant_Login_Section accountantlogin=new Accountant_Login_Section();
		FileReader frr=new FileReader("C:\\Users\\pcplanet\\eclipse-workspace\\JAVA MINIPROJECT2\\bin\\Accountant Details\\Details.txt");
		BufferedReader br=new BufferedReader(frr);
		String str=" ";
		while((str=br.readLine()) != null)
		{
			if(str.indexOf(l)!=-1 && str.indexOf(s)!=-1)
			{
				q=true;
				break;
			}
		}
		if(q)
		{
			System.out.println("Login Successfull!!!!!!!");
			accountantlogin.display();
		}	
		else
			
			System.out.println("Enter valid credentials");
	}
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("How you want to save data: 1-Using File System     2-Using Database   ");
		Scanner sc=new Scanner(System.in);
		int User_Choice=sc.nextInt();
		if( User_Choice==1)
		{
		int r;
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter the choice Among Numbers 1 And 2 :-     1-Admin Login   2-Accountant Login");
		r=sc3.nextInt();
		switch(r)
		{
		case 1:
			AdminLogin();
			 break;
		case 2:
			Accountant_login_section();
			break;
			default:System.out.println("Enter a valid Choice");
		}
	}
		else
		{
			int r;
			Scanner sc3=new Scanner(System.in);
			System.out.println("Enter the choice Among Numbers 1 And 2 :-     1-Admin Login   2-Accountant Login");
			r=sc3.nextInt();
			switch(r)
			{
			case 1: AdminLoginDB admin=new  AdminLoginDB();
			Scanner sc1=new Scanner(System.in);
			String n,p;
			System.out.println("Enter Name and Password :");
			n=sc1.next();
			p=sc1.next();
				boolean X=admin.checkcredential(n, p);
				if(X)
				{
					System.out.println("Login Succesfull");
					System.out.println("Welcome to Admin section ");
					AdminLoginSectiondatabsedaoimpl obj=new AdminLoginSectiondatabsedaoimpl();
					AdminLogindatabase obj2=new AdminLogindatabase();
					do{
						System.out.println("Enter the choie: 1-Add Accountant 2-View Accountant 3-Logout");
						Scanner sc5=new Scanner(System.in);
						int n1=sc5.nextInt();
						switch(n1)
					   {
						case 1:
							
							System.out.println("Enter the number of accountant you want to add");
							Scanner sc11=new Scanner(System.in);
							int n11;
							n11=sc11.nextInt();
							int i;
							for(i=0;i<n11;i++)
							{ 
								
								System.out.println("Enter the Accountant Details Name,Password,Email,Contact_no:");
								Scanner sc111=new Scanner(System.in);
							obj2.setName(sc111.nextLine());
							obj2.setPassword(sc111.nextLine());
							obj2.setEmail(sc111.nextLine());
							obj2.setContact_NO(sc111.nextLine());
							obj.Add_Accounatnt(obj2);
							}
							break;
						case 2:
							obj.View_Accounatnt();
							break;
						case 3:
							obj.logout();
							break;
						default:System.out.println("Enter a valid choice");
						}
						System.out.println("Do you want to continue: y/n"); 
					    String s=sc.next(); 
					    if(s.startsWith("n")){ 
					    break;
					    }
					    
					}while(true);
				}
				else
					System.out.println("enter valid credentials");
				 break;
			case 2:
			Scanner sc11=new Scanner(System.in);
			String l,s;
				AccountantloginsectionDb object=new AccountantloginsectionDb();
				System.out.println("Enter Name and Password");
				l=sc11.nextLine();
				s=sc11.nextLine();
				boolean Y=object.checkcredentials(l,s);
				if(Y)
				{
					System.out.println("login Succcessfull!!");
					System.out.println("Welecome to Accountant Section");
					Student s1=new Student();
					StudentDaoImpl  student=new StudentDaoImpl();
					do
					{
						System.out.println("1- To add student"+"\n"+"2-To View student"+"\n"+"3-To view Student Due fess "+"\n"+"4-To edit student"+"\n"+"5-To logout");
						int v;
						Scanner sc111=new Scanner(System.in);
						v=sc111.nextInt();
						switch(v)
						{
case 1:
							
							System.out.println("Enter the number of accountant you want to add");
							Scanner sc121=new Scanner(System.in);
							int n11;
							n11=sc121.nextInt();
							int i;
							for(i=0;i<n11;i++)
							{ 
								
								System.out.println("Enter the student Details Roll_No,Name,Email,Course,Fee,Paid,Due,Address,City,State,Country,Contact_no:");
								Scanner sc5=new Scanner(System.in);
								System.out.println("Enter Roll Number:");
								 s1.setRoll_no(sc5.nextInt());
								System.out.println("Enter Name:");
								 s1.setName(sc5.next());	
								System.out.println("Enter Email:");
								  s1.setEmail(sc5.next());
								System.out.println("Enter Course:");
								  s1.setCourse(sc5.next());
								System.out.println("Enter Total Fees:");
								s1.setFee(sc5.nextInt());
								System.out.println("Enter Amount Paid:");
								s1.setPaid(sc5.nextInt());
								System.out.println("Enter Due Amount:");
								s1.setDue(sc5.nextInt());
								System.out.println("Enter Address:");
								  s1.setAddress(sc5.next());
								System.out.println("Enter City:");
								  s1.setCity(sc5.next());
								System.out.println("Enter State:");
								  s1.setState(sc5.next());
								System.out.println("Enter Country:");
								  s1.setCountry(sc5.next());
								System.out.println("Enter Contact Number:");
								  s1.setContact_no(sc5.next());	
								  student.addstudentdb(s1);
							}
							break;
case 2:student.viewstudentdb();
	break;
case 3:student.duestudentdb();
	break;
case 4:
	System.out.println("Enter the Roll number");
	Scanner f=new Scanner(System.in);
	int rollno=f.nextInt();
	int x=student.loadrecordb(rollno);
	if(x==1)
	{
		System.out.println("Enter the student Details for Updation");
		Scanner sc5=new Scanner(System.in);
		//System.out.println("Enter Roll Number of student You want to update:");
		 //s1.setRoll_no(sc5.nextInt());
		System.out.println("Enter Name:");
		 s1.setName(sc5.next());	
		System.out.println("Enter Email:");
		  s1.setEmail(sc5.next());
		System.out.println("Enter Course:");
		  s1.setCourse(sc5.next());
		System.out.println("Enter Total Fees:");
		s1.setFee(sc5.nextInt());
		System.out.println("Enter Amount Paid:");
		s1.setPaid(sc5.nextInt());
		System.out.println("Enter Due Amount:");
		s1.setDue(sc5.nextInt());
		System.out.println("Enter Address:");
		  s1.setAddress(sc5.next());
		System.out.println("Enter City:");
		  s1.setCity(sc5.next());
		System.out.println("Enter State:");
		  s1.setState(sc5.next());
		System.out.println("Enter Country:");
		  s1.setCountry(sc5.next());
		System.out.println("Enter Contact Number:");
		  s1.setContact_no(sc5.next());	
		  student.editstudentdb(s1,rollno);

	}
	break;
case 5:
	break;
default:System.out.println("Enter a valid choice");
						}
						System.out.println("Do you want to continue: y/n"); 
					    String d=sc.next(); 
					    if(d.startsWith("n")){ 
					    break;
					    }
					}while(true);
				}
				break;
				default:System.out.println("Enter a valid Choice");
			}
		}
}
}
