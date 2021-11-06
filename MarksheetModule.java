package in.sterling.StudentProject;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MarksheetModule
{	
public static void main(String[] args) throws SQLException,ClassNotFoundException
{
java.sql.Connection con=null;
System.out.println("Please Choose Any Option ");
MarksheetTest.printOptions();
Scanner sc = new Scanner(System.in);
int value=sc.nextInt();
boolean flag = false;
if(value==1)
{
System.out.println("Please Insert Your Roll Number ");
String rollno=sc.next();
System.out.println("Please Insert Your Name ");
String name=sc.next();
System.out.println("Please Insert Your Physics Marks ");
int phy=sc.nextInt();
System.out.println("Please Insert Your Chemistry Marks ");
int chm =sc.nextInt();
System.out.println("Please Insert Your Maths Marks ");
int mat =sc.nextInt();
Marksheet m1 =new Marksheet();
m1.setRollno(rollno);
m1.setName(name);
m1.setPhysics(phy);
m1.setChemistry(chm);
m1.setMaths(mat);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.add(m1);
}
if(value==2)
{
System.out.println("Please Enter Your Roll Number");
String rollno = sc.next();
Marksheet m1 = new Marksheet();
m1.setRollno(rollno);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.delete(m1);
if(flag1)
{
System.out.println("Data Deleted"); 
}
}
if(value==3)
{
System.out.println("Please Select an Option for Update");
System.out.println("Press 1 for Roll Number Update");
System.out.println("Press 2 for Name Update");
System.out.println("Press 3 for Physics Marks Update");
System.out.println("Press 4 for Chemisry Marks Update");
System.out.println("Press 5 for Maths Marks Update");
int value1 = sc.nextInt();
if(value1==1)
{
System.out.println("Please Enter Name");
String rollno=sc.next();
System.out.println("Please Enter New RollNumber");
String name=sc.next();
Marksheet m1 = new Marksheet();
m1.setRollno(rollno);
m1.setName(name);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.updateMarksheet(m1);
if(flag1)
{
System.out.println("Data Updated"); 
}
}
if(value1==2)
{
System.out.println("Please Enter RollNumber");
String rollno=sc.next();
System.out.println("Please Enter New Name");
String name=sc.next();
Marksheet m1 = new Marksheet();
m1.setRollno(rollno);
m1.setName(name);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.updateMarksheet(m1);
if(flag1)
{
System.out.println("New Name Updated"); 
}
}
if(value1==3)
{
System.out.println("Please Enter RollNumber");
String rollno=sc.next();
System.out.println("Please Enter Correct Physics Marks");
int physics=sc.nextInt();
Marksheet m1 = new Marksheet();
m1.setRollno(rollno);
m1.setPhysics(physics);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.updateMarksheet(m1);
if(flag1)
{
System.out.println("Physics Marks Updated "); 
}
}
if(value1==4)
{
System.out.println("Please Enter RollNumber");
String rollno=sc.next();
System.out.println("Please Enter Correct Chemistry Marks");
int chemistry=sc.nextInt();
Marksheet m1=new Marksheet();
m1.setRollno(rollno);
m1.setChemistry(chemistry);
MarksheetTest mst = new MarksheetTest();
boolean flag1=mst.updateMarksheet(m1);
if(flag1)
{
System.out.println("Chemistry Marks Updated "); 
}
}
if(value1==5)
{
System.out.println("Please Enter RollNumber");
String rollno=sc.next();
System.out.println("Please Enter Correct Maths Marks");
int maths=sc.nextInt();
Marksheet m1=new Marksheet();
m1.setRollno(rollno);
m1.setMaths(maths);
MarksheetTest mst = new MarksheetTest();
boolean flag1=mst.updateMarksheet(m1);
if(flag1)
{
System.out.println("Maths Marks updated "); 
}
}
}
if(value==4)
{
System.out.println("Please Insert Your RollNumber ");
String rollno=sc.next();
System.out.println("Please Enter New Name ");
String name=sc.next();
System.out.println("Please Enter New Physics Marks ");
int phy=sc.nextInt();
System.out.println("Please Enter New Chemistry Marks ");
int chm =sc.nextInt();
System.out.println("Please Enter New Maths Marks ");
int mat =sc.nextInt();
Marksheet m1 = new Marksheet();
m1.setRollno(rollno);
m1.setName(name);
m1.setPhysics(phy);
m1.setChemistry(chm);
m1.setMaths(mat);
MarksheetTest mst = new MarksheetTest();
boolean flag1 = mst.updateall(m1);
if(flag1)
{
System.out.println("New Data Updated "); 
}
}
if (value==5)
{
System.out.println("Enter Your RollNumber");
String rollno=sc.next();
Marksheet m1=new Marksheet();
m1.setRollno(rollno);
MarksheetTest mst = new MarksheetTest();
boolean flag1=mst.getElementRollNo(m1);
}
if(value==6)
{
System.out.println("Enter Your RollNumber");
String rollno=sc.next();
Marksheet m1=new Marksheet();
m1.setRollno(rollno);
MarksheetTest mst=new MarksheetTest();
boolean flag1=mst.getCompleteMarksheet(m1);
}
if(value==7)
{
System.out.println("Merit list is"+"    ");
MarksheetTest mst=new MarksheetTest();	
mst.getMeritList();
System.out.println("");
}
if (value==8)
{
System.out.println("Total Number Of Students"+"   ");
MarksheetTest mst = new MarksheetTest();
mst.totalStudents();
System.out.println("");
}
if(value==9)
{
System.out.println("Total Number Of Students"+"   ");
MarksheetTest mst = new MarksheetTest();
mst.failedStudents();
System.out.println();
}
if(value==10)
{
System.out.println("Topper Of Batch is"+"    ");
MarksheetTest mst = new MarksheetTest();
mst.topper();
}
if (value==11)
{
System.out.println("List Of Average Student");
System.out.println("                       ");
Marksheet m1=new Marksheet();
MarksheetTest mst=new MarksheetTest();
mst.getAverageMarks(m1);
}
if (value==12)
{
System.out.println("Passed Students Of Class");
System.out.println("                        ");
Marksheet m1 =new Marksheet();
MarksheetTest mst = new MarksheetTest();
mst.getPassedStudents(m1);
}
if (value==13) 
{
Marksheet m1 = new Marksheet();
MarksheetTest mst = new MarksheetTest();
mst.getWholeClass(m1);
}
if (value<1||value>15)
{
System.err.println("Please Select Any Above Option");	
}
} 
}
