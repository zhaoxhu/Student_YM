<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.SscoreDao"%>
<%@page import="vo.Sscore"%>

<body bgcolor="#cdf2e3">
	 <center><font size="+1" color="red">${msg3}</font></center>
  	 <c:if test="${msg3==null}">
  	 <form action="/EduSystem/servlet/Stu_ExportScoreServlet" method="post">
  		<table width="1000" height="200" align="center" border="1" cellpadding="3">
	 	 <tr bgcolor="#B0E0E6">
	   		 <td colspan="5"><font color="#556B2F"> 您的证书成绩如下：</font></td>
		 </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">证书编号</div></td>
	    <td><div align="center">证书名称</div></td>
	    <td><div align="center">学生学号</div></td>
	    <td><div align="center">学生姓名</div></td>
	    <td><div align="center">是否通过</div></td>
	  </tr>
  		<c:forEach items="${sscore}" var="sscore">
  			<tr bgcolor="#F0FFF0">
		    <td><div align="center">${sscore.credentno }</div></td>
			<td><div align="center">${sscore.credentname }</div></td>
			    <td><div align="center">${sscore.stuno }</div></td>
			    <td><div align="center">${student.stuname }</div></td>
			<c:choose>
			    <c:when test="${sscore.sscore==100}">
			    <td><div align="center">通过</div></td> </c:when>   
  				<c:otherwise>
  				<td><div align="center">未登分</div></td> </c:otherwise>
  			</c:choose>
  			</tr>
  		</c:forEach>
  		<tr bgcolor="#B0E0E6">
	       <td colspan="6"><div align="center"><input type="submit" value="导出到PDF文件"></div></td>
	    </tr>
	  </table>
	  </form>
	</c:if>
</body>
