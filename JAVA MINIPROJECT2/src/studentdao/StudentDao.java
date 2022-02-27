package studentdao;

import java.sql.SQLException;

public interface StudentDao {
void AddStudent(Student A);
void ViewStudent();
void EditStudent();
void DueStudent();
void Logout();
void addstudentdb(Student A);
void viewstudentdb();
void editstudentdb(Student S1,int rollno);
void duestudentdb();
int loadrecordb(int rollno) throws SQLException;
void logoutdb();
}
