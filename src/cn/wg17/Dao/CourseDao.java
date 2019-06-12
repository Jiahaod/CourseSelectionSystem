package cn.wg17.Dao;

import java.awt.List;
import java.util.ArrayList;

import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Teacher;

public interface CourseDao
{
	/*
	 * ͨ��id�鿴���ҵ������Ϣ
	 * ����γ�
	 * �޸Ŀγ�
	 * ɾ���γ�
	 */
	public ArrayList<Course> selectAllCourse();
	public boolean findCourseById(String Cid);
	public boolean addCourse(Course course);
	public boolean updateCourse(Course course);
	public boolean deleteCourse(Course course);
	public Course ReturnCourseInformation(String Cid);
	public Teacher ReturnCourseTeacher(String Cid);
}
