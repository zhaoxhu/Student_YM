<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<html>
	<body bgcolor="#cdf2e3">
		<table witdh="100%" height="100%" border="1">
			<tr height="10%"><td colspan="2"><p><img src="/EduSystem/res/images/img01.jpg"></p></td></tr>
			<tr>
				<td height="10%" width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryCourse1Servlet" target="iframe1" style=text-decoration:none>查看课程</a></td>
				<td rowspan="7"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/EduSystem/jsp/right.jsp"></iframe></td>
			</tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_EntryScore1Servlet" target="iframe1" style=text-decoration:none>录入成绩</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryScore1Servlet" target="iframe1" style=text-decoration:none>成绩分布</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>修改密码</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryNewsServlet" target="iframe1" style=text-decoration:none>消息查询</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/StuorTea_QueryBurseServlet" target="iframe1" style=text-decoration:none>奖学金查询</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/LogoutServlet" style=text-decoration:none>退 出</a></td></tr>
			<tr heigth="5%"><td colspan="2">
			<pre style="display:inline"><font color="#556B2F">    ${type }：[${teacher.teano}] ${teacher.teaname }                                                                                                                     COPYRIGHT 2017-2018 BY  张丹丹 ALL RIGHTS RESERVED</font></pre>
			</td></tr>
		</table>
	</body>
</html>