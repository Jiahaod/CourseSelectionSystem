package cn.wg17.JavaBean;


public class Student				//学生类
{
	/* 学生的相关属性
	 * 密码			
	 * 编号			primary key
	 * 班级
	 * 所在的院系
	 */
	
	/*public Student(String spassword, String sname, String sid, String sclass, String sdept)
	{
		Spassword = spassword;
		Sname = sname;
		Sid = sid;
		Sclass = sclass;
		Sdept = sdept;
	}*/
	
	private String Spassword;			//学生的密码	
	private String Sname;				//学生的姓名  		
	private String Sid;					//学生的id		设置为主键
	private String Sclass;				//学生的班级
	private String Sdept;				//学生所在的院系
	
	
	public String getPassword()
	{
		return this.Spassword;
	}
	public void setPassword(String pass)
	{
		this.Spassword = pass;
	}
	public String getName()
	{
		return this.Sname;
	}
	public void setName(String name)
	{
		this.Sname = name;
	}
	public String getId()
	{
		return this.Sid;
	}
	public void setId(String id)
	{
		this.Sid = id;
	}
	public String getSclass()
	{
		return this.Sclass;
	}
	public void setSclass(String sclass)
	{
		this.Sclass = sclass;
	}
	public String getSdept()
	{
		return this.Sdept;
	}
	public void setSdept(String sdept)
	{
		this.Sdept = sdept;
	}
}
