package cn.wg17.JavaBean;

public class Teacher			//��ʦ��
{
	/* ��ʦ���������
	 * ����
	 * ����
	 * Ժϵ
	 * ����
	 */
	private String Tid;			//��ʦ�ı��
	private String Tname;		//��ʦ�������� ����Ϊ����
	private String Tdept;		//��ʦ���ڵ�Ժϵ
	private String Tpassword;	//��ʦ�ĵ�½����
	
	
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
