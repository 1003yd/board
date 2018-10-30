package kr.or.ddit.user.service;

import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {
	
	/**  
	* Method   : searchUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userId
	* @return  
	* Method 설명 :  회원 한 사람의 정보를 출력
	*/
	public UserVo searchUser(String userId);

}
