package ѧ������ϵͳ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class StudentMessageView {
	JFrame jm;
	JButton an1,an2,an3;
	JTable jta,jta1,jta2,jta3;
	JScrollPane jsc,jsc1,jsc2,jsc3;
	JTextField txt1;
	Object[] columnNames= {"ѧ��","����","�༶","��ѧ","����","Ӣ��","����","�ܷ�"};
	Object[] columnNames1= {"ѧ��","����","�༶","��ѧ"};
	Object[] columnNames2= {"ѧ��","����","�༶","����"};
	Object[] columnNames3= {"ѧ��","����","�༶","Ӣ��"};
	String[][] str=new String[100][8];
	String[][] str1=new String[100][4];
	String[][] str2=new String[100][4];
	String[][] str3=new String[100][4];
	JComboBox jcb1,jcb2,jcb3,jcb4;
	String[] a1= {" ","��һ","�߶�","����"};
	String[] a2= {" ","1��","2��","3��"};
	String[] a3= {" ","����","��ѧ","Ӣ��","ȫ����Ŀ"};
	String[] a4= {" ","������","ȫ��"};

	String s1=null,s2=null,ss=null;
	String s3;
	int s4=0,s5=0;
	public void messageView()  throws Exception{
	       
	       jm=new JFrame("ѧ����Ϣ");
		   an3=new JButton("����ѧ����Ϣ");an3.setBounds(100, 650, 180, 60);
		   jcb1=new JComboBox(a1);
		   jcb2=new JComboBox(a2);
		   jcb3=new JComboBox(a3);
		   jcb4=new JComboBox(a4);
		  
		   jcb1.setBorder(BorderFactory.createTitledBorder("�꼶"));
		   jcb2.setBorder(BorderFactory.createTitledBorder("�༶"));
		   jcb3.setBorder(BorderFactory.createTitledBorder("��Ŀ"));
		   jcb4.setBorder(BorderFactory.createTitledBorder("������"));
		   
		   jcb1.setBounds(500, 650, 100, 50);
		   jcb2.setBounds(600, 650, 100, 50);
		   jcb3.setBounds(700, 650, 100, 50);
		   jcb4.setBounds(800, 650, 100, 50);
		   jcb1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				  s1=(String)e.getItem();
			}
			   
		   });
		   jcb2.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					s2=(String)e.getItem();
				}
				   
			   });
		   jcb3.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					s3=(String) e.getItem();
				   }
			   });
		   jcb4.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					String ss=(String) e.getItem();
					if("������".equals(ss)) {
						s5=80;
					}
					if("ȫ��".equals(ss)) {
						s5=150;
					}
				   }
			   });
		   
		   an3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jm.dispose();
				new AdministratorView().Guanliyuanjiemian();
			}
		});
		   an1=new JButton("��ѯ");an1.setBounds(380,650, 100, 60);
		   an1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("��ѧ".equals(s3)) {
					jsc.setVisible(false);
					jsc1.setVisible(true);
					jsc2.setVisible(false);
					jsc3.setVisible(false);
					jcb4.setVisible(true);
					
					jm.setTitle(s1+""+s2+"��ѧ");
					xx1();
					s5=0;
				}
				if("����".equals(s3)) {
					jsc.setVisible(false);
					jsc1.setVisible(false);
					jsc2.setVisible(true);
					jsc3.setVisible(false);
					jcb4.setVisible(true);
					
					jm.setTitle(s1+""+s2+"����");
					xx2();
					s5=0;
					
				}
				if("Ӣ��".equals(s3)) {
					jsc.setVisible(false);
					jsc1.setVisible(false);
					jsc2.setVisible(false);
					jsc3.setVisible(true);
					jcb4.setVisible(true);
					
					jm.setTitle(s1+" "+s2+"Ӣ��");
					xx3();
					s5=0;
				}
				if("ȫ����Ŀ".equals(s3)) {
					jsc.setVisible(true);
					jsc1.setVisible(false);
					jsc2.setVisible(false);
					jsc3.setVisible(false);
					jcb4.setVisible(false);
					
					jm.setTitle(s1+" "+s2);
					xx();
				}
				if(s3==null) {
					jsc.setVisible(true);
					jsc1.setVisible(false);
					jsc2.setVisible(false);
					jsc3.setVisible(false);
					jcb4.setVisible(false);
					
					jm.setTitle(s1+" "+s2);
					xx();
					if(s2==null&&s3==null)
					{
						jsc.setVisible(true);
						jsc1.setVisible(false);
						jsc2.setVisible(false);
						jsc3.setVisible(false);
						jcb4.setVisible(false);
						jm.setTitle(s1+"");
						xx4();
					}
				}
			
								
			}
		});
		   jm.setLayout(null);
		   
		   jta=new JTable(str,columnNames);
		   jta.setShowHorizontalLines(false);
		   /*
		    * DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		    *  r.setHorizontalAlignment(JLabel.CENTER);
		        *  ��JTable�е����ݾ�����ʾ
		    */
		   jta.setShowVerticalLines(false);
		  
		   DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		   r.setHorizontalAlignment(JLabel.CENTER);
		   jta.setDefaultRenderer(Object.class, r);
		   jsc=new JScrollPane(jta);
		   jta.setBounds(400, 200, 980, 600);
		   
		   jta1=new JTable(str1,columnNames1);
		   jta1.setShowHorizontalLines(false);
		   jta1.setShowVerticalLines(false);
		  
		   DefaultTableCellRenderer r1=new DefaultTableCellRenderer();
		   r1.setHorizontalAlignment(JLabel.CENTER);
		   jta1.setDefaultRenderer(Object.class, r1);
		   jsc1=new JScrollPane(jta1);
		   jta1.setBounds(400, 200, 980, 600);
		   /*
		    * DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		    *  r.setHorizontalAlignment(JLabel.CENTER);
		        *  ��JTable�е����ݾ�����ʾ
		    */
		   jta2=new JTable(str2,columnNames2);
		   jta2.setShowHorizontalLines(false);
		   jta2.setShowVerticalLines(false);
		  
		   DefaultTableCellRenderer r2=new DefaultTableCellRenderer();
		   r2.setHorizontalAlignment(JLabel.CENTER);
		   jta2.setDefaultRenderer(Object.class, r2);
		   jsc2=new JScrollPane(jta2);
		   jta2.setBounds(400, 200, 980, 600);
		    /*
		    * DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		    *  r.setHorizontalAlignment(JLabel.CENTER);
		        *  ��JTable�е����ݾ�����ʾ
		    */
		   jta3=new JTable(str3,columnNames3);
		   jta3.setShowHorizontalLines(false);
		   jta3.setShowVerticalLines(false);
		  
		   DefaultTableCellRenderer r3=new DefaultTableCellRenderer();
		   r3.setHorizontalAlignment(JLabel.CENTER);
		   jta3.setDefaultRenderer(Object.class, r3);
		   jsc3=new JScrollPane(jta3);
		   jta3.setBounds(400, 200, 980, 600);
		   jsc.setSize(980, 600);
		   jsc1.setSize(980, 600);
		   jsc2.setSize(980, 600);
		   jsc3.setSize(980, 600);
		   jm.add(jsc);
		   jm.add(jsc1);
		   jm.add(jsc2);
		   jm.add(jsc3);
		   jm.add(an1);
           jm.add(an3);
          
           jm.add(jcb1);
           jm.add(jcb2);
           jm.add(jcb3);
           jm.add(jcb4);
       
          jcb4.setVisible(false);
		   jm.setBounds(400, 20, 1000, 800);
		   jm.setVisible(true);
		   jm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		      
}   

	public void xx4() {
		Connection conn = null;
		Statement state = null;
		String sql="select * from "+s1+"  order by �ܷ� desc;";
		ResultSet rs = null;
		
		try {
			conn = JDBCDemo.open();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			int i=0;
			for(int o=0;o<100;o++)
			{
				int p=0;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   p=0;
			}
			while(rs.next()) {
				int j=0;
				str[i][j]=rs.getString(1);j++;
				str[i][j]=rs.getString(2);j++;
				str[i][j]=rs.getString(3);j++;
				str[i][j]=rs.getString(4);j++;
				str[i][j]=rs.getString(5);j++;
				str[i][j]=rs.getString(6);j++;
				str[i][j]=rs.getString(7);j++;
				str[i][j]=rs.getString(8);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	  }
	public void xx() {
		Connection conn = null;
		Statement state = null;
		String sql="select * from "+s1+" where �༶='"+s2+"' order by �ܷ� desc;";
		ResultSet rs = null;
		
		try {
			conn = JDBCDemo.open();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			int i=0;
			for(int o=0;o<100;o++)
			{
				int p=0;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   str[o][p]=null;p++;
			   p=0;
			}
			while(rs.next()) {
				int j=0;
				str[i][j]=rs.getString(1);j++;
				str[i][j]=rs.getString(2);j++;
				str[i][j]=rs.getString(3);j++;
				str[i][j]=rs.getString(4);j++;
				str[i][j]=rs.getString(5);j++;
				str[i][j]=rs.getString(6);j++;
				str[i][j]=rs.getString(7);j++;
				str[i][j]=rs.getString(8);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	  }
	public void xx1() {
		Connection conn = null;
		Statement state = null;
		String sql = null;
		if("��ѧ".equals(s3)&&s4==0&&s5==0)
			sql="select ѧ��,����,�༶,��ѧ from "+s1+" where �༶='"+s2+"' and ��ѧ order by "+s3+" desc;";
		else if(s5!=0)
			{sql="select  ѧ��,����,�༶,��ѧ  from "+s1+" where �༶='"+s2+"'and ��ѧ  between "+s4+" and "+s5+";";
}
		ResultSet rs = null;
		try {
			conn = JDBCDemo.open();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			int i=0;
			for(int o=0;o<100;o++)
			{
				int p=0;
			   str1[o][p]=null;p++;
			   str1[o][p]=null;p++;
			   str1[o][p]=null;p++;
			   str1[o][p]=null;p++;
			   p=0;
			}
			while(rs.next()) {
				int j=0;
				str1[i][j]=rs.getString(1);j++;
				str1[i][j]=rs.getString(2);j++;
				str1[i][j]=rs.getString(3);j++;
				str1[i][j]=rs.getString(4);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	  }
	public void xx2() {
	
		Connection conn = null;
		Statement state = null;
		String sql = null;
		if("����".equals(s3)&&s4==0&&s5==0)
			sql="select  ѧ��,����,�༶,���� from "+s1+" where �༶='"+s2+"' and ���� order by "+s3+" desc;";
		else if(s5!=0)
			{sql="select  ѧ��,����,�༶,����  from "+s1+" where �༶='"+s2+"'and ����  between "+s4+" and "+s5+";";
	}
		ResultSet rs = null;
		try {
			conn = JDBCDemo.open();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			int i=0;
			for(int o=0;o<100;o++)
			{
				int p=0;
			   str2[o][p]=null;p++;
			   str2[o][p]=null;p++;
			   str2[o][p]=null;p++;
			   str2[o][p]=null;p++;
			   p=0;
			}
			while(rs.next()) {
				int j=0;
				str2[i][j]=rs.getString(1);j++;
				str2[i][j]=rs.getString(2);j++;
				str2[i][j]=rs.getString(3);j++;
				str2[i][j]=rs.getString(4);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	  }
	public void xx3() {
		Connection conn = null;
		Statement state = null;
		String sql = null;
		if("Ӣ��".equals(s3)&&s4==0&&s5==0)
			sql="select  ѧ��,����,�༶,Ӣ��  from "+s1+" where �༶='"+s2+"' and Ӣ�� order by "+s3+" desc;";
		else if(s5!=0)
			{sql="select ѧ��,����,�༶,Ӣ��  from "+s1+" where �༶='"+s2+"'and Ӣ��  between "+s4+" and "+s5+";";
}
		ResultSet rs = null;
		try {
			conn = JDBCDemo.open();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			int i=0;
			for(int o=0;o<100;o++)
			{
				int p=0;
			   str3[o][p]=null;p++;
			   str3[o][p]=null;p++;
			   str3[o][p]=null;p++;
			   str3[o][p]=null;p++;
			   p=0;
			}
			while(rs.next()) {
				int j=0;
				str3[i][j]=rs.getString(1);j++;
				str3[i][j]=rs.getString(2);j++;
				str3[i][j]=rs.getString(3);j++;
				str3[i][j]=rs.getString(4);j++;
				i++;
				
			}
	      JDBCDemo.close(conn);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}