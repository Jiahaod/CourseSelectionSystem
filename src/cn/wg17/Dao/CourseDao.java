package cn.wg17.Dao;

import java.awt.List;
import java.util.ArrayList;

import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Teacher;

public interface CourseDao
{
	/*
	 * 通过id查看教室的相关信息
	 * 开设课程
	 * 修改课程
	 * 删除课程
	 */
	public ArrayList<Course> selectAllCourse();
	public boolean findCourseById(String Cid);
	public boolean addCourse(Course course);
	public boolean updateCourse(Course course);
	public boolean deleteCourse(Course course);
	public Course ReturnCourseInformation(String Cid);
	public Teacher ReturnCourseTeacher(String Cid);
}
