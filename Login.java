package package1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

public class Login {
static Scanner scan=new Scanner(System.in);
	
	public static boolean accountlogin()
	{
		System.out.println("  <>  WELCOME TO-ATM (Automated Teller Machine)   <>");
		System.out.println("__________________________________________________________");
		  System.out.println(" ENTER CARD_NO & PIN_NO" );
	
		try
		{
			Connection con= DataBaseConnection.getConnection();
			String s1 = "SELECT * FROM users WHERE card_no = ? AND pin_no = ?";

		PreparedStatement pt=con.prepareStatement(s1);
		System.out.println("CARD_NO:");
	long a=scan.nextLong();
	
		pt.setLong(1,a);
		
		System.out.println("enter pin_number");
		int  b=scan.nextInt();
		pt.setInt(2,b);
	ResultSet rt=pt.executeQuery();
	 if (rt.next()) {
         System.out.println("Login Successful ✅");
         TransactionType.transactiontype();
         System.out.println("_______________________________________");
         System.out.println("Enter s_no To Use Transaction");
         int f=scan.nextInt();
         switch(f)
         {
         case 1:
         {
          System.out.println("_______________________________________");
    		 
        	 CheckBalance.balancechecking();
        	 System.out.println("\"Thank you for using the ATM. Have a nice day!");
        	 break;
        	 
         }
         case 2:
         {
        	 System.out.println("_______________________________________");
        	 CashWithDraw.withdraw();
        	 System.out.println("\"Thank you for using the ATM. Have a nice day!");
        	 break;
         }
         case 3:
         {
        	 System.out.println("_______________________________________");
        	 Deposit.deposit();
        	 System.out.println("\"Thank you for using the ATM. Have a nice day!");
        	 break;
         }
         case 4:
         {
        	 System.out.println("\"Thank you for using the ATM. Have a nice day!");
         }
         default:
         {
        	 System.out.println("Invalid option! Please choose a valid transaction.");
         }

         }
         
         
         return true;
     } else {
         System.out.println("Invalid Card Number or PIN ❌");
         return false;
     }	
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login obj=new Login();
		obj.accountlogin();

	}

}
