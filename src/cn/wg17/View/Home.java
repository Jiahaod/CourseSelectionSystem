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
	//ѧ������
	AddStudent addStudent;
	UpdateStudent updateStudent;
	DeleteStudent deleteStudent;
	SelectStudent selectStudent;
	
	//��ʦ����
	AddTeacher addTeacher;
	UpdateTeacher updateTeacher;
	DeleteTeacher deleteTeacher;
	SelectTeacher selectTeacher;
	
	//�γ̹���
	AddCourse addCourse;
	DeleteCourse deleteCourse;
	UpdateCourse updateCourse;
	SelectCourse selectCourse;
	//ѡ�ι���
	ChooseCourse chooseCourse;
	OpenCourse openCourse;
	DropCourse dropCourse;
	/*AddSC addSC;
	DeleteSC deleteSC;
	UpdateSC updateSC;
	SelectSC selectSC;
	//�ɼ�����
	UpdateScore updateScore;
	SelectScore selectScore;
	//�޸�����
	UpdatePassword updatePassword;*/
	
	JPanel pCenter;			//JPanel �� Javaͼ���û�����(GUI)���߰�swing�е����������
	CardLayout card = null;	//cardlayout���ǽ�һ������˴˵ڽ����ص��ز��֣�����һ���ſ�Ƭһ��������ÿ��ֻ��չ��һ�����档
	JLabel label1 = null;
	//JLabel label2 = null;
	
	JMenuBar mb = new JMenuBar();//�˵���
	
	JMenu m1 = new JMenu("ѧ������");
	JMenuItem add1 = new JMenuItem("¼��");
	JMenuItem update1 = new JMenuItem("�޸�");
	JMenuItem delete1 = new JMenuItem("ɾ��");
	JMenuItem select1 = new JMenuItem("��ѯ");
	
	JMenu m7 = new JMenu("��ʦ����");
	JMenuItem add7 = new JMenuItem("¼��");
	JMenuItem update7 = new JMenuItem("�޸�");
	JMenuItem delete7 = new JMenuItem("ɾ��");
	JMenuItem select7 = new JMenuItem("��ѯ");
	
	
	JMenu m2 = new JMenu("�γ̹���");
	JMenuItem add2 = new JMenuItem("¼��");
	JMenuItem update2 = new JMenuItem("�޸�");
	JMenuItem delete2 = new JMenuItem("ɾ��");
	JMenuItem select2 = new JMenuItem("��ѯ");
	
	JMenu m3 = new JMenu("ѡ�ι���");
	JMenuItem add3 = new JMenuItem("����");
	JMenuItem update3 = new JMenuItem("�޸�");
	JMenuItem delete3 = new JMenuItem("�˿�");
	JMenuItem select3 = new JMenuItem("ѡ��");
	
	/*JMenu m4=new JMenu("�ɼ�����");
	JMenuItem update4=new JMenuItem("���³ɼ� ");	
	JMenuItem select4=new JMenuItem("��ѯ�ɼ� ");
	*/
	JMenu m5 = new JMenu("�������");
	JMenuItem update5 = new JMenuItem("�޸����� ");	
	
	JMenu m6 = new JMenu("ϵͳ�˳�");
	JMenuItem excel = new JMenuItem("�˳�");
	
	Font t=new Font ("sanerif",Font.PLAIN,15);
    
	public Home(){
		this.setTitle("ѡ��ϵͳ");	
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){System.err.println("�����������:   "+e);}
		//��ϲ˵�
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
		label1 = new JLabel("<html><body>���ã���ӭʹ�ñ���ѡ�ι���ϵͳ��<br><br><br>�����������ǹ���Ա��ѡ����Ҫ���й���Ľ�ɫ��<br><br><br>����ѧ������ʦ������ʹ�á�</body></html>",SwingConstants.CENTER);
		
		label1.setFont(new Font("����",Font.BOLD,36));
		label1.setHorizontalTextPosition(SwingConstants.CENTER); 	
			
		/*label2.setFont(new Font("����",Font.BOLD,36));
		label2.setHorizontalTextPosition(SwingConstants.CENTER); */
		//����¼�
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
		
		pCenter.add("��ӭ����", label1);
		//pCenter.add("��ӭ����",label2);
		
		pCenter.add("����ѧ������", addStudent);
		pCenter.add("�޸�ѧ������", updateStudent);
		pCenter.add("ɾ��ѧ������", deleteStudent);
		pCenter.add("��ѯѧ������", selectStudent);
		
		pCenter.add("���ӽ�ʦ����", addTeacher);
		pCenter.add("�޸Ľ�ʦ����", updateTeacher);
		pCenter.add("ɾ����ʦ����", deleteTeacher);
		pCenter.add("��ѯ��ʦ����", selectTeacher);
		
		
		pCenter.add("���ӿγ̽���", addCourse);
		pCenter.add("ɾ���γ̽���", deleteCourse);
		pCenter.add("�޸Ŀγ̽���", updateCourse);
		pCenter.add("��ѯ�γ̽���",selectCourse);
		
		pCenter.add("����ѡ�ν���", chooseCourse);
		pCenter.add("����γ̽���", openCourse);
		pCenter.add("��ѡ�γ̽���", dropCourse);
		/*pCenter.add("�޸�ѡ�ν���",updateSC);
		pCenter.add("��ѯѡ�ν���",selectSC);
		
		
		pCenter.add("�޸ĳɼ�����",updateScore);
		pCenter.add("��ѯ�ɼ�����",selectScore);
		
		pCenter.add("�޸��������",updatePassword);*/
		
		add(pCenter,BorderLayout.CENTER);
		//BorderLayout��һ�����������ı߿򲼾֣������Զ�����������а��ţ����������С��ʹ���������������򣺱����ϡ����������С�
		validate();//ʹ�����ٴβ����������,ȷ�����������Ч�Ĳ���
		setVisible(true);
		setBounds(400,150,900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){//�رճ���ʱ�Ĳ���
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		validate();
	}
	
	//��ӽ��˵�����
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
	private void addMenu2() {//���˵����뵽�˵�����
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
		m1.setFont(t);//����
	}
	private void addMenu7()
	{
		m7.add(add7);
		m7.add(update7);
		m7.add(delete7);
		m7.add(select7);
		m7.setFont(t);//����
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == excel){System.exit(0);}
		else{if(obj ==add1){
		card.show(pCenter,"����ѧ������");
		}
		else{if(obj == update1){
			card.show(pCenter,"�޸�ѧ������");
		}
		else{if(obj == delete1){
			card.show(pCenter, "ɾ��ѧ������");
		}
		else{if(obj == select1){
			card.show(pCenter, "��ѯѧ������");
		}
		else{if(obj == add2){
			card.show(pCenter, "���ӿγ̽���");
		}
		else{if(obj == delete2){
			card.show(pCenter, "ɾ���γ̽���");
		}
		else{if(obj == update2){
			card.show(pCenter, "�޸Ŀγ̽���");
		}
		else{if(obj == select2){
			card.show(pCenter,"��ѯ�γ̽���");
		}
		else{if(obj == add3){
			card.show(pCenter, "����γ̽���");
		}
		else{if(obj == delete3){
			card.show(pCenter, "��ѡ�γ̽���");
		}
		else{if(obj == update3){
			//card.show(pCenter, "�޸�ѡ�ν���");
		}
		else{if(obj == select3){
			card.show(pCenter, "����ѡ�ν���");
		}		
		else{if(obj == add7){
			card.show(pCenter, "���ӽ�ʦ����");
		}
		else{if(obj == update7){
			card.show(pCenter, "�޸Ľ�ʦ����");
		}
		else{if(obj == select7){
			card.show(pCenter, "��ѯ��ʦ����");
		}		
		else{if(obj == delete7){
			card.show(pCenter,"ɾ����ʦ����");
		}
		
		
		//else{if(obj==update5){
			//card.show(pCenter,"�޸��������");
		//}
		}
		}}}}}}}}}}}}}}}
	}
	public static void main(String[] args) {
	      new Home();
	}
}
