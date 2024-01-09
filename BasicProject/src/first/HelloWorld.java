package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HelloWorld
{
 public static void main(String[] args)
 {
	 
   
   String url="jdbc:mysql://localhost:3306?user=root&password=12345";
   String query="select * from bank_project.bank_account where FULLNAME=?";
   
   Scanner sc = new Scanner(System.in);
   
   try 
   {
	Connection con = DriverManager.getConnection(url);
	PreparedStatement ps = con.prepareStatement(query);
	
	System.out.println("Enter the name here :");
	
	ps.setString(1, sc.nextLine());
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
	{
		System.out.println("Login Succesfull....");
	}
	else
	{
		System.err.println("Invalid credentials.....");
	}
}
   catch (SQLException e) 
   {
	e.printStackTrace();
}
   
 
 }
}
