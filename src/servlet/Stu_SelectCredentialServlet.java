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
				request.setAttribute("msg2", "�Բ���,���Ѿ�ѡ��֤���ˣ�");
			}
			else{
				CredentialDao cdao = new CredentialDao();
				/*������ѡ��,�����ݿ��ȡ���пγ�,����request��*/
				ArrayList allcredent = cdao.getAllCredent();
				for(int i=0;i<allcredent.size();i++){
					Credential cou = (Credential)allcredent.get(i);
				}
				request.setAttribute("allcredent",allcredent);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcredential.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*Ϊ�����̣���ϵͳҪ��ѧ��ѡ�ε���ѧ�ָպ���7��ѡ��ɹ���ϵͳ�Զ����Գɼ�������Ӽ�¼������ѡ��ʧ�ܣ�����ˢ�º���ͣ����ҳ��*/
		Student stu = (Student)request.getSession().getAttribute("student");
		SscoreDao sdao = new SscoreDao();
		CredentialDao cdao = new CredentialDao();
		
		try{
			ArrayList al = cdao.getAllCredentname();//�õ����пγ�����
			ArrayList selectedcredent = new ArrayList();
			float allxuefen = 0; 
			/*����ѡȡ�γ̵���ѧ��*/
			for(int i=0;i<al.size();i++){
				String credentname = (String)al.get(i);
				String credentno = request.getParameter(credentname);
				if(credentno!=null){
					Credential cou1 = cdao.getCredentByCredentno(credentno);
					allxuefen += cou1.getCredit(); 
					selectedcredent.add(cou1);
				}	
			}
			/*��ѧ�ָպ���20ʱ��ѡ�γɹ���������Ϣ�����ݿ�*/
			if(allxuefen==7){
				for(int i=0;i<selectedcredent.size();i++){
					Credential cou2 = (Credential)selectedcredent.get(i);
					Sscore sco = new Sscore();
					sco.setStuno(stu.getStuno());
					sco.setCredentno(cou2.getCredentno());
					sdao.insertSscore(sco);
				}
				request.setAttribute("msg2", "ѡ��ɹ���");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcredential.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
}
