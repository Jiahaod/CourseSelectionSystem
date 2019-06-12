package cn.wg17.View;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;

public class SelectTeacherUI extends JFrame {
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
	public SelectTeacherUI(Teacher teacher, Course course) throws ClassNotFoundException{
		columnNames = new Vector();
		// 设置列名
		columnNames.add("课程号");
		columnNames.add("课程名");
		columnNames.add("限制人数");
		columnNames.add("教室位置");
		//columnNames.add("班级");
		columnNames.add("教授老师");
		columnNames.add("老师工号");
		//columnNames.add("上课地点");
		
		rowData = new Vector();
		Vector hang = new Vector();
		hang.add(teacher.getTid());
		hang.add(teacher.getTname());
		hang.add(teacher.getTdept());
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