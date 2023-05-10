<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include 지시어</h1>
	
	<%@ include file="01_scriptingElement.jsp" %>
	
	<br>
	<hr>
	매 페이지마다 공통적으로 존재해야하는 요소들을 별도의 jsp로 만들고 
	include 지시어를 이용해서 포함함으로써 중복코딩을 방지할 수 있음.<br><br>
	
	현재 포함하고 있는 jsp내에 존재하는 변수를 include 지시어를 이용해서 포함한<br>
	jsp 페이지에서 사용할 수 있음.<br> 
	
	1부터 100까지의 총 합계 : <%= sum %>
	sports배열의 길이 : <%= sports.length %>
	
</body>
</html>