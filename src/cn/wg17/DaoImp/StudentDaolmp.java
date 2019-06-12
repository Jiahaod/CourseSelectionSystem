package cn.wg17.DaoImp;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wg17.DaoImp.*;
import cn.wg17.Dao.StudentDao;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class StudentDaolmp implements StudentDao
{

	/*
	 * ���ӿγ������Ϣ
	 */
	@Override
	public boolean addStudent(Student student)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
        	if(findStudentById(student.getId()))
        	{
        		return false;
        	}
            con = JavaMysql.getConnection();
            String sql="insert into student values(?, ?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSclass());
            ps.setString(4, student.getPassword());
            ps.setString(5, student.getSdept());
            
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("ѧ����ӳɹ���");
                return true;
            }
            else{
                System.out.println("ѧ�����ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	/*
	 * ����ѧ����Ϣ
	 */
	@Override
	public boolean updateStudent(Student student)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="update student set Sname = ?, Sclass = ?, Spassword = ?, Sdept = ? where Sid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSclass());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getSdept());
            ps.setString(5, student.getId());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("ѧ�����³ɹ���");
                return true;
            }
            else{
                System.out.println("ѧ������ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	
	/*
	 * ͨ��ѧ��������ѧ���������Ϣ
	 */
	@Override
	public boolean findStudentById(String Sid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
         // ���Statement����
         	stmt = con.createStatement();
            String sql="select * from student where Sid = " + Sid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
            Student student = new Student();
            int flag = 0;
            while (rs.next()) {
            	student.setName(rs.getString("Sname"));
            	student.setSclass(rs.getString("Sclass"));
            	student.setSdept(rs.getString("Sdept"));
            	flag = 1;
            	break;
            }
			if(flag == 0)
			{
				System.out.println("��Ǹ����ѯ�������");
				return false;
			}
			else
			{
				System.out.println("��ѧ��ѧ��Ϊ " + Sid + ", ����Ϊ " + student.getName() + "�� �༶Ϊ" + student.getSclass() + ", Ժϵ " + student.getSdept());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * ͨ���γ̺����鿴�γ���Ϣ
	 */
	@Override
	public Course StudentfindCourseById(String Sid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null; 
        Course course = new Course();
        findStudentById(Sid);
        CourseDaoImp courseDaoImp = new CourseDaoImp();
        try {
            con = JavaMysql.getConnection();
            // ���Statement����
         	stmt = con.createStatement();
            String sql = "select * from course where Cid in (select Cid from student_course where Sid = '" + Sid + "')";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
            Student student = new Student();
            int flag = 0;
            while (rs.next()) {
            	course.setCid(rs.getString("Cid"));
            	course.setCname(rs.getString("Cname"));
            	course.setClimit(rs.getInt("Climit"));
            	course.setClocation(rs.getString("Clocation"));
            	course.setcredit(rs.getInt("credit"));
            	flag = 1;
            	break;
            }
			if(flag == 1)
			{
				System.out.println(course.getCid() +  " " + course.getCname() + " " +course.getClocation());
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return course;
	}

	/*
	 * ѧ������ѡ�β���
	 */
	public boolean choseClass(Student stu, Course course)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="insert into student_course values(?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu.getId());
            ps.setString(2, stu.getName());
            ps.setString(3, course.getCid());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("ѧ��ѡ�γɹ���");
                return true;
            }
            else{
                System.out.println("ѧ��ѡ��ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	public boolean Login(Student student)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
         // ���Statement����
            
         	stmt = con.createStatement();
            String sql = "select * from student where Sid = '" + student.getId() + "'";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
            Student student1  = new Student();
            while (rs.next()) 
            {
            	student1.setPassword(rs.getString("Spassword"));
            	break;
            }
			if(student1.getPassword().equals(student.getPassword()))
			{
				System.out.println("��½�ɹ�.");
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	public Student ReturnStudentInformation(String Sid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 

		Student student  = new Student();
		try {
		   con = JavaMysql.getConnection();
		   // ���Statement����		            
		   stmt = con.createStatement();
	       String sql = "select * from student where Sid = '" + Sid + "'";
		   //ps = con.prepareStatement(sql);
		   rs = stmt.executeQuery(sql);
		   // ��������
		   while (rs.next()) 
		   {
			   	student.setId(Sid);
			   	student.setName(rs.getString("Sname"));
		        student.setPassword(rs.getString("Spassword"));
		        student.setSclass(rs.getString("Sclass"));
		        student.setSdept(rs.getString("Sdept"));
		        break;
		   }
		   //return student;
		} catch (Exception e) {
		            // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean DropCourse(String Cid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try {
			con = JavaMysql.getConnection();
		    String sql="delete from student_course where Cid = '" + Cid + "'";
		    ps=con.prepareStatement(sql);
		    //ps.setString(1, student.getId());
		    int a = ps.executeUpdate();
		    if(a>0){
		         System.out.println("ɾ���ɹ���");
		         return true;
		    }
		    else{
		        System.out.println("ɾ��ʧ�ܣ�");
		        return false;
		    }
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		     e.printStackTrace();
		}
		return false;
	}
}
