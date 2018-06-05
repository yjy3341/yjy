package kr.co.pk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Reply;

@Repository
public class ReplyDao {
	@Autowired
	private SqlSession sqlSession;
	
	//댓글 저장을 위한 메소드
	public int register(Reply reply) {
		return sqlSession.insert("reply.register", reply);
	}
}
