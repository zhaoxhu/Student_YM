<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body bgcolor=#cdf2e3>
	<c:choose>
		<c:when test="${msg6!=null}">
			<center><font size="+1" color="red">${msg6}</font></center>
		</c:when>
		<c:otherwise>
				<form action="/EduSystem/servlet/Stu_EntryJobServlet" method="post">
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr bgcolor="#B0E0E6">
			    <td colspan="5"> ��ӭǰ���ǼǾ�ҵ��Ϣ��</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">ѧ��</div></td>
			    <td><div align="center">����</div></td>
			    <td><div align="center">�Ա�</div></td>
			    <td><div align="center">�Ƿ��ҵ�����</div></td>
			    <td><div align="center">������λ</div></td>
			  </tr>
  		 <c:forEach items="${jobs}" var="job">
	  		<tr bgcolor="#F0FFF0">
			    <td><div align="center">${job.stuno }</div></td><input type="hidden" name="stuno" value="${job.stuno }"></div></td>
			    <td><div align="center">${job.stuname }</div></td>
			    <td><div align="center">${job.stusex }</div></td>
			    <td>
			    	<c:choose>
				 		<c:when test="${job.job==NULL }">
			    	    <div align="center"><input type="text" name="job" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${job.state==null||job.state=='�ݴ�'}">
	  			  	      
	  					      <div align="center"><input type="text" name="job" value="${job.job }"></div>
							  
	  				          </c:when>
	  				          <c:when test="${job.state=='�ύ'}">  				         
	  					      <div align="center">${job.job }</div>
							 
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			  	</td>
	  			  	<td>
	  			  	<c:choose>
				 		<c:when test="${job.firm==NULL }">
			    	    <div align="center"><input type="text" name="firm" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${job.state==null||job.state=='�ݴ�'}">
	  			  	      
	  					      <div align="center"><input type="text" name="firm" value="${job.firm }"></div>
							  
	  				          </c:when>
	  				          <c:when test="${job.state=='�ύ'}">  				         
	  					      <div align="center">${job.firm }</div>
							 
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
