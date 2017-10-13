package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.News;
import vo.Student;
import vo.Burse;
import vo.Score;
import vo.SumScore;
import dao.NewsDao;
import dao.StudentDao;
import dao.BurseDao;
import dao.ScoreDao;

import java.util.ArrayList;
import java.util.*;
public class Adm_EntryBurseServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
    	String type = request.getParameter("type"); //几等奖学金
		
		/*b-排序所以学生的总成绩*/
    	ArrayList<SumScore> students = new ArrayList<SumScore>();
		for(int i = 1301; i<1304; i++)
		{
			float temp = 0;
			SumScore stu = new SumScore();
			ScoreDao sco = new ScoreDao();
			String s = Integer.toString(i);
			stu.setStuno(s);
			try{
				temp = sco.getSumScoreByStuno(s);
			}catch(Exception ex){	ex.printStackTrace();}
			stu.setSumScore(temp);
			students.add(stu);
		}
		Comparator<SumScore> comparator=new Comparator<SumScore>() {
         
            @Override
            public int compare(SumScore stu1, SumScore stu2) {
                if(stu1.getSumScore()<stu2.getSumScore()){
                    return 1;
                }else if(stu1.getSumScore()==stu2.getSumScore()){
                    return 0;
                }else {
                    return -1;
                }
            }
		};
		
		Collections.sort(students,comparator);
        /*e-排序所以学生的总成绩*/
		
		/*b-判断几等奖学金*/
		/* 一等奖学金*/
		if(type.equals("one")){ 
		//	type = "一等奖学金";
			StudentDao sdao = new StudentDao();
			Burse bur = new Burse();
			BurseDao dbur = new BurseDao();
			try{
				Student stu = sdao.getStudentByStuno(((SumScore)students.get(0)).getStuno());
				bur.setStuno(stu.getStuno());
				bur.setStuname(stu.getStuname());
				bur.setStusex(stu.getStusex());
				bur.setState("提交");
				bur.setBurse("一等奖学金");
				dbur.insertBurse(bur);
				request.setAttribute("msg6", "算法完成，结果已保存数据库！");
			}catch(Exception ex){	ex.printStackTrace();}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}
		/*二等奖学金*/
		else if(type.equals("two")){ 
		//	type = "二等奖学金";
			StudentDao sdao = new StudentDao();
			Burse bur = new Burse();
			BurseDao dbur = new BurseDao();
			try{
				Student stu = sdao.getStudentByStuno(((SumScore)students.get(1)).getStuno());
				bur.setStuno(stu.getStuno());
				bur.setStuname(stu.getStuname());
				bur.setStusex(stu.getStusex());
				bur.setState("提交");
				bur.setBurse("二等奖学金");
				dbur.insertBurse(bur);
				request.setAttribute("msg6", "算法完成，结果已保存数据库！");
			}catch(Exception ex){	ex.printStackTrace();}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}
		/*三等奖学金*/
		else if(type.equals("three")){ 
			//type = "三等奖学金";
			StudentDao sdao = new StudentDao();
			Burse bur = new Burse();
			BurseDao dbur = new BurseDao();
			try{
				Student stu = sdao.getStudentByStuno(((SumScore)students.get(2)).getStuno());
				bur.setStuno(stu.getStuno());
				bur.setStuname(stu.getStuname());
				bur.setStusex(stu.getStusex());
				bur.setState("提交");
				bur.setBurse("三等奖学金");
				dbur.insertBurse(bur);
				request.setAttribute("msg6", "算法完成，结果已保存数据库！");
			}catch(Exception ex){	ex.printStackTrace();}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}
		else if(type.equals("del")){
			Burse bur = new Burse();
			BurseDao dbur = new BurseDao();
			bur.setState("提交");
			try{
				dbur.delBurse(bur);
				request.setAttribute("msg6", "复位成功！");
			}catch(Exception ex){	ex.printStackTrace();}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/adm_entryburse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
			
		}
	}
    /*e-判断几等奖学金*/
}
