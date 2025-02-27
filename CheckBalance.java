package package1;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CheckBalance {
	static Scanner scan=new Scanner(System.in);
	public static void balancechecking()
	{
		try {
			Connection con=DataBaseConnection.getConnection();
			System.out.println("CHECKING_BALANCE");
			System.out.println("ENTER CARD_NO & PIN_NO");
			String s="select  user_name, balance from  users where card_no=?";
			PreparedStatement pt=con.prepareStatement(s);
			System.out.println("enter card_no");
			long a=scan.nextLong();
			pt.setLong(1,a);
			 
			ResultSet rt=pt.executeQuery();
			if (rt.next()) {
		        	System.out.println("USER_NAME : "+rt.getString("user_name"));
					System.out.println("BALANCE   :  "+rt.getDouble("balance"));
				 } else {
		         System.out.println("Invalid Card Number");
		      }	
				}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBalance obj=new CheckBalance();
		obj.balancechecking();

	}

}
