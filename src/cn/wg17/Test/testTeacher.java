package cn.wg17.Test;

import java.awt.List;
import java.util.ArrayList;

import cn.wg17.Dao.TeacherDao;
import cn.wg17.DaoImp.Adminlmp;
import cn.wg17.DaoImp.CourseDaoImp;
import cn.wg17.DaoImp.TeacherDaolmp;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class testTeacher
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Adminlmp adminlmp = new Adminlmp();
		TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
		/*Teacher teacher = new Teacher();
		teacher.setTid("14");
		teacher.setTname("����");
		teacher.setTdept("����s");
		teacher.setTpassword("1455");
		adminlmp.addTeacher(teacher);
		//TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
		//teacherDaolmp.updateTeacher(teacher);
		/*adminlmp.deteleTeacher(teacher);*/
		//adminlmp.findTeacherById("141");
		//teacherDaolmp.findTeacherById("14");
		/*ArrayList<Student> list = teacherDaolmp.findAllStudentWhoChooseIt("21");
		int len = list.size();
		for(int i = 0; i < len; i++)
		{
			
			System.out.println("��ͬѧѧ��Ϊ" + list.get(i).getId() + " ������"
					+ list.get(i).getName() + " �Ա���" + list.get(i).getSdept());

		}*/
		/*Course course = new Course();
		course.setCid("101");
		course.setClimit(40);
		course.setClocation("��������");
		course.setCname("Java");
		course.setcredit(3);
		Teacher teacher = new Teacher();
		teacher.setTid("144");
		teacher.setTname("���");
		teacher.setTdept("�����");
		teacher.setTpassword("1455");*/
		Teacher teacher = new Teacher();
		
		//teacher = teacherDaolmp.ReturnTeacherInformation("144");
		Course course = new Course();
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		teacher = courseDaoImp.ReturnCourseTeacher("101");
		//System.out.println(teacher.getTname() + " " + teacher.getTdept());
	}
}
