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
import cn.wg17.Util.JavaMysql;



public class SelectStudentUI extends JFrame {
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
	public SelectStudentUI(Student student, Course course) throws ClassNotFoundException{
		columnNames = new Vector();
		// ��������
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�༶");
		columnNames.add("ѧԺ");
		columnNames.add("��ѡ�γ�");
		columnNames.add("�γ̺�");
		columnNames.add("�Ͽεص�");
		
		rowData = new Vector();
		Vector hang = new Vector();
		hang.add(student.getId());
		hang.add(student.getName());
		hang.add(student.getSclass());
		hang.add(student.getSdept());	
		hang.add(course.getCname());
		hang.add(course.getCid());
		hang.add(course.getClocation());
		rowData.add(hang);
		
		jt = new JTable(rowData, columnNames);
		jsp = new JScrollPane(jt);
		this.add(jsp);
		this.setSize(700,300);
		this.setVisible(true);
		}
}