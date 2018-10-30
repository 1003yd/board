package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.SqlFactoryBuilder;

public class BoardDao implements BoardDaoInf {

	/**  
	* Method   : boardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  게시판 전체 리스트 조회
	*/
	@Override
	public List<BoardVo> boardList() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVo> boardList = session.selectList("board.selectBoard");
		session.close();
		
		return boardList;
	}

	/**  
	* Method   : boardUserList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  게시판 사용여부가 Y인 리스트 조회
	*/
	@Override
	public List<BoardVo> boardUserList() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVo> boardList = session.selectList("board.selectUseBoard");
		session.close();
		
		return boardList;
	}

	/**  
	* Method   : insertBoardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param boardVo
	* @return  
	* Method 설명 :  게시판 등록
	*/
	@Override
	public int insertBoardList(BoardVo boardVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertBoard = session.update("board.insertBoard",boardVo);
		session.commit();
		session.close();
		
		return insertBoard;
	}

	/**  
	* Method   : postBoardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param board_no
	* @return  
	* Method 설명 :  게시판 번호에 맞는 게시글 리스트 출력
	*/
	@Override
	public List<PostVo> postBoardList(PageVo pageVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<PostVo> postList = session.selectList("board.selectPostBoardList", pageVo);
		session.close();
		
		return postList;
	}

	/**  
	* Method   : insertPost 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param postVo
	* @return  
	* Method 설명 :  게시글 등록
	*/
	@Override
	public int insertPost(PostVo postVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertPost = session.insert("board.insertPost",postVo);
		session.commit();
		session.close();
		
		return postVo.getPost_no();
	}
	

	@Override
	public PostVo selectOnePost(int post_no) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		PostVo postVo = session.selectOne("board.selectOnePost", post_no);
		session.close();
		
		return postVo;
	}

	@Override
	public int insertComment(CommentVo commentVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertComment = session.insert("board.insertComment", commentVo);
		session.commit();
		session.close();
		
		
		return insertComment;
	}

	@Override
	public List<CommentVo> selectPostComment(int postNo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommentVo> commentList = session.selectList("board.selectPostComment", postNo);
		session.close();
		
		return commentList;
	}

	@Override
	public int updatePost(PostVo postVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updatePost = session.update("board.updatePost", postVo);
		session.commit();
		session.close();
		
		return updatePost;
	}

	@Override
	public int deletePost(int postNo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deletePost = session.update("board.deletePost",postNo);
		session.commit();
		session.close();
		
		return deletePost;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateBoard = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateBoard;
	}

	@Override
	public int postBoardCnt(int boardNo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		int pageCnt = session.selectOne("board.PostBoardCnt",boardNo);
		session.close();
		
		return pageCnt;
	}

	@Override
	public int insertFile(AttachmentsVo attchVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertFile = session.insert("board.insertFile", attchVo);
		session.commit();
		session.close();
		
		return insertFile;
	}

	@Override
	public int updateFile(AttachmentsVo attachVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateFile = session.update("board.updateFile", attachVo);
		session.commit();
		session.close();
		
		return updateFile;
	}

	@Override
	public List<AttachmentsVo> selectAttachment(int postNo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<AttachmentsVo> attachList = session.selectList("board.selectAttachment", postNo);
		session.close();
		
		return attachList;
	}

	@Override
	public int insertPostNo(PostVo postVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int postInsert = session.insert("board.insertPostNo", postVo); 
		session.commit();
		session.close();
		
		return postInsert;
	}
	
	
	
	

}
