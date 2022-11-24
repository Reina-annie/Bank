package banking;
import java.sql.*;
import java.util.*;


public class Bank {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Loki Bank");
		System.out.println("Are you an Admin or a User?");
		String portal = scan.nextLine();
		if(portal.equalsIgnoreCase("User")) {
			System.out.println("Enter your account number:");
			scan.nextLine();
			user();
			
		} else {
			logIn();
			admin();
		}
	}
	
	
		public static void logIn() {
			Scanner scan = new Scanner(System.in);
			String username , password;
			
			do {
			System.out.println("Admin, please enter your username:");
			username = scan.nextLine();
			System.out.println("Password: ");
			password = scan.nextLine();
			if(username.equals("Admin") && password.equals("1111")) {
				System.out.println("Authentication successful");
			} else {
				System.out.println("Authentication failed"); 
			} 
			}while (!username.equals("Admin") && !password.equals("1111"));
		}
		
		public static void admin() {
			Scanner scan = new Scanner(System.in);
//			logIn();
     		System.out.println("\nWhat would you like to access?");
     		System.out.println("\nA.Customer details \nB.Account details \nC.Branch details \nD.Loans \nE.Transaction details \nF.Exit");
     		String choice = scan.nextLine();
     		switch (choice) {
     		case "a" :
     			System.out.println("What would you like to do?");
     			System.out.println("\nA.View customer details \nB.Add customer details");
     			String custChoice = scan.next();
     			if(custChoice.equalsIgnoreCase("a")) {
     			customerDetails();
     			} else {
     				addCustDetails();
     			}
     			break;
     		case "b" :
     			System.out.println("What would you like to do?");
     			System.out.println("\nA.View account details \nB.Add account details");
     			String accChoice = scan.nextLine();
     			if(accChoice.equalsIgnoreCase("a")) {
     				accountDetails();
     			} else {
     				addAccDetails();
     			}
     			break;
     		case "c" :
     			System.out.println("What would you like to do?");
     			System.out.println("\nA.View branch details \nB.Add branch details");
     			String bChoice = scan.nextLine();
     			if (bChoice.equalsIgnoreCase("a")) {
     				branchDetails();
     			} else {
     				addBrDetails();
     			}
     			break;
     		case "d" :
     			System.out.println("Loans: ");
     			loans();
     			break;
     		case "e" :
     			System.out.println("Transaction details: ");
     			tranDetails();
     			break;
     		case "f" :
     			System.out.println("You have been logged out.");
     			break;
     		}
		}
		
	
	
	public static void customerDetails() {
			try 
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer");
				
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ rs.getString(4)+ " " 
			                       + rs.getString(5)+ " " + rs.getString(6)+ " " + rs.getString(7)+ " " + rs.getString(8));
			}
				con.close();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			admin();
	}
	
	
	public static void addCustDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the customer details:");
		System.out.println("Customer ID:");
		String custId = scan.nextLine();
		System.out.println("First name:");
		String fname = scan.nextLine();
		System.out.println("Middle name:");
		String mname = scan.nextLine();
		System.out.println("Last name:");
		String lname = scan.nextLine();
		System.out.println("City");
		String city = scan.nextLine();
		System.out.println("Mobile number (10 digits):");
		String mobileno = scan.nextLine();
		System.out.println("Occupation");
		String job = scan.nextLine();
		System.out.println("Date Of Birth yyyy-mm-DD");
		String dob = scan.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?);");
			stmt.setString(1, custId);
			stmt.setString(2, fname);
			stmt.setString(3, mname);
			stmt.setString(4, lname);
			stmt.setString(5, city);
			stmt.setString(6, mobileno);
			stmt.setString(7, job);
			stmt.setString(8, dob);
			
			int i = stmt.executeUpdate();
			System.out.println(i+" account added");
			
			con.close();
		}
			catch (Exception e) {
				System.out.println(e);
			}
		
		admin();
		
	}
	
	public static void accountDetails() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ rs.getString(4)+ " " 
			                                      + rs.getString(5)+ " " + rs.getString(6)+ " " + rs.getString(7));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		admin();
	}
	
	public static void addAccDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account details:");
		System.out.println("Account number:");
		String acnumber = scan.nextLine();
		System.out.println("Customer ID:");
		String custid = scan.nextLine();
		System.out.println("Branch ID:");
		String bid = scan.nextLine();
		System.out.println("Opening balance:");
		String opbalance = scan.nextLine();
		System.out.println("Date acoount was opened yyyy-MM-dd:");
		String aod = scan.nextLine();
		System.out.println("Account type:");
		String atype = scan.nextLine();
		System.out.println("Account status");
		String astatus = scan.nextLine();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO account VALUES(?,?,?,?,?,?,?);");
			stmt.setString(1, acnumber);
			stmt.setString(2, custid);
			stmt.setString(3, bid);
			stmt.setString(4, opbalance);
			stmt.setString(5, aod);
			stmt.setString(6, atype);
			stmt.setString(7, astatus);
		
			
			int i = stmt.executeUpdate();
			System.out.println(i+" account added");
			
			con.close();
		}
			catch (Exception e) {
				System.out.println(e);
			}
		admin();
	}
	
	
	public static void branchDetails() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from branch");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		admin();
	}
	
	public static void addBrDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the branch details:");
		System.out.println("Branch ID:");
		String bid = scan.nextLine();
		System.out.println("Branch name:");
		String bname = scan.nextLine();
		System.out.println("Branch city:");
		String bcity = scan.nextLine();
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO branch VALUES(?,?,?);");
			stmt.setString(1, bid);
			stmt.setString(2, bname);
			stmt.setString(3, bcity);
			
			int i = stmt.executeUpdate();
			System.out.println(i+" account added");
			
			con.close();
		}
			catch (Exception e) {
				System.out.println(e);
			}
		admin();
	}
	
	public static void loans() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from loan");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		admin();
	}
	
	public static void tranDetails() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from trandetails");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		admin();
	}
	
	
	
	public static void user() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhat would you like to do?");
		System.out.println("\nA.Withdraw money \nB.Deposit money \nC.Take out a loan \nD.Exit");
		String userChoice = scan.nextLine();
		if (userChoice.equalsIgnoreCase("A")) {
			withdraw();
		} else if (userChoice.equalsIgnoreCase("B")) {
			deposit();
		} else if (userChoice.equalsIgnoreCase("C")){
			loan();
		} else {
			System.out.println("You have been logged out.");
		}
	}
	
	
	public static void withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your transaction number:");
		String tnum = scan.nextLine();
		System.out.println("Enter your account number:");
		String acno = scan.nextLine();
		System.out.println("Enter the date (yyyy-mm-dd):");
		String today = scan.nextLine();
		System.out.println("Do you want to withdraw cash or a cheque?");
		String tranType = scan.nextLine();
		System.out.println("How much money would you like to withdraw?");
		int amount = scan.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO trandetails VALUES(?,?,?,?,?,?);");
			stmt.setString(1, tnum);
			stmt.setString(2, acno);
			stmt.setObject(3, today);
			stmt.setString(4, tranType);
			stmt.setString(5, " Withdrawal");
			stmt.setLong(6, amount);
			
			int i = stmt.executeUpdate();
			System.out.println(i+" account added");
			
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		System.out.println("You have withdrawn £" +amount +" from your account.");
		user();
	}
	
	public static void deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your transaction number:");
		String tnum = scan.nextLine();
		System.out.println("Enter your account number:");
		String acno = scan.nextLine();
		System.out.println("Enter the date (yyyy-mm-dd):");
		String today = scan.nextLine();
		System.out.println("Do you want to deposit cash or a cheque?");
		String tranType = scan.nextLine();
		System.out.println("How much money would you like to deposit into your account?");
		int amount = scan.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Dyamond1Icyy!");
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO trandetails VALUES(?,?,?,?,?,?);");
			stmt.setString(1, tnum);
			stmt.setString(2, acno);
			stmt.setObject(3, today);
			stmt.setString(4, tranType);
			stmt.setString(5, " Deposit");
			stmt.setLong(6, amount);
			
			int i = stmt.executeUpdate();
			System.out.println(i+" account added");
			
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		System.out.println("You have deposited £" +amount +" into your account.");
		user();
	}
	
	public static void loan() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much do you want to take out?");
		int loanAmt = scan.nextInt();
		if (loanAmt > 1) {
			System.out.println("Sorry you are not eligible to take out a loan for this amount.");
			user();
		}
	}
}

