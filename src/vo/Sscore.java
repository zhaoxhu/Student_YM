package vo;

public class Sscore {//技能分
	
	private String stuno;//学号
	private String stuname;//姓名
	private String credentno;//证书号
	private String credentname;//证书名称
	private float sscore;//分数
	private String state;//状态（admin/root可以选择“暂存”或者“提交”录入的成绩，不同的操作对应不同的状态）
	private String type;//省级，国家级，校级
	/*各个变量对应的getter和setter方法*/
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getCredentno() {
		return credentno;
	}
	public void setCredentno(String credentno) {
		this.credentno = credentno;
	}
	public String getCredentname() {
		return credentname;
	}
	public void setCredentname(String credentname) {
		this.credentname = credentname;
	}
	public float getSscore() {
		return sscore;
	}
	public void setSscore(float sscore) {
		this.sscore = sscore;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
		public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
