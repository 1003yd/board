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
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/postUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf boardService = new BoardService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		PostVo postVo = boardService.selectOnePost(postNo);
		List<AttachmentsVo> attachList = boardService.selectAttachment(postNo);
		request.setAttribute("postVo", postVo);
		request.setAttribute("attachList", attachList);
		
		request.getRequestDispatcher("/board/updatePost.jsp").forward(request, response);
 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String postContext = request.getParameter("smarteditor");
		String postTitle = request.getParameter("postTitle");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Part postAttach = request.getPart("postFile");
		
		String contentDisposition = postAttach.getHeader("Content-disposition");
		String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
		
		String path = getServletContext().getRealPath("/profile");
//		postAttach.write( "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
		

		AttachmentsVo attchVo = new AttachmentsVo();
		
		if(fileName.equals("")){
			attchVo.setAttach_name(null);
		}else{
			postAttach.write(path + File.separator + fileName);
			attchVo.setAttach_name("/profile/"+fileName);
			postAttach.delete();
			boardService.insertFile(attchVo);
		}
		attchVo.setAttach_post(postNo);
		List<AttachmentsVo> attachList = boardService.selectAttachment(postNo);
		
		PostVo postVo = new PostVo();
		postVo.setPost_no(postNo);
		postVo.setPost_title(postTitle);
		postVo.setPost_context(postContext);
		boardService.updatePost(postVo);
		
		PostVo post = boardService.selectOnePost(postNo);
		request.setAttribute("postVo", post);
		request.setAttribute("attachList", attachList);
		request.getRequestDispatcher("/board/boardDetailPage.jsp").forward(request, response);
		
		/*response.sendRedirect("/boardMenuPageServlet?boardNo="+ boardNo+"&page=1&pageSize=10");*/
		
	}

}
