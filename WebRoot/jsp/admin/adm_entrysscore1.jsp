<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.AdminDao"%>
<%@page import="vo.Admin"%>
<%@page import="dao.CredentialDao"%>
<%@page import="vo.Credential"%>

<body bgcolor=#cdf2e3>
<table width="1000" height="200" align="center" border="1" cellpadding="3">
  <tr bgcolor="#B0E0E6">
    <td colspan="5"> 您所可以授权的证书如下如下：</td>
  </tr>
  <tr bgcolor="#F0FFF0">
    <td><div align="center">证书编号</div></td>
    <td><div align="center">证书名称</div></td>
    <td><div align="center">技能分</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  	 <c:forEach items="${credentials}" var="credential">
  		<tr bgcolor="#F0FFF0">
   			 <td><div align="center">${credential.credentno }</div></td>
    		 <td><div align="center">${credential.credentname }</div></td>
   			 <td><div align="center">${credential.credit }</div></td>
    		 <td><div align="center"><a href="/EduSystem/servlet/Adm_EntrySscore2Servlet?credentno=${credential.credentno }">录入分数</div></td>
  	   </tr>
  	 </c:forEach>	
   </table>
</body>
