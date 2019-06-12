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
	 * �������пγ�
	 */
	@Override
	public ArrayList<Course> selectAllCourse()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * ͨ���γ̺������ҿγ̵������Ϣ
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql="select * from course where Cid = " + Cid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
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
				System.out.println("��Ǹ����ѯ�������");
				return false;
			}
			else
			{
				return true;
				//System.out.println("��ѧ��ѧ��Ϊ " + Sid + ", ����Ϊ " + student.getName() + "�� �༶Ϊ" + student.getSclass() + ", Ժϵ " + student.getSdept());
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	
	/*
	 * ���ӿγ�
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
            	System.out.println("�γ���ӳɹ���");
            	return true;
                
            }
            else{
                System.out.println("�γ����ʧ�ܣ�");
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
	 * ���¿γ���Ϣ
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
                System.out.println("�γ̸��³ɹ���");
                return true;
            }
            else{
                System.out.println("�γ̸���ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	
	/*
	 * ɾ���γ���Ϣ
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
                System.out.println("�γ�ɾ���ɹ���");
                return true;
            }
            else{
                System.out.println("�γ�ɾ��ʧ�ܣ�");
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
	 * ͨ���γ̺������ҿγ̵�����
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql="select * from course where Cid = " + Cid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
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
				System.out.println("��Ǹ����ѯ�������");
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql="select * from teacher where Tid in ( select Tid from teacher_course where Cid = '" + Cid + "')";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
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
				System.out.println("��Ǹ����ѯ�������");
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return teacher;
	}

}
