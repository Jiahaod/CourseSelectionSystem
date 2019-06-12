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
	Vector rowData, columnNames;//Vector类提供了实现可增长数组的功能，随着更多元素加入其中，数组变得更大。在删除一些元素之后，数组变小。
	Statement stmt=null;

    String sql=null;
	JTable jt = null;
	JScrollPane jsp = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public SelectCourseUI(Teacher teacher, Course course) throws ClassNotFoundException{
		columnNames = new Vector();
		// 设置列名
		columnNames.add("课程号");
		columnNames.add("课程名");
		columnNames.add("上课地点");
		columnNames.add("学分");
		columnNames.add("教师工号");
		columnNames.add("授课老师");
		columnNames.add("所属学院");
		
		
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