package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.News;


import dao.NewsDao;


public class Tea_QueryNewsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  		NewsDao ndao = new NewsDao();
  		
  		try{
  			ArrayList news = ndao.getNewsByType("teacher");//获取老师消息
	
  			if(news==null){
  				request.setAttribute("msg3", "对不起,您还没有消息！");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("news", news);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/tea_querynews.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
