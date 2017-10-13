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
  			ArrayList stus = bdao.getStudentByState("�ύ");//��ȡ��ѧ��
  			if(stus.size() == 0){
  				request.setAttribute("msg3", "�Բ���,û�н�ѧ����Ϣ");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("stus", stus);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_queryburse.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
