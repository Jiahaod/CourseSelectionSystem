package cn.wg17.JavaBean;


public class Student				//ѧ����
{
	/* ѧ�����������
	 * ����			
	 * ���			primary key
	 * �༶
	 * ���ڵ�Ժϵ
	 */
	
	/*public Student(String spassword, String sname, String sid, String sclass, String sdept)
	{
		Spassword = spassword;
		Sname = sname;
		Sid = sid;
		Sclass = sclass;
		Sdept = sdept;
	}*/
	
	private String Spassword;			//ѧ��������	
	private String Sname;				//ѧ��������  		
	private String Sid;					//ѧ����id		����Ϊ����
	private String Sclass;				//ѧ���İ༶
	private String Sdept;				//ѧ�����ڵ�Ժϵ
	
	
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
