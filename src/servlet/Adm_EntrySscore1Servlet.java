package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

public class Adm_EntrySscore1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Admin adm = (Admin)request.getSession().getAttribute("admin");
		CredentialDao cdao = new CredentialDao();
		
		try{
			ArrayList credentials = cdao.getCredentByAdmno(adm.getAdmno());//��ȡ����Աӵ�е�֤��
			if(credentials.size()!=0){
				request.setAttribute("credentials",credentials);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entrysscore1.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
