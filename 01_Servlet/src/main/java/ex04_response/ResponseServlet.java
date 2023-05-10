package ex04_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  응답
		 *  
		 *  1. 서버 -> 클라이언트로 보내는 것이 응답(response)이다.
		 *  2. HttpServletResponse클래스가 응답을 처리함.
		 *  3. 어떤 MIME 타입으로 응답할 것인지 결정해야함.(MIME타입은 클라이언트에게 전송된 문서의 다양성을 알려주기 위한 메커니즘입니다.)
		 *  	  1) HTML : text/html        => 태그를 만들어서 반환하는 경우
		 *  	  2) XML  : application/xml  => ajax 응답이 XML인 경우
		 *        3) JSON : application/json => ajax 응답이 JSON인 경우 
		 */
		// 파라미터에서 값 추출하기
		String model = request.getParameter("model");
		String strPrice = request.getParameter("price");
		
		int price = 0;
		if(strPrice != null) {
			price = Integer.parseInt(strPrice);
		}
		// 응답 만들기
		
		// 1. 응답할 데이터의 MIME 타입과 인코딩 설정
		response.setContentType("text/html;charset=utf-8");
		
		// 2. 응답 스크림 생성(IOException 처리가 필요함. 서블릿 생성시 이미 처리되어 있음.)
		PrintWriter out = response.getWriter(); //PrintWriter의 출력 메서드 : append(), write(), print(), println()
		
		// 3. 응답 만들기
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 응답</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>모델명 : " + model + "</h1><br>");
		out.println("<h1>가격 : " + price + "</h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
