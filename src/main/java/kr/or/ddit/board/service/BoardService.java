package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

public class BoardService implements BoardServiceInf {
	
	private BoardDaoInf boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> boardList() {
		// TODO Auto-generated method stub
		return boardDao.boardList();
	}

	@Override
	public List<BoardVo> boardUserList() {
		// TODO Auto-generated method stub
		return boardDao.boardUserList();
	}

	@Override
	public int insertBoardList(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.insertBoardList(boardVo);
	}

	@Override
	public Map<String, Object> postBoardList(PageVo pageVo) {
		// TODO Auto-generated method stub
		List<PostVo> postList =  boardDao.postBoardList(pageVo);
		System.out.println(pageVo.getPage());
		System.out.println(pageVo.getPageSize());
		int totalCnt = boardDao.postBoardCnt(pageVo.getBoard_no());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", postList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalCnt/pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int insertPost(PostVo postVo) {
		// TODO Auto-generated method stub
		int insertPost = 0;
		if(postVo.getPost_pid() != 0){
			insertPost = boardDao.insertPost(postVo);
		}else{
			insertPost = boardDao.insertPostNo(postVo);
		}
		
		return insertPost;
	}

	@Override
	public PostVo selectOnePost(int post_no) {
		// TODO Auto-generated method stub
		return boardDao.selectOnePost(post_no);
	}

	@Override
	public int insertComment(CommentVo commentVo) {
		// TODO Auto-generated method stub
		return boardDao.insertComment(commentVo);
	}

	@Override
	public List<CommentVo> selectPostComment(int postNo) {
		// TODO Auto-generated method stub
		return boardDao.selectPostComment(postNo);
	}

	@Override
	public int updatePost(PostVo postVo) {
		// TODO Auto-generated method stub
		return boardDao.updatePost(postVo);
	}

	@Override
	public int deletePost(int postNo) {
		// TODO Auto-generated method stub
		return boardDao.deletePost(postNo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(boardVo);
	}


	@Override
	public int postBoardCnt(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.postBoardCnt(boardNo);
	}

	@Override
	public int insertFile(AttachmentsVo attchVo) {
		// TODO Auto-generated method stub
		return boardDao.insertFile(attchVo);
	}

	@Override
	public int updateFile(AttachmentsVo attachVo) {
		// TODO Auto-generated method stub
		return boardDao.updateFile(attachVo);
	}

	@Override
	public List<AttachmentsVo> selectAttachment(int postNo) {
		// TODO Auto-generated method stub
		return boardDao.selectAttachment(postNo);
	}

}
