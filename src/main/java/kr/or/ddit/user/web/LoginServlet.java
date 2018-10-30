package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService = new BoardService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BoardVo> boardList = boardService.boardUserList();
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		response.sendRedirect("board/main.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserServiceInf userService = new UserService();
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("pass : " + pass);
		
		//패스워드 암호화
		String encryptPass = KISA_SHA256.encrypt(pass);
		
		UserVo user = userService.searchUser(userId);
		
		List<BoardVo> boardList = boardService.boardUserList();
		
		if(user != null && user.authPass(encryptPass)){
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("boardList", boardList);
			
			request.getRequestDispatcher("/board/main.jsp").forward(request, response);
		}else{
			response.sendRedirect("/board/login.jsp");
		}
	}

}
