package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Credential;
import vo.Student;
import vo.Admin;

import dao.CredentialDao;
import dao.SscoreDao;
import dao.StudentDao;
import dao.AdminDao;

public class Adm_QueryCredential1Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Admin adm = (Admin)request.getSession().getAttribute("admin");
		CredentialDao cdao = new CredentialDao();
		
		try{
			ArrayList credents = cdao.getCredentByAdmno(adm.getAdmno());//��ȡ����Ա��ͨ����֤��
			//ArrayList credents = cdao.getCredentByAdmno("admin");//��ȡ����Ա��ͨ����֤��
			if(credents.size()!=0){
				request.setAttribute("credents",credents);
			}
			request.getRequestDispatcher("/jsp/admin/adm_querycredential1.jsp").forward(request, response);//�ڲ���ת
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
