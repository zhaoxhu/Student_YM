package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Burse;

import dao.BurseDao;

public class StuorTea_QueryBurseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  		BurseDao bdao = new BurseDao();
  		try{
  			ArrayList stus = bdao.getStudentByState("提交");//获取奖学金
  			if(stus.size() == 0){
  				request.setAttribute("msg3", "对不起,没有奖学金信息");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("stus", stus);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_queryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
