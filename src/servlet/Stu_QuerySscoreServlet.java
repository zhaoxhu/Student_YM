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
  			ArrayList sscore = sdao.getSscoreByStuno(stu.getStuno());//获取该生的考试信息
  			if(sscore==null){
  				request.setAttribute("msg3", "对不起,您还没有选课！");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("sscore", sscore);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_querysscore.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
