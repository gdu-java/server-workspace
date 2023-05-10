<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">피자 주문 페이지</h1>

    <h2>오늘 날짜</h2>
    <%
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    %>

    <h4><%= sdf.format(today) %></h4>

    <form action="/02_JSP/confirm.do" method="post">
        <fieldset>
            <legend>주문자 정보</legend>

            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="user_name" required></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <th>요청사항</th>
                    <td><textarea name="message"></textarea></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>주문정보</legend>

            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza">
                            <option>콤비네이션 피자</option>
                            <option>치즈피자</option>
                            <option>포테이토 피자</option>
                            <option>고구마 피자</option>
                            <option>불고기 피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <input type="checkbox" name="topping" value="고구마무스"> 고구마무스
                        <input type="checkbox" name="topping" value="파인애플"> 파인애플
                        <input type="checkbox" name="topping" value="치즈"> 치즈 
                        <br>
                        <input type="checkbox" name="topping" value="치즈바이트"> 치즈바이트
                        <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트
                        <input type="checkbox" name="topping" value="쉬림프"> 쉬림프
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td>
                        <input type="checkbox" name="side" value="콜라"> 콜라 
                        <input type="checkbox" name="side" value="사이다"> 사이다 
                        <input type="checkbox" name="side" value="갈릭소스"> 갈릭소스 
                        <br>
                        <input type="checkbox" name="side" value="핫소스"> 핫소스
                        <input type="checkbox" name="side" value="피클"> 피클
                        <input type="checkbox" name="side" value="치즈가루"> 치즈가루
                    </td>
                </tr>
                <tr>
                    <th>결제방식</th>
                    <td>
                        <input type="radio" name="payment" value="card" checked> 카드결제
                        <input type="radio" name="payment" value="cash"> 현금결제
                    </td>
                </tr>
            </table>
        </fieldset>
        <br>
        <input type="submit" value="주문">
        <input type="reset" value="다시입력">
    </form>
</body>
</html>