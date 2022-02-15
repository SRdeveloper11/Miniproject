package studentdao;

public class Student {
private String Name,Email,Course,Address,City,State,Country,Contact_no;
private int Fee,Paid,Due, Roll_no;

	public int getRoll_no() {
		return Roll_no;
	}
	public void  setRoll_no(int roll_no) {
		Roll_no = roll_no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getContact_no() {
		return Contact_no;
	}
	public void setContact_no(String contact_no) {
		Contact_no = contact_no;
	}
	public int getFee() {
		return Fee;
	}
	public void setFee(int fee) {
		Fee = fee;
	}
	public int getPaid() {
		return Paid;
	}
	public void setPaid(int paid) {
		Paid = paid;
	}
	public int getDue() {
		return Due;
	}
	public void setDue(int due) {
		Due = due;
	}
	
}
