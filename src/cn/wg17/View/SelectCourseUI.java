package cn.wg17.View;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;



public class SelectCourseUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector rowData, columnNames;//Vector���ṩ��ʵ�ֿ���������Ĺ��ܣ����Ÿ���Ԫ�ؼ������У������ø�����ɾ��һЩԪ��֮�������С��
	Statement stmt=null;

    String sql=null;
	JTable jt = null;
	JScrollPane jsp = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public SelectCourseUI(Teacher teacher, Course course) throws ClassNotFoundException{
		columnNames = new Vector();
		// ��������
		columnNames.add("�γ̺�");
		columnNames.add("�γ���");
		columnNames.add("�Ͽεص�");
		columnNames.add("ѧ��");
		columnNames.add("��ʦ����");
		columnNames.add("�ڿ���ʦ");
		columnNames.add("����ѧԺ");
		
		
		rowData = new Vector();
		Vector hang = new Vector();
		hang.add(course.getCid());
		hang.add(course.getCname());
		hang.add(course.getClocation());
		hang.add(course.getcredit());	
		hang.add(teacher.getTid());
		hang.add(teacher.getTname());
		hang.add(teacher.getTdept());
		rowData.add(hang);
		
		jt = new JTable(rowData, columnNames);
		jsp = new JScrollPane(jt);
		this.add(jsp);
		this.setSize(700,300);
		this.setVisible(true);
		}
}