package cn.wg17.Dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;

public interface TeacherDao
{
	/*
	 * ������ʦ
	 * ���ӿγ�
	 * ɾ���γ�
	 * ���¿γ�
	 * �����Լ�����Ϣ
	 * ͨ�������Լ��Ĺ�������γ�
	 * ͨ������������ʦ
	 * ��ʦ�ĵ�½
	 */
	public boolean openCourse(Teacher teacher, Course course);
	//public void deleteCourse(Course course);
	public boolean updateCourse(Course course);
	public ArrayList<Student> findAllStudentWhoChooseIt(String Cid);
	public boolean updateTeacher(Teacher teacher);
	public boolean findClassById(String Tid);
	public boolean findTeacherById(String Tid);
	public boolean Login(Teacher teacher);
	public Teacher ReturnTeacherInformation(String Tid);
	public Course TeacherfindCourseById(String Tid);
	
}
