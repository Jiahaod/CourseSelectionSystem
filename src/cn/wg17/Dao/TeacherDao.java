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
	 * 对于老师
	 * 增加课程
	 * 删除课程
	 * 更新课程
	 * 更新自己的信息
	 * 通过查找自己的工号来查课程
	 * 通过工号来查老师
	 * 老师的登陆
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
