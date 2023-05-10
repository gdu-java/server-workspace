<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 지시어</h1>
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet");  //0번 인덱스
		list.add("JSP");      //1번 인덱스
		
		Date today = new Date();
	%>
	
	<p>
		현재 날짜 및 시간 : <%= today %> <br>
		리스트의 크기 : <%= list.size() %><br>
		0번 인덱스 값 : <%= list.get(0) %><br>
		1번 인덱스 값 : <%= list.get(1) %><br>

		
	</p>
</body>
</html>