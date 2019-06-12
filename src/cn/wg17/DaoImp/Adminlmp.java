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
	 * ���ӹ���Ա�û�
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
                System.out.println("����Ա��ӳɹ���");
                return true;
            }
            else{
                System.out.println("����Ա���ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	/*
	 * ���¹���Ա�û�
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
                System.out.println("����Ա���³ɹ���");
                return true;
            }
            else{
                System.out.println("����Ա����ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * ���¹���Ա�û�
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
                System.out.println("����Աɾ���ɹ���");
                return true;
            }
            else{
                System.out.println("����Աɾ��ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * ����ѧ���û�
	 */
	@Override
	public boolean addStudent(Student student)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.addStudent(student);
	}
	
	/*
	 * ����ѧ���û�
	 */
	@Override
	public boolean updateStudent(Student student)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.updateStudent(student);
	}
	
	/*
	 * ɾ��ѧ���û�
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
                System.out.println("ѧ��ɾ���ɹ���");
                return true;
            }
            else{
                System.out.println("ѧ��ɾ��ʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
	}
	
	/*
	 * ͨ��ѧ����id������ѧ���������Ϣ
	 */
	@Override
	public boolean findStudentById(String Sid)
	{
		// TODO Auto-generated method stub
		StudentDaolmp studentDaolmp = new StudentDaolmp();
		return studentDaolmp.findStudentById(Sid);
	}
	
	/*
	 * ���¿γ̵������Ϣ
	 */
	@Override
	public boolean updateCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.updateCourse(course);
	}
	
	/*
	 * ���ӿγ̵������Ϣ
	 */
	@Override
	public boolean addCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.addCourse(course);
	}

	/*
	 * ɾ���γ�	
	 */
	@Override
	public boolean deleteCourse(Course course)
	{
		// TODO Auto-generated method stub
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.deleteCourse(course);
	}
	
	/*
	 * ͨ����ʦ�Ĺ�����������ʦ����Ϣ
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
	 * ������ʦ�û�
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
                System.out.println("��ʦ��ӳɹ���");
                return true;
            }
            else{
                System.out.println("��ʦ���ʧ�ܣ�");
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
	 * ������ʦ����Ϣ
	 */
	@Override
	public boolean updateTeacher(Teacher teacher)
	{
		// TODO Auto-generated method stub
		TeacherDaolmp teacherDaolmp = new TeacherDaolmp();
		return teacherDaolmp.updateTeacher(teacher);
	}

	
	/*
	 * ɾ����ʦ����Ϣ
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
                System.out.println("ɾ����ʦ��Ϣ�ɹ���");
                return true;
            }
            else{
                System.out.println("ɾ����ʦ��Ϣʧ�ܣ�");
                return false;
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}
	
	/*
	 * ��������ѧ��������list��
	 */
	@Override
	public ArrayList<Student> findAllStudent()
	{
		// TODO Auto-generated method stub
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
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			// ��������
			while (rs.next()) {						//һ��һ������
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
         // ���Statement����
         	stmt = con.createStatement();
            String sql = "select * from admin where Aid = '" + admin.getId() + "'";
            //ps = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
			// ��������
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