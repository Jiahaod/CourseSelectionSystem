package cn.wg17.Dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;

public interface StudentDao
{
	/* 
	 * 增加学生账号
	 * 更新学生的相关信息
	 * 学生进行选课
	 * 通过学生的学号来查学生的相关信息
	 * 学生的登陆
	 */	
		
	public boolean addStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean findStudentById(String Sid);
	public boolean choseClass(Student stu, Course course);
	public Course StudentfindCourseById(String Sid);
	public boolean Login(Student student);
	public Student ReturnStudentInformation(String Sid);
	public boolean DropCourse(String Cid);
}
