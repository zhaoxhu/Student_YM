<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.CredentialDao"%>
<%@page import="vo.Credential"%>
<%@page import="dao.AdminDao"%>
<%@page import="vo.Admin"%>
<%@page import="dao.SscoreDao"%>

<body bgcolor=#cdf2e3>
	<center><font size="+1" color="red">${msg4}</font></center>	
	<c:if test="${msg4==null}">
	<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
    	<td colspan="5"><font color="#556B2F"> 选择结果如下：</font></td>
    </tr>
  	<tr bgcolor="#F0FFF0">
	    <td><div align="center">证书编号</div></td>
	    <td><div align="center">证书名称</div></td>
	    <td><div align="center">技能分</div></td>
	    <td><div align="center">管理员</div></td>
	    <td><div align="center">等级</div></td>
  	</tr>	
  	<c:forEach items="${selectedcredents}" var="selectedcredents">
		<tr bgcolor="#F0FFF0">
		<td><div align="center">${selectedcredents.credentno }</div></td>
		<td><div align="center">${selectedcredents.credentname }</div></td>
		<td><div align="center">${selectedcredents.credit }</div></td>
		<td><div align="center">${selectedcredents.adminno}</div></td>
		<td><div align="center">${selectedcredents.credenttile}</div></td>
		</tr>
	</c:forEach>
	</table>
  </c:if>
</body>

