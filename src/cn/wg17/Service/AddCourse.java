package cn.wg17.Service;

import java.awt.*;


import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.*;

import cn.wg17.DaoImp.*;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.Dao.*;


public class AddCourse extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseDaoImp cD = new CourseDaoImp();
	
	//课程号、课程名、限制人数、位置、学分
	JTextField Aid, Apassword, Cid, Cname,Climit, Clocation, credit;
	
	JButton addcou;
	
	public AddCourse(){
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){System.err.println("不能设置外观:   "+e);}
		
		Aid = new JTextField(20);
		Apassword = new JTextField(20);
		
		Cid = new JTextField(20);
		Cname = new JTextField(20);
		Climit = new JTextField(20);
		Clocation = new JTextField(20);
		credit = new JTextField(20);
		
		
		addcou = new JButton("录入课程");
		addcou.addActionListener(this);
		
		Box box1 = Box.createHorizontalBox();//横放box
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();
		Box box6 = Box.createHorizontalBox();
		Box box7 = Box.createHorizontalBox();
		Box box8 = Box.createHorizontalBox();
		Box box9 = Box.createHorizontalBox();
		Box box10 = Box.createHorizontalBox();
		Box box11 = Box.createHorizontalBox();
		Box box12 = Box.createHorizontalBox();
		Box box13 = Box.createHorizontalBox();
		Box box14 = Box.createHorizontalBox();
		Box box15 = Box.createHorizontalBox();
		Box box16 = Box.createHorizontalBox();
		Box box17 = Box.createHorizontalBox();
		Box box18 = Box.createHorizontalBox();
		
		box18.add(new JLabel("   "));
		
		box17.add(new JLabel("增加课程"));
		
		box9.add(new JLabel("  "));
		
		
		box1.add(new JLabel("管理员账号:"));
		box1.add(Aid);
		
		box10.add(new JLabel("  "));
		
		box2.add(new JLabel("管理员密码:"));
		box2.add(Apassword);
		
		box11.add(new JLabel("  "));
		
		box3.add(new JLabel("课程号:"));
		box3.add(Cid);
		
		box12.add(new JLabel("  "));
		
		box4.add(new JLabel("课程名:"));
		box4.add(Cname);
		
		box13.add(new JLabel("  "));
		
		box5.add(new JLabel("限制人数："));
		box5.add(Climit);
		
		box14.add(new JLabel("  "));
		
		box6.add(new JLabel("教室位置"));
		box6.add(Clocation);
		
		box15.add(new JLabel("  "));
		
		box7.add(new JLabel("学分:"));
		box7.add(credit);
		
		box16.add(new JLabel("  "));
		
		box8.add(addcou);
		
		
		Box boxH=Box.createVerticalBox();	//竖放box的顺序，每个box之间都要空出一个空box	
		
		boxH.add(box18);
		
		boxH.add(box17);
		
		boxH.add(box9);
		
		boxH.add(box1);

		boxH.add(box10);
		
		boxH.add(box2);
		
		boxH.add(box11);
		
		boxH.add(box3);
		
		boxH.add(box12);
		
		boxH.add(box4);
		
		boxH.add(box13);
		
		boxH.add(box5);
		
		boxH.add(box14);
		
		boxH.add(box6);
		
		boxH.add(box15);
		
		boxH.add(box7);
		
		boxH.add(box16);
		
		boxH.add(box8);
		
		
		boxH.add(Box.createVerticalGlue());
		JPanel messPanel=new JPanel();
		messPanel.add(boxH);
		setLayout(new BorderLayout());
		add(messPanel,BorderLayout.CENTER);
		validate();
	}
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		if(obj == addcou){
			//JTextComponent cterm;
			if(Aid.getText().equals("") || Apassword.getText().equals("") || Cid.getText().equals("") || Cname.getText().equals("") ||
				Climit.getText().equals("") || Clocation.getText().equals("") || credit.getText().equals("")){
				JOptionPane.showMessageDialog(this,"课程信息请填满再录入！" );
			}
			else{
				Admin admin = new Admin();
				admin.setId(Aid.getText());
				admin.setPassword(Apassword.getText());
				Adminlmp adminlmp = new Adminlmp();
				
				if(adminlmp.Login(admin))
				{
					CourseDaoImp s = new CourseDaoImp();
					Course course = new Course();
					
					course.setCid(Cid.getText());
					course.setCname(Cname.getText());
					course.setClimit(Integer.valueOf(Climit.getText()));
					course.setClocation(Clocation.getText());
					course.setcredit(Integer.valueOf(credit.getText()));
					
					
					   
					boolean b = cD.addCourse(course);
					if(b) {
						JOptionPane.showMessageDialog(this,"添加成功");	
					}
					else {
						JOptionPane.showMessageDialog(this,"添加失败,请检查课程号是否冲突");	
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "您的账号或者密码有误");	
				}
			}
		}
	}

}
