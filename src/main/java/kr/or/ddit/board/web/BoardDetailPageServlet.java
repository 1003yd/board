package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/boardDetailPageServlet")
public class BoardDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf boardService = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		PostVo postVo = boardService.selectOnePost(postNum);
		List<AttachmentsVo> attachList = boardService.selectAttachment(postNum);
		List<CommentVo> commentList = boardService.selectPostComment(postNum);
		request.setAttribute("attachList", attachList);
		request.setAttribute("commentList", commentList);
		request.setAttribute("postVo", postVo);
		request.getRequestDispatcher("board/boardDetailPage.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
