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
	 * ����ѧ���˺�
	 * ����ѧ���������Ϣ
	 * ѧ������ѡ��
	 * ͨ��ѧ����ѧ������ѧ���������Ϣ
	 * ѧ���ĵ�½
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
