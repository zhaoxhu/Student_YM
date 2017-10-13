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
 
public class Adm_EntrySscore2Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Admin tea = (Admin)request.getSession().getAttribute("admin"); 
		String credentno = request.getParameter("credentno");
  		SscoreDao sdao = new SscoreDao();		
  		
		try{
			ArrayList sscores = sdao.getSscoreByCredentno(credentno);
			if(sscores.size()==0){
				request.getSession().setAttribute("msg5", "�Բ���,����ѧ������֤�飡");
			}
			else{
				request.setAttribute("msg5", null);
				request.setAttribute("sscores", sscores);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entrysscore2.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String operate = request.getParameter("submit");//��ʦ��ѡ���������ݴ桱���ߡ��ύ��
	   	String[] stunos = request.getParameterValues("stuno");//ѡ�޸��ſγ̵�����ѧ����ѧ��
	   	String[] credentnos = request.getParameterValues("credentno");//���ſγ̵Ŀγ̺�
	  	String[] sscores = request.getParameterValues("sscore");//��ʦ¼��ķ���
	   	SscoreDao sdao = new SscoreDao();
	   	
	   	if(sscores!=null){
		   for(int i=0;i<sscores.length;i++){
		   	  if(sscores[i]!=null){
		   		 try{
		   			 Sscore sco = new Sscore();
		   			 sco.setStuno(stunos[i]);
		   			 sco.setCredentno(credentnos[i]);
		   			 sco.setSscore(Float.parseFloat(sscores[i]));
		   			 sco.setState(operate);
		   		 	 sdao.updateSscore(sco);
		   		 	 request.setAttribute("msg6", "֤��¼��ɹ���");
		   		 }catch(Exception ex){	ex.printStackTrace();}
		   	  }
		   }
		}
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entrysscore2.jsp");
		dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
	}
}
