package package1;
import java.sql.DriverManager;
import java.sql.Connection;
public class DataBaseConnection {
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static  final String s="system";
	private static final String p="tiger";
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(url,s,p);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
