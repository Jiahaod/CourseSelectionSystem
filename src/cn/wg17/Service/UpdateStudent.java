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
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.Student;



public class UpdateStudent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDaolmp SDI = new StudentDaolmp();
	String save=null;
	JTextField Spassword1, Sid, Sname, Sclass, Spassword, Sdept;
	//学号，姓名、班级，学校，学院
	JButton updatestu,selectstu;
	
	public UpdateStudent(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			System.err.println("不能设置外观:   "+e);
		}
		
		Spassword1 = new JTextField(20);
		Sid = new JTextField(20);
		Sname = new JTextField(20);
		Sclass = new JTextField(20);
		Spassword = new JTextField(20);
		Sdept = new JTextField(20);
		
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
		
		box8.add(new Label("修改学生信息"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("学生账号"/*,JLabel.CENTER*/));
		box1.add(Sid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("学生密码"/*,JLabel.CENTER*/));
		box2.add(Spassword);
		
		box11.add(new Label("    "));
		
		/*box3.add(new JLabel("学号:",JLabel.CENTER));
		box3.add(Sid1);
		
		box12.add(new Label("    "));*/
		
		box4.add(new JLabel("姓名:"/*,JLabel.CENTER*/));
		box4.add(Sname);
		
		box13.add(new Label("    "));
		
		box5.add(new JLabel("班级:"/*,JLabel.CENTER*/));
		box5.add(Sclass);
		
		box14.add(new Label("    "));
		
		box6.add(new JLabel("密码:"/*,JLabel.CENTER*/));
		box6.add(Spassword1);	
		
		box15.add(new Label("    "));
		
		box16.add(new JLabel("院系:"));
		box16.add(Sdept);
		
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
		//boxH.add(box3);
		//boxH.add(box12);
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
		
		
		Student student1 = new Student();
		
		student1.setId(Sid.getText());
		student1.setPassword(Spassword.getText());
		
		Student student = new Student();
		
		student.setId(Sid.getText());
		student.setPassword(Spassword1.getText());
		student.setName(Sname.getText());
		student.setSclass(Sclass.getText());
		student.setSdept(Sdept.getText());
		
		
		if(obj == updatestu)
		{
			if(Sid.getText().equals("") || Spassword.getText().equals("") || Sdept.getText().equals("") || 
					Sname.getText().equals("") || Sclass.getText().equals("") || Spassword1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"请填写完整的信息。" );
			}
			else
			{ 
				
				if(SDI.findStudentById(Sid.getText()) == false)
				{
					JOptionPane.showMessageDialog(this, "该学生不存在" );
				}
				else
				{
					if(SDI.Login(student1))
					{
						if(SDI.updateStudent(student))
						{
							JOptionPane.showMessageDialog(this,"修改完成" );
							Spassword.setText("");
							Sdept.setText("");
							Sname.setText("");
							Sid.setText("");
							Spassword1.setText("");
							Sclass.setText("");		
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