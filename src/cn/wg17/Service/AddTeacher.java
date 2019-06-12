package cn.wg17.Service;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.DaoImp.TeacherDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;


public  class AddTeacher extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDaolmp studentDaolmp = new StudentDaolmp();
	
	JTextField Aid, Apassword, Tid, Tname, Tpassword, Tdept;
	//学号，姓名、班级，学校，学院
	JButton addtea;
	
	public AddTeacher(){
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){System.err.println("不能设置外观:   "+e);}
		
		Aid = new JTextField(20);
		Apassword = new JTextField(20);
		Tid = new JTextField(20);
		Tname = new JTextField(20);

		Tdept = new JTextField(20);
		Tpassword = new JTextField(20);
		
		addtea = new JButton("录入");
		addtea.addActionListener(this);
		
		Box box1=Box.createHorizontalBox();//横放box
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();//横放box
		Box box6=Box.createHorizontalBox();
		Box box7=Box.createHorizontalBox();
		Box box8=Box.createHorizontalBox();
		Box box9=Box.createHorizontalBox();
		Box box10=Box.createHorizontalBox();
		Box box11=Box.createHorizontalBox();
		Box box12=Box.createHorizontalBox();
		Box box13=Box.createHorizontalBox();
		Box box14=Box.createHorizontalBox();
		Box box15=Box.createHorizontalBox();
		Box box16=Box.createHorizontalBox();
		Box box17=Box.createHorizontalBox();
		
		
		box9.add(new Label("    "));
		
		box8.add(new Label("增加教师账号"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("管理员账号"/*,JLabel.CENTER*/));
		box1.add(Aid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("管理员密码"/*,JLabel.CENTER*/));
		box2.add(Apassword);
		
		box11.add(new Label("    "));
		
		box3.add(new JLabel("教师工号:"/*,JLabel.CENTER*/));
		box3.add(Tid);
	
		box12.add(new Label("    "));
		
		box4.add(new JLabel("教师姓名:"/*,JLabel.CENTER*/));
		box4.add(Tname);
		
		box14.add(new Label("    "));
		
		box6.add(new JLabel("教师院系:"/*,JLabel.CENTER*/));
		box6.add(Tdept);
		
		box13.add(new Label("    "));
		
		box5.add(new JLabel("教师密码:"/*,JLabel.CENTER*/));
		box5.add(Tpassword);
		
		box15.add(new Label("    "));
		
		
		
		box9.add(addtea);
		
		Box boxH=Box.createVerticalBox();//竖放box
		boxH.add(box9);
		boxH.add(box8);
		boxH.add(box7);
		boxH.add(box1);
		boxH.add(box10);
		boxH.add(box2);
		boxH.add(box11);
		boxH.add(box3);
		boxH.add(box12);
		boxH.add(box4);
		boxH.add(box14);
		boxH.add(box6);
		boxH.add(box13);
		boxH.add(box5);
		boxH.add(box15);
		boxH.add(box9);
		
		boxH.add(Box.createVerticalGlue());
		JPanel messPanel=new JPanel();
		messPanel.add(boxH);
		setLayout(new BorderLayout());
		add(messPanel,BorderLayout.CENTER);
		validate();
	}
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		if(obj == addtea){
			if(Aid.getText().equals("") || Apassword.getText().equals("") || Tid.getText().equals("") ||
					Tname.getText().equals("") || Tdept.getText().equals("") || Tpassword.getText().equals("")){
				    JOptionPane.showMessageDialog(this, "信息请填满再录入！" );
			}
			else
			{
				Adminlmp adminlmp = new Adminlmp();
				Admin admin = new Admin();
				
				admin.setId(Aid.getText());
				admin.setPassword(Apassword.getText());
				
				if(adminlmp.Login(admin))
				{
					TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
					Teacher teacher = new Teacher();
					
					teacher.setTdept(Tdept.getText());
					teacher.setTid(Tid.getText());
					teacher.setTname(Tname.getText());
					teacher.setTpassword(Tpassword.getText());
					
					boolean b = adminlmp.addTeacher(teacher);
					if(b) {
						JOptionPane.showMessageDialog(this,"添加成功");	
					}
					else {
						JOptionPane.showMessageDialog(this,"添加失败,请检查您的id是否与其他人产生冲突");	
					}
				}
				else{
					JOptionPane.showMessageDialog(this, "您的账号或者密码有误");
				}
			}
		}
	}
}

