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
			    <td colspan="5"> ��ӭǰ����ѯ��ѧ����Ϣ��</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">ѧ��</div></td>
			    <td><div align="center">����</div></td>
			    <td><div align="center">�Ա�</div></td>
			    <td><div align="center">��ѧ��</div></td>
			  </tr>
			  <c:forEach items="${stus}" var="stus">
				<tr bgcolor="#F0FFF0">
				<td><div align="center">${stus.stuno }</div></td>
				<td><div align="center">${stus.stuname }</div></td>
				<td><div align="center">${stus.stusex }</div></td>
				<td><div align="center">${stus.burse }</div></td>
  			</tr>
  		</c:forEach>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>
</body>