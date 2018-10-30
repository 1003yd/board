package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import oracle.jdbc.proxy.annotation.Post;
import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/postCommentServlet")
public class PostCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postNo = Integer.parseInt(request.getParameter("postNumber"));
		int postBoard = Integer.parseInt(request.getParameter("postBoard"));
		request.setAttribute("postNo", postNo);
		request.setAttribute("postBoard", postBoard);

		request.getRequestDispatcher("/board/newCommentPost.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardServiceInf boardService = new BoardService();
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String postTitle = request.getParameter("postTitle");
		String postContext = request.getParameter("smarteditor");
		int postBoard = Integer.parseInt(request.getParameter("boardNo"));

		HttpSession session = request.getSession();
		UserVo userVo  = (UserVo)session.getAttribute("user");

		//		postAttach.write( "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);

		PostVo postVO = new PostVo();

		postVO.setPost_board(postBoard);
		postVO.setPost_user(userVo.getUserId());
		postVO.setPost_title(postTitle);
		postVO.setPost_context(postContext);
		postVO.setPost_pid(postNo);

		int postNum = boardService.insertPost(postVO);

		System.out.println("postNum = " + postNum);


		AttachmentsVo attchVo = new AttachmentsVo();
		attchVo.setAttach_post(postNum);


//		Part postAttach = request.getPart("postFile");
		Collection<Part> fileList = request.getParts();
		for(Part postAttach : fileList){
//			postAttach = request.getPart("postFile");
			String contentDisposition = postAttach.getHeader("Content-disposition");
			System.out.println(contentDisposition);
			String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
			System.out.println(fileName);
			String path = getServletContext().getRealPath("/profile");
			System.out.println(path);
			if(!(fileName.equals("") || fileName == null)){
				postAttach.write(path + File.separator + fileName);
				attchVo.setAttach_name("/profile/"+fileName);
				postAttach.delete();
				boardService.insertFile(attchVo);
			}
		}
		



		List<AttachmentsVo> attachList = boardService.selectAttachment(postNum);

		PostVo postVo = boardService.selectOnePost(postNum);
		request.setAttribute("postVo", postVo);
		request.setAttribute("attachList", attachList);

		System.out.println("postVo" + postVo.getPost_user());
		System.out.println("attachList"  + attachList.size());

		request.getRequestDispatcher("/board/boardDetailPage.jsp").forward(request, response);




	}

}
