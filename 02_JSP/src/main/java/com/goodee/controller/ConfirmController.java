package com.goodee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmController
 */
@WebServlet("/confirm.do")
public class ConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * 1) 전달값 중에 한글이 있는 경우 인코딩 처리(POST방식일 때만 처리)
		 * 	  request.setCharacterEncoding("UTF-8");
		 * 
		 * 2) 요청시 전달값(parameter) 추출 및 데이터 가공처리(파싱 등) => 변수 및 객체에 담기
		 * 	  request.getParameter("키(name)") : value값 (String타입)
		 *    request.getParameterValues("키") : [Value값,Value값,Value값 ...] String[] 타입
		 *    공통점 : 만일 키값이 존재하지 않을 경우 null반환함.
		 */
		request.setCharacterEncoding("utf-8");
		//주문자 정보 추출
		String userName = request.getParameter("user_name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		//주문내역 추출
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		// 3) 요청 처리( -> Service -> Dao -> SQL처리 후 결과값 반환)
		
		// 총 가격 구하기
		int price = 0;
		switch(pizza) {
		case "콤비네이션피자" : price += 20000; break;
		case "치즈피자" : price += 15000; break;
		case "포테이토피자" :
		case "고구마피자" : price += 18000; break;
		case "불고기피자" : price += 25000; break;
		}
		
		if(topping != null) {
			for(int i=0; i < topping.length ; i++) {
				switch(topping[i]) {
				case "고구마무스" : 
				case "파인애플" : price += 1500; break;
				case "치즈" : price += 2000; break;
				case "치즈바이트" : 
				case "치즈크러스트" : price += 3000; break;
				case "쉬림프" : price += 2500; break;
				}
			}
		}
		
		if(side != null) {
			for(int i=0; i<side.length; i++) {
				switch(side[i]) {
				case "콜라": case "사이다": price +=1000; break;
				case "갈릭소스": case "핫소스":
				case "피클": case "치즈가루": price +=1500; break;
				
				}
			}
		}
		
		// 4) 반환받은 결과를 가지고 성공/실패 확인 후 사용자가 보게될 응답페이지 작성
		//    응답페이지 만들기 : Servlet에서 만들거나 JSP에 위임함. 여기서는 JSP에 위임.
		// RequestDispatcher : 위임과 관련된 객체 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/pizzaPayment.jsp");
		
		//주문자정보를 위임하는 JSP페이지로 보내기 위해 request객체에 담는다.(setAttribute메서드 사용)
		request.setAttribute("userName", userName);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza );
		request.setAttribute("topping",topping );
		request.setAttribute("side", side );
		request.setAttribute("price",price );
		request.setAttribute("payment",payment );
		
		view.forward(request, response); //현재 지정된 jsp를 사용자에게 응답하는 방식(포워딩 방식)
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
