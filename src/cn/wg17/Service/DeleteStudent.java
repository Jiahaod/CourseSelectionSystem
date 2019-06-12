package cn.wg17.Service;

import java.awt.BorderLayout;
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

import cn.wg17.Dao.AdminDao;
import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;


public class DeleteStudent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private  studentDAO = new StudentDAO();
	JTextField Aid, Apassword, Sid;
	JButton deletestu, selectstu;
		
	public DeleteStudent(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){System.err.println("不能设置外观:   "+e);}
		
		Aid = new JTextField(20);
		Apassword = new JTextField(20);
		Sid = new JTextField(20);
		deletestu=new JButton("删除");
		//selectstu=new JButton("查找");
	
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
		
		
		box10.add(new JLabel("  "));
		box11.add(new JLabel("  "));
		box4.add(new JLabel("  "));
		
		box5.add(new JLabel("   "));
		
		box1.add(new JLabel("管理员账号:",JLabel.CENTER));
		box1.add(Aid);
		
		box6.add(new JLabel("   "));
		
		box2.add(new JLabel("管理员密码:",JLabel.CENTER));
		box2.add(Apassword);
		
		box7.add(new JLabel("   "));
		
		
		box3.add(new JLabel("删除的学生的学号:",JLabel.CENTER));
		box3.add(Sid);
		
		box8.add(new JLabel("   "));
		box9.add(deletestu);
		
		
		Box boxH=Box.createVerticalBox();//竖放box
		
		boxH.add(box10);
		boxH.add(box11);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box1);
		boxH.add(box6);
		boxH.add(box2);
		boxH.add(box7);
		boxH.add(box3);
		boxH.add(box8);
		boxH.add(box9);
		boxH.add(Box.createVerticalGlue());
		
		deletestu.addActionListener(this);
		//selectstu.addActionListener(this);
		
		JPanel picPanel=new JPanel();
		JPanel messPanel=new JPanel();
		messPanel.add(box5);
		picPanel.add(boxH);
		setLayout(new BorderLayout());
		JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//分割
		add(splitV,BorderLayout.CENTER);
		validate();
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		Adminlmp adminlmp = new Adminlmp();
		Admin admin = new Admin();
		admin.setId(Aid.getText());
		admin.setPassword(Apassword.getText());
		Student student = new Student();
		student.setId(Sid.getText());
		if(obj==deletestu){
			if(Aid.getText().equals("") || Apassword.getText().equals("") || Sid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "请填写完整的信息");
			}
			else if(adminlmp.Login(admin))
			{
				if(adminlmp.findStudentById(Sid.getText()))
				{
					adminlmp.deteleStudent(student);
					JOptionPane.showMessageDialog(this, "删除成功");
					Aid.setText("");
					Apassword.setText("");
					Sid.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "不存在该课程");
				}
			}
		}
		
	}
}