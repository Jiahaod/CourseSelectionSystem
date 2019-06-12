package cn.wg17.Test;

import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.StudentDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class testAdmin
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JavaMysql javaMysql = new JavaMysql();
		Admin admin = new Admin();
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		Student student = new Student();
		student.setId("12013");
		student.setName("李四");
		student.setPassword("123456");
		student.setSclass("网工");
		student.setSdept("计算机");
		admin.setAname("张三");
		admin.setId("14");
		admin.setPassword("13465");
		Course course = new Course();
		/*course.setCname("");
		
		//adminlmp.addStudent(student);
		studentDaolmp.choseClass(stu, course);*/
		course.setCid("101");
		course.setClimit(40);
		course.setClocation("第三教室");
		course.setCname("Java");
		course.setcredit(3);
		
		Adminlmp adminlmp = new Adminlmp();
		Teacher teacher = new Teacher();
		teacher.setTid("144");
		teacher.setTname("马哥");
		teacher.setTdept("计算机");
		teacher.setTpassword("1455");
		adminlmp.addCourse(course);
	}

}
