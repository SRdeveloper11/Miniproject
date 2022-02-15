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
			 //Admin_section_details();
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
				default:System.out.println("Enter a alid choice");
			}	
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
	void display() throws IOException
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
		student.Add_Student();
		student.Logout();
		}
        break;
	case 2:
		student.View_Student();
		student.Logout();
		break;
	case 3:
		student.Edit_Student();
		student.Logout();
		break;
	case 4:
		student.Due_Student();
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
	static void Accountant_login_section() throws IOException
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
	public static void main(String[] args) throws IOException {
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
}
