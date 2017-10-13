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
import vo.Job;

import dao.JobDao;
import dao.StudentDao;

public class Adm_QueryJobServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  		JobDao jdao = new JobDao();
  		
  		try{
  			ArrayList jobs = jdao.getJobByAdmin("admin");//获取该生的就业信息
  			if(jobs.size() == 0){
  				request.setAttribute("msg3", "对不起,该生还没有就业信息！");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("jobs", jobs);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_queryjob.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
