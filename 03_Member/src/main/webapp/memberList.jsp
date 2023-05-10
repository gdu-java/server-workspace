<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.goodee.model.vo.*, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 목록 </h1>
<%
	ArrayList<memberVO> list = (ArrayList<memberVO>)request.getAttribute("list");
	
%>


<table border="1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
	</tr>
	<% 	for(memberVO m : list){ %>
	<tr>
		<td> <%= m.getUserId() %> </td>
		<td> <%= m.getUserName() %></td>
		<td> <%= m.getAddress() %></td>
	</tr>
	<% 	} %>
</table>

</body>
</html>