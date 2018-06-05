package kr.co.pk.service;

import javax.servlet.http.HttpServletRequest;

public interface ReplyService {
	//댓글 저장을 위한 메소드
	public boolean register(HttpServletRequest request);
}
