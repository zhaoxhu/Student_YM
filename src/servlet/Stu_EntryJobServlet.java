package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import vo.Job;
import vo.Student;



import dao.CourseDao;
import dao.JobDao;
import dao.StudentDao;

public class Stu_EntryJobServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student"); 
  		JobDao jdao = new JobDao();		
  		
		try{
			ArrayList jobs = jdao.getStuByStuno(stu.getStuno());
			if(jobs.size()==0){
				Job jo = new Job();
				jo.setStuno(stu.getStuno());
				jo.setStusex(stu.getStusex());
				jo.setStuname(stu.getStuname());
				jdao.insertJob(jo);
				
			}
			request.setAttribute("msg5", null);
			request.setAttribute("jobs", jobs);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_entrysjob.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String operate = request.getParameter("submit");//��ʦ��ѡ���������ݴ桱���ߡ��ύ��
	  	String jobs = request.getParameter("job");
	  	String firms = request.getParameter("firm");
	  	String stunos = request.getParameter("stuno");
	   	JobDao jdao = new JobDao();
	   	
	   	if(jobs!=null){
		   		 try{
		   			 Job jo = new Job();
		   			 jo.setState(operate);
		   			 jo.setFirm(firms);
		   			 jo.setJob(jobs);
		   			 jo.setStuno(stunos);
		   		 	 jdao.updateJob(jo);
		   		 	 request.setAttribute("msg6", "֤��¼��ɹ���");
		   		 }catch(Exception ex){	ex.printStackTrace();}
		   	  }
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_entrysjob.jsp");
		dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
	}
}
