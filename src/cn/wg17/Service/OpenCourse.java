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
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import cn.wg17.DaoImp.CourseDaoImp;
import cn.wg17.DaoImp.TeacherDaolmp;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.View.SelectAllCourseUI;

public class OpenCourse extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherDaolmp TDI = new TeacherDaolmp();
	String save=null;
	JTextField Tpassword, Tid, Cid;
	//ѧ�ţ��������༶��ѧУ��ѧԺ
	JButton opencourse, showTheCourses;
	
	public OpenCourse(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			System.err.println("�����������:   "+e);
		}
		
		Tpassword = new JTextField(20);
		Tid = new JTextField(20);
		Cid = new JTextField(20);
		/*Tpassword = new JTextField(20);
		Tdept = new JTextField(20);*/
		
		opencourse = new JButton("�޸�");
		showTheCourses = new JButton("�鿴�γ���Ϣ");
		
		Box box1=Box.createHorizontalBox();//���box
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();//���box
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
		
		
		box16.add(showTheCourses);
		
		box19.add(new Label("    "));
		
		box8.add(new Label("��ʦ����γ�"));
		
		box7.add(new Label("    "));
		
		box1.add(new JLabel("��ʦ�˺�"/*,JLabel.CENTER*/));
		box1.add(Tid);
		
		box10.add(new Label("    "));
		
		box2.add(new JLabel("��ʦ����"/*,JLabel.CENTER*/));
		box2.add(Tpassword);
		
		box11.add(new Label("    "));
		
		box18.add(opencourse);
		
		box19.add(new JLabel("�γ̺�:",JLabel.CENTER));
		
		box19.add(Cid);
		
		box7.add(new Label("    "));
		//box19.add(opencourse);
		
		opencourse.addActionListener(this);
		showTheCourses.addActionListener(this);
		Box boxH=Box.createVerticalBox();//����box
		
		boxH.add(box16);
		boxH.add(box19);
		boxH.add(box9);
		boxH.add(box8);
		boxH.add(box7);
		boxH.add(box1);
		boxH.add(box10);
		boxH.add(box2);
		boxH.add(box11);
		//boxH.add(box3);
		//boxH.add(box12);
		//boxH.add(box15);
		boxH.add(box19);
		boxH.add(box7);
		boxH.add(box18);
		
		
		boxH.add(Box.createVerticalGlue());
		
		JPanel picPanel=new JPanel();
		JPanel messPanel=new JPanel();
		//messPanel.add(box19);
		picPanel.add(boxH);
		setLayout(new BorderLayout());
		JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//�ָ�
		add(splitV,BorderLayout.CENTER);
		validate();
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		boolean f = true;
		
		
		Teacher teacher1 = new Teacher();
		teacher1.setTid(Tid.getText());
		teacher1.setTpassword(Tpassword.getText());
		
		
		Teacher teacher = new Teacher();
		
		teacher.setTid(Tid.getText());
		teacher.setTdept(Tpassword.getText());
		teacher.setTname(Cid.getText());
		//teacher.setTpassword(Tpassword1.getText());
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		if(obj == opencourse)
		{
			if(Tid.getText().equals("") || Tpassword.getText().equals("") || Cid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"����д��������Ϣ��" );
			}
			else
			{ 
				
				if(TDI.findTeacherById(Tid.getText()) == false || courseDaoImp.findCourseById(Cid.getText()) == false)
				{
					JOptionPane.showMessageDialog(this, "�ý�ʦ�����ڻ�ÿγ̲�����" );
				}
				else
				{
					if(TDI.Login(teacher1))
					{
						Course course = new Course();
						course = courseDaoImp.ReturnCourseInformation(Cid.getText());
						if(TDI.openCourse(teacher, course))
						{
							JOptionPane.showMessageDialog(this,"����ɹ�" );
							Tpassword.setText("");
							Tid.setText("");
							Cid.setText("");
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"���������������" );
					}
				}				
			}
		}
		else if(obj == showTheCourses)
		{
			try
			{
				SelectAllCourseUI K = new SelectAllCourseUI();
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}