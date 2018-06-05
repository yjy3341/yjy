package kr.co.pk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Board;
import kr.co.pk.domain.Criteria;
import kr.co.pk.domain.SearchCriteria;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	//게시물 저장을 위한 메소드
	public void register(Board board){
		//System.out.println("dao 수행");
		sqlSession.insert("board.register", board);
	}
	
	//게시물의 데이터 개수를 가져오는 메소드
	public int totalCount(SearchCriteria criteria) {
		return sqlSession.selectOne("board.totalcount", criteria);
	}
	
	//게시물 전체 목록을 가져오는 메소드
	public List<Board> list(SearchCriteria criteria){
		return sqlSession.selectList("board.list", criteria);
	}
	
	//글번호에 해당하는 데이터의 조회수를 1증가시키는 메소드
	public void updatecnt(int bno) {
		sqlSession.update("board.updatecnt", bno);
	}
	
	//글번호에 해당하는 데이터를 가져오는 메소드
	public Board detail(int bno) {
		return sqlSession.selectOne("board.detail", bno);
	}
	
	//글번호에 해당하는 데이터의 수정을 처리하는 메소드
	public void update(Board board) {
		//System.out.println("DAO");
		sqlSession.update("board.update", board);
	}
	
	//글번호에 해당하는 데이터를 삭제를 하는 메소드
	public void delete(int bno) {
		sqlSession.delete("board.delete", bno);
	}
}









