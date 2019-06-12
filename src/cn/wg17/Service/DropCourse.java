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
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.CourseDaoImp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.DaoImp.TeacherDaolmp;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.View.SelectAllCourseUI;

public class DropCourse extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherDaolmp TDI = new TeacherDaolmp();
	String save=null;
	JTextField Tpassword1, Tid, Cid;
	//学号，姓名、班级，学校，学院
	JButton updatetea; //showTheCourses;
	
	public DropCourse(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			System.err.println("不能设置外观:   "+e);
		}
		
		Tpassword1 = new JPasswordField(20);
		Tid = new JTextField(20);
		Cid = new JTextField(20);
		updatetea = new JButton("确定选择");
		//showTheCourses = new JButton("查看课程");
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
		
		//box8.add(showTheCourses);
		
		box3.add(new Label(""));
		
		box9.add(new Label("推选课程"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("学生账号"/*,JLabel.CENTER*/));
		box1.add(Tid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("学生密码"/*,JLabel.CENTER*/));
		box2.add(Tpassword1);
		
		box11.add(new Label("    "));
		
		/*box3.add(new JLabel("学号:",JLabel.CENTER));
		box3.add(Sid1);
		
		box12.add(new Label("    "));*/
		
		box4.add(new JLabel("课程号:"/*,JLabel.CENTER*/));
		box4.add(Cid);
		
		box13.add(new Label("    "));
		
		
		
		
		box18.add(updatetea);
		
		/*box19.add(new JLabel("学号:",JLabel.CENTER));
		box19.add(Sid2);
		
		box19.add(selectstu);*/
		
		updatetea.addActionListener(this);
		//showTheCourses.addActionListener(this);
		Box boxH=Box.createVerticalBox();//竖放box
		
		boxH.add(box3);
		boxH.add(box9);
		boxH.add(box8);
		boxH.add(box7);
		boxH.add(box1);
		boxH.add(box10);
		boxH.add(box2);
		boxH.add(box11);
		//boxH.add(box3);
		//boxH.add(box12);
		boxH.add(box4);
		boxH.add(box13);
		boxH.add(box5);
		boxH.add(box14);
		boxH.add(box6);
		boxH.add(box15);

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
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		
		Student student = new Student();
		student = studentDaolmp.ReturnStudentInformation(Tid.getText());
		
		Course course = new Course();
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		course = courseDaoImp.ReturnCourseInformation(Cid.getText());
		if(obj == updatetea)
		{
			if(Tid.getText().equals("") || Tpassword1.getText().equals("") || Cid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"请填写完整的信息。" );
			}
			else
			{
				if(studentDaolmp.Login(student))
				{
					if(studentDaolmp.DropCourse(Cid.getText()))
						JOptionPane.showMessageDialog(this, "退选成功" );
					Cid.setText("");
					Tid.setText("");
					Tpassword1.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "密码或账号有误" );
				}
			}
		}
		
	}
}