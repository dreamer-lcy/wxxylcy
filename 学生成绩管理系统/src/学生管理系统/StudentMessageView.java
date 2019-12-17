package 学生管理系统;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class StudentMessageView {
	JFrame jm;
	JButton an1,an2,an3;
	JTable jta;
	JScrollPane jsc;
	Object[] columnNames= {"学号","名字","班级","数学","语文","英语","理综"};
	String[][] str=new String[100][7];
	
	public void messageView()  throws Exception{
	       
	       jm=new JFrame("学生信息");
		   an3=new JButton("管理学生信息");an3.setBounds(100, 650, 180, 60);
		   an3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new AdministratorView().Guanliyuanjiemian();
			}
		});
		   an1=new JButton("查询");an1.setBounds(700,650, 100, 60);
		   an1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xx();				
			}
		});
		   
			
		   jm.setLayout(null);
		   
		   jta=new JTable(str,columnNames);
		   jta.setShowHorizontalLines(false);
		   jta.setShowVerticalLines(false);
		   /*
		    * DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		    *  r.setHorizontalAlignment(JLabel.CENTER);
		        *  将JTable中的数据居中显示
		    */
		   DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		   r.setHorizontalAlignment(JLabel.CENTER);
		   jta.setDefaultRenderer(Object.class, r);
		   jsc=new JScrollPane(jta);
		   jta.setBounds(0, 100, 900, 600);
		   jsc.setSize(900, 600);
		   jm.add(jsc);
		   jm.add(an1);
           jm.add(an3);
        
        
		   jm.setBounds(600, 400, 1000, 800);
		   jm.setVisible(true);
		   jm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		      
}
	public void xx() {
		  Connection conn = null;
		Statement state = null;
		String sql="select * from Studentgrade;";
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
				str[i][j]=rs.getString(4);j++;
				str[i][j]=rs.getString(5);j++;
				str[i][j]=rs.getString(6);j++;
				str[i][j]=rs.getString(7);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	  }
}
