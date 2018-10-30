package kr.or.ddit.board.web;

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

/**
 * Servlet implementation class BoardMenuServlet
 */
@WebServlet("/boardMenuServlet")
public class BoardMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardServiceInf boardService = new BoardService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String uri = request.getRequestURI();

		if(uri.equals("/boardMenuServlet")){
			boardMenu(request,response);
		}

		if(uri.equals("/boardManageServlet")){
			boardManage(request, response);
		}
		 */
		List<BoardVo> boardAllList = boardService.boardList();
		request.setAttribute("boardAllList", boardAllList);


		// createMenu.jsp로 위임
		request.getRequestDispatcher("/board/createMenu.jsp").forward(request, response);



	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//여기서 게시판 등록처리
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String boardUse = request.getParameter("boardUse");
		String boardName = request.getParameter("boardNames");
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(boardName);
		boardVo.setBoard_user(userId);
		boardVo.setBoardUsing(boardUse);

		boardService.insertBoardList(boardVo);
		response.sendRedirect("/loginServlet");
	}


	
}


