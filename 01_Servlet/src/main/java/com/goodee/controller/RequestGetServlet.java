package com.goodee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/get.do")      // http://localhost:8099/01_Servlet/get.do
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("서블릿 테스트");
		
		/*
		 * - Get방식으로 요청시 해당 메서드(doGet)가 호출됨 
		 *  
		 *  첫번째 매서드 매개변수인 request에는 요청시 담긴 내용들이 저장돼 있음.
		 *  두번째 매서드 매개변수인 response에는 요청처리후 응답할 때 사용될 객체(응답할 값들을 저장함.)
		 *  
		 *  따라서 request의 parameter영역으로 부터 전달된 데이터를 추출하는 메서드는 다음과 같음.
		 *  	> request.getParameter("키(name)"); => String 타입으로 전달됨. 만약 전달한값이 숫자일 경우 형변환해야함.
		 *      > request.getParameterValues("키"); => String[] (value값이 배열에 담겨서 전달됨.)
		 */  
		
		String name = request.getParameter("name");      // 이름 추출
		String gender = request.getParameter("gender");  //성별 추출
		int age = Integer.parseInt(request.getParameter("age")); // 나이 추출. int로 형변환해야함.
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height"));
		
		// 체크박스와 같은 복수개의 값들을 추출하고자 할 때
		String foods[] = request.getParameterValues("food");  // 좋아하는 음식 추출
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		
		if (foods == null) {
			System.out.println("좋아하는 음식 없음.");
		}else {
			System.out.println("food : " + String.join("/",foods));
		}
		/*
		 * 위의 요청처리 후 클라이언트로 응답할 정보를 가지고 응답페이지를 만들어서 전송하기
		 * 즉, 여기 자바코드내에 사용자가 보게 될 응답 HTML구문 작성하여 응답함. 
		 *
		 * 장점 : JAVA코드내에 작성하기 때문에 자바내에서 반복문이나 조건문, 유용한 메서드 등을 바로 활용할 수 있음.,
		 * 단점 : HTML 태그와 JAVA코드가 섞이기 때문에 복잡해짐. HTML코드를 수정할 경우 결국 자바코드를 수정하는 것과 같음. 
		 *       즉, 서버를 재실행해야함.
		 */      
		 // - response객체를 이용해서 사용자에게 HTML로 전달함.
		 // 1) 앞으로 응답할 문서의 인코딩과 문서타입 설정
		 response.setContentType("text/html; charset=UTF-8");
		 // 2) 응답하고자 하는 사용자(요청했던 사용자)와의 스트림(클라이언트와의 통로) 생성
		 PrintWriter out = response.getWriter();
		 // 3) 스트림을 통해서 응답 HTML구문을 한줄씩 출력
		 out.println("<html>");
		 out.println("<body>");
		 out.println("");
		 out.println("<h1>개인정보 응답화면</h1>");
		 out.println(name + "님은 ");
		 out.print(age + "살이며,");
		 out.print(city + "에 살며");
		 out.print("키는 " + height + "cm 입니다.");
		 out.print("성별은");
		 if(gender == null) {
			 out.println("선택하지 않았습니다.");
		 }else {
			 out.print(gender.equals("m") ? "남자" : "여자");
		 }
		 
		 out.print("좋아하는 음식은 ");
		 if(foods == null) {
			 out.println("좋아하는 음식이 없습니다.");
		 }else {
			 out.println("<ul>");
			 for (int i = 0 ; i < foods.length ; i++) {
				 out.println("<li>" + foods[i] + "</li>");
			 }
			 out.println("</ul");
		 }
		 out.println("</body>");
		 out.println("</html>");

         out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
