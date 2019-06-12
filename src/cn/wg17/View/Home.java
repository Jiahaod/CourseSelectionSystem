package cn.wg17.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import cn.wg17.JavaBean.Course;
import cn.wg17.Service.AddCourse;
import cn.wg17.Service.AddStudent;
import cn.wg17.Service.AddTeacher;
import cn.wg17.Service.ChooseCourse;
import cn.wg17.Service.DeleteCourse;
import cn.wg17.Service.DeleteStudent;
import cn.wg17.Service.DeleteTeacher;
import cn.wg17.Service.DropCourse;
import cn.wg17.Service.OpenCourse;
import cn.wg17.Service.SelectCourse;
import cn.wg17.Service.SelectStudent;
import cn.wg17.Service.SelectTeacher;
import cn.wg17.Service.UpdateCourse;
import cn.wg17.Service.UpdateStudent;
import cn.wg17.Service.UpdateTeacher;

public class Home extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//学生管理
	AddStudent addStudent;
	UpdateStudent updateStudent;
	DeleteStudent deleteStudent;
	SelectStudent selectStudent;
	
	//教师管理
	AddTeacher addTeacher;
	UpdateTeacher updateTeacher;
	DeleteTeacher deleteTeacher;
	SelectTeacher selectTeacher;
	
	//课程管理
	AddCourse addCourse;
	DeleteCourse deleteCourse;
	UpdateCourse updateCourse;
	SelectCourse selectCourse;
	//选课管理
	ChooseCourse chooseCourse;
	OpenCourse openCourse;
	DropCourse dropCourse;
	/*AddSC addSC;
	DeleteSC deleteSC;
	UpdateSC updateSC;
	SelectSC selectSC;
	//成绩管理
	UpdateScore updateScore;
	SelectScore selectScore;
	//修改密码
	UpdatePassword updatePassword;*/
	
	JPanel pCenter;			//JPanel 是 Java图形用户界面(GUI)工具包swing中的面板容器类
	CardLayout card = null;	//cardlayout就是将一组组件彼此第进行重叠地布局，就像一张张卡片一样，这样每次只会展现一个界面。
	JLabel label1 = null;
	//JLabel label2 = null;
	
	JMenuBar mb = new JMenuBar();//菜单栏
	
	JMenu m1 = new JMenu("学生管理");
	JMenuItem add1 = new JMenuItem("录入");
	JMenuItem update1 = new JMenuItem("修改");
	JMenuItem delete1 = new JMenuItem("删除");
	JMenuItem select1 = new JMenuItem("查询");
	
	JMenu m7 = new JMenu("教师管理");
	JMenuItem add7 = new JMenuItem("录入");
	JMenuItem update7 = new JMenuItem("修改");
	JMenuItem delete7 = new JMenuItem("删除");
	JMenuItem select7 = new JMenuItem("查询");
	
	
	JMenu m2 = new JMenu("课程管理");
	JMenuItem add2 = new JMenuItem("录入");
	JMenuItem update2 = new JMenuItem("修改");
	JMenuItem delete2 = new JMenuItem("删除");
	JMenuItem select2 = new JMenuItem("查询");
	
	JMenu m3 = new JMenu("选课管理");
	JMenuItem add3 = new JMenuItem("开课");
	JMenuItem update3 = new JMenuItem("修改");
	JMenuItem delete3 = new JMenuItem("退课");
	JMenuItem select3 = new JMenuItem("选课");
	
	/*JMenu m4=new JMenu("成绩管理");
	JMenuItem update4=new JMenuItem("更新成绩 ");	
	JMenuItem select4=new JMenuItem("查询成绩 ");
	*/
	JMenu m5 = new JMenu("密码管理");
	JMenuItem update5 = new JMenuItem("修改密码 ");	
	
	JMenu m6 = new JMenu("系统退出");
	JMenuItem excel = new JMenuItem("退出");
	
	Font t=new Font ("sanerif",Font.PLAIN,15);
    
	public Home(){
		this.setTitle("选课系统");	
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){System.err.println("不能设置外观:   "+e);}
		//组合菜单
		addMenu1();
		addMenu7();
		addMenu2();
		addMenu3();
		//addMenu4();
		addMenu5();
		addMenu6();
		
		addJMenuBar();
		setJMenuBar(mb);
		
		//label1 = new JLabel(new ImageIcon("./Image/1.png"));
		label1 = new JLabel("<html><body>您好，欢迎使用本套选课管理系统！<br><br><br>如果您的身份是管理员请选择您要进行管理的角色。<br><br><br>您是学生或老师则正常使用。</body></html>",SwingConstants.CENTER);
		
		label1.setFont(new Font("楷体",Font.BOLD,36));
		label1.setHorizontalTextPosition(SwingConstants.CENTER); 	
			
		/*label2.setFont(new Font("楷体",Font.BOLD,36));
		label2.setHorizontalTextPosition(SwingConstants.CENTER); */
		//点击事件
		add1.addActionListener(this);
		update1.addActionListener(this);
		delete1.addActionListener(this);
		select1.addActionListener(this);
		
		add7.addActionListener(this);
		delete7.addActionListener(this);
		update7.addActionListener(this);
		select7.addActionListener(this);
		
		
		add2.addActionListener(this);
		delete2.addActionListener(this);
		update2.addActionListener(this);
		select2.addActionListener(this);
		
		add3.addActionListener(this);
		delete3.addActionListener(this);
		update3.addActionListener(this);
		select3.addActionListener(this);
		
		//update4.addActionListener(this);
		//select4.addActionListener(this);
		
		update5.addActionListener(this);
		
		excel.addActionListener(this);
		
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		
		addStudent = new AddStudent();
		updateStudent = new UpdateStudent(); 
		deleteStudent = new DeleteStudent();
		selectStudent = new SelectStudent();
		
		addTeacher = new AddTeacher();
		updateTeacher = new UpdateTeacher();
		deleteTeacher = new DeleteTeacher();
		selectTeacher = new SelectTeacher();
		
		
		addCourse = new AddCourse();
		deleteCourse = new DeleteCourse();
		updateCourse = new UpdateCourse();
		selectCourse = new SelectCourse();
		
		chooseCourse = new ChooseCourse();
		openCourse = new OpenCourse();
		dropCourse = new DropCourse();
		/*addSC=new AddSC();
		deleteSC=new DeleteSC();
		updateSC=new UpdateSC();
		selectSC=new SelectSC();
				
		updateScore=new UpdateScore();
		selectScore=new SelectScore();
		
		updatePassword=new UpdatePassword();*/
		
		pCenter.add("欢迎界面", label1);
		//pCenter.add("欢迎界面",label2);
		
		pCenter.add("增加学生界面", addStudent);
		pCenter.add("修改学生界面", updateStudent);
		pCenter.add("删除学生界面", deleteStudent);
		pCenter.add("查询学生界面", selectStudent);
		
		pCenter.add("增加教师界面", addTeacher);
		pCenter.add("修改教师界面", updateTeacher);
		pCenter.add("删除教师界面", deleteTeacher);
		pCenter.add("查询教师界面", selectTeacher);
		
		
		pCenter.add("增加课程界面", addCourse);
		pCenter.add("删除课程界面", deleteCourse);
		pCenter.add("修改课程界面", updateCourse);
		pCenter.add("查询课程界面",selectCourse);
		
		pCenter.add("进行选课界面", chooseCourse);
		pCenter.add("开设课程界面", openCourse);
		pCenter.add("退选课程界面", dropCourse);
		/*pCenter.add("修改选课界面",updateSC);
		pCenter.add("查询选课界面",selectSC);
		
		
		pCenter.add("修改成绩界面",updateScore);
		pCenter.add("查询成绩界面",selectScore);
		
		pCenter.add("修改密码界面",updatePassword);*/
		
		add(pCenter,BorderLayout.CENTER);
		//BorderLayout是一个布置容器的边框布局，它可以对容器组件进行安排，并调整其大小，使其符合下列五个区域：北、南、东、西、中。
		validate();//使容器再次布置其子组件,确保组件具有有效的布局
		setVisible(true);
		setBounds(400,150,900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){//关闭程序时的操作
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		validate();
	}
	
	//添加进菜单栏中
	private void addJMenuBar() {
		mb.add(m1);
		mb.add(m7);
		mb.add(m2);
		mb.add(m3);
		//mb.add(m4);
		mb.add(m5);
		mb.add(m6);
	}
	private void addMenu6() {
		m6.add(excel);
		m6.setFont(t);
	}

	private void addMenu5(){
		m5.add(update5);
		m5.setFont(t);
	}
	/*private void addMenu4() {
		
		m4.add(update4);	
		m4.add(select4);
	    m4.setFont(t);
	}*/
	private void addMenu3() {
		m3.add(add3);
		//m3.add(update3);

		m3.add(select3);
		m3.add(delete3);
		m3.setFont(t);
	}
	private void addMenu2() {//将菜单加入到菜单栏中
		m2.add(add2);
		m2.add(update2);
		m2.add(delete2);
		m2.add(select2);
		m2.setFont(t);
	}
	private void addMenu1() {
		m1.add(add1);
		m1.add(update1);
		m1.add(delete1);
		m1.add(select1);
		m1.setFont(t);//字体
	}
	private void addMenu7()
	{
		m7.add(add7);
		m7.add(update7);
		m7.add(delete7);
		m7.add(select7);
		m7.setFont(t);//字体
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == excel){System.exit(0);}
		else{if(obj ==add1){
		card.show(pCenter,"增加学生界面");
		}
		else{if(obj == update1){
			card.show(pCenter,"修改学生界面");
		}
		else{if(obj == delete1){
			card.show(pCenter, "删除学生界面");
		}
		else{if(obj == select1){
			card.show(pCenter, "查询学生界面");
		}
		else{if(obj == add2){
			card.show(pCenter, "增加课程界面");
		}
		else{if(obj == delete2){
			card.show(pCenter, "删除课程界面");
		}
		else{if(obj == update2){
			card.show(pCenter, "修改课程界面");
		}
		else{if(obj == select2){
			card.show(pCenter,"查询课程界面");
		}
		else{if(obj == add3){
			card.show(pCenter, "开设课程界面");
		}
		else{if(obj == delete3){
			card.show(pCenter, "退选课程界面");
		}
		else{if(obj == update3){
			//card.show(pCenter, "修改选课界面");
		}
		else{if(obj == select3){
			card.show(pCenter, "进行选课界面");
		}		
		else{if(obj == add7){
			card.show(pCenter, "增加教师界面");
		}
		else{if(obj == update7){
			card.show(pCenter, "修改教师界面");
		}
		else{if(obj == select7){
			card.show(pCenter, "查询教师界面");
		}		
		else{if(obj == delete7){
			card.show(pCenter,"删除教师界面");
		}
		
		
		//else{if(obj==update5){
			//card.show(pCenter,"修改密码界面");
		//}
		}
		}}}}}}}}}}}}}}}
	}
	public static void main(String[] args) {
	      new Home();
	}
}
