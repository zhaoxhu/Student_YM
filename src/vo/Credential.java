package vo;

public class Credential {
	
	private String credentno;//֤���
	private String credentname;//֤������
	private String credenttile;//֤������
	private String adminno;//����Ա
	private float credit;//�γ�ѧ��
	
	
	/*����������Ӧ��getter��setter����*/
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
