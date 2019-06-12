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
	 * ��ʦ���п���γ̲���
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
                System.out.println("����γ̳ɹ���");
                return true;
            }
            else{
                System.out.println("�������ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}

	/*
	 * ��ʦ���и��¿γ̲���
	 */
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.updateCourse(course);
	}

	/*
	 * ��ʦ�����Լ��������Ϣ
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
                System.out.println("������ʦ��Ϣ�ɹ���");
                return true;
            }
            else{
                System.out.println("������ʦ��Ϣʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * ͨ����ʦ�Ĺ�����������Ϣ
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql="select * from teacher where Tid = " + Tid;
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
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
				System.out.println("��Ǹ����ѯ�������");
				return false;
			}
			else
			{
				System.out.println("�ý�ʦ����Ϊ " + Tid + ", ����Ϊ " + teacher.getTname() + ",Ժϵ " + teacher.getTdept());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * ͨ����ʦ�Ĺ�����������������Ŀγ�
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql = "select Cname from course where Cid in (select Cid from teacher_course where Tid = " + Tid + ")";;
            rs = stmt.executeQuery(sql);
			// ��������
            Course course = new Course();
            int flag = 0;
            while (rs.next()) {
            	course.setCname(rs.getString("Cname"));
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
				System.out.println( "���ڿγ�Ϊ" + course.getCname());
				return true;
			}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * ͨ���γ̺�������ѡ�ÿε�ѧ��
	 */
	public ArrayList<Student> findAllStudentWhoChooseIt(String Cid)
	{
		Connection conn = null;						//����
		Statement stmt = null;						
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();	//��������
		try {										//�����쳣
			// ������ݵ�����
			conn = JavaMysql.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "select * from student where Sid in (select Sid from student_course where Cid = " + Cid + ")";
			rs = stmt.executeQuery(sql);
			// ��������
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
		// ���Statement����
		    stmt = con.createStatement();
		    String sql = "select * from teacher where Tid = '" + teacher.getTid() + "'";
		    //ps = con.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
			// ��������
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
		   // ���Statement����		            
		   stmt = con.createStatement();
	       String sql = "select * from teacher where Tid = '" + Tid + "'";
		   //ps = con.prepareStatement(sql);
		   rs = stmt.executeQuery(sql);
		   //int flag = 0;
		   // ��������
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
		    // ���Statement����
		    stmt = con.createStatement();
		    String sql = "select * from course where Cid in (select Cid from teacher_course where Tid = '" + Tid + "')";
		    //ps = con.prepareStatement(sql);
		    rs = stmt.executeQuery(sql);
			// ��������
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
