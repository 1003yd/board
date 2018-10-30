package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf {

	@Override
	public List<UserVo> userAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo searchUser(String userId) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo user = session.selectOne("user.selectUser", userId);
		
		return user;
	}

}
