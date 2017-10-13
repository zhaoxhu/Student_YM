package vo;

public class News {
	private String type;//学生或老师的消息
	private String news;//消息
	private String time;//时间
    private int id;//id
    private String state;//状态
	/*各个变量对应的getter和setter方法*/
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
