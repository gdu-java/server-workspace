<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 스크립팅 원소 </h1>
	
    <!--HTML 주석-->
    <%-- JSP주석 --%>
	
    <%
        //스크립틀릿 : 일반적인 자바코드 작성(변수 선언 및 초기화, 제어문 등)
        int sum = 0;
        for(int i=1; i <= 100; i++){
            sum += i;
        }
        // 콘솔창에 출력
        System.out.println("1에서 100까지 합계 :"+sum); 
    %>
    <p>
    	화면으로 출력하고자 한다면 <br>
    	스크립틀릿 이용해서도 출력 가능 : <% out.println(sum); %><br>
    	표현식(출력식) 이용해서도 출력 가능 : 합계는 <%= sum %>
    
    </p>
    
    <% 
    	String[] sports = {"야구","농구","축구","배구"}; 
    %>
    
    <h5> 배열의 길이 : <%= sports.length %> </h5>
    <h5> 배열에 담긴 값 : <%= String.join("-",sports) %></h5>
    
    <h4> 반복문을 이용해서 html 요소를 반복적으로 만들어내기 </h4>
    
    <ol>
    	<% for(String s : sports){ %>
    		<li><%= s %> </li>
    	<% } %>
    </ol>
    <%!
    	public void test(){
    	System.out.println("선언문 테스트");
    }
    %>
    <% test(); %>
</body>
</html>