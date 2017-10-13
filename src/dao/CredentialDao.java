package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Credential;

public class CredentialDao {
	private Connection conn = null;
	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}
	/** 
	 * FunName:           getAllCoursename 
	 * Description :      获取所有的课程名称
	 * @param：			  无
	 * @return：			  ArrayList
	 * @Author:           王昭阳
	 * @Create Date:      2010-08-08
	 */
	public ArrayList getAllCredentname() throws Exception{//获得所有证书名称
		ArrayList al = new ArrayList();
		this.initConnection();
		String sql = "select distinct(credentname) from t_credential";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			al.add(rs.getString("credentname").trim());
		}
		this.closeConnection();
		return al;
	}

	public ArrayList getAllCredent() throws Exception{//获得所有证书
		ArrayList al = new ArrayList();
		this.initConnection();
		String sql = "select * from t_credential A join t_admin B on A.admno = B.admno";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Credential cou = new Credential();
			cou.setCredentno(rs.getString("credentno").trim());
			cou.setCredentname(rs.getString("credentname").trim());
			cou.setCredenttile(rs.getString("title").trim());
			cou.setAdminno(rs.getString("admno").trim());
			cou.setCredit(rs.getFloat("credit"));
			
			al.add(cou);
		}
		this.closeConnection();
		return al;
	}

	public Credential getCredentByCredentno(String credentno) throws Exception{//根据证书号获取证书信息
		this.initConnection();
		Credential cou = null;
		String sql = "select * from t_credential A join t_admin B on A.admno = B.admno where A.credentno='"+credentno+"'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()){
			cou = new Credential();
			cou.setCredentno(credentno);
			cou.setCredentname(rs.getString("credentname").trim());
			cou.setCredenttile(rs.getString("title").trim());
			cou.setAdminno(rs.getString("admno").trim());
			cou.setCredit(rs.getFloat("credit"));
		}
		this.closeConnection();
		return cou;
	}

	public ArrayList getCredentByAdmno(String admno) throws Exception{//获得相应admin的颁布证书情况
		ArrayList al = new ArrayList();
		this.initConnection();
		String sql = "select * from t_credential A join t_admin B on A.admno = B.admno where B.admno='"+admno+"'";;
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Credential cou = new Credential();
			cou.setCredentno(rs.getString("credentno").trim());
			cou.setCredentname(rs.getString("credentname").trim());
			cou.setAdminno(admno);
			cou.setCredenttile(rs.getString("title").trim());
			cou.setCredit(rs.getFloat("credit"));
			al.add(cou);
		}
		this.closeConnection();
		return al;
	}
	
	public ArrayList getCredentByStuno(String stuno) throws Exception{//获得相应学号选好的证书项
		ArrayList al = new ArrayList();
		this.initConnection();
		String sql = "select * from t_credential A join t_sscore B on A.credentno=B.credentno join t_admin C on A.admno=C.admno" 
			+" where B.stuno='"+stuno+"'";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			Credential cou = new Credential();
			cou.setCredentno(rs.getString("credentno").trim());
			cou.setCredentname(rs.getString("credentname").trim());
			cou.setCredenttile(rs.getString("title").trim());
			cou.setAdminno(rs.getString("admno").trim());
			cou.setCredit(rs.getFloat("credit"));
			al.add(cou);
		}
		this.closeConnection();
		return al;
	}

	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
