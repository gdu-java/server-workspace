package ex01_lifecycle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   서블릿(Servlet)
 *   
 *   1. 웹 화면을 결과로 만드는 클래스.
 *   2. HttpServlet 클래스를 상속 받음.
 *   3. Jsp/Servlet Container인 Tomcat(WAS:Wep Application Server)에 의해서 실행됨.
 *   4. 서블릿을 실행하면(Ctrl+F11) 웹브라우저에 결과가 표시됨.
 *   
 */

/*
 * 	 URL(Uniform Resource Locator)
 * 
 * 	 1.구성 =>   프로토콜://호스트:포트번호/ContextPath/URLMapping
 *   2.HelloServlet의 URL =>   http://localhost:8099/01_Servlet/HelloServlet
 */

@WebServlet("/HelloServlet") // URLMapping
public class HelloServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		
		
		/*
		 * 1. 생성자
		 * 	  1) 가장 먼저 호출됨.
		 * 	  2) 생성자 호출 뒤 자동으로 init() 메서드가 호출됨.
		 * 
		 */
	
		public HelloServlet() {
			super();
			System.out.println("생성자호출");
		}
		
		/*
		 * 2. init()
		 * 	  1) 서블릿 환경 설정을 담당
		 *    2) init() 호출 뒤 자동으로 service() 메소드 호출됨.
		 *        
		 */
		 public void init(ServletConfig config) throws ServletException {
			 System.out.println("init() 호출");
		 }
		 
		 /*
		  * 3. service()
		  *    1) 클라이언트가 요청할 때마다 자동으로 호출됨.
		  *    2) service()메서드가 없으면 doGet() 또는 doPost() 메서드가 자동으로 호출됨.
		  *    3) 클라이언트가 하는 요청을 직접 처리할 수 있음.
		  *    4) 클라이언트의 요청을 직접 처리하지 않으면 요청에 따라 doGet() 또는 doPost()메서드를 호출해야함.
		  */
		 
		 public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			 System.out.println("service() 호출");
			 
			 //HTTP Method(요청 메서드)에 따른 doGet() 또는 doPost()메서드 호출하기
			 switch(request.getMethod()) {
			 case "GET":
				 doGet(request,response);
				 break;
			 case "POST":
				 doPost(request,response);
				 break;
			 }
		 }
		 
		 /*
		  * 4. doGet()
		  *    1)GET방식의 요청을 처리하는 메서드
		  *    2)GET방식의 요청 예시
		  *      (1) <a href="http://localhost:8099/01_Servlet/HelloServlet">
		  *      (2) <form action="http://localhost:8099/01_Servlet/HelloServlet">
		  *      (3) location.href='http://localhost:8099/01_Servlet/HelloServlet'
		  *      (4) open('http://localhost:8099/01_Servlet/HelloServlet','','')
		  *      
		  */
		  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			  // 요청정보를 가진 객체 : request
			  // 응답정보를 담을 객체 : response
			  
			  // 클라이언트로 정보(텍스트)를 보내기 위한 출력 스트림 : response.getWriter() - PrintWriter
			  
			  // 출력 스트림으로 정보(텍스트)를 보내는 메서드 :  append(), write(), print(), println()
			  
			  response.getWriter().append("Served at :").append(request.getContextPath());
			  
		  }
		  
		  /*
		   * 5. doPost()
		   *    1)POST방식의 요청을 처리하는 메서드
		   *    2)POST방식의 요청예시 :  <form method="POST" action="http://localhost:8099/01_Servlet/HelloServlet">
		   */
		  
		  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			  
			  //POST 메서드를 통해서 들어온 정보를 모두 doGet() 메서드로 넘김.
			  doGet(request,response);
		  }
}
