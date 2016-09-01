<%@page import="java.util.List"%>
<%@ page import="kr.co.saramin.emailist.DAO.EmailListDao"%>
<%@ page import="kr.co.saramin.emailist.VO.emaillistVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	EmailListDao dao = new EmailListDao();
	List<emaillistVO> list = dao.getList();
	

%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<%=list.size() %>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<%
		int count = list.size();
		for(int i = 0; i < count; i++) {
			emaillistVO vo = list.get(i);			
		
	%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right>First name: </td>
			<td>안</td>
		</tr>
		<tr>
			<td align="right" width="110">Last name: </td>
			<td width="110">대혁</td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td><%=vo.getFirstName() %></td>
			<td>kickscar@gmail.com</td>
		</tr>
		<tr>
			<td><%=vo.getLastName() %></td>
			<td><%=vo.getEmail() %></td>
		</tr>
	</table>
	<%} %>
	<br>
	<p>
		<a href="">추가메일 등록</a>
	</p>
	<br>
</body>
</html>