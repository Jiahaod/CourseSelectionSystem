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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Student;


public  class AddStudent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDaolmp studentDaolmp = new StudentDaolmp();
	
	JTextField Aid, Apassword, Sid, Sname, Sclass, Spassword, Sdept;
	//学号，姓名、班级，学校，学院
	JButton addstu;
	
	public AddStudent(){
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){System.err.println("不能设置外观:   "+e);}
		
		Aid = new JTextField(20);

		Apassword = new JPasswordField(20);
		//Apassword = new JTextField(20);
		Sid = new JTextField(20);
		Sname = new JTextField(20);
		Sclass = new JTextField(20);
		Spassword = new JTextField(20);
		Sdept = new JTextField(20);
		
		addstu=new JButton("录入");
		addstu.addActionListener(this);
		
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
		
		box8.add(new Label("增加学生账号"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("管理员账号"/*,JLabel.CENTER*/));
		box1.add(Aid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("管理员密码"/*,JLabel.CENTER*/));
		box2.add(Apassword);
		
		box11.add(new Label("    "));
		
		box3.add(new JLabel("学号:"/*,JLabel.CENTER*/));
		box3.add(Sid);
		
		box12.add(new Label("    "));
		
		box4.add(new JLabel("姓名:"/*,JLabel.CENTER*/));
		box4.add(Sname);
		
		box13.add(new Label("    "));
		
		box5.add(new JLabel("班级:"/*,JLabel.CENTER*/));
		box5.add(Sclass);
		
		box14.add(new Label("    "));
		
		box6.add(new JLabel("密码:"/*,JLabel.CENTER*/));
		box6.add(Spassword);	
		
		box15.add(new Label("    "));
		
		box16.add(new JLabel("院系:"));
		box16.add(Sdept);
		
		box17.add(new Label("    "));
		
		box9.add(addstu);
		
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
		boxH.add(box13);
		boxH.add(box5);
		boxH.add(box14);
		boxH.add(box6);
		boxH.add(box15);
		boxH.add(box16);
		boxH.add(box17);
		boxH.add(box9);
		
		boxH.add(Box.createVerticalGlue());
		JPanel messPanel=new JPanel();
		messPanel.add(boxH);
		setLayout(new BorderLayout());
		add(messPanel,BorderLayout.CENTER);
		validate();
		}
	/*Aid = new JTextField(20);
	Apassword = new JTextField(20);
	Sid = new JTextField(20);
	Sname = new JTextField(20);
	Sclass = new JTextField(20);
	Spassword = new JTextField(20);
	Sdept = new JTextField(20);*/
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		if(obj == addstu){
			if(Aid.getText().equals("") || Apassword.getText().equals("") || Sid.getText().equals("") ||
					Sname.getText().equals("") || Sclass.getText().equals("") || Spassword.getText().equals("")||
					Sdept.getText().equals("")){
				    JOptionPane.showMessageDialog(this,"信息请填满再录入！" );
			}
			else
			{
				Adminlmp adminlmp = new Adminlmp();
				Admin admin = new Admin();
				
				admin.setId(Aid.getText());
				admin.setPassword(Apassword.getText());
				
				if(adminlmp.Login(admin))
				{
					StudentDaolmp studentDaolmp = new StudentDaolmp();
					Student student = new Student();
					
					student.setId(Sid.getText());
					student.setName(Sname.getText());
					student.setPassword(Spassword.getText());
					student.setSclass(Sclass.getText());
					student.setSdept(Sdept.getText());
					
					boolean b = studentDaolmp.addStudent(student);
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
