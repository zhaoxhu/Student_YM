<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<html>
	<body bgcolor="#cdf2e3">
		<table witdh="100%" height="100%" border="1">
			<tr height="10%"><td colspan="2"><p><img src="/EduSystem/res/images/img01.jpg"></p></td></tr>
			<tr>
				<td height="10%" width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryCourse1Servlet" target="iframe1" style=text-decoration:none>�鿴�γ�</a></td>
				<td rowspan="7"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/EduSystem/jsp/right.jsp"></iframe></td>
			</tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_EntryScore1Servlet" target="iframe1" style=text-decoration:none>¼��ɼ�</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryScore1Servlet" target="iframe1" style=text-decoration:none>�ɼ��ֲ�</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>�޸�����</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Tea_QueryNewsServlet" target="iframe1" style=text-decoration:none>��Ϣ��ѯ</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/StuorTea_QueryBurseServlet" target="iframe1" style=text-decoration:none>��ѧ���ѯ</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/LogoutServlet" style=text-decoration:none>�� ��</a></td></tr>
			<tr heigth="5%"><td colspan="2">
			<pre style="display:inline"><font color="#556B2F">    ${type }��[${teacher.teano}] ${teacher.teaname }                                                                                                                     COPYRIGHT 2017-2018 BY  �ŵ��� ALL RIGHTS RESERVED</font></pre>
			</td></tr>
		</table>
	</body>
</html>