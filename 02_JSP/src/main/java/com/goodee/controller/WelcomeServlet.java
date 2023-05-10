package com.goodee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/jsp/*")  // http://localhost:8099/02_JSP/jsp/로 시작하는 모든 요청을 처리
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청된 URL을 String 변수 url에 담는다.
		String url = request.getRequestURI().toString();
		System.out.println(url);
		
		//url변수의 값에 따라 forward를 분기 처리한다.
		switch(url) {
		case "/02_JSP/jsp/script" :
			request.getRequestDispatcher("/WEB-INF/views/01_scriptingElement.jsp").forward(request, response);
			break;
		case "/02_JSP/jsp/directive":
			request.getRequestDispatcher("/WEB-INF/views/02_pageDirective.jsp").forward(request, response);
			break;
		case "/02_JSP/jsp/include":
			request.getRequestDispatcher("/WEB-INF/views/03_includeDirective.jsp").forward(request, response);
			break;
		case "/02_JSP/jsp/order":
			request.getRequestDispatcher("/WEB-INF/views/pizzaOrderForm.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
