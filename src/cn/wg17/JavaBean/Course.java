package cn.wg17.JavaBean;



public class Course		//�����γ̵����
{
	/* �γ̵��������
	 * �γ̺�
	 * �γ���
	 * ��������
	 * ���ڵĽ���
	 * ���ſε�ѧ��
	 */
	private String Cid;			//�γ̺�
	private String Cname;		//�γ���
	private int Climit;		//�γ̵���������
	private String Clocation;  	//�γ����ڵĽ���
	private int credit;		//���ſε�ѧ��
	
	/*public Course(String cid, String cname, int climit, String clocation, int redit)
	{
		Cid = cid;
		Cname = cname;
		Climit = climit;
		Clocation = clocation;
		credit = redit;
	}*/
	
	/*
	 * get��set����
	 */
	public String getCid()
	{
		return  this.Cid;
	}
	
	public String getCname()
	{
		return  this.Cname;
	}
	public int getClimit()
	{
		return this.Climit;
	}
	public String getClocation()
	{
		return this.Clocation;
	}
	public int getcredit()
	{
		return this.credit;
	}
	public void setCid(String id)
	{
		this.Cid = id;
	}
	public void setCname(String name)
	{
		this.Cname = name;
	}
	public void setClimit(int string)
	{
		this.Climit = string;
	}	
	public void setClocation(String location)
	{
		this.Clocation = location;
	}
	public void setcredit(int credit)
	{
		this.credit = credit;
	}
	
}
