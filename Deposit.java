package package1;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Deposit {
	static Scanner scan=new Scanner(System.in);
	public static void deposit()
	{
		try
		{
			System.out.println(" AMOUNT DEPOSIT ");
			Connection con=DataBaseConnection.getConnection();
			System.out.println("ENTER CARD_NO");
			long lt=scan.nextLong();
		    String st="update users set balance=balance + ? where card_no=?";
		    PreparedStatement pt=con.prepareStatement(st);
		    System.out.println("ENTER AMOUNT:");
		    double d=scan.nextDouble();
		    pt.setDouble(1, d);
		    pt.setLong(2, lt);
		   
		    pt.executeUpdate();
		    System.out.println("DEPOSIT SUCCESSFUL");
		    pt.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deposit obj=new Deposit();
		obj.deposit();

	}

}
