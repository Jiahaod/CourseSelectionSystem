package cn.wg17.Test;

import java.awt.List;
import java.util.ArrayList;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.*;
import cn.wg17.Util.*;

public class testStudent
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JavaMysql javaMysql = new JavaMysql();
		/*Student student = new Student();
		student.setId("123");
		student.setName("李四");
		student.setPassword("123456");
		student.setSclass("网工");
		student.setSdept("计算机");
		Course course = new Course();
		course.setCid("21");
		Adminlmp adminlmp = new Adminlmp();
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		//adminlmp.deteleStudent(student);
		studentDaolmp.findCourseById("1203");*/
		/*StudentDaolmp studentDaolmp = new StudentDaolmp();
		ArrayList<Student> list = studentDaolmp.findAllStudent();
		int len = list.size();
		for(int i = 0; i < len; i++)
		{
			
			System.out.println("该同学学号为" + list.get(i).getId() + " 姓名是"
					+ list.get(i).getName() + " 性别是" + list.get(i).getSdept());

		}*/
		Student student = new Student();
		student.setId("1203");
		student.setPassword("123456");
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		studentDaolmp.StudentfindCourseById("1203");
	}

}
