<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.CredentialDao"%>
<%@page import="vo.Credential"%>
<%@page import="dao.AdminDao"%>
<%@page import="vo.Admin"%>
<%@page import="dao.SscoreDao"%>

<body bgcolor=#cdf2e3>
	<center><font size="+1" color="red">${msg2}</font></center>
	<c:if test="${msg2==null}">
	<form method="post" action="/EduSystem/servlet/Stu_SelectCredentialServlet">
	<table width="1000" height="200" align="center" border="1" cellpadding="3">
	  <tr>
	  	<td colspan="6" bgcolor="#B0E0E6"><font color="#556B2F">������ѡ���֤�����£� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">(ע:����ѡ��7��ѧ��,�Ҳ��ܶ�ѡ)</td>
	  </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">֤����</div></td>
	    <td><div align="center">֤������</div></td>
	    <td><div align="center">���ܷ�</div></td>
	    <td><div align="center">����Ա</div></td>
	    <td><div align="center">�ȼ�</div></td>
	    <td><div align="center">ѡ��</div></td>
	   </tr>
	   <c:forEach items="${allcredent}" var="credential">
			<tr bgcolor="#F0FFF0">
			<td><div align="center">${credential.credentno }</div></td>
			<td><div align="center">${credential.credentname }</div></td>
			<td><div align="center">${credential.credit }</div></td>
			<td><div align="center">${credential.adminno }</div></td>
			<td><div align="center">${credential.credenttile }</div></td>
			<td><div align="center"><input type="radio" name="${credential.credentname }" value="${credential.credentno }"></div></td>
			</tr>
	   </c:forEach>
	    <tr bgcolor="#B0E0E6">
	       <td colspan="6"><div align="center"><input type="submit" value="�ύ���"></div></td>
	    </tr>
	</table>
	</form>
	</c:if>
</body>