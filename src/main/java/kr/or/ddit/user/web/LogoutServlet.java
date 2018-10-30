package kr.or.ddit.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session 무효화
		//1. session invalidate 메소드를 통해 무효화
		//2. session 객체를 확보
		
		//servlet
		// page : 존재하지 않음 
		// request : 메소드 인자로 제공
		// session : request 객체에서 획득 가능
		// application : getServletContext(); 를 통해 획득가능
		
		//jsp
		// page : pageContext(내장객체)
		// request : request(내장객체)
		// session : session(내장객체)
		// application : application(내장객체)
		
		HttpSession session = request.getSession();
		//session 무효화
		session.invalidate();
		
		//sss
		//로그아웃을 누르면 처음 로그인 페이지로 이동한다.
		//처음 설정을 
		response.sendRedirect("/board/login.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
