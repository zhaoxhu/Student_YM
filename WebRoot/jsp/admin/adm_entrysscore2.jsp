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
				<form action="/EduSystem/servlet/Adm_EntrySscore2Servlet" method="post">
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr bgcolor="#B0E0E6">
			    <td colspan="5"> ��ӭǰ���ǼǼ���֤�飺</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">֤����</div></td>
			    <td><div align="center">֤������</div></td>
			    <td><div align="center">ѧ��ѧ��</div></td>
			    <td><div align="center">ѧ������</div></td>
			    <td><div align="center">�Ƿ�ͨ��</div></td>
			  </tr>
  		 <c:forEach items="${sscores}" var="sscore">
	  		<tr bgcolor="#F0FFF0">
			    <td><div align="center">${sscore.credentno }<input type="hidden" name="credentno" value="${sscore.credentno }"></div></td>
			    <td><div align="center">${sscore.credentname }</div></td>
			    <td><div align="center">${sscore.stuno }<input type="hidden" name="stuno" value="${sscore.stuno }"></div></td>
			    <td><div align="center">${sscore.stuname }</div></td>
			    <td>
			    	<c:choose>
				 		<c:when test="${sscore.sscore==0 }">
			    	    <div align="center"><input type="text" name="sscore" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${sscore.state==null||sscore.state=='�ݴ�'}">
	  					      <div align="center"><input type="text" name="sscore" value="${sscore.sscore }"></div>
	  				          </c:when>
	  				          <c:when test="${sscore.state=='�ύ'}">
	  					      <div align="center">${sscore.sscore }</div>
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			</td> </tr>
	  		</c:forEach>
	  		<tr bgcolor="#B0E0E6">
		       <td colspan="6"><div align="center"><input type="submit" name="submit" value="�ݴ�">
		       <input type="submit" name="submit" value="�ύ"></div></td>
			</tr>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>
</body>
