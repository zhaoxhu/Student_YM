package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Course;
import vo.Student;
import vo.Teacher;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;

public class Tea_QueryCourse1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList courses = cdao.getCourseByTeano(tea.getTeano());//��ȡ��ʦ��������пγ�
			if(courses.size()!=0){
				request.setAttribute("courses",courses);
			}
			request.getRequestDispatcher("/jsp/teacher/tea_querycourse1.jsp").forward(request, response);//�ڲ���ת
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
