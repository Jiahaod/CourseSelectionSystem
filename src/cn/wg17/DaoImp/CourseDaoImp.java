package cn.wg17.DaoImp;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wg17.Dao.CourseDao;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class CourseDaoImp implements CourseDao
{
	
	/*
	 * 查找所有课程
	 */
	@Override
	public ArrayList<Course> selectAllCourse()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 通过课程号来查找课程的相关信息
	 */
	@Override
	public boolean findCourseById(String Cid)
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
            String sql="select * from course where Cid = " + Cid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            Course course = new Course();
            int flag = 0;
            while (rs.next()) {
            	course.setCname(rs.getString("Cname"));
            	course.setClimit(rs.getInt("Climit"));
            	course.setClocation(rs.getString("Clocation"));
            	course.setcredit(rs.getInt("credit"));
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
				return true;
				//System.out.println("该学生学号为 " + Sid + ", 姓名为 " + student.getName() + "， 班级为" + student.getSclass() + ", 院系 " + student.getSdept());
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	
	/*
	 * 增加课程
	 */
	@Override
	public boolean addCourse(Course course)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
        	
        	if(findCourseById(course.getCid()))
        	{
        		return false;
        	}
        	
            con = JavaMysql.getConnection();
            String sql = "insert into course values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, course.getCid());
            ps.setString(2, course.getCname());
            ps.setInt(3, course.getClimit());
            ps.setString(4, course.getClocation());
            ps.setInt(5, course.getcredit());
            
            int a = ps.executeUpdate();
            if(a>0){
            	System.out.println("课程添加成功！");
            	return true;
                
            }
            else{
                System.out.println("课程添加失败！");
            	return false;
            }
         }
         catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	
	/*
	 * 更新课程信息
	 */
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql = "update course set Cname = ?, Climit = ?, Clocation = ?, credit = ? where Cid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, course.getCname());
            ps.setInt(2, course.getClimit());
            ps.setString(3, course.getClocation());
            ps.setInt(4, course.getcredit());
            ps.setString(5, course.getCid());
            int a = ps.executeUpdate();
            if(a > 0){
                System.out.println("课程更新成功！");
                return true;
            }
            else{
                System.out.println("课程更新失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	
	/*
	 * 删除课程信息
	 */
	@Override
	public boolean deleteCourse(Course course)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="delete from course where Cid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getCid());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程删除成功！");
                return true;
            }
            else{
                System.out.println("课程删除失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see cn.wg17.Dao.CourseDao#ReturnCourseInformation(java.lang.String)
	 * 通过课程号来查找课程的内容
	 */
	public Course ReturnCourseInformation(String Cid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;

        Course course = new Course();
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
         // 获得Statement对象
         	stmt = con.createStatement();
            String sql="select * from course where Cid = " + Cid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            int flag = 0;
            while (rs.next()) {
            	course.setCname(rs.getString("Cname"));
            	course.setClimit(rs.getInt("Climit"));
            	course.setClocation(rs.getString("Clocation"));
            	course.setcredit(rs.getInt("credit"));
            	course.setCid(rs.getString("Cid"));
            	flag = 1;
            	break;
            }
			if(flag == 0)
			{
				System.out.println("抱歉，查询不到结果");
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return course;
	}

	@Override
	public Teacher ReturnCourseTeacher(String Cid)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        //PreparedStatement ps = null;
        Statement stmt = null;

        Teacher teacher = new Teacher();
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
         // 获得Statement对象
         	stmt = con.createStatement();
            String sql="select * from teacher where Tid in ( select Tid from teacher_course where Cid = '" + Cid + "')";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            int flag = 0;
            while (rs.next()) {
            	teacher.setTid(rs.getString("Tid"));
            	teacher.setTname(rs.getString("Tname"));
            	teacher.setTdept(rs.getString("Tdept"));
            	flag = 1;
            	break;
            }
			if(flag == 0)
			{
				System.out.println("抱歉，查询不到结果");
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return teacher;
	}

}
