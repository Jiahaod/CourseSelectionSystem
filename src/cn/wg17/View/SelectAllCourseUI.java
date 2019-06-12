package cn.wg17.View;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.wg17.Util.JavaMysql;


public class SelectAllCourseUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector rowData, columnNames;//Vector���ṩ��ʵ�ֿ���������Ĺ��ܣ����Ÿ���Ԫ�ؼ������У������ø�����ɾ��һЩԪ��֮�������С��
	Statement stmt=null;

    String sql=null;
	JTable jt = null;
	JScrollPane jsp = null;
	PreparedStatement ps = null;
	ResultSet rs=null; 
	public SelectAllCourseUI() throws ClassNotFoundException{
		columnNames = new Vector();
		// ��������
		columnNames.add("�γ̺�");
		columnNames.add("�γ���");
		columnNames.add("���Ƶ�����");
		columnNames.add("��ʦλ��");
		columnNames.add("ѧ��");

		rowData=new Vector();
		String sql1 = "Select * from course";
		sql = sql1;
		try{
		    Connection dbConn1 = JavaMysql.getConnection();
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Vector hang = new Vector();
				hang.add(rs.getString("Cid"));		//System.out.print(rs.getString("sno"));
				hang.add(rs.getString("Cname"));	//System.out.print(rs.getString("sname"));
				hang.add(rs.getString("Climit"));		//System.out.println(rs.getString("ssex"));
				hang.add(rs.getString("Clocation"));	//	System.out.print(rs.getString("sage"));
				hang.add(rs.getString("credit"));		//System.out.print(rs.getString("stel"));
				
				rowData.add(hang);
			}
			jt=new JTable(rowData,columnNames);
			jsp=new JScrollPane(jt);
			this.add(jsp);
			this.setSize(700,300);
			this.setVisible(true);
		}catch(SQLException e1){
			System.out.print("SQL Exception occur.Message is:"+e1.getMessage());
		}
	}
}