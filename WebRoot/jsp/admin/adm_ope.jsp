<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<html>
	<body bgcolor="#cdf2e3">
		<table witdh="100%" height="100%" border="1">
			<tr height="10%"><td colspan="2"><p><img src="/EduSystem/res/images/img01.jpg"></p></td></tr>
			<tr>
				<td height="10%" width="10%" align="center"><a href="/EduSystem/servlet/Adm_QueryCredential1Servlet" target="iframe1" style=text-decoration:none>�鿴֤��</a></td>
				<td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/EduSystem/jsp/right.jsp"></iframe></td>
			</tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Adm_EntrySscore1Servlet" target="iframe1" style=text-decoration:none>¼��֤��</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Adm_QueryJobServlet" target="iframe1" style=text-decoration:none>��ѯ��ҵ��Ϣ</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Adm_EntryNewsServlet" target="iframe1" style=text-decoration:none>��Ϣ����</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Adm_EntryBurseServlet" target="iframe1" style=text-decoration:none>¼�뽱ѧ��</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/LogoutServlet" style=text-decoration:none>�� ��</a></td></tr>
			<tr heigth="10%"><td>&nbsp;</td></tr>
			<tr heigth="5%"><td colspan="2">
			<pre style="display:inline"><font color="#556B2F">    ${type }��[${admin.admno}] ${admin.admname }                                                                                                                     COPYRIGHT 2017-2018 BY  �ŵ��� ALL RIGHTS RESERVED</font></pre>
			</td></tr>
		</table>
	</body>
</html>