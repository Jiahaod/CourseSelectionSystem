package cn.wg17.Dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;

public interface AdminDao
{
	/*
	 * 管理员的登陆
	 */
	public boolean Login(Admin admin);
	
	/*
	 * 增加管理员角色
	 * 更新管理员信息
	 * 删除管理员信息
	 */
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(Admin admin);

	/* 
	 * 管理员查找所有学生
	 * 管理员对教师进行操作
	 * 管理员增加学生
	 * 管理员更新学生的相关信息
	 * 管理员删除学生账号
	 * 管理员通过学生的学号来查学生的相关信息
	 */	
	public ArrayList<Student>  findAllStudent();
	public boolean addStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean deteleStudent(Student student);
	public boolean findStudentById(String Sid);
	
	/*
	 * 更新管理员账号
	 * 管理员增加课程
	 * 管理员更新课程
	 * 管理员删除课程相关信息
	 * 通过查课程号来查哪个老师教的
	 */
	public boolean updateCourse(Course course);
	public boolean addCourse(Course course);
	public boolean deleteCourse(Course course);
	public boolean findTeacherById(String Tid);
	
	/* 
	 * 管理员对教师进行操作
	 * 管理员增加老师
	 * 管理员更新老师的相关信息
	 * 管理员删除老师账号
	 */
	public boolean addTeacher(Teacher teacher);
	public boolean updateTeacher(Teacher teacher);
	public boolean deteleTeacher(Teacher teacher);
	
	
	
	
}
