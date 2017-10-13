package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import vo.Sscore;
import vo.Student;
import vo.Admin;

import dao.SscoreDao;
import dao.StudentDao;
import dao.AdminDao;

public class Adm_ExportSscoreServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String credentno = request.getParameter("credentno");//��ѡ�γ̵Ŀγ̺�
		SscoreDao sdao = new SscoreDao();
		Sscore sco = null;
		
		try{
			ArrayList sscores = sdao.getSscoreByCredentno(credentno);
			if(sscores.size()!=0){
	  			Document doc = new Document();//Ĭ��ΪA4ҳ��
	  			String path = request.getRealPath("/res/reports");
	  			PdfWriter pw = 
	  				PdfWriter.getInstance(doc,new java.io.FileOutputStream(path + "/report.pdf"));
	  			doc.open();	
	  			Table  t = new Table(5,5);
	  			t.setDefaultHorizontalAlignment(Table.ALIGN_CENTER);
	  			t.setPadding(4);//�߿�����ֵľ���
	  			BaseFont baseFont = BaseFont.createFont("C:/WINDOWS/Fonts/SIMKAI.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
	  			Font font = new Font(baseFont,10);//10��ʾ�����С
	  			for(int i=0;i<sscores.size();i++){
	  				sco = (Sscore)sscores.get(i);
	  				t.addCell(new Phrase(sco.getCredentno(),font));
	  				t.addCell(new Phrase(sco.getCredentname(),font));
	  				t.addCell(new Phrase(sco.getStuno(),font));
	  				t.addCell(new Phrase(sco.getStuname(),font));
	  				if(sco.getSscore()==0){	t.addCell(new Phrase("δ�Ƿ�",font));}
  					else{	t.addCell(new Phrase(""+sco.getSscore(),font));}
	  			}
	  			doc.add(t);
	  			doc.close();
	  			response.setHeader("Content-Disposition","attachment;filename=report.pdf");//�������ؿ�   
			}
  			request.getRequestDispatcher("/res/reports/report.pdf").forward(request, response);
		}catch(Exception ex){	ex.printStackTrace();}
	}

}
