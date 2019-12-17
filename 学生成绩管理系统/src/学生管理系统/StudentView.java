package 学生管理系统;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class StudentView implements ActionListener{
    JLabel lable1,lable2,lable3,lable4,lable5,lable6,lable7,lable8,lable9,lable10;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    JButton but1,but2;
    JFrame jf=new JFrame("学生查询系统");
	String[] a2= {" ","高一","高二","高三"};
	JComboBox comboBox2 = new JComboBox(a2);
	String f;
	
	StudentView(){
		
		lable1=new JLabel("学 号："); lable1.setBounds(365, 24, 50, 30);
		lable2=new JLabel("姓 名："); lable2.setBounds(100, 80, 50, 30);
		lable3=new JLabel("班级："); lable3.setBounds(365, 83, 50, 30);
		lable4=new JLabel("数学："); lable4.setBounds(97, 142, 105, 30);
		lable5=new JLabel("语文："); lable5.setBounds(97, 199, 105, 30);
		lable6=new JLabel("英语：");lable6.setBounds(362, 149, 105, 30);
		lable7=new JLabel("理综：");lable7.setBounds(361, 205, 105, 30);
		lable9=new JLabel("总分：");lable9.setBounds(204, 240, 105, 30);
		lable10=new JLabel("年级：");lable10.setBounds(100,24,50,30);
		comboBox2.setBounds(170, 25, 150, 30);
		String picPath="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"学生查询.jpg";
   	    Icon  icon = new ImageIcon(picPath);
   	    lable8=new JLabel(icon);lable8.setBounds(0, 0, 700, 400);

		txt1=new JTextField(10); txt1.setBounds(419, 25, 150, 30);
		txt2=new JTextField(10); txt2.setBounds(170, 80, 150, 30);
		txt3=new JTextField(10); txt3.setBounds(419, 83, 150, 30);
		txt4=new JTextField(10);  txt4.setBounds(168, 147, 150, 30);
		txt5=new JTextField(10); txt5.setBounds(168, 201, 150, 30);
		txt6=new JTextField(10); txt6.setBounds(421, 149, 150, 30);
		txt7=new JTextField(10); txt7.setBounds(421, 205, 150, 30);
		txt8=new JTextField(10); txt8.setBounds(288, 240, 150, 30);
		
		but1=new JButton("查询");but1.setBounds(408, 300, 60, 30);
		but2=new JButton("退出");but2.setBounds(250, 300, 60, 30);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		comboBox2.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	       f=(String)e.getItem();
	            }
	    });
		jf.setLayout(null);
		
		jf.add(lable1); jf.add(txt1);
		jf.add(lable2); jf.add(txt2);
		jf.add(lable3); jf.add(txt3);
		jf.add(lable4); jf.add(txt4);
		jf.add(lable5); jf.add(txt5);
		jf.add(lable6); jf.add(txt6);
		jf.add(lable7); jf.add(txt7);
		jf.add(lable9); jf.add(txt8);
		jf.add(lable10);
		jf.add(but1); jf.add(but2);
		jf.add(comboBox2);
		jf.add(lable8);
	
		
		jf.setBounds(400, 200, 700, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==but1) {
			Connection conn;
			try {
				conn = JDBCDemo.open();
				String sql="select 姓名,班级,数学,语文,英语,理综,总分  from "+f+"  where 学号=?;";
			    PreparedStatement state=conn.prepareStatement(sql);
			    state.setString(1, txt1.getText());
			    ResultSet rs=state.executeQuery();
			    while(rs.next()) {
			    	txt2.setText(rs.getString(1));
			    	txt3.setText(rs.getString(2));
			    	txt4.setText(rs.getString(3));
			    	txt5.setText(rs.getString(4));
			    	txt6.setText(rs.getString(5));
			    	txt7.setText(rs.getString(6));
			    	txt8.setText(rs.getString(7));
			    }
			    
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==but2) {
			System.exit(0);
		}
	}
}
