package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Course;
import vo.Score;
import vo.ScoreSection;
import vo.Student;

public class ScoreDao {
	private Connection conn = null;	

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}

	public ArrayList getScoreByCourseno(String courseno) throws Exception{//���ĳ�γ̵Ŀ�����Ϣ
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_score A join t_course B on A.courseno=B.courseno join t_student C on A.stuno=C.stuno" 
			+ " where A.courseno='"+courseno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Score sco = new Score();
			sco.setStuno(rs.getString("stuno").trim());
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCourseno(courseno);
			sco.setCoursename(rs.getString("coursename").trim());
			sco.setScore(rs.getFloat("score"));
			String str = rs.getString("state");
			if(str!=null){
				sco.setState(str.trim());
			}
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}

	public ArrayList getScoreSectionByCourseno(String courseno) throws Exception{//���ĳ�γ̵ĳɼ��ֲ�
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select courseno,coursename,case when score between 0 and 60 then '0-60' "+
					      				" when score between 60 and 70 then '60-70'"+
					      				" when score between 70 and 80 then '70-80'"+
					      				" when score between 80 and 90 then '80-90'"+
					      				" else '90-100' end as ������,count(*)���� "+
					 " from (select A.courseno courseno,B.coursename coursename,A.score score from" +
					 " t_score A join t_course B on A.courseno=B.courseno where A.courseno='"+courseno+"')"+
					 " group by courseno,coursename,case when score between 0 and 60 then '0-60'"+
					 					" when score between 60 and 70 then '60-70'"+ 
					 					" when score between 70 and 80 then '70-80'"+ 
					 					" when score between 80 and 90 then '80-90'"+ 
					 					" else '90-100' end order by count(*)";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			ScoreSection ss = new ScoreSection();
			ss.setCourseno(courseno);
			ss.setCoursename(rs.getString("coursename").trim());
			ss.setSection(rs.getString("������"));
			ss.setNumber(rs.getInt("����"));
			al.add(ss);
		}
		this.closeConnection();
		return al;
	}
	
	public ArrayList getScoreByStuno(String stuno) throws Exception{//�����Ӧѧ�ŵĿ�����Ϣ
		this.initConnection();
		ArrayList al = new ArrayList();
		Statement stat = conn.createStatement();
		String sql = "select * from t_score A join t_student B on A.stuno=B.stuno join t_course C on A.courseno=C.courseno" 
			+ " where A.stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Score sco = new Score();
			sco.setStuno(stuno);
			sco.setStuname(rs.getString("stuname").trim());
			sco.setCourseno(rs.getString("courseno").trim());
			sco.setCoursename(rs.getString("coursename").trim());
			sco.setScore(rs.getFloat("score"));
			al.add(sco);
		}
		this.closeConnection();
		return al;
	}
	public float getSumScoreByStuno(String stuno) throws Exception{//�����Ӧѧ�ŵĿ�����Ϣ
	this.initConnection();
	float sum = 0;
	Statement stat = conn.createStatement();
	String sql = "select * from t_score A join t_student B on A.stuno=B.stuno join t_course C on A.courseno=C.courseno" 
		+ " where A.stuno='"+stuno+"'";
	ResultSet rs = stat.executeQuery(sql);
	while(rs.next()){
		sum += rs.getFloat("score");
	}
	this.closeConnection();
	return sum;
	}

	public void insertScore(Score sco)throws Exception{
		this.initConnection();
		String sql = "insert into t_score(stuno,courseno,type) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sco.getStuno());
		ps.setString(2, sco.getCourseno());
		ps.setString(3, sco.getType());
		ps.executeUpdate();
		this.closeConnection();
	}
	
	public void updateScore(Score sco)throws Exception{
		this.initConnection();
		String sql = "update t_score set type=?,score=?,state=? where stuno=? and courseno=?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, sco.getType());
		ps.setFloat(2, sco.getScore());
		ps.setString(3, sco.getState());
		ps.setString(4, sco.getStuno());
		ps.setString(5, sco.getCourseno());
		ps.executeUpdate();
		this.closeConnection();
	}

	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
