package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/boardMenuPageServlet")
public class BoardMenuPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// TODO Auto-generated method stub
		BoardServiceInf boardService = new BoardService();
		int boardNO = Integer.parseInt(request.getParameter("boardNo"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		pageVo.setBoard_no(boardNO);
		Map<String, Object> resultMap = boardService.postBoardList(pageVo);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("postList");
		int pageCnt = (int) resultMap.get("pageCnt");
		
		HttpSession session = request.getSession();
		session.setAttribute("boardNo", boardNO);
		session.setAttribute("postList", postList);
		request.setAttribute("pageCnt", pageCnt);
		
		request.getRequestDispatcher("/board/boardMenuPage.jsp").forward(request, response);
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
