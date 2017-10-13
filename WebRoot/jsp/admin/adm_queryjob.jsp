<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body bgcolor=#cdf2e3>
	<c:choose>
	    <c:when test="${msg5!=null}">
			<center><font size="+1" color="red">${msg5}</font></center>
		</c:when>
		<c:when test="${msg6!=null}">
			<center><font size="+1" color="red">${msg6}</font></center>
		</c:when>
		<c:otherwise>
			
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr bgcolor="#B0E0E6">
			    <td colspan="5"> 欢迎前来查询就业信息：</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">学号</div></td>
			    <td><div align="center">姓名</div></td>
			    <td><div align="center">性别</div></td>
			    <td><div align="center">是否找到工作</div></td>
			    <td><div align="center">工作单位</div></td>
			  </tr>
			  <c:forEach items="${jobs}" var="job">
				<tr bgcolor="#F0FFF0">
				<td><div align="center">${job.stuno }</div></td>
				<td><div align="center">${job.stuname }</div></td>
				<td><div align="center">${job.stusex }</div></td>
				<td><div align="center">${job.job }</div></td>
				<td><div align="center">${job.firm }</div></td>
  			</tr>
  		</c:forEach>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>
</body>