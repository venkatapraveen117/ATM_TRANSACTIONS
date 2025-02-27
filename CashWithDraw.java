package package1;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class CashWithDraw {
	static Scanner scan=new Scanner(System.in);
	public static void withdraw()
	{
		try
		{
			Connection con=DataBaseConnection.getConnection();
			System.out.println("WITHDRAW AMOUNT");
			System.out.println("ENTER CARD_NO:");
			  long a=scan.nextLong();
			  scan.nextLine();
			  String b="select*from users where card_no=?";
			  PreparedStatement pt=con.prepareStatement(b);
			  pt.setLong(1, a);
			  ResultSet rt=pt.executeQuery();
			  
			  if(rt.next())
			  {
				  System.out.println("NAME :"+rt.getString("user_name"));
				  System.out.println("ACCOUNT_BALANCE :"+rt.getDouble("balance"));
				  System.out.println("ENTER AMOUNT: ");
				 
			  int c=scan.nextInt();
	
			  
			  System.out.println("WITHDRAW SUCCESSFULL");
			  
				  String g="update users set balance=balance -? where card_no=?";
				  PreparedStatement st=con.prepareStatement(g);
				  st.setInt(1, c);
				  st.setLong(2,a);
				  
				  st.executeUpdate();
				  String d="select balance from users where card_no=?";
				 
				  PreparedStatement bt = con.prepareStatement(d);
				  bt.setLong(1, a);
				  ResultSet jt = bt.executeQuery();
				  
				
				 
				  while(jt.next())
				  {
					  System.out.println("UPDATED_ACCOUNT_BALANCE:"+jt.getDouble("balance"));
				  }
				  }
			  con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CashWithDraw obj=new CashWithDraw();
		obj.withdraw();

	}

}
