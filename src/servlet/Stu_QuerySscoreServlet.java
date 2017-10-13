package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;
import vo.Admin;

import dao.SscoreDao;
import dao.StudentDao;
import dao.AdminDao;

public class Stu_QuerySscoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
  		SscoreDao sdao = new SscoreDao();
  		
  		try{
  			ArrayList sscore = sdao.getSscoreByStuno(stu.getStuno());//��ȡ�����Ŀ�����Ϣ
  			if(sscore==null){
  				request.setAttribute("msg3", "�Բ���,����û��ѡ�Σ�");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("sscore", sscore);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_querysscore.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
