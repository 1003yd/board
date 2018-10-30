package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/boardNewPostServlet")
public class BoardNewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/board/newPost.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardServiceInf boardService = new BoardService();
		
		String postTitle = request.getParameter("postTitle");
		String postContext = request.getParameter("smarteditor");
		Part postAttach = request.getPart("postFile");
		
		String contentDisposition = postAttach.getHeader("Content-disposition");
		String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
		
		
		HttpSession session = request.getSession();
		int boardNo = (int)session.getAttribute("boardNo");
		UserVo userVo = (UserVo)session.getAttribute("user");
		

		PostVo postVO = new PostVo();
		postVO.setPost_title(postTitle);
		postVO.setPost_context(postContext);
		
		postVO.setPost_board(boardNo);
		postVO.setPost_user(userVo.getUserId());
		int postNo = boardService.insertPost(postVO);
		
		String path = getServletContext().getRealPath("/profile");
//		postAttach.write( "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
		//ssss
		AttachmentsVo attchVo = new AttachmentsVo();
		attchVo.setAttach_post(postNo);
		if(fileName.equals("")){
			
		}else{
			postAttach.write(path + File.separator + fileName);
			attchVo.setAttach_name("/profile/"+fileName);
			postAttach.delete();
			boardService.insertFile(attchVo);
		}
		
		PostVo post = boardService.selectOnePost(postNo);
		List<AttachmentsVo> attachList = boardService.selectAttachment(postNo);
		request.setAttribute("postVo", post);
		request.setAttribute("attachList", attachList);
		/*
		List<PostVo> postList = boardService.postBoardList(boardNo);
		 */		
		/*response.sendRedirect("/boardMenuPageServlet?boardNo=" + boardNo+"&page=1&pageSize=10");*/
		request.getRequestDispatcher("/board/boardDetailPage.jsp").forward(request, response);


	}

}
