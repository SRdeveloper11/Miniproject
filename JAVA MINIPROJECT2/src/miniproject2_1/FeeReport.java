package miniproject2_1;
import  studentdao.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import admindbdao.*;
public class FeeReport {
	static void admin() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		String n,p;
		System.out.println("Enter Name and Password :");
		n=sc.nextLine();
		p=sc.nextLine();
		 Admin admin1=new Admin();
		 admin1.admininfo(n, p);
	}
	static void accountant() throws IOException, SQLException
	{ AccountantUtility accountantutility=new AccountantUtility();
		Scanner sc1=new Scanner(System.in);
		String l,s;
		boolean q=false;
		System.out.println("Enter Name and Password");
		l=sc1.nextLine();
		s=sc1.nextLine();
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
			 accountantutility.display();
		}	
		else
			
			System.out.println("Enter valid credentials");
	}
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("How you want to save data: 1-Using File System     2-Using Database   ");
		Scanner sc=new Scanner(System.in);
		int userchoice=sc.nextInt();
		if( userchoice==1)
		{
		int r;
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter the choice Among Numbers 1 And 2 :-     1-Admin Login   2-Accountant Login");
		r=sc3.nextInt();
		switch(r)
		{
		case 1:
			admin();
			 break;
		case 2:
			accountant();
			break;
			default:System.out.println("Enter a valid Choice");
		}
	}
		//Separation of file and database
		else
		{
			int r;
			Scanner sc3=new Scanner(System.in);
			System.out.println("Enter the choice Among Numbers 1 And 2 :-     1-Admin Login   2-Accountant Login");
			r=sc3.nextInt();
			switch(r)
			{
			case 1: AdminDB admin=new  AdminDB();
			Scanner sc1=new Scanner(System.in);
			String n,p;
			System.out.println("Enter Name and Password :");
			n=sc1.next();
			p=sc1.next();
				boolean X=admin.credential(n, p);
				if(X)
				{
					System.out.println("Login Succesfull");
					System.out.println("Welcome to Admin section ");
					Admindb admindb=new Admindb();
					 AdmindbDaoimpl  admindbDaoimpl=new  AdmindbDaoimpl(); 
					do{
						System.out.println("Enter the choie: 1-Add Accountant 2-View Accountant ");
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
								System.out.println("Enter Name");
								admindb.setname(sc111.nextLine());
								System.out.println("Enter password");
								admindb.setPassword(sc111.nextLine());
								System.out.println("Enter Email");
							admindb.setemail(sc111.nextLine());
							System.out.println("Enter Contact number");
							admindb.setcontactno(sc111.nextLine());
							admindbDaoimpl.addaccounatnt(admindb);
							}
							break;
						case 2:
							admindbDaoimpl.viewaccounatnt();;
							break;
						default:System.out.println("Enter a valid choice");
						}
						System.out.println("Do you want to continue: y/n"); 
					    String s=sc.next(); 
					    if(s.startsWith("n")){ 
					    	System.out.println("Logout Successfully");
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
			AccountantDb accountant=new  AccountantDb();
				System.out.println("Enter Name and Password");
				l=sc11.nextLine();
				s=sc11.nextLine();
				boolean y=accountant.credential(l,s);
				if(y)
				{
					System.out.println("login Succcessfull!!");
					System.out.println("Welecome to Accountant Section");
					Student s1=new Student();
					StudentDaoImpl  student=new StudentDaoImpl();
					do
					{
						System.out.println("1- To add student"+"\n"+"2-To View student"+"\n"+"3-To view Student Due fess "+"\n"+"4-To edit student");
						int v;
						Scanner sc111=new Scanner(System.in);
						v=sc111.nextInt();
						switch(v)
						{
case 1:
							
							System.out.println("Enter the number of Student you want to add");
							Scanner sc121=new Scanner(System.in);
							int n11;
							n11=sc121.nextInt();
							int i;
							for(i=0;i<n11;i++)
							{ 
								
								System.out.println("Enter the student Details Roll_No,Name,Email,Course,Fee,Paid,Due,Address,City,State,Country,Contact_no:");
								Scanner sc5=new Scanner(System.in);
								System.out.println("Enter Roll Number:");
								 s1.setrollno(sc5.nextInt());
								System.out.println("Enter Name:");
								 s1.setname(sc5.next());	
								System.out.println("Enter Email:");
								  s1.setemail(sc5.next());
								System.out.println("Enter Course:");
								  s1.setcourse(sc5.next());
								System.out.println("Enter Total Fees:");
								s1.setfee(sc5.nextInt());
								System.out.println("Enter Amount Paid:");
								s1.setpaid(sc5.nextInt());
								System.out.println("Enter Due Amount:");
								s1.setdue(sc5.nextInt());
								System.out.println("Enter Address:");
								  s1.setaddress(sc5.next());
								System.out.println("Enter City:");
								  s1.setcity(sc5.next());
								System.out.println("Enter State:");
								  s1.setstate(sc5.next());
								System.out.println("Enter Country:");
								  s1.setcountry(sc5.next());
								System.out.println("Enter Contact Number:");
								  s1.setcontactno(sc5.next());	
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
		System.out.println("Enter Name:");
		 s1.setname(sc5.next());	
		System.out.println("Enter Email:");
		  s1.setemail(sc5.next());
		System.out.println("Enter Course:");
		  s1.setcourse(sc5.next());
		System.out.println("Enter Total Fees:");
		s1.setfee(sc5.nextInt());
		System.out.println("Enter Amount Paid:");
		s1.setpaid(sc5.nextInt());
		System.out.println("Enter Due Amount:");
		s1.setdue(sc5.nextInt());
		System.out.println("Enter Address:");
		  s1.setaddress(sc5.next());
		System.out.println("Enter City:");
		  s1.setcity(sc5.next());
		System.out.println("Enter State:");
		  s1.setstate(sc5.next());
		System.out.println("Enter Country:");
		  s1.setcountry(sc5.next());
		System.out.println("Enter Contact Number:");
		  s1.setcontactno(sc5.next());	
		  student.editstudentdb(s1,rollno);
	}
	break;
default:System.out.println("Enter a valid choice");
						}
						System.out.println("Do you want to continue: y/n"); 
					    String d=sc.next(); 
					    if(d.startsWith("n")){ 
					    	System.out.println("Logout succesfully!!");
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
