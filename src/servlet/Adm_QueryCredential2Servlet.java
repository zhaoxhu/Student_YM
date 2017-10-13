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

public class Adm_QueryCredential2Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String credentno = request.getParameter("credentno");
  		SscoreDao sdao = new SscoreDao();	
  		
		try{
			ArrayList sscores = sdao.getSscoreByCredentno(credentno);//获取所选课程的考试信息
			if(sscores.size()==0){
				request.getSession().setAttribute("msg7", "对不起,暂无学生申请证书！");
			}
			else{
				request.setAttribute("msg7", null);
				request.setAttribute("sscores", sscores);
			}
			request.getRequestDispatcher("/jsp/admin/adm_querycredential2.jsp").forward(request, response);//内部跳转
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
