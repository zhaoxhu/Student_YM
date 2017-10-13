package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Credential;
import vo.Sscore;
import vo.Student;

public class SscoreDao {
	private Connection conn = null;	

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}

	public ArrayList getSscoreByCredentno(String credentno) throws Exception{//获得某课程的考试信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_sscore A join t_credential B on A.credentno=B.credentno join t_student C on A.stuno=C.stuno" 
			+ " where A.credentno='"+credentno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Sscore sco = new Sscore();
			sco.setStuno(rs.getString("stuno").trim());
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCredentno(credentno);
			sco.setCredentname(rs.getString("credentname").trim());
			sco.setSscore(rs.getFloat("sscore"));
			String str = rs.getString("state");
			if(str!=null){
				sco.setState(str.trim());
			}
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}

	public ArrayList getSscoreByStuno(String stuno) throws Exception{//获得相应学号的证书信息
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_sscore A join t_student B on A.stuno=B.stuno join t_credential C on A.credentno=C.credentno" 
			+ " where A.stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Sscore sco = new Sscore();
			sco.setStuno(stuno);
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCredentno(rs.getString("credentno").trim());
			sco.setCredentname(rs.getString("credentname").trim());
			sco.setSscore(rs.getFloat("sscore"));
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}

	public void insertSscore(Sscore sco)throws Exception{
		this.initConnection();
		String sql = "insert into t_sscore(stuno,credentno,type) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sco.getStuno());
		ps.setString(2, sco.getCredentno());
		ps.setString(3, sco.getType());
		ps.executeUpdate();
		this.closeConnection();
	}

	public void updateSscore(Sscore sco)throws Exception{
		this.initConnection();
		String sql = "update t_sscore set type=?,sscore=?,state=? where stuno=? and credentno=?";
		PreparedStatement ps = conn.prepareStatement(sql);	
        ps.setString(1, sco.getType());		
		ps.setFloat(2, sco.getSscore());
		ps.setString(3, sco.getState());
		ps.setString(4, sco.getStuno());
		ps.setString(5, sco.getCredentno());
		ps.executeUpdate();
		this.closeConnection();
	}

	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
