package package1;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class TransactionType {
	Scanner scan=new Scanner(System.in);
	static ArrayList<String> ar=new ArrayList<String>(Arrays.asList("BalanceInquiry","CashWithdrawal","DepositCash","Exit"));
	  public static  void transactiontype()
  {
	  try
	  {  
		  System.out.println("  **** ATM-Services ****");
		  for(int i=0;i<ar.size();i++)
		  {
			  System.out.println( "    " +(i+1) +":"+ar.get(i));
		  } }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	   }
  
public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransactionType obj=new TransactionType();
		

	}

}
