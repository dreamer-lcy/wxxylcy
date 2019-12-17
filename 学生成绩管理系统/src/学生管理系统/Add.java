package 学生管理系统;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Add implements ActionListener{
	JTable l1;
	JFrame f1;
	JButton b1,b2;
	Object[] columnNames= {"学号","姓名","班级","数学","语文","英语","理综"};
	String[][] str=new String[100][7];
	String r;
	
	public Add() {
		f1=new JFrame("添加学生信息");
		l1=new JTable(str,columnNames);
		b1=new JButton("返回");
		b2=new JButton("添加");
		b1.setBounds(100, 650, 100, 60);
		b2.setBounds(700,650, 100, 60);
		l1.setShowHorizontalLines(false);
		l1.setShowVerticalLines(false);
		b2.addActionListener(this);
		b1.addActionListener(this);
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		l1.setDefaultRenderer(Object.class, r);
		JScrollPane jsc = new JScrollPane(l1);
		l1.setBounds(400, 200, 980, 600);
		jsc.setSize(980, 600);
		f1.setLayout(null);
		f1.add(jsc);
		f1.add(b1);
		f1.add(b2);
		f1.setBounds(400, 200, 1000, 800);		  
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		      
	}

	public void td(String a, String s) {
		 Connection conn = null;
			Statement state = null;
			f1.setTitle(a+""+s); 
			f1.setVisible(true);
			//new Add();
			String sql="select * from "+a+" where 班级='"+s+"';";
			ResultSet rs = null;
			
			try {
				conn = JDBCDemo.open();
				state = conn.createStatement();
				rs = state.executeQuery(sql);
				int i=0;
				while(rs.next()) {
					int j=0;
					str[i][j]=rs.getString(1);j++;
					str[i][j]=rs.getString(2);j++;
					str[i][j]=rs.getString(3);j++;
					
					i++;
					
				}
		      JDBCDemo.close(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			r=a;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==b2) {
		// TODO Auto-generated method stub
		Connection conn;
		try {
			conn = JDBCDemo.open();
		for(int i=0;i<str.length;i++) {
       
			String sql="update "+r+" set 数学=? where 学号=?;";
		    PreparedStatement state=conn.prepareStatement(sql);         
            state.setString(2, str[i][0]);
            state.setString(1, str[i][3]);
            state.executeUpdate();
            String sql0="update  "+r+" set 语文=? where 学号=?;";
		    PreparedStatement state0=conn.prepareStatement(sql0);         
            state0.setString(2, str[i][0]);
            state0.setString(1, str[i][4]);
            state0.executeUpdate();
            String sql1="update  "+r+" set 英语=? where 学号=?;";
		    PreparedStatement state1=conn.prepareStatement(sql1);         
            state1.setString(2, str[i][0]);
            state1.setString(1, str[i][5]);
            state1.executeUpdate();
            String sql2="update  "+r+" set 理综=? where 学号=?;";
		    PreparedStatement state2=conn.prepareStatement(sql2);         
            state2.setString(2, str[i][0]);
            state2.setString(1, str[i][6]);
            state2.executeUpdate();
            String sql3="select 数学,语文,英语,理综  from "+r+" where 学号=?;";
            PreparedStatement state3=conn.prepareStatement(sql3);
            state3.setString(1, str[i][0]);
            ResultSet rs=state3.executeQuery();
            int Z = 0;
            int X = 0;
            int C = 0;
            int V = 0;
            while(rs.next()) {
            	 Z=rs.getInt(1);
            	 X=rs.getInt(2);
            	 C=rs.getInt(3);
            	 V=rs.getInt(4);
            }
            double sum=Z+X+C+V;
            String sql4="update  "+r+" set 总分=? where 学号=?;";
		    PreparedStatement state4=conn.prepareStatement(sql4);         
           state4.setString(2, str[i][0]);
           state4.setString(1, String.valueOf(sum));
           state4.executeUpdate();
  
			}
		 JDBCDemo.close(conn);
         JOptionPane.showMessageDialog(null, "添加成功");
		}catch (Exception e1) {
		e1.printStackTrace();
	}
		}
		if(arg0.getSource()==b1) {
			try {
				f1.dispose();
				new 	AdministratorView().Guanliyuanjiemian();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
}

}