package cn.wg17.DaoImp;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

import cn.wg17.Dao.TeacherDao;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class TeacherDaolmp implements TeacherDao
{
	/*
	 * 教师进行开设课程操作
	 */
	@Override
	public boolean openCourse(Teacher teacher, Course course)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="insert into teacher_course values(?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getCid());
            ps.setString(2, course.getCname());
            ps.setString(3, teacher.getTname());
            ps.setString(4, teacher.getTid());


            
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("开设课程成功！");
                return true;
            }
            else{
                System.out.println("开设添加失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	/*
	 * 教师进行更新课程操作
	 */
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.updateCourse(course);
	}

	/*
	 * 教师更新自己的相关信息
	 */
	@Override
	public boolean updateTeacher(Teacher teacher)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="update teacher set Tname = ?, Tdept = ?, Tpassword = ? where Tid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTname());
            ps.setString(2, teacher.getTdept());
            ps.setString(3, teacher.getTpassword());
            ps.setString(4, teacher.getTid());
            int a = ps.executeUpdate();
            if(a > 0){
                System.out.println("更新老师信息成功！");
                return true;
            }
            else{
                System.out.println("更新老师信息失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * 通过教师的工号来查找信息
	 */
	@Override
	public boolean findTeacherById(String Tid)
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
            String sql="select * from teacher where Tid = " + Tid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            Teacher teacher = new Teacher();
            int flag = 0;
            while (rs.next()) {
    			teacher.setTname(rs.getString("Tname"));
    			teacher.setTdept(rs.getString("Tdept"));
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
				System.out.println("该教师工号为 " + Tid + ", 姓名为 " + teacher.getTname() + ",院系 " + teacher.getTdept());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * 通过教师的工号来查找他所开设的课程
	 */
	@Override
	public boolean findClassById(String Tid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null; 
        findTeacherById(Tid);
        try {
            con = JavaMysql.getConnection();
         // 获得Statement对象
         	stmt = con.createStatement();
            String sql = "select Cname from course where Cid in (select Cid from teacher_course where Tid = " + Tid + ")";;
            rs = stmt.executeQuery(sql);
			// 处理结果集
            Course course = new Course();
            int flag = 0;
            while (rs.next()) {
            	course.setCname(rs.getString("Cname"));
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
				System.out.println( "教授课程为" + course.getCname());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * 通过课程号来找找选该课的学生
	 */
	public ArrayList<Student> findAllStudentWhoChooseIt(String Cid)
	{
		Connection conn = null;						//连接
		Statement stmt = null;						
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();	//建立对象
		try {										//处理异常
			// 获得数据的连接
			conn = JavaMysql.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "select * from student where Sid in (select Sid from student_course where Cid = " + Cid + ")";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {						
				Student javaBean = new Student();
				javaBean.setId(rs.getString("Sid"));
				javaBean.setName(rs.getString("Sname"));
				javaBean.setSclass(rs.getString("Sclass"));
				javaBean.setPassword(rs.getString("Spassword"));
				javaBean.setSdept(rs.getString("Sdept"));
				list.add(javaBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaMysql.release(rs, stmt, conn);
		}
		return null;
		
	}

	public boolean Login(Teacher teacher)
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
		    String sql = "select * from teacher where Tid = '" + teacher.getTid() + "'";
		    //ps = con.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
			// 处理结果集
		    Teacher teacher2  = new Teacher();
		    while (rs.next()) {
		    	teacher2.setTpassword(rs.getString("Tpassword"));
		         break;
		    }
			if(teacher2.getTpassword().equals(teacher.getTpassword()))
			{
				return true;
			}
	} catch (Exception e) {
		            // TODO Auto-generated catch block
		    e.printStackTrace();
		  }
	return false;
		
	}

	@Override
	public Teacher ReturnTeacherInformation(String Tid)
	{
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 

		Teacher teacher = new Teacher();
		try {
		   con = JavaMysql.getConnection();
		   // 获得Statement对象		            
		   stmt = con.createStatement();
	       String sql = "select * from teacher where Tid = '" + Tid + "'";
		   //ps = con.prepareStatement(sql);
		   rs = stmt.executeQuery(sql);
		   //int flag = 0;
		   // 处理结果集
		   while (rs.next()) 
		   {
			   
			   teacher.setTid(rs.getString("Tid"));
			   teacher.setTname(rs.getString("Tname"));
			   teacher.setTdept(rs.getString("Tdept"));
			   teacher.setTpassword(rs.getString("Tpassword"));
			   
		        break;
		   }
		   //if(flag == 1)
		   //{
			//   System.out.println("Yes");
		  // }
		   //return student;
		} catch (Exception e) {
		            // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Course TeacherfindCourseById(String Tid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
		//PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null; 
		Course course = new Course();
		//findStudentById(Sid);
		//CourseDaoImp courseDaoImp = new CourseDaoImp();
		TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
		try {
			con = JavaMysql.getConnection();
		    // 获得Statement对象
		    stmt = con.createStatement();
		    String sql = "select * from course where Cid in (select Cid from teacher_course where Tid = '" + Tid + "')";
		    //ps = con.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
			// 处理结果集
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

}
