package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Burse;

public class BurseDao {
	private Connection conn = null;

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}

	public Burse getStudentByBurse(String burse) throws Exception{//通过几等奖学金来获取学生信息
		Burse stu = new Burse();//attention！
		this.initConnection();
		Statement stat = conn.createStatement();
		String sql = "select * from t_burse where burse='"+burse+"'";
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()){
			stu.setBurse(burse);
			stu.setStuno(rs.getString("stuno").trim());
			stu.setStuname(rs.getString("stuname").trim());	
			stu.setStusex(rs.getString("stusex").trim());
			stu.setStusex(rs.getString("state").trim());
		}
		this.closeConnection();
		return stu;		
	}
	public ArrayList getStudentByState(String states) throws Exception{//通过状态来获取学生信息
//	Burse stu = null;//attention！
	this.initConnection();
	ArrayList al = new ArrayList();
	Statement stat = conn.createStatement();
	String sql = "select * from t_burse where state='"+states+"'";
	ResultSet rs = stat.executeQuery(sql);
	while(rs.next()){
		Burse stu = new Burse();
		stu.setState(states);
		stu.setBurse(rs.getString("burse").trim());
		stu.setStuno(rs.getString("stuno").trim());
		stu.setStuname(rs.getString("stuname").trim());	
		stu.setStusex(rs.getString("stusex").trim());	
		al.add(stu);
	}
	this.closeConnection();
	return al;		
	}

	public void insertBurse(Burse stu) throws Exception{//向数据库中插入奖学金信息
		this.initConnection();
		String sql = "insert into t_burse(stuno,stuname,stusex,burse,state) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getStuno());
		ps.setString(2, stu.getStuname());
		ps.setString(3, stu.getStusex());
		ps.setString(4, stu.getBurse());
		ps.setString(5, stu.getState());
		ps.executeUpdate();
		this.closeConnection();
	}
	public void delBurse(Burse stu) throws Exception{//删除表
		this.initConnection();
		String sql = "delete from t_burse where state=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getState());
		ps.executeUpdate();
		this.closeConnection();
	}
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
