package ѧ������ϵͳ;

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
		   JOptionPane.showMessageDialog(null, "ע��ɹ�");
	   }else {
		   JOptionPane.showConfirmDialog(null, "�����˺�λ��Ϊ10λ��������ע�ᣡ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	   }
 }
   public void zc2(String a,String b) throws Exception{
	   String zh2;
	   //����Ա�˺�����
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
		   JOptionPane.showMessageDialog(null, "ע��ɹ�");
	   }else {
		   JOptionPane.showConfirmDialog(null, "�����˺�λ��Ϊ10λ�����ظ��˺ţ�������ע�ᣡ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	   }
   }
   
   
}
