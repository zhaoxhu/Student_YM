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
			ArrayList selectedcredents = cdao.getCredentByStuno(stu.getStuno());//��ȡ����ѡ�õ�֤��
			if(selectedcredents.size()==0){
				request.setAttribute("msg4", "�Բ���,����û��ѡ֤��!");
			}
			else{
				request.setAttribute("msg4", null);
				request.setAttribute("selectedcredents",selectedcredents);	
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_querycredential.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
