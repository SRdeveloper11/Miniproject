package studentdao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void Add_Student() {
		// TODO Auto-generated method stub
	        	Scanner sc5=new Scanner(System.in);
	        	Student s=new Student();
				System.out.println("Enter Roll Number:");
				 s.setRoll_no(sc5.nextInt());
				System.out.println("Enter Name:");
				 s.setName(sc5.next());	
				System.out.println("Enter Email:");
				  s.setEmail(sc5.next());
				System.out.println("Enter Course:");
				  s.setCourse(sc5.next());
				System.out.println("Enter Total Fees:");
				s.setFee(sc5.nextInt());
				System.out.println("Enter Amount Paid:");
				s.setPaid(sc5.nextInt());
				System.out.println("Enter Due Amount:");
				s.setDue(sc5.nextInt());
				System.out.println("Enter Address:");
				  s.setAddress(sc5.next());
				System.out.println("Enter City:");
				  s.setCity(sc5.next());
				System.out.println("Enter State:");
				  s.setState(sc5.next());
				System.out.println("Enter Country:");
				  s.setCountry(sc5.next());
				System.out.println("Enter Contact Number:");
				  s.setContact_no(sc5.next());
				String lineToAppend=("\n"+s.getRoll_no()+"\t\t"+s.getName()+"\t\t"+s.getEmail()+"\t\t"+s.getCourse()+"\t\t"+s.getFee()+"\t\t"+s.getPaid()+"\t\t"+s.getDue()+"\t\t"+s.getAddress()+"\t\t"+s.getCity()+"\t\t"+s.getState()+"\t\t"+s.getCountry()+"\t\t"+s.getContact_no());    
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
	public void  View_Student() {
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
	public void Edit_Student() {
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
			 s.setName(sc51.nextLine());	
			System.out.println("Enter Email:");
			  s.setEmail(sc51.nextLine());
			System.out.println("Enter Course:");
			  s.setCourse(sc51.nextLine());
			System.out.println("Enter Total Fees:");
			s.setFee(sc51.nextInt());
			System.out.println("Enter Amount Paid:");
			s.setPaid(sc51.nextInt());
			System.out.println("Enter Due Amount:");
			s.setDue(sc51.nextInt());
			System.out.println("Enter Address:");
			  s.setAddress(sc51.nextLine());
			System.out.println("Enter City:");
			  s.setCity(sc51.nextLine());
			System.out.println("Enter State:");
			  s.setState(sc51.nextLine());
			System.out.println("Enter Country:");
			  s.setCountry(sc51.nextLine());
			System.out.println("Enter Contact Number:");
			  s.setContact_no(sc51.nextLine());
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
	public void Due_Student() {
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

}
