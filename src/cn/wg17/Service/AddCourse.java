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
	
	//�γ̺š��γ���������������λ�á�ѧ��
	JTextField Aid, Apassword, Cid, Cname,Climit, Clocation, credit;
	
	JButton addcou;
	
	public AddCourse(){
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){System.err.println("�����������:   "+e);}
		
		Aid = new JTextField(20);
		Apassword = new JTextField(20);
		
		Cid = new JTextField(20);
		Cname = new JTextField(20);
		Climit = new JTextField(20);
		Clocation = new JTextField(20);
		credit = new JTextField(20);
		
		
		addcou = new JButton("¼��γ�");
		addcou.addActionListener(this);
		
		Box box1 = Box.createHorizontalBox();//���box
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
		
		box17.add(new JLabel("���ӿγ�"));
		
		box9.add(new JLabel("  "));
		
		
		box1.add(new JLabel("����Ա�˺�:"));
		box1.add(Aid);
		
		box10.add(new JLabel("  "));
		
		box2.add(new JLabel("����Ա����:"));
		box2.add(Apassword);
		
		box11.add(new JLabel("  "));
		
		box3.add(new JLabel("�γ̺�:"));
		box3.add(Cid);
		
		box12.add(new JLabel("  "));
		
		box4.add(new JLabel("�γ���:"));
		box4.add(Cname);
		
		box13.add(new JLabel("  "));
		
		box5.add(new JLabel("����������"));
		box5.add(Climit);
		
		box14.add(new JLabel("  "));
		
		box6.add(new JLabel("����λ��"));
		box6.add(Clocation);
		
		box15.add(new JLabel("  "));
		
		box7.add(new JLabel("ѧ��:"));
		box7.add(credit);
		
		box16.add(new JLabel("  "));
		
		box8.add(addcou);
		
		
		Box boxH=Box.createVerticalBox();	//����box��˳��ÿ��box֮�䶼Ҫ�ճ�һ����box	
		
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
				JOptionPane.showMessageDialog(this,"�γ���Ϣ��������¼�룡" );
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
						JOptionPane.showMessageDialog(this,"��ӳɹ�");	
					}
					else {
						JOptionPane.showMessageDialog(this,"���ʧ��,����γ̺��Ƿ��ͻ");	
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "�����˺Ż�����������");	
				}
			}
		}
	}

}
