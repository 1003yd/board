package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/postDeleteServlet")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf boardService = new BoardService();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postNo = Integer.parseInt(request.getParameter("postNum"));
		int postBoard = Integer.parseInt(request.getParameter("postBoard"));
		
		boardService.deletePost(postNo);
		
		response.sendRedirect("/boardMenuPageServlet?boardNo="+ postBoard+"&page=1&pageSize=10");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
