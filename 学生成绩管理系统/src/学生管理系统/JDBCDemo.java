package 学生管理系统;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo{
   static String driver;
   static String url;
   static String user;
   static String password;
   
   static {
	   driver="com.mysql.cj.jdbc.Driver";
	   url="jdbc:mysql://localhost:3306/xuesheng?serverTimezone=UTC";
	   user="root";
	   password="123456";
   }
   public static Connection open() throws  Exception{
	   Class.forName(driver); 
	   return DriverManager.getConnection(url, user, password);
   }
   public static void close(Connection conn) throws Exception {
	   if(conn!=null) {
		   conn.close();
	   }
   }
}
