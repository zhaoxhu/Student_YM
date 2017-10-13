<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.News"%>

<body bgcolor="#cdf2e3">
	 <center><font size="+1" color="red">${msg3}</font></center>
  	 <c:if test="${msg3==null}">
  	 <form action="/EduSystem/servlet/Stu_ExportScoreServlet" method="post">
  		<table width="1000" height="200" align="center" border="1" cellpadding="3">
	 	 <tr bgcolor="#B0E0E6">
	   		 <td colspan="5"><font color="#556B2F"> 您的消息如下：</font></td>
		 </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">消息编号</div></td>
	    <td><div align="center">消息时间</div></td>
	    <td><div align="center">消息内容</div></td>
	  </tr>
  		<c:forEach items="${news}" var="news">
  			<tr bgcolor="#F0FFF0">
		    <td><div align="center">${news.id}}</div></td>
			<td><div align="center">${news.time }</div></td>
			    <td><div align="center">${news.news }</div></td>
  			</tr>
  		</c:forEach>
  		<tr bgcolor="#B0E0E6">
	       <td colspan="6"><div align="center"><input type="submit" value="导出到PDF文件"></div></td>
	    </tr>
	  </table>
	  </form>
	</c:if>
</body>
