package vo;

public class Sscore {//���ܷ�
	
	private String stuno;//ѧ��
	private String stuname;//����
	private String credentno;//֤���
	private String credentname;//֤������
	private float sscore;//����
	private String state;//״̬��admin/root����ѡ���ݴ桱���ߡ��ύ��¼��ĳɼ�����ͬ�Ĳ�����Ӧ��ͬ��״̬��
	private String type;//ʡ�������Ҽ���У��
	/*����������Ӧ��getter��setter����*/
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
