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

public class Stu_QueryCredentialServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
		CredentialDao cdao = new CredentialDao();
		
		try{
			ArrayList selectedcredents = cdao.getCredentByStuno(stu.getStuno());//获取该生选好的证书
			if(selectedcredents.size()==0){
				request.setAttribute("msg4", "对不起,您还没有选证书!");
			}
			else{
				request.setAttribute("msg4", null);
				request.setAttribute("selectedcredents",selectedcredents);	
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_querycredential.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
