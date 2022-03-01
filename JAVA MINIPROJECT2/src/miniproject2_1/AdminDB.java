package miniproject2_1;


public class AdminDB {

	public boolean credential( String w,String Y) {
		String name="admin";
		String password="admin123";
		return name.equals(w)&& password.equals(Y);
		}
}
