package studentdao;

import java.sql.SQLException;

public interface StudentDao {
void addstudent(Student A);
int loadrecord(String j);
void viewstudent();
void editstudent(Student a);
void duestudent();
void logout();
void addstudentdb(Student A);
void viewstudentdb();
void editstudentdb(Student S1,int rollno);
void duestudentdb();
int loadrecordb(int rollno) throws SQLException;
}
