package vo;

public class News {
	private String type;//ѧ������ʦ����Ϣ
	private String news;//��Ϣ
	private String time;//ʱ��
    private int id;//id
    private String state;//״̬
	/*����������Ӧ��getter��setter����*/
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
