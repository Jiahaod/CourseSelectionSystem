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
	 * ����Ա�ĵ�½
	 */
	public boolean Login(Admin admin);
	
	/*
	 * ���ӹ���Ա��ɫ
	 * ���¹���Ա��Ϣ
	 * ɾ������Ա��Ϣ
	 */
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(Admin admin);

	/* 
	 * ����Ա��������ѧ��
	 * ����Ա�Խ�ʦ���в���
	 * ����Ա����ѧ��
	 * ����Ա����ѧ���������Ϣ
	 * ����Աɾ��ѧ���˺�
	 * ����Աͨ��ѧ����ѧ������ѧ���������Ϣ
	 */	
	public ArrayList<Student>  findAllStudent();
	public boolean addStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean deteleStudent(Student student);
	public boolean findStudentById(String Sid);
	
	/*
	 * ���¹���Ա�˺�
	 * ����Ա���ӿγ�
	 * ����Ա���¿γ�
	 * ����Աɾ���γ������Ϣ
	 * ͨ����γ̺������ĸ���ʦ�̵�
	 */
	public boolean updateCourse(Course course);
	public boolean addCourse(Course course);
	public boolean deleteCourse(Course course);
	public boolean findTeacherById(String Tid);
	
	/* 
	 * ����Ա�Խ�ʦ���в���
	 * ����Ա������ʦ
	 * ����Ա������ʦ�������Ϣ
	 * ����Աɾ����ʦ�˺�
	 */
	public boolean addTeacher(Teacher teacher);
	public boolean updateTeacher(Teacher teacher);
	public boolean deteleTeacher(Teacher teacher);
	
	
	
	
}
