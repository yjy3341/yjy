package kr.co.pk.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pk.dao.ReplyDao;
import kr.co.pk.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;
	//파라미터의 이름은 테이블의 컬럼이름과 동일
	
	//댓글 저장을 위한 메소드
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;

		//1.파라미터 읽기
		String bno = request.getParameter("bno");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String replytext = request.getParameter("replytext");
		
		//2.Dao의 파라미터를 만들기
		Reply reply = new Reply();
		reply.setBno(Integer.parseInt(bno));
		reply.setEmail(email);
		reply.setNickname(nickname);
		reply.setReplytext(replytext);
		
		//3.Dao의 메소드 호출
		int r = replyDao.register(reply);
		
		//4.Dao의 호출결과를 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		
		return result;
	}
}












