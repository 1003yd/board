package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/commentServlet")
public class BoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardServiceInf boardService = new BoardService();
		
		String context = request.getParameter("comment");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		HttpSession session = request.getSession();
		UserVo userVo = (UserVo)session.getAttribute("user");
		
		CommentVo comment = new CommentVo();
		comment.setComm_context(context);
		comment.setComm_post(postNo);
		comment.setComm_user(userVo.getUserId());
		
		boardService.insertComment(comment);
		response.sendRedirect("/boardDetailPageServlet?postNum="+postNo);
		
		
	}

}
