package in.sterling.StudentProject;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MarksheetTest
{
private static HashSet HashSet = null;
public static boolean flag = false;
public static Connection con=null;
public static String printOptions()
{
String str = new String();
Scanner sc2 = new Scanner(System.in);
System.out.println("For Insert Your Data Press 1");
System.out.println("For Delete Your Data Press 2");
System.out.println("For Update Your Data Press 3");
System.out.println("For Update All Data Press 4");
System.out.println("For MarkSheet Details Press 5");
System.out.println("For Complete MarkSheet Press 6");
System.out.println("To Get Merit List Press 7");
System.out.println("To Get Attendence Press 8");
System.out.println("To Get Failed Students Press 9");
System.out.println("To Get Topper Press 10");
System.out.println("To Get Average Marks Of Class Press 11");
System.out.println("To Get Passed Students Of Class Press 12");
System.out.println("To Get All Students MarksSheet Press 13");
return str;
}
public static String askOptions()
{
String str = new String();
Scanner sc = new Scanner(System.in);
System.out.println("Would you like to Continue Please Choose an Option....Yes/No");
String opt = sc.next();
if(opt.equalsIgnoreCase("yes"))
{
System.out.println("Please Choose an Option Again");
MarksheetTest.printOptions();
}
else if (opt.equalsIgnoreCase("No")){
System.out.println("Thank you Please Vist Us Again");
}
else
{
System.out.println("Please Select An Option");
}
return str;
}

public static Connection connectivity()
{ 
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newbatch","root","root");
}
catch(ClassNotFoundException cnfe){
cnfe.printStackTrace();
}
catch(SQLException sqle){
sqle.printStackTrace();	
}
return con;
}
public boolean add(Marksheet ms)
{
flag = false;
con= connectivity();
String rollno = ms.getRollno();
String name=ms.getName();
int physics=ms.getPhysics();
int maths= ms.getMaths();
int chemistry= ms.getChemistry();
try
{
PreparedStatement ps  = con.prepareStatement("insert into student values(?,?,?,?,?)");	
ps.setString(1,rollno);
ps.setString(2,name );
ps.setInt(3, physics);
ps.setInt(4,chemistry);
ps.setInt(5, maths);;
int val = ps.executeUpdate();
if(val==1)
{
System.out.println("Marksheet Added SuccessFully");
MarksheetTest.askOptions();
}
else
{
System.err.println("Please Enter Valid Options");
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();	
}
return flag;
}
public boolean delete(Marksheet ms)
{
flag = false;
con= connectivity();
String rollno = ms.getRollno();
try
{
PreparedStatement ps = con.prepareStatement("delete from student where Roll_No=?");
ps.setString(1, rollno);
int val = ps.executeUpdate();
if (val==1)
{
System.out.println("Marksheet Deleted");
MarksheetTest.askOptions();
}
else
{
System.out.println("Please Enter Valid Options");
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return flag;
}		

public boolean updateMarksheet(Marksheet ms)
{
flag=false;
con=connectivity();
String rollno = ms.getRollno();
String name = ms.getName();
int physics=ms.getPhysics();
int chemistry=ms.getChemistry();
int maths=ms.getMaths();
try
{
if (rollno!=null&&name!=null)
{
PreparedStatement ps  = con.prepareStatement("update student set roll_no=? where name=?");
ps.setString(1,name);
ps.setString(2,rollno);
int ch = ps.executeUpdate();
PreparedStatement ps1 = con.prepareStatement("update student set name=? where roll_no=?");
ps1.setString(1,name);
ps1.setString(2,rollno);
int ch1= ps1.executeUpdate();
if(ch==1)
{
flag = true;
}	
if(ch1==1)
{
flag=true;
}
}
if(rollno!=null&&physics!=0)
{
PreparedStatement ps  = con.prepareStatement("update student set physics=? where roll_no=?");
ps.setInt(1,physics);
ps.setString(2,rollno);
int ch=ps.executeUpdate();	
if(ch==1)
{
flag=true;
}
}
if(rollno!=null&&chemistry!=0)
{
PreparedStatement ps  = con.prepareStatement("update student set chemistry=? where roll_no=?");	
ps.setInt(1,chemistry);
ps.setString(2,rollno);
int ch=ps.executeUpdate();
if(ch==1)
{
flag=true;
}		
}
if(rollno!=null&&maths!=0)
{
PreparedStatement ps=con.prepareStatement("update student set maths=? where roll_no=?"); 
ps.setInt(1,maths);
ps.setString(2,rollno);
int ch=ps.executeUpdate();
if(ch==1)
{
flag=true;
}
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return flag;
}

public boolean updateall(Marksheet ms)
{
flag = false;
con= connectivity();
String rollno = ms.getRollno();
String name = ms.getName();
int maths = ms.getMaths();
int physics = ms.getPhysics();
int chemistry = ms.getChemistry();
try
{
PreparedStatement ps  = con.prepareStatement("update student set Name=?,Maths_Marks=?,Physics_Marks=?,Chemistry_Marks=? where Roll_NO=?");	
ps.setString(1,name );
ps.setInt(2, maths);
ps.setInt(3,physics);
ps.setInt(4, chemistry);
ps.setString(5,rollno);
int val = ps.executeUpdate();
if (val==1)
{
flag=true;
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return flag;
}

public boolean getElementRollNo(Marksheet m1)  
{
flag=false;
con=connectivity();
String rollno=m1.getRollno();
try
{
PreparedStatement ps=con.prepareStatement("select * from student where roll_no=?");
ps.setString(1,rollno);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("roll_no"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return true;
}
public boolean getCompleteMarksheet(Marksheet ms)
{
flag=false;
con=connectivity();
String rollno=ms.getRollno();
try
{
PreparedStatement ps=con.prepareStatement("select * from Student where roll_no=?");
ps.setString(1,rollno);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("roll_no"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return true;
}


public Set<Marksheet> getMeritList()
{
flag=false;
con=connectivity();
Marksheet m1 = new Marksheet();
Set<Marksheet> HashSet=new HashSet<Marksheet>();
HashSet.add(m1);
try
{
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select* from student where Physics_Marks+Chemistry_Marks+Maths_Marks>=250");
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("roll_no"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
flag=true;
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return HashSet;
}

public int totalStudents()
{
flag = false;
con= connectivity();
Marksheet m1 = new Marksheet();
try
{
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from student");
while(rs.next())
{
System.out.println(rs.getString(1));
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return 0;
}		

public ArrayList<Marksheet> failedStudents()
{
flag=false;
con=connectivity();
Marksheet m1 = new Marksheet();
ArrayList<Marksheet> al = new ArrayList<Marksheet>();
al.add(m1);
try
{
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select* from student where Physics_Marks+Chemistry_Marks+Maths_Marks<=200");
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("roll_no"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
flag=true;
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return al;
}

public ArrayList<Marksheet> topper()
{
flag=false;
con=connectivity();
Marksheet m1 = new Marksheet();
ArrayList<Marksheet> al = new ArrayList<Marksheet>();
al.add(m1);
try
{
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select max(Physics_Marks),max(Chemistry_Marks),max(Maths_Marks) from student");
while(rs.next())
{
System.out.println("Your Roll_No : "+rs.getString("Roll_No"));
System.out.println("Your Name : "+rs.getString("Name"));
System.out.println("Your Physics_Marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your Chemistry_Marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your Maths_Marks : "+rs.getInt("Maths_Marks"));
}	
flag=true;
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return al;
}

public double getAverageMarks(Marksheet m1)
{
double d = 0;
con=connectivity();
try
{
PreparedStatement ps=con.prepareStatement("select * from student where Physics_Marks+Maths_Marks+Chemistry_Marks<=250 && Physics_Marks+Maths_Marks+Chemistry_Marks>=100 ");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("Roll_No"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return d;	
}
public String getPassedStudents(Marksheet m1)
{
String str = new String();
con = connectivity();
try
{
PreparedStatement ps=con.prepareStatement("select * from student where Physics_Marks+Maths_Marks+Chemistry_Marks>=200");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("Roll_No"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return str;	
}

public Set getWholeClass(Marksheet m1) 
{
flag=false;
con=connectivity();
Set<Marksheet> HashSet=new HashSet<Marksheet>();
HashSet.add(m1);
try
{
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select* from student");
while(rs.next())
{
System.out.println("Your roll number : "+rs.getString("roll_no"));
System.out.println("Your name : "+rs.getString("name"));
System.out.println("Your physics marks : "+rs.getInt("Physics_Marks"));
System.out.println("Your chemistry marks : "+rs.getInt("Chemistry_Marks"));
System.out.println("Your maths marks : "+rs.getInt("Maths_Marks"));
}
flag=true;
}
catch(SQLException sqle)
{
sqle.printStackTrace();
}
return HashSet;
}
}