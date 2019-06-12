package cn.wg17.DaoImp;

import java.awt.List;
import java.nio.channels.NonWritableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wg17.Dao.AdminDao;
import cn.wg17.JavaBean.Admin;
import cn.wg17.JavaBean.Course;
import cn.wg17.JavaBean.Student;
import cn.wg17.JavaBean.Teacher;
import cn.wg17.Util.JavaMysql;

public class Adminlmp implements AdminDao
{
	
	/*
	 * 增加管理员用户
	 */
	public boolean addAdmin(Admin admin)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="insert into admin values(?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, admin.getId());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getAname());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("管理员添加成功！");
                return true;
            }
            else{
                System.out.println("管理员添加失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	/*
	 * 更新管理员用户
	 */
	@Override
	public boolean updateAdmin(Admin admin)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="update admin set Apassword = ?, Aname = ? where Aid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, admin.getPassword());
            ps.setString(2, admin.getAname());
            ps.setString(3, admin.getId());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("管理员更新成功！");
                return true;
            }
            else{
                System.out.println("管理员更新失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * 更新管理员用户
	 */
	@Override
	public boolean deleteAdmin(Admin admin)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="delete from admin where Aid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, admin.getId());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("管理员删除成功！");
                return true;
            }
            else{
                System.out.println("管理员删除失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * 增加学生用户
	 */
	@Override
	public boolean addStudent(Student student)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.addStudent(student);
	}
	
	/*
	 * 更新学生用户
	 */
	@Override
	public boolean updateStudent(Student student)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.updateStudent(student);
	}
	
	/*
	 * 删除学生用户
	 */
	@Override
	public boolean deteleStudent(Student student)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="delete from student where Sid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getId());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("学生删除成功！");
                return true;
            }
            else{
                System.out.println("学生删除失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * 通过学生的id来查找学生的相关信息
	 */
	@Override
	public boolean findStudentById(String Sid)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.findStudentById(Sid);
	}
	
	/*
	 * 更新课程的相关信息
	 */
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.updateCourse(course);
	}
	
	/*
	 * 增加课程的相关信息
	 */
	@Override
	public boolean addCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.addCourse(course);
	}

	/*
	 * 删除课程	
	 */
	@Override
	public boolean deleteCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.deleteCourse(course);
	}
	
	/*
	 * 通过老师的工号来查找老师的信息
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
	 * 增加老师用户
	 */
	@Override
	public boolean addTeacher(Teacher teacher)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
        	if(findTeacherById(teacher.getTid()))
        	{
        		return false;
        	}
            con = JavaMysql.getConnection();
            String sql="insert into teacher values(?, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTid());
            ps.setString(2, teacher.getTname());
            ps.setString(3, teacher.getTdept());
            ps.setString(4, teacher.getTpassword());
            
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("教师添加成功！");
                return true;
            }
            else{
                System.out.println("教师添加失败！");
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
	 * 更新老师的信息
	 */
	@Override
	public boolean updateTeacher(Teacher teacher)
	{
		// TODO Auto-generated method stub
		TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
		return teacherDaolmp.updateTeacher(teacher);
	}

	
	/*
	 * 删除老师的信息
	 */
	@Override
	public boolean deteleTeacher(Teacher teacher)
	{
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try {
            con = JavaMysql.getConnection();
            String sql="delete from teacher where Tid = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTid());
            int a = ps.executeUpdate();
            if(a > 0){
                System.out.println("删除老师信息成功！");
                return true;
            }
            else{
                System.out.println("删除老师信息失败！");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * 查找所有学生来存入list中
	 */
	@Override
	public ArrayList<Student> findAllStudent()
	{
		// TODO Auto-generated method stub
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
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {						//一条一条处理
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

	public boolean Login(Admin admin)
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
            String sql = "select * from admin where Aid = '" + admin.getId() + "'";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// 处理结果集
            Admin admin2  = new Admin();
            while (rs.next()) {
            	admin2.setAname(rs.getString("Aname"));
            	admin2.setPassword(rs.getString("Apassword"));
            	break;
            }
			if(admin2.getPassword().equals(admin.getPassword()))
			{
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	

	
}