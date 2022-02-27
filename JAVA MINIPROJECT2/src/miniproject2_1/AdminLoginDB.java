package miniproject2_1;


public class AdminLoginDB {

	public boolean checkcredential( String w,String Y) {
		String Name="admin";
		String Password="admin123";
		return Name.equals(w)&& Password.equals(Y);
		}
}
