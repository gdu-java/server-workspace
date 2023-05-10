package ex03_parameter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 	요청
		 * 
		 *  1. 클라이언트 -> 서버로 보내는 것이 요청(request)임.
		 *  2. HttpServletRequest 클래스가 요청을 처리함.
		 *  3. 요청에 포함된 파라미터(parameter)는 String타입으로 수신됨.
		 *  
		 */
		
		 // 요청 정보를 UTF-8로 인코딩
		 request.setCharacterEncoding("utf-8");
		 
		 // 응답 정보의 데이터타입과 인코딩을 설정함.
		 response.setContentType("text/html;charset=utf-8");
		 
		 // 요청 파라미터에서 값을 추출함.
		 String model = request.getParameter("model");
		 String strPrice = request.getParameter("price");
		 
		 // 요청 파라미터의 null처리를 함.
		 int price = 0;
		 
		 if(strPrice != null) {
			 price = Integer.parseInt(strPrice); 
		 }
		 
		 response.getWriter().append("모델 : " + model).append(", 가격 : " + price);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
