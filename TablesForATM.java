package package1;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class TablesForATM {
	
	
	
	public static  void m1()
	{
		Connection con=null;
		Statement st=null;
		PreparedStatement pt=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String s="system";
		String p="tiger";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection(url,s,p);
			 st=con.createStatement();
			 String t1="create table users(card_no number(20) primary key,pin_no  number(5) unique,user_name varchar2(30) not null,balance number(15,2) check(balance>=0.00))";	
	    //     st.executeUpdate(t1);
	       
	         String t2="create table transactions (transaction_id number(15)   primary key,card_no number(20) references users(card_no) on delete cascade,type varchar2(50) check(type in('Deposit','withdraw')) ,amount number(12,2) not null,timestamp timestamp default current_timestamp)";
			// st.executeUpdate(t2);
	         System.out.println("table created");
	         String t3 = "INSERT ALL "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (1234567890123456, 1234, 'John Doe', 5000.00) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (2345678901234567, 2345, 'Jane Smith', 10000.00) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (3456789012345678, 3456, 'Alice Johnson', 7500.50) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (4567890123456789, 4567, 'Bob Brown', 3000.00) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (1111222233334444, 1237, 'John Doe', 10000.00) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (9999000011112222, 3486, 'Alice Johnson', 5000.00) "
	        	        + "INTO users (card_no, pin_no, user_name, balance) VALUES (3333444455556666, 4566, 'Bob Brown', 2500.00) "
	        	        + "SELECT * FROM dual";
	         pt=con.prepareStatement(t3);
	        
	     //    pt.executeUpdate();
	         String t4 = "INSERT ALL "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (1, 1234567890123456, 'Deposit', 2000.00, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (2, 2345678901234567, 'withdraw', 1500.00, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (3, 3456789012345678, 'Deposit', 2500.50, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (4, 4567890123456789, 'withdraw', 1000.00, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (5, 1111222233334444, 'Deposit', 3000.00, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (6, 9999000011112222, 'withdraw', 500.00, CURRENT_TIMESTAMP) "
	        	        + "INTO transactions (transaction_id, card_no, type, amount, timestamp) VALUES (7, 3333444455556666, 'Deposit', 1200.00, CURRENT_TIMESTAMP) "
	        	        + "SELECT * FROM dual";

	        	// Use Statement instead of PreparedStatement
	        	 st = con.createStatement();
	        	st.executeUpdate(t4);
	        	System.out.println("Transactions inserted successfully");

	   pt.executeUpdate(t4);

	         
	         System.out.println("data inserted");
	         
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TablesForATM  obj=new TablesForATM ();
		obj.m1();

	}

}
