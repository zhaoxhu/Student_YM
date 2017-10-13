<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body bgcolor=#cdf2e3>
	<c:choose>
		<c:when test="${msg6!=null}">
			<center><font size="+1" color="red">${msg6}</font></center>
		</c:when>
		<c:otherwise>
			<form action="/EduSystem/servlet/Adm_EntryBurseServlet" method="post">
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			 <tr bgcolor="#B0E0E6">
			    <td colspan="5"> 欢迎前来公布奖学金：</td>
			  </tr>
			 <tr>
		     <td><div align="right"><font size="-1" color="#556B2F">奖学金选项:</font></div></td>
		     <td><select name="type" style="width:152">
		        <option value="one" selected>一等奖学金</option>
		        <option value="two">二等奖学金</option>
		        <option value="three">三等奖学金</option>
				<option value="del">复位奖学金算法</option>
		      </select></td>
		     </tr>
	  		<tr bgcolor="#B0E0E6">
		        <td colspan="6"><div align="center"><input type="submit" name="submit" value="暂存">
		       <input type="submit" name="submit" value="提交"></div></td>
			</tr>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>
</body>