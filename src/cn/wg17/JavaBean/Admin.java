package cn.wg17.JavaBean;

public class Admin				//����Ա	���ȷ������пγ̵������Ϣ
{
	/* ����Ա���������
	 * ����
	 * ����
	 * ���
	 */
	/*public Admin(String aname, String apassword, String aid)
	{
		Aname = aname;
		Apassword = apassword;
		Aid = aid;
	}*/
	
	private String Aname;						//����Ա����
	private String Apassword;					//����Ա������
	private String Aid;							//����Ա�ı��
	
	
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
