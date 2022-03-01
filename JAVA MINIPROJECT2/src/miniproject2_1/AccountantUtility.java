package miniproject2_1;
import  studentdao.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import studentdao.Student;
import studentdao.StudentDaoImpl;

public class AccountantUtility {
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
			student.addstudent(s1);
			student.logout();
			}
	        break;
		case 2:
			student.viewstudent();
			student.logout();
			break;
		case 3:
			System.out.println("Enter the Roll_no of student you want to Edit");
			Scanner sc2=new Scanner(System.in);
			String j=sc2.nextLine();
			int x=student.loadrecord(j);
			if(x==1)
			{Scanner sc5=new Scanner(System.in);
        	Student s1=new Student();
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
			 student.editstudent(s1); 
			}
			student.logout();
			break;
		case 4:
			student.duestudent();
			student.logout();
			break;
		case 5:
			student.logout();
			break;
		}
	}
}
