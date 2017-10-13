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
import vo.Sscore;
import vo.Student;
import vo.Admin;

import dao.CredentialDao;
import dao.SscoreDao;
import dao.StudentDao;
import dao.AdminDao;

public class Stu_SelectCredentialServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
		SscoreDao sdao = new SscoreDao();
		
		try{
			ArrayList info = sdao.getSscoreByStuno(stu.getStuno()); 
			if(info.size()!=0){
				request.setAttribute("msg2", "对不起,您已经选好证书了！");
			}
			else{
				CredentialDao cdao = new CredentialDao();
				/*若可以选课,从数据库获取所有课程,放入request中*/
				ArrayList allcredent = cdao.getAllCredent();
				for(int i=0;i<allcredent.size();i++){
					Credential cou = (Credential)allcredent.get(i);
				}
				request.setAttribute("allcredent",allcredent);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcredential.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*为简化流程，该系统要求学生选课的总学分刚好满7则选则成功，系统自动向考试成绩表中添加记录；否则，选课失败，界面刷新后仍停留本页面*/
		Student stu = (Student)request.getSession().getAttribute("student");
		SscoreDao sdao = new SscoreDao();
		CredentialDao cdao = new CredentialDao();
		
		try{
			ArrayList al = cdao.getAllCredentname();//得到所有课程名称
			ArrayList selectedcredent = new ArrayList();
			float allxuefen = 0; 
			/*计算选取课程的总学分*/
			for(int i=0;i<al.size();i++){
				String credentname = (String)al.get(i);
				String credentno = request.getParameter(credentname);
				if(credentno!=null){
					Credential cou1 = cdao.getCredentByCredentno(credentno);
					allxuefen += cou1.getCredit(); 
					selectedcredent.add(cou1);
				}	
			}
			/*总学分刚好满20时，选课成功，更新信息到数据库*/
			if(allxuefen==7){
				for(int i=0;i<selectedcredent.size();i++){
					Credential cou2 = (Credential)selectedcredent.get(i);
					Sscore sco = new Sscore();
					sco.setStuno(stu.getStuno());
					sco.setCredentno(cou2.getCredentno());
					sdao.insertSscore(sco);
				}
				request.setAttribute("msg2", "选择成功！");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcredential.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
}
