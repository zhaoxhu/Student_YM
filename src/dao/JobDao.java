package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


import vo.Job;
import vo.Student;

public class JobDao {
	private Connection conn = null;	

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}


	public ArrayList getJobByStuno(String stuno) throws Exception{//获得相应学号的就业信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_job A join t_student B on A.stuno=B.stuno" 
			+ " where A.stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Job jo = new Job();
			jo.setStuno(stuno);
			jo.setStuname(rs.getString("stuname").trim());
			jo.setStusex(rs.getString("stusex").trim());
			jo.setJob(rs.getString("job").trim());
			jo.setFirm(rs.getString("firm").trim());
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}
	public ArrayList getJobByAdmin(String admin) throws Exception{//获得相应admin的就业信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_job where admin='"+admin+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Job jo = new Job();
			jo.setAdmin(admin);
			jo.setStuname(rs.getString("stuname").trim());
			jo.setStusex(rs.getString("stusex").trim());
			jo.setJob(rs.getString("job").trim());
			jo.setFirm(rs.getString("firm").trim());
			jo.setStuno(rs.getString("stuno").trim());
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}
	public ArrayList getStuByStuno(String stuno) throws Exception{//获得相应学号的就业信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_job A join t_student B on A.stuno=B.stuno" 
			+ " where A.stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Job jo = new Job();
			jo.setStuno(stuno);
			jo.setStuname(rs.getString("stuname").trim());
			jo.setStusex(rs.getString("stusex").trim());
			al.add(jo);
		}
		this.closeConnection();
		return al;
	}
	
	public void insertJob(Job jo)throws Exception{
		this.initConnection();
		String sql = "insert into t_job(stuno,stuname,stusex,job,firm) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, jo.getStuno());
		ps.setString(2, jo.getStuname());
		ps.setString(3, jo.getStusex());
		ps.setString(4, jo.getJob());
		ps.setString(5, jo.getFirm());
		ps.executeUpdate();
		this.closeConnection();
	}

	public void updateJob(Job jo)throws Exception{
		this.initConnection();
		String sql = "update t_job set firm=?,job=? where stuno=?";
		PreparedStatement ps = conn.prepareStatement(sql);	
        ps.setString(1, jo.getFirm());		
		ps.setString(2, jo.getJob());
		ps.setString(3, jo.getStuno());
		ps.executeUpdate();
		this.closeConnection();
	}
	
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
