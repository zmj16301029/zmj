package serv;
import java.sql.*;
public class Connect
{
	private static String DRVIER = "oracle.jdbc.OracleDriver";
	static final String USER = "c##16301029";
	static final String PASS = "123456";
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:zmj16301029";
	
	public static Connection connect()
    {
    	// 创建用于连接数据库的Connection对象
    	Connection con = null;
    	try 
    	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
    	catch (ClassNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 加载Oracle驱动程序
    	try 
    	{
			con = DriverManager.getConnection(URL, USER, PASS);
		} 
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 获取连接
    	return con;
    }
}
