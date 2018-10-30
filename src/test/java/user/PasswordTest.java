package user;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

import org.junit.AfterClass;
import org.junit.Test;

public class PasswordTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void passwordTest() {
		System.out.println(KISA_SHA256.encrypt("jamespass"));
	}
	
	@Test
	public void userSelectTest(){
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.searchUser("brown");
		
		assertEquals("brown", userVo.getUserId());
	}

}
