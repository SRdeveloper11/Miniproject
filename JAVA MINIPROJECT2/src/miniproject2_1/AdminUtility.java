package miniproject2_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminUtility {
	  String name ,password, email ,contactno;
		void addacountant() throws IOException
		{
			System.out.println("Enter the Accountant Details Name,Password,Email,Contact_no:");
			Scanner sc1=new Scanner(System.in);
			name=sc1.nextLine();
			password=sc1.nextLine();
			email =sc1.nextLine();
			contactno=sc1.nextLine();
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
		  	      String lineToAppend=("\n"+name+"\t\t"+password+"\t\t"+email+"\t\t"+contactno+"\t\t");    
		  	      bw.write(lineToAppend);
		  	      bw.close();
			}
			System.out.println("Account  Added Successfully");
		}
		void viewaccountant() throws IOException
		{
			System.out.println("Account details are");
			FileReader fr2=new FileReader("C:\\\\Users\\\\pcplanet\\\\eclipse-workspace\\\\JAVA MINIPROJECT2\\\\bin\\\\Accountant Details\\\\Details.txt");
			BufferedReader br1=new BufferedReader(fr2);
			String str1;
			while((str1=br1.readLine()) != null)
			{
				System.out.println(str1);
			}
		}
	
}
