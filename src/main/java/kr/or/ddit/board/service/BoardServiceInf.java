package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachmentsVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.CommentVo;
import kr.or.ddit.board.model.PageVo;
import kr.or.ddit.board.model.PostVo;

public interface BoardServiceInf {
	
	/**  
	* Method   : boardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 : 게시판 전체 정보 출력 
	*/
	public List<BoardVo> boardList();
	
	/**  
	* Method   : boardUserList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  게시판 사용여부가 Y 인 전체정보 출력
	*/
	public List<BoardVo> boardUserList();
	
	/**  
	* Method   : postBoardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param board_no
	* @return  
	* Method 설명 :  게시판 번호에 맞는 게시글 리스트 출력
	*/
	public Map<String, Object> postBoardList(PageVo pageVo);
	
	
	/**  
	* Method   : insertBoardList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  게시판 등록
	*/
	public int insertBoardList(BoardVo boardVo);
	
	
	/**  
	* Method   : insertPost 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param postVo
	* @return  
	* Method 설명 :  게시글 등록
	*/
	public int insertPost(PostVo postVo);

	
	/**  
	* Method   : selectOnePost 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param post_no
	* @return  
	* Method 설명 : 게시글 번호에 맞는 하나의 게시글 정보 조회 
	*/
	public PostVo selectOnePost(int post_no);
	
	/**  
	* Method   : insertComment 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param commentVo
	* @return  
	* Method 설명 :  각 게시글에 해당한 댓글 작성
	*/
	public int insertComment(CommentVo commentVo);
	
	/**  
	* Method   : selectPostComment 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param postNo
	* @return  
	* Method 설명 :  각 게시글에 대한 댓글 조회
	*/
	public List<CommentVo> selectPostComment(int postNo); 
	
	/**  
	* Method   : updatePost 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param postVo
	* @return  
	* Method 설명 :  게시글 수정
	*/
	public int updatePost(PostVo postVo);
	
	
	/**  
	* Method   : deletePost 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param postNo
	* @return  
	* Method 설명 :  게시글 삭제여부를 Y로 변경
	*/
	public int deletePost(int postNo);
	
	/**  
	* Method   : updateBoard 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param boardVo
	* @return  
	* Method 설명 :  게시판 수정
	*/
	public int updateBoard(BoardVo boardVo);
	
	/**  
	* Method   : postBoardCnt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  게시글 갯수 조회
	*/
	public int postBoardCnt(int boardNo);
	
	/**  
	* Method   : insertFile 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param attchVo
	* @return  
	* Method 설명 :  파일 등록
	*/
	public int insertFile(AttachmentsVo attchVo);
	
	/**  
	* Method   : updateFile 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param attachVo
	* @return  
	* Method 설명 :  파일 수정
	*/
	public int updateFile(AttachmentsVo attachVo);
	
	/**  
	* Method   : selectAttachmen 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param attachVo
	* @return  
	* Method 설명 :  게시글에 맞는 첨부파일 조회
	*/
	public List<AttachmentsVo> selectAttachment(int postNo);

	
}
