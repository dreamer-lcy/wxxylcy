package 学生管理系统;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class zhuce {
   public void zc(String a,String b) throws Exception{
	 String zh  ; 

	 if(Long.parseLong(a)>=999999999&&Long.parseLong(a)<10000000000L) {
		   Connection conn=JDBCDemo.open();
		   Statement state=conn.createStatement();
		   String sql="select * from zhuce";
		   PreparedStatement state1=conn.prepareStatement(sql);
		   ResultSet rs=state1.executeQuery();
		   while(rs.next()) {
			   zh=rs.getString(1);
		   }
		   state.executeUpdate("insert  zhuce(user_stu,password) values('"+a+"','"+b+"');");
		   JDBCDemo.close(conn);
		   JOptionPane.showMessageDialog(null, "注册成功");
	   }else {
		   JOptionPane.showConfirmDialog(null, "错误，账号位数为10位，请重新注册！！", "提示", JOptionPane.INFORMATION_MESSAGE);
	   }
 }
   public void zc2(String a,String b) throws Exception{
	   String zh2;
	   //管理员账号密码
	   if(Long.parseLong(a)>=999999999&&Long.parseLong(a)<10000000000L) {
		   Connection conn=JDBCDemo.open();
		   Statement state=conn.createStatement();
		   String sql="select * from zhuce2";
		   PreparedStatement state1=conn.prepareStatement(sql);
		   ResultSet rs=state1.executeQuery();
		   while(rs.next()) {
				 zh2=rs.getString(1);
			   }
		   state.executeUpdate("insert  zhuce2(uesr_tea,password) values('"+a+"','"+b+"');");
		   JDBCDemo.close(conn);
		   JOptionPane.showMessageDialog(null, "注册成功");
	   }else {
		   JOptionPane.showConfirmDialog(null, "错误，账号位数为10位或有重复账号，请重新注册！！", "提示", JOptionPane.INFORMATION_MESSAGE);
	   }
   }
   
   
}
