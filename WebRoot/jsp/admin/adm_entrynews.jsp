<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body bgcolor=#cdf2e3>
	<c:choose>
		<c:when test="${msg6!=null}">
			<center><font size="+1" color="red">${msg6}</font></center>
		</c:when>
		<c:otherwise>
				<form action="/EduSystem/servlet/Adm_EntryNewsServlet" method="post">
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr bgcolor="#B0E0E6">
			    <td colspan="5"> 欢迎前来发布消息：</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">消息id</div></td>
			    <td><div align="center">消息类型</div></td>
			    <td><div align="center">消息内容</div></td>
			  </tr>
  		 <c:forEach items="${news}" var="nw">
	  		<tr bgcolor="#F0FFF0">
			    
				<td><div align="center">${nw.id }</div></td><input type="hidden" name="id" value="${nw.id }"></div></td>
			    <td>	
			    	<c:choose>
				 		<c:when test="${nw.type==null }">
			    	    <div align="center"><input type="text" name="type" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${nw.state==null||nw.state=='暂存'}">
	  			  	      
	  					      <div align="center"><input type="text" name="type" value="${nw.type }"></div>
							  
	  				          </c:when>
	  				          <c:when test="${nw.state=='提交'}">  				         
	  					      <div align="center">${nw.type }</div>
							 
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			  	</td>
	  			  	<td>
	  			  	<c:choose>
				 		<c:when test="${nw.news==null }">
			    	    <div align="center"><input type="text" name="news" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${nw.state==null||nw.state=='暂存'}">
	  			  	      
	  					      <div align="center"><input type="text" name="news" value="${nw.news }"></div>
							  
	  				          </c:when>
	  				          <c:when test="${nw.state=='提交'}">  				         
	  					      <div align="center">${nw.news }</div>
							 
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			</td> </tr>
	  		</c:forEach>
	  		<tr bgcolor="#B0E0E6">
		       <td colspan="6"><div align="center"><input type="submit" name="submit" value="暂存">
		       <input type="submit" name="submit" value="提交"></div></td>
			</tr>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>
</body>
