<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> * JSP(Java Server Page) </h1>
	
	<p>
		JSP란 HTML문서내에 자바코드를 사용할 수 있도록 JSP용 코드를 제공.<br>
		Servlet(자바코드)에서 응답화면(HTML)을 구현했던 복잡함을 보다 간단하게 해결 가능함.<br>
		=> JSP의 가장 큰 장점은 Servlet에서는 요청처리(비즈니스로직)에만 집중하고<br>
		응답화면만들기(프리젠테이션로직)는 JSP에서 집중하게 끔 분리할 수 있다는 것.
		JSP/Servlet을 해석하기 위해서는 Tomcat과 같은 WAS(Web Application Server)가 필요함. => main 메서드 없이 동작가능
	</p>
	<hr>  
	<h2>>> JSP Element 표현법</h2>
	<h3>1. JSP 스크립팅 요소(Scripting Element)</h3>
	<p> JSP페이지내에서 자바코드를 사용할 수 있도록 해주는 기능</p>
	
	<ol>
		<li>
			선언문 : &lt;%! 자바코드 %&gt; <br>
			멤버변수와 메소드 정의시 사용
		</li>
		<li>
			스크립틀릿 : &lt;% 자바코드 %&gt; <br>
			JSP내에서 자바코드를 기술하기 위한 가장 기본적인 표현법
		</li>
	</ol>
	<a href="/02_JSP/jsp/script">스크립팅 요소(Scripting Element)</a>

	<h3>
		2. 지시어(Directive)<br>
		&lt;%@ page|include|talib 속성="속성값" 속성="속성값" %gt;
	</h3>
	<p>
		<ol>
			<li>
				page 지시어 : 현재 jsp페이지를 처리하는데 필요한 각종 속성들을 기술<br>
				 - language : 사용할 언어 유형을 지정<br>
				 - contentType : 해당 페이지의 형식, 문자셋 지정<br>
				 - pageEncoding : jsp페이지내에 기록된 자바코드의 인코딩 방식 지정<br>
				 - import : 자바에서의 import와 동일 <br>
				 - errorPage : 해당 jsp에서 오류 발생시 보여줄 에러페이지 경로 지정<br><br>
				 
				 <a href="/02_JSP/jsp/directive">지시어(Directive)</a>
			</li>
			<li>
				include 지시어 : 현재 jsp내에 또다른 jsp를 포함시키고자 할 때 사용하는 지시어<br>
				<a href="/02_JSP/jsp/include">include 지시어</a>
			</li>
			<li>
				taglib 지시어 : JSP기능을 좀 더 확장시킬 수 있는 라이브러리를 등록하는 지시어
			</li>
		</ol>
	</p>
	
	<hr>

	<h2>피자 주문 페이지(jsp) -- 주문 요청 --> 주문 요청을 받아서 처리해주는 Servlet -->  피자 결제페이지(응답jsp)</h2>
	<a href="/02_JSP/jsp/order">피자 주문페이지</a>


</body>
</html>