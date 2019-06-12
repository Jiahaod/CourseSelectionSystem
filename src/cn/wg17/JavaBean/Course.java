package cn.wg17.JavaBean;



public class Course		//基础课程的相关
{
	/* 课程的相关属性
	 * 课程号
	 * 课程名
	 * 上限人数
	 * 所在的教室
	 * 该门课的学分
	 */
	private String Cid;			//课程号
	private String Cname;		//课程名
	private int Climit;		//课程的人数上限
	private String Clocation;  	//课程所在的教室
	private int credit;		//该门课的学分
	
	/*public Course(String cid, String cname, int climit, String clocation, int redit)
	{
		Cid = cid;
		Cname = cname;
		Climit = climit;
		Clocation = clocation;
		credit = redit;
	}*/
	
	/*
	 * get、set方法
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
