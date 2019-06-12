package cn.wg17.Service;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Sides;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.View.SelectStudentUI;


public class SelectStudent extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField Sid;
	JButton selectStudent;

	public SelectStudent (){
		Sid = new JTextField(12);
		/*sname=new JTextField(12);
		ssex=new JTextField(12);
		smajor=new JTextField(12);*/		
		selectStudent=new JButton("查找学生信息");
		
		Box box1=Box.createHorizontalBox();//横放box
		/*Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();*/
		Box box5=Box.createHorizontalBox();
		
		box1.add(new JLabel("学号:",JLabel.CENTER));
		box1.add(Sid);
		/*box2.add(new JLabel("姓名:",JLabel.CENTER));
		box2.add(sname);
		box3.add(new JLabel("性别:",JLabel.CENTER));
		box3.add(ssex);
		box4.add(new JLabel("专业:",JLabel.CENTER));
		box4.add(smajor);*/
		box5.add(selectStudent);

		Box boxH1=Box.createVerticalBox();//竖放box
		boxH1.add(box1);
		/*boxH1.add(box2);
		boxH1.add(box3);
		boxH1.add(box4);*/
		boxH1.add(box5);
		boxH1.add(Box.createVerticalGlue());     
		
		selectStudent.addActionListener(this);
        
		JPanel messPanel=new JPanel();
		JPanel picPanel=new JPanel();
		
		messPanel.add(boxH1);
		setLayout(new BorderLayout());
		
		JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//分割
		add(splitV,BorderLayout.CENTER);
		validate();
	}
	
	public void actionPerformed(ActionEvent c){
		Object obj = c.getSource();
	
	    String sql = null;
	    SelectStudentUI K;
	    Adminlmp adminlmp = new Adminlmp();
	    StudentDaolmp studentDaolmp = new StudentDaolmp();
	    Student student = new Student();
	    Course course = new Course();
	    
		if(obj == selectStudent){
			
			if(Sid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "学号不能为空！");	
			}
			else
			{
				if(adminlmp.findStudentById(Sid.getText()))
				{
					student = studentDaolmp.ReturnStudentInformation(Sid.getText());
					course = studentDaolmp.StudentfindCourseById(Sid.getText());
				}
			}
		}
		try
		{
			K = new SelectStudentUI(student, course);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
