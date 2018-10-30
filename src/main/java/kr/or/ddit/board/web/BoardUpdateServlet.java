package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/boardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardServiceInf boardService = new BoardService();
		request.setCharacterEncoding("utf-8");
		int boarNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardName = request.getParameter("boardName");
		String boardUse = request.getParameter("boardUse");
		
		request.setAttribute("boardUse", boardUse);
		request.setAttribute("boardName", boardName);
		request.setAttribute("boarNo", boarNo);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(boardName);
		boardVo.setBoard_use(boardUse);
		boardVo.setBoard_no(boarNo);
		
		boardService.updateBoard(boardVo);
		
		response.sendRedirect("/boardMenuServlet");
		
	}

}
