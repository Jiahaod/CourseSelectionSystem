package cn.wg17.JavaBean;

public class Teacher			//老师类
{
	/* 教师的相关属性
	 * 工号
	 * 姓名
	 * 院系
	 * 密码
	 */
	private String Tid;			//教师的编号
	private String Tname;		//教师的姓名， 设置为主键
	private String Tdept;		//教师所在的院系
	private String Tpassword;	//教师的登陆密码
	
	
	public void setTname(String name)
	{
		this.Tname = name;
	}
	public String getTname()
	{
		return this.Tname;
	}
	public void setTid(String id)
	{
		this.Tid = id;
	}
	public String getTid()
	{
		return this.Tid;
	}
	public void setTdept(String dept)
	{
		this.Tdept = dept;
	}
	public String getTdept()
	{
		return this.Tdept;
	}
	public void setTpassword(String password)
	{
		this.Tpassword = password;
	}
	public String getTpassword()
	{
		return this.Tpassword;
	}

}
