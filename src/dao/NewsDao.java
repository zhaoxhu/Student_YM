package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.News;

public class NewsDao {
	private Connection conn = null;

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}

		public ArrayList getNewsByType(String type) throws Exception{//获得相应type信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_new where type='"+type+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			News jo = new News();
			jo.setType(type);
			jo.setNews(rs.getString("news").trim());
			jo.setTime(rs.getString("time").trim());
			jo.setId(rs.getInt("id"));
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}
		public ArrayList getNewsByAdmin(String admin) throws Exception{//获得相应type信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_new where admin='"+admin+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			News jo = new News();
			jo.setType(admin);
			jo.setNews(rs.getString("news").trim());
			jo.setTime(rs.getString("time").trim());
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}
	public ArrayList getNewsById(int id) throws Exception{//获得相应type信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_new where id='"+id+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			News jo = new News();
			jo.setId(id);
//			jo.setNews(rs.getString("news").trim());
//			jo.setTime(rs.getString("time").trim());
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}

	public void insertNews(News jo)throws Exception{
		this.initConnection();
		String sql = "insert into t_new(type,news,time,id) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, jo.getType());
		ps.setString(2, jo.getNews());
		ps.setString(3, jo.getTime());
		ps.setInt(4, jo.getId());

		ps.executeUpdate();
		this.closeConnection();
	}
	/** 

	public void updateNews(News jo)throws Exception{
		this.initConnection();
		String sql = "update t_new set news=?,time=?,type=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);	
        ps.setString(1, jo.getNews());		
		ps.setString(2, jo.getTime());
		ps.setString(3, jo.getType());
		ps.setInt(4, jo.getId());
		ps.executeUpdate();
		this.closeConnection();
	}
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
