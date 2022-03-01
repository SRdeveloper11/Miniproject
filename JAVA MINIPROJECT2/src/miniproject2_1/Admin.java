package miniproject2_1;

import java.io.IOException;
import java.util.Scanner;

public class Admin {

	void admininfo(String name,String password) throws IOException
	{
		AdminUtility adminutility=new AdminUtility();
		String name1="admin";
		String password1="admin123";
		if(name1.equals(name1)&& password1.equals(password1))
		{
			System.out.println("Name is:"+name1);
			System.out.println("Password is:"+password1);
			System.out.println("Login Succesfully");
		do{
			System.out.println("Enter the choie: 1-Add Accountant 2-View Accountant ");
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
					adminutility.addacountant();
				}
				break;
			case 2:
				adminutility.viewaccountant();
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
		{
			System.out.println("Please eneter valid credentials");
		}
}
}
