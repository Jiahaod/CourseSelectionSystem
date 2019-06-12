package cn.wg17.JavaBean;

public class Admin				//管理员	事先发布所有课程的相关信息
{
	/* 管理员的相关属性
	 * 姓名
	 * 密码
	 * 编号
	 */
	/*public Admin(String aname, String apassword, String aid)
	{
		Aname = aname;
		Apassword = apassword;
		Aid = aid;
	}*/
	
	private String Aname;						//管理员姓名
	private String Apassword;					//管理员的密码
	private String Aid;							//管理员的编号
	
	
	public String getPassword()
	{
		return this.Apassword;
	}
	public void setPassword(String password)
	{
		this.Apassword = password;
	}
	public String getId()
	{
		return this.Aid;
	}
	public void setId(String id)
	{
		this.Aid = id;
	}
	public String getAname()
	{
		// TODO Auto-generated method stub
		return this.Aname;
	}
	public void setAname(String string)
	{
		// TODO Auto-generated method stub
		this.Aname = string;
	}
	
}
