package board;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.junit.AfterClass;
import org.junit.Test;

public class BoardUseListTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/*@Test
	public void boardList(){
		BoardDaoInf boardDao = new BoardDao();
		
		List<BoardVo> boardList = boardDao.boardList();
		
		assertEquals(9, boardList.size());
	}

	*//**  
	* Method   : boardUseListTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  사용여부가 Y 인 게시판 조회
	*//*
	@Test
	public void boardUseListTest() {
		BoardDaoInf boardDao = new BoardDao();
		
		List<BoardVo> boardList = boardDao.boardUserList();
		
		assertEquals(6, boardList.size());
		
	}
	
	@Test
	public void postBoardListTest(){
		BoardDaoInf boardDao = new BoardDao();
		
		List<PostVo> postList = boardDao.postBoardList(6);
		
		assertEquals(0, postList.size());
	}
	
	@Test
	public void insertPostList(){
		BoardDaoInf boardDao = new BoardDao();
		
		PostVo postVo = new PostVo();
		postVo.setPost_title("일곱번째 게시글입니다.");
		postVo.setPost_context("답글 아니고 새로운 게시글 ");
		postVo.setPost_board(1);
		postVo.setPost_user("brown");
		
		int insertPost = boardDao.insertPost(postVo);
		
		assertEquals(1, insertPost);
	}
	
	
	@Test
	public void selectOnePostTest(){
		BoardDaoInf boardDao = new BoardDao();
		
		PostVo post = boardDao.selectOnePost(6);
		
		assertEquals("cony", post.getPost_user());
	}
	
	@Test
	public void insertCommentTest(){
		BoardDaoInf boardDao = new BoardDao();
		
		CommentVo comment = new CommentVo();
		comment.setComm_context("처음 댓글달아요");
		comment.setComm_post(1);
		comment.setComm_user("brown");
		
		int comm = boardDao.insertComment(comment);
		
		assertEquals(1, comm);
		
		
	}
	*/
	@Test
	public void selectAttachmentTest(){
		BoardDaoInf boardDao = new BoardDao();
		
		List<AttachmentsVo> attahcList = boardDao.selectAttachment(47);
		
		assertEquals(1,attahcList.size());
	}

}
