package 学生管理系统;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loadingView {
     JLabel lable1,lable2,lable3,lable4,lable5,lable6,lable7,lable8;
     JTextField txt1,txt2,txt3;
     JPasswordField word1,word2,word3,word4;
     JButton but1,but2,but3,but4,but5,but6,but7,but8,but9;
     JFrame ck1=new JFrame("登录");
     JFrame ck2;
     JPanel jp1,jp2,jp3,jp4,jp5;
     
     loadingView(){}
     
     public static void main(String[] args) {
    	 loadingView mv=new loadingView();
    	 mv.Jp1();		
	}
     
     public void Jp1() {
    	 jp1=new JPanel();
    	 String picPath="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"登录界面.jpg";
    	 Icon  icon = new ImageIcon(picPath);
    	 lable6=new JLabel(icon);lable6.setBounds(-25, -20, 666, 470);
    	 but1=new JButton("注册");but1.setBounds(21, 369, 100, 40);
    	 but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp1.setVisible(false);
				Jp2();
				ck1.setTitle("注册");				
			}
		});
    	 but2=new JButton("管理员登录");but2.setBounds(21, 296, 100, 40);
    	 but2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					new denglu().dl(txt1.getText(), word1.getText());
					ck1.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
    	 but7=new JButton("修改密码");but7.setBounds(177, 369, 100, 40);
    	 but7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatack();
				ck1.dispose();
				
			}
		});
    	 but8=new JButton("学生登录");but8.setBounds(177, 296, 100, 40);
    	 but8.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new denglu().dl2(txt1.getText(), word1.getText());
					ck1.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
    	 
    	 txt1=new JTextField(10);txt1.setBounds(128, 185, 150, 30);
    	 lable1=new JLabel("账 号：");lable1.setBounds(38, 184, 50, 30);
    	 lable2=new JLabel("密  码：");lable2.setBounds(38, 240, 50, 29);
    	 word1=new JPasswordField(10);word1.setBounds(128, 240, 150, 30);
    	 
    	 ck1.getContentPane().setLayout(new BorderLayout());
    	 jp1.setLayout(null); 
    	 jp1.setBounds(0, 0, 800, 500);
    	 
    	 ck1.getContentPane().add(jp1,BorderLayout.CENTER);
    	 jp1.add(lable1);jp1.add(txt1);
    	 jp1.add(lable2); jp1.add(word1);
    	 jp1.add(but1);jp1.add(but2);jp1.add(but7);
    	 jp1.add(but8);jp1.add(lable6);
    	 ck1.setBounds(400, 200, 626, 467);
    	 ck1.setVisible(true);
    	 ck1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }//主界面
     
     public void Jp2() {
    	 jp2=new JPanel();
    	 String zhucetu="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"注册.jpg";
    	 Icon  icon = new ImageIcon(zhucetu);
    	 lable7=new JLabel(icon);lable7.setBounds(0, 0, 400, 400);
    	 but4=new JButton("学生注册");but4.setBounds(140, 200, 100, 40);
    	 but4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					new zhuce().zc(txt2.getText(), word2.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
    	 but9=new JButton("管理员注册");but9.setBounds(260, 200, 100, 40);
    	 but9.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new zhuce().zc2(txt2.getText(), word2.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
    	 but3=new JButton("返回");but3.setBounds(60, 200, 60, 40);
    	 but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp2.setVisible(false);
				Jp1();		
				ck1.setTitle("登录");
			}
		});
    	
    	 txt2=new JTextField(10);txt2.setBounds(120, 90, 150, 30);
    	 lable1=new JLabel("账 号：");lable1.setBounds(70, 90, 50, 30);
    	 lable2=new JLabel("密 码：");lable2.setBounds(70, 150, 50, 30);
    	 word2=new JPasswordField(10);word2.setBounds(120, 150, 150, 30);
    	 
    	 ck1.getContentPane().setLayout(new BorderLayout());
    	 jp2.setLayout(null); jp2.setBounds(0, 0, 300, 200);
    	 
    	 ck1.getContentPane().add(jp2,BorderLayout.CENTER);
    	 jp2.add(lable1);jp2.add(txt2);
    	 jp2.add(lable2); jp2.add(word2);
    	 jp2.add(but4);jp2.add(but3);jp2.add(but9);
     	 jp2.add(lable7);
    	 ck1.setBounds(400, 200, 400, 400);
    	 ck1.setVisible(true);
    	 ck1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }//注册相关界面
     public void updatack() {
    	 
    	 ck2=new JFrame("修改密码");
    	 lable3=new JLabel("新密码：");
    	 lable4=new JLabel("账   号：");
    	 lable5=new JLabel("密   码：");
    	 txt3=new JTextField(10);
    	 word3=new JPasswordField(10);
    	 word4=new JPasswordField(10);
    	 jp4=new JPanel();
    	 jp5=new JPanel();
    	 but5=new JButton("返回");
    	 but5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ck1.setVisible(true);
				ck2.dispose();
				
			}
		});
    	 but6=new JButton("确定");
    	 
    	 but6.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				
				try {
				Connection conn=JDBCDemo.open();
				String jg=null;
				String sql1="select 密码 from zhuce where 账号='"+txt3.getText()+"';";
				Statement state=conn.createStatement();
				ResultSet rs=state.executeQuery(sql1);
				while(rs.next()) {
					jg=rs.getString(1);
				}
					if(jg.equals(word4.getText())) {
					String sql2="update zhuce set 密码=? where 账号=?;";
					PreparedStatement state2;
					state2 = conn.prepareStatement(sql2);
					state2.setString(1,word3.getText());
					state2.setString(2, txt3.getText());
					state2.executeUpdate();
					JDBCDemo.close(conn);
					JOptionPane.showMessageDialog(null, "修改成功");
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
							
		});
    	 String zhucetu="C:/Users/10723/Desktop/学生成绩管理系统/"+ File.separator+"修改密码.jpg";
    	 Icon  ico = new ImageIcon(zhucetu);
    	 lable8=new JLabel(ico);lable8.setBounds(0, 0, 400, 400);
    	 ck2.getContentPane().setLayout(null);
    	 lable4.setBounds(60, 30, 50, 30);
    	 txt3.setBounds(130, 30, 150, 30);
    	 lable5.setBounds(60, 80, 50, 30);
    	 word4.setBounds(130, 80, 150, 30);
    	 lable3.setBounds(60, 130, 60, 30);
    	 word3.setBounds(130, 130, 150, 30);
    	 but5.setBounds(110, 200, 60, 30);
    	 but6.setBounds(200, 200, 60, 30);
    	 ck2.getContentPane().add(lable4);ck2.getContentPane().add(txt3);
    	 ck2.getContentPane().add(lable5);ck2.getContentPane().add(word4);
    	 ck2.getContentPane().add(lable3);ck2.getContentPane().add(word3);
    	 ck2.getContentPane().add(but5);ck2.getContentPane().add(but6);
    	 ck2.getContentPane().add(lable8);
    	 ck2.setBounds(400, 200, 400, 400);
    	 ck2.setVisible(true);
    	 ck2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 
    	 }//修改密码
}

