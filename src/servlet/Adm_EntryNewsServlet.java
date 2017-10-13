package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date; 
import java.util.Calendar; 
import java.text.SimpleDateFormat; 
 
import java.util.Date; 
import vo.News;

import dao.NewsDao;

 
public class Adm_EntryNewsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
  		NewsDao ndao = new NewsDao();		
  		
		try{
			int i = 1;
			for(i = 1;i<65535;i++)
			{
				ArrayList news = ndao.getNewsById(i);
			    if(news.size()==0){
				News jo = new News();
			    jo.setId(i);
			    ndao.insertNews(jo);
				break;
			   }
			    
			}
			ArrayList news = ndao.getNewsById(i);
			request.setAttribute("msg5", null);
			request.setAttribute("news", news);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entrynews.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��

		}catch(Exception ex){	ex.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String operate = request.getParameter("submit");//����Ա���ݴ桱���ߡ��ύ��
	   	String news = request.getParameter("news");//��jspҳ���������Ϣ
	   	/*b-��ȡ��ǰʱ��*/
	   	Date now = new Date(); 
	   	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   	String times = dateFormat.format( now ); 
	   	/*e-��ȡ��ǰʱ��*/
	  	String types = request.getParameter("type");//��jspҳ�������˭���Կ�����Ϣ
	  	String ids = request.getParameter("id");//��jspҳ���ȡ������Ϣid
	  	/*b-��ΪgetParameter��ȡ����String���󣬽��ַ�������ת����int*/
	  	int id = 0;
		try {
			  id =  Integer.parseInt(ids);
			      } catch (NumberFormatException e) {
			          e.printStackTrace();
			       }
		/*e-��ΪgetParameter��ȡ����String���󣬽��ַ�������ת����int*/
	  	NewsDao ndao = new NewsDao();	
	   	
	   	if(news!=null){
		   		 try{
		   			 News sco = new News();
		   			 sco.setNews(news);
		   			 sco.setTime(times);
					 sco.setType(types);
					 sco.setId(id);
					 ndao.updateNews(sco);
		   		 	 request.setAttribute("msg6", "��Ϣ¼��ɹ���");
		   		 }catch(Exception ex){	ex.printStackTrace();}
		   
		}
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entrynews.jsp");
		dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
	}
}
