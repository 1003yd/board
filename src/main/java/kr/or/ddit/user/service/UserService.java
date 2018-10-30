package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {
	
	private UserDaoInf userDao = new UserDao();
	
	/**  
	* Method   : searchUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userId
	* @return  
	* Method 설명 :  회원 한명의 정보 출력
	*/
	@Override
	public UserVo searchUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.searchUser(userId);
	}

}
