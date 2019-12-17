package 学生管理系统;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class AdministratorView implements ActionListener{
    JMenuBar menul;
    JMenuItem menux1,menux2,menux3,menux4;
	JPanel jp1,jp2,jp3,jp4;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,
	           txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20,txt21,txt22,txt23;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10
	       ,label11,label12,label13,label14,label15,label16,label17,label18,label19,label20,label21,label22,lable23,lable24,lable25,lable26,lable27,lable28,lable29;
	JFrame jm;
	JTable b1;
	String[] a1= {" ","高一","高二","高三"};
	String[] a2= {" ","高一","高二","高三"};
	String[] a3= {" ","高一","高二","高三"};
	JComboBox comboBox = new JComboBox(a1);
	JComboBox comboBox1 = new JComboBox(a2);
	JComboBox comboBox2 = new JComboBox(a2);
	String f,w,t;
	Object[] columnNames= {"学号","姓名","班级","数学","语文","英语","理综"};
	String[][] str1=new String[100][7];
	JButton but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,but11,but12,but13,but14,but15,but16;
	String[][] str=new String[100][7];
	public void Guanliyuanjiemian() {
    	jm=new JFrame("学生成绩信息管理界面");
    	menul=new JMenuBar();menul.setSize(700,100);
    	menux1=new JMenuItem("添加");
    	menux2=new JMenuItem("删除");
    	menux3=new JMenuItem("修改");
    	menux4=new JMenuItem("查询");

    	jp1=new JPanel(); jp1.setLayout(null); jp1.setBounds(0, 100, 700, 400);
    	jp2=new JPanel(); jp2.setLayout(null); jp2.setBounds(0, 100, 700, 400);
    	jp3=new JPanel(); jp3.setLayout(null); jp3.setBounds(0, 100, 700, 400);
    	jp4=new JPanel(); jp4.setLayout(null); jp4.setBounds(0, 100, 700, 400);
    	
    	but1=new JButton("1班");but1.setBounds(250, 24, 60, 30);
    	but2=new JButton("2班");but2.setBounds(350, 24, 60, 30);
    	but9=new JButton("3班");but9.setBounds(450, 24, 60, 30);
    	but11=new JButton("1班");but11.setBounds(250, 124, 60, 30);
    	but12=new JButton("2班");but12.setBounds(350, 124, 60, 30);
    	but13=new JButton("3班");but13.setBounds(450, 124, 60, 30);
    	but14=new JButton("1班");but14.setBounds(250, 224, 60, 30);
    	but15=new JButton("2班");but15.setBounds(350, 224, 60, 30);
    	but16=new JButton("3班");but16.setBounds(450, 224, 60, 30);
    	but3=new JButton("修改");but3.setBounds(330, 300, 60, 30);
    	but4=new JButton("查询");but4.setBounds(330, 300, 60, 30);
    	but5=new JButton("返回");but5.setBounds(350, 300, 60, 30);
    	but6=new JButton("返回");but6.setBounds(250, 190, 60, 30);
    	but7=new JButton("返回");but7.setBounds(250, 300, 60, 30);
    	but8=new JButton("返回");but8.setBounds(250, 300, 60, 30);
    	but10=new JButton("删除");but10.setBounds(330, 190, 60, 30);
    	
    	label1=new JLabel("高一："); label1.setBounds(150, 24, 50, 30);
		label2=new JLabel("高二："); label2.setBounds(150, 124, 50, 30);
		label3=new JLabel("高三："); label3.setBounds(150, 224, 50, 30);
		label4=new JLabel("数学："); label4.setBounds(97, 142, 105, 30);
		label5=new JLabel("语文："); label5.setBounds(97, 199, 105, 30);
		label17=new JLabel("英语：");label17.setBounds(362, 149, 105, 30);
		label18=new JLabel("理综：");label18.setBounds(362, 205, 105, 30);

		
		txt1=new JTextField(10);  txt1.setBounds(288, 25, 150, 30);
		txt2=new JTextField(10);  txt2.setBounds(170, 80, 150, 30);
		txt3=new JTextField(10);  txt3.setBounds(419,83, 150, 30);
		txt4=new JTextField(10);  txt4.setBounds(168, 147, 150, 30);
		txt5=new JTextField(10);  txt5.setBounds(168, 201, 150, 30);
		txt17=new JTextField(10); txt17.setBounds(421, 149, 150, 30);
		txt18=new JTextField(10); txt18.setBounds(421, 205, 150, 30);
		
		lable29=new JLabel("年级:  ");lable29.setBounds(200,24,50,30);
		label6=new JLabel("学 号："); label6.setBounds(200, 130, 50, 30);
		txt6=new JTextField(10);  txt6.setBounds(270, 130, 150, 30);
		comboBox2.setBounds(270, 24, 150, 30);
		label7=new JLabel("学 号："); label7.setBounds(365, 24, 50, 30);
		label8=new JLabel("姓 名："); label8.setBounds(100, 80, 50, 30);
		label9=new JLabel("班 级："); label9.setBounds(365, 83, 50, 30);
		label10=new JLabel("数学："); label10.setBounds(97, 142, 105, 30);
		label11=new JLabel("语文："); label11.setBounds(97, 199, 105, 30);
		label19=new JLabel("英语：");label19.setBounds(362, 149, 105, 30);
		label20=new JLabel("理综：");label20.setBounds(362, 205, 105, 30);
		lable28=new JLabel("年级:  ");lable28.setBounds(100,24,50,30);
		comboBox1.setBounds(170, 25, 150, 30);
		txt7=new JTextField(10);  txt7.setBounds(419, 25, 150, 30);
		txt8=new JTextField(10);  txt8.setBounds(170, 80, 150, 30);
		txt9=new JTextField(10);  txt9.setBounds(419,83, 150, 30);
		txt10=new JTextField(10);  txt10.setBounds(168, 147, 150, 30);
		txt11=new JTextField(10);  txt11.setBounds(168, 201, 150, 30);
		txt19=new JTextField(10); txt19.setBounds(421, 149, 150, 30);
		txt20=new JTextField(10); txt20.setBounds(421, 205, 150, 30);
       
		comboBox.setBounds(170, 25, 150, 30);
		label12=new JLabel("学 号："); label12.setBounds(365, 24, 50, 30);
		label13=new JLabel("姓 名："); label13.setBounds(100, 80, 50, 30);
		label14=new JLabel("班 级："); label14.setBounds(365, 83, 50, 30);
		label15=new JLabel("数学："); label15.setBounds(97, 142, 105, 30);
		label16=new JLabel("语文："); label16.setBounds(97, 199, 105, 30);
		label21=new JLabel("英语：");label21.setBounds(362, 149, 105, 30);
		label22=new JLabel("理综：");label22.setBounds(362, 205, 105, 30);
        lable27=new JLabel("年级:  ");lable27.setBounds(100,24,50,30);
		txt12=new JTextField(10);  txt12.setBounds(419, 25, 150, 30);
		txt13=new JTextField(10);  txt13.setBounds(170, 80, 150, 30);
		txt14=new JTextField(10);  txt14.setBounds(419,83, 150, 30);
		txt15=new JTextField(10);  txt15.setBounds(168, 147, 150, 30);
		txt16=new JTextField(10);  txt16.setBounds(168, 201, 150, 30);
		txt21=new JTextField(10); txt21.setBounds(421, 149, 150, 30);
		txt22=new JTextField(10); txt22.setBounds(421, 205, 150, 30);
		  comboBox.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	           f=(String)e.getItem();
	                }
	        });
		  comboBox1.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	           w=(String)e.getItem();
	                }
	        });
		  comboBox2.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	           t=(String)e.getItem();
	                }
	        });
		menux1.addActionListener(this);
		menux2.addActionListener(this);
		menux3.addActionListener(this);
		menux4.addActionListener(this);
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		but8.addActionListener(this);
		but10.addActionListener(this);
		but11.addActionListener(this);
		but12.addActionListener(this);
		but13.addActionListener(this);
		but14.addActionListener(this);
		but15.addActionListener(this);
		but16.addActionListener(this);	
		
		jm.setLayout(new BorderLayout());
		
		jm.setJMenuBar(menul);
		menul.add(menux1);
		menul.add(menux2);
		menul.add(menux3);
		menul.add(menux4);
		String chaxun="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"管理员.jpg";
    	Icon  icon = new ImageIcon(chaxun);
    	lable23=new JLabel(icon);lable23.setBounds(0,0, 700, 400);
		String tianjia="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"标题1.jpg";
    	Icon  icon1 = new ImageIcon(tianjia);
    	lable24=new JLabel(icon1);lable24.setBounds(0,0, 700, 400);
		String shanchu="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"标题2.jpg";
    	Icon  icon2 = new ImageIcon(shanchu);
    	lable25=new JLabel(icon2);lable25.setBounds(0,0, 700, 400);
		String xiugai="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"标题3.jpg";
    	Icon  icon3 = new ImageIcon(xiugai);
    	lable26=new JLabel(icon3);lable26.setBounds(0,0, 700, 400);
		jp1.add(label1);
		jp1.add(label2);
		jp1.add(label3);
		jp1.add(but9);jp1.add(but2);
		jp1.add(but1);jp1.add(but16);
		jp1.add(but5);
		jp1.add(but11);jp1.add(but12);
		jp1.add(but14);jp1.add(but13);
		jp1.add(but15);jp1.add(lable24);
		jp2.add(label6);
		jp2.add(lable29);jp2.add(txt6);
		jp2.add(but6);jp2.add(but10);
		jp2.add(comboBox2);
		jp2.add(lable25);
		jp3.add(label7);jp3.add(txt7);
		jp3.add(label8);jp3.add(txt8);
		jp3.add(label9);jp3.add(txt9);
		jp3.add(label10);jp3.add(txt10);
		jp3.add(label11);jp3.add(txt11);
		jp3.add(label19);jp3.add(txt19);
		jp3.add(label20);jp3.add(txt20);
		jp3.add(but3);jp3.add(but7);jp3.add(lable28);
		jp3.add(comboBox1);
		jp3.add(lable26);
		jp4.add(label12);jp4.add(txt12);
		jp4.add(label13);jp4.add(txt13);
		jp4.add(label14);jp4.add(txt14);
		jp4.add(label15);jp4.add(txt15);
		jp4.add(label16);jp4.add(txt16);
		jp4.add(label21);jp4.add(txt21);
		jp4.add(label22);jp4.add(txt22);
		jp4.add(lable27);//jp4.add(txt23);
		jp4.add(but4);jp4.add(but8);
		jp4.add(comboBox);
		jp4.add(lable23);
		
		jm.add(jp1);
		jm.setBounds(400, 200, 700, 500);
		jm.setVisible(true);
		jm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menux1) {
			jp1.setVisible(true);
			jp2.setVisible(false);
			jp3.setVisible(false);
			jp4.setVisible(false);
		}
		if(e.getSource()==menux2) {
			jm.add(jp2);
			jp1.setVisible(false);
			jp2.setVisible(true);
			jp3.setVisible(false);
			jp4.setVisible(false);
		}
		if(e.getSource()==menux3) {
			jm.add(jp3);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(true);
			jp4.setVisible(false);
		}
		if(e.getSource()==menux4) {
			jm.add(jp4);
			jp1.setVisible(false);
			jp2.setVisible(false);
			jp3.setVisible(false);
			jp4.setVisible(true);
		}
		//JBut[] s= {but5,but6,but7,but8};
		if(e.getSource()==but5||e.getSource()==but6||e.getSource()==but7||e.getSource()==but8) {
				try {
					jm.dispose();
					new StudentMessageView().messageView();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

		}
		if(e.getSource()==but1||e.getSource()==but2||e.getSource()==but9) {
			String s="高一";
			new Add().td(s, e.getActionCommand());
			jm.dispose();
		}
		if(e.getSource()==but11||e.getSource()==but12||e.getSource()==but13) {
			String s="高二";
			new Add().td(s, e.getActionCommand());
			jm.dispose();
		}
		if(e.getSource()==but14||e.getSource()==but15||e.getSource()==but16) {
			String s="高三";
			new Add().td(s, e.getActionCommand());
			jm.dispose();
		}
		if(e.getSource()==but10) {
			Connection conn;
			try {
				conn = JDBCDemo.open();//
				String sql="delete from "+t+"  where 学号=?; ";
			    PreparedStatement state=conn.prepareStatement(sql);
			    state.setString(1, txt6.getText());
			    state.executeUpdate();
			    JDBCDemo.close(conn);
			    JOptionPane.showMessageDialog(null, "删除成功");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==but3) {
			Connection conn;
			try {
				conn = JDBCDemo.open();
				if(txt8.getText().length()!=0) {
					String sql="update "+w+"  set 姓名=? where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt8.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
				if(txt9.getText().length()!=0) {
					String sql="update  "+w+" set 班级=? where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt9.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
				if(txt10.getText().length()!=0) {
					String sql="update  "+w+" set 数学=? where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt10.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
				if(txt11.getText().length()!=0) {
					String sql="update  "+w+" set 语文=? where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt11.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
				if(txt19.getText().length()!=0) {
					String sql="update  "+w+" set 英语=?where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt19.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
				if(txt20.getText().length()!=0) {
					String sql="update  "+w+" set 理综=? where 学号=?; ";
				    PreparedStatement state=conn.prepareStatement(sql);
				    state.setString(1, txt20.getText());
				    state.setString(2, txt7.getText());
				    state.executeUpdate();
				}
			    JOptionPane.showMessageDialog(null, "修改成功");
			    JDBCDemo.close(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==but4) {
			Connection conn;
			try {
				conn = JDBCDemo.open();
				String sql="select 姓名,班级,数学,语文,英语,理综  from "+f+"  where 学号=?;";
			    PreparedStatement state=conn.prepareStatement(sql);
			    state.setString(1, txt12.getText());
			    ResultSet rs=state.executeQuery();
			    
			    while(rs.next()) {
			    	txt13.setText(rs.getString(1));
			    	txt14.setText(rs.getString(2));
			    	txt15.setText(rs.getString(3));
			    	txt16.setText(rs.getString(4));
			    	txt21.setText(rs.getString(5));
			    	txt22.setText(rs.getString(6));
			    }
			    
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	 }
	}

