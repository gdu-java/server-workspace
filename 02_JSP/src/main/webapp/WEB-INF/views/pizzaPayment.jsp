<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 서블릿(Controller)에서 JSP파일로 위임하는 경우 setAttribute메서드를 이용해서 값들을 request객체에 담아 전달함.
	 JSP파일에서는 request객체에 담겨진 값들을 getAttribute메서드를 이용해서 추출할 수 있음. 이때 request객체에
	 담겨진 값들은 Object타입이므로 형변환이 필요함.
 -->
<%
	String userName = (String)request.getAttribute("userName");
	String address = (String)request.getAttribute("address");
	String phone = (String)request.getAttribute("phone");
	String message = (String)request.getAttribute("message");
	String pizza = (String)request.getAttribute("pizza");
	String[] topping = (String[])request.getAttribute("topping");
	String[] side = (String[])request.getAttribute("side");
	int price = (int)request.getAttribute("price");
	String payment = (String)request.getAttribute("payment");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 주문 내역 </h1>
	<h4> [주문자 정보] </h4>
	<ul>
		<li>이름 : <%= userName %></li>
		<li>주소 : <%= address %></li>
		<li>전화번호 : <%= phone %></li>
		<% if(message.equals("")) { %>
		<li>요청사항 : 작성안함</li>
		<% }else { %>
		<li>요청사항 : <%= message %></li>
		<% } %>
	</ul>
	
	<br>
	
	<h4>[주문 내역]</h4>
	<ul>
		<li> 피자 : <%= pizza %></li>
		<% if(topping == null) { %>
		<li> 토핑 : 선택안함.</li>
		<% } else { %>
		<li> 토핑 : <%= String.join("/",topping) %>
		<% } %>
		<% if(side == null) { %>
		<li> 사이드 : 선택안함.</li>
		<%}else { %>
		<li> 사이드 : <%= String.join("/",side) %>
		<%} %>
	</ul>
	<br>
	
	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>주문가격 : <%= price %>원</h2>
	<h2>결제방식 : <%= payment.equals("card") ? "카드" : "현금" %></h2>
	<br>
	<h1>주문해주셔서 감사합니다.</h1>
</body>
</html>