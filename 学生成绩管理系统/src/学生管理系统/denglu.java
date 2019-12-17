package 学生管理系统;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class denglu {
	
   public void dl(String a,String b) throws Exception{
	 Connection conn=JDBCDemo.open();
	   Statement state=conn.createStatement();
	   ResultSet s1=state.executeQuery("select password  from zhuce2 where user_tea='"+a+"';");
	   String s2 = null;
	   while(s1.next()) {
		    s2=s1.getString(1);
	   }
	   if(b.equals(s2)) { 
		   new StudentMessageView().messageView();
	  }else{
		   JOptionPane.showConfirmDialog(null, "登陆失败，账号或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
           new loadingView().Jp1();
	   }
	   JDBCDemo.close(conn);
   }
   
   public void dl2(String a,String b) throws Exception{
	   Connection conn=JDBCDemo.open();
	   Statement state=conn.createStatement();
	   ResultSet s1=state.executeQuery("select password  from zhuce where user_stu='"+a+"';");
	   String s2 = null;
	   while(s1.next()) {
		    s2=s1.getString(1);
	   }
	   if(b.equals(s2)) {
		   new StudentView();
	   }else{
		   JOptionPane.showConfirmDialog(null, "登陆失败，账号或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
           new loadingView().Jp1();
	   }
	   JDBCDemo.close(conn);
   }
}


