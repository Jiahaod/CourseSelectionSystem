package cn.wg17.Service;


import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.CourseDaoImp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;



public class UpdateCourse extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseDaoImp courseDaoImp = new CourseDaoImp();
	String save = null;
	JTextField Apassword;
	JTextField Cid, Aid, Cname, Climit, Clocation, credit;
	//学号，姓名、班级，学校，学院
	JButton updatestu,selectstu;
	
	public UpdateCourse(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			System.err.println("不能设置外观:   "+e);
		}
		
		Apassword = new JPasswordField(20);
		Cid = new JTextField(20);
		Aid = new JTextField(20);
		Cname = new JTextField(20);
		Climit = new JTextField(20);
		Clocation = new JTextField(20);
		credit = new JTextField(20);
		
		updatestu = new JButton("修改");
		selectstu = new JButton("查找");
		
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
		Box box18=Box.createHorizontalBox();
		Box box19=Box.createHorizontalBox();
		
		//box9.add(new Label("    "));
		
		box8.add(new Label("修改课程信息"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("管理员账号"/*,JLabel.CENTER*/));
		box1.add(Aid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("管理员密码"/*,JLabel.CENTER*/));
		box2.add(Apassword);
		
		box11.add(new Label("    "));
		
		box3.add(new JLabel("课程号:",JLabel.CENTER));
		box3.add(Cid);
		
		box12.add(new Label("    "));
		
		box4.add(new JLabel("课程名:"/*,JLabel.CENTER*/));
		box4.add(Cname);
		
		box13.add(new Label("    "));
		
		box5.add(new JLabel("学分:"/*,JLabel.CENTER*/));
		box5.add(credit);
		
		box14.add(new Label("    "));
		
		box6.add(new JLabel("限制人数:"/*,JLabel.CENTER*/));
		box6.add(Climit);	
		
		box15.add(new Label("    "));
		
		box16.add(new JLabel("教室:"));
		box16.add(Clocation);
		
		box17.add(new Label("    "));
		
		
		
		
		box18.add(updatestu);
		
		/*box19.add(new JLabel("学号:",JLabel.CENTER));
		box19.add(Sid2);
		
		box19.add(selectstu);*/
		
		updatestu.addActionListener(this);
	    selectstu.addActionListener(this);
		
		Box boxH=Box.createVerticalBox();//竖放box
		
		//boxH.add(box19);
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

		boxH.add(box18);
		
		
		boxH.add(Box.createVerticalGlue());
		
		JPanel picPanel=new JPanel();
		JPanel messPanel=new JPanel();
		//messPanel.add(box19);
		picPanel.add(boxH);
		setLayout(new BorderLayout());
		JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//分割
		add(splitV,BorderLayout.CENTER);
		validate();
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		boolean f = true;
		Adminlmp adminlmp = new Adminlmp();
		Admin admin = new Admin();
		admin.setId(Aid.getText());
		admin.setPassword(Apassword.getText());
		
		Course course = new Course();
		course.setCid(Cid.getText());
		course.setClimit(Integer.valueOf(Climit.getText()));
		course.setClocation(Climit.getText());
		course.setCname(Cname.getText());
		course.setcredit(Integer.valueOf(credit.getText()));
		
		
		
		if(obj == updatestu)
		{
			if(Aid.getText().equals("") || Cid.getText().equals("") || Apassword.getText().equals("") || Climit.getText().equals("") || 
					Clocation.getText().equals("") || credit.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"请填写完整的信息。" );
			}
			else
			{ 
				
				if(courseDaoImp.findCourseById(Cid.getText()) == false)
				{
					JOptionPane.showMessageDialog(this, "该课程不存在");
				}
				else
				{
					if(adminlmp.Login(admin))
					{
						if(courseDaoImp.updateCourse(course))
						{
							JOptionPane.showMessageDialog(this,"修改完成" );
							Apassword.setText("");
							Aid.setText("");
							Cname.setText("");
							Cid.setText("");
							Climit.setText("");
							Clocation.setText("");
							credit.setText("");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"您输入的密码有误！" );
					}
				}				
			}
		}
	}
}