package vo;

public class Credential {
	
	private String credentno;//证书号
	private String credentname;//证书名称
	private String credenttile;//证书类型
	private String adminno;//管理员
	private float credit;//课程学分
	
	
	/*各个变量对应的getter和setter方法*/
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public String getCredenttile() {
		return credenttile;
	}
	public void setCredenttile(String credenttile) {
		this.credenttile = credenttile;
	}
	public String getCredentname() {
		return credentname;
	}
	public void setCredentname(String credentname) {
		this.credentname = credentname;
	}
	public String getCredentno() {
		return credentno;
	}
	public void setCredentno(String credentno) {
		this.credentno = credentno;
	}
	public String getAdminno() {
		return adminno;
	}
	public void setAdminno(String adminno) {
		this.adminno = adminno;
	}
	
	
}
