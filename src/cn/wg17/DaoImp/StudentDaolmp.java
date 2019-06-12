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
	 * 增加课程相关信息
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
                System.out.println("学生添加成功！");
                return true;
            }
            else{
                System.out.println("学生添加失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	/*
	 * 更新学生信息
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
                System.out.println("学生更新成功！");
                return true;
            }
            else{
                System.out.println("学生更新失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	
	/*
	 * 通过学号来查找学生的相关信息
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
         // 获得Statement对象
         	stmt = con.createStatement();
            String sql="select * from student where Sid = " + Sid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
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
				System.out.println("抱歉，查询不到结果");
				return false;
			}
			else
			{
				System.out.println("该学生学号为 " + Sid + ", 姓名为 " + student.getName() + "， 班级为" + student.getSclass() + ", 院系 " + student.getSdept());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * 通过课程号来查看课程信息
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
            // 获得Statement对象
         	stmt = con.createStatement();
            String sql = "select * from course where Cid in (select Cid from student_course where Sid = '" + Sid + "')";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
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
	 * 学生进行选课操作
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
                System.out.println("学生选课成功！");
                return true;
            }
            else{
                System.out.println("学生选课失败！");
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
         // 获得Statement对象
            
         	stmt = con.createStatement();
            String sql = "select * from student where Sid = '" + student.getId() + "'";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            Student student1  = new Student();
            while (rs.next()) 
            {
            	student1.setPassword(rs.getString("Spassword"));
            	break;
            }
			if(student1.getPassword().equals(student.getPassword()))
			{
				System.out.println("登陆成功.");
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
		   // 获得Statement对象		            
		   stmt = con.createStatement();
	       String sql = "select * from student where Sid = '" + Sid + "'";
		   //ps = con.prepareStatement(sql);
		   rs = stmt.executeQuery(sql);
		   // 处理结果集
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
		         System.out.println("删除成功！");
		         return true;
		    }
		    else{
		        System.out.println("删除失败！");
		        return false;
		    }
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		     e.printStackTrace();
		}
		return false;
	}
}
