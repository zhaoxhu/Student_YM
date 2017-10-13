shi package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Admin;

public class AdminDao {
	private Connection conn = null;

	public void initConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:2120/student","root","zdd5201314");
	}
 Admin getAdminByAdmno(String admno) throws Exception{//ͨ����Ż��ѧ����Ϣ
		Admin adm = null;//attention��
		this.initConnection();
		Statement stat = conn.createStatement();
		String sql = "select * from t_admin where admno='"+admno+"'";
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()){
			adm = new Admin();
			adm.setAdmno(admno);
			adm.setPassword(rs.getString("admpwd").trim());
			adm.setAdmname(rs.getString("admname").trim());	
		}
		this.closeConnection();
		return adm;		
	}

	public void updateAdmin(Admin adm) throws Exception{//�޸Ĺ���Ա��Ϣ
		this.initConnection();
		String sql = "update t_admin set admpwd=? where admno=?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, adm.getPassword());
		ps.setString(2, adm.getAdmno());
		ps.executeUpdate();
		this.closeConnection();
	}

	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
