package vo;

public class Burse {
	
	private String stuno;//学号
	private String stuname;//姓名
	private String stusex;//性别
	private String burse;//奖学金
	private String state;//状态
	
	/*各个变量对应的getter和setter方法*/
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getBurse() {
		return burse;
	}
	public void setBurse(String burse) {
		this.burse = burse;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
