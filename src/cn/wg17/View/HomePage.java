package cn.wg17.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextPane;

import cn.wg17.Dao.AdminDao;
import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.DaoImp.TeacherDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;






public class HomePage
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	
	public boolean judgeIdentity(String identity, String u, String p)
	{
		
		if(identity.equals("管理员"))
		{
			Admin admin = new Admin();
			admin.setId(u);
			admin.setPassword(p);
			Adminlmp adminlmp = new Adminlmp();
			if(adminlmp.Login(admin))
			{
				return true;
			}
			else 
			{
				return false;
			}
			
		}
		else if(identity.equals("老师"))
		{
			Teacher teacher = new Teacher();
			teacher.setTid(u);
			teacher.setTpassword(p);
			TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
			
			if(teacherDaolmp.Login(teacher))
			{
				return true;
			}
			else 
			{
				return false;
			}
			
		}
		else if(identity.equals("学生"))
		{
			Student student = new Student();
			
			student.setId(u);
			student.setPassword(p);
			StudentDaolmp studentDaolmp = new StudentDaolmp();
			
			if(studentDaolmp.Login(student))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		
		
		return false;
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame("选课系统");
		frame.setBounds(200, 200, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u7BA1\u7406\u5458", "\u8001\u5E08", "\u5B66\u751F"}));
		comboBox.setBounds(328, 198, 116, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u672C\u5957\u9009\u8BFE\u7CFB\u7EDF\uFF0C\u8BF7\u9009\u62E9\u60A8\u7684\u8EAB\u4EFD\u3002");
		label.setFont(new Font("宋体", Font.PLAIN, 35));
		label.setBounds(39, 45, 720, 104);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(249, 198, 94, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 24));
		label_2.setBounds(249, 278, 94, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		label_3.setBounds(249, 349, 94, 30);
		frame.getContentPane().add(label_3);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String identity = comboBox.getSelectedItem().toString();
				String user = textField.getText().toString();
				String password = textField_1.getText().toString();
				/*System.out.println(identity);
				System.out.println(user1);
				System.out.println(password);
				*/
				if(judgeIdentity(identity, user, password))
				{
					System.out.println("Hello!");
					//this.add(new AdminPage());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "您输入的账号和密码有错", "出错了",  JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(583, 418, 137, 49);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(328, 285, 116, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(328, 356, 116, 24);
		frame.getContentPane().add(textField_1);
	}
}
