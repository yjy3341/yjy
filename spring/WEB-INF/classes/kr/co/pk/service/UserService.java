package kr.co.pk.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.pk.domain.User;

public interface UserService {
	//email 중복 체크를 위한 메소드
	//파라미터는 3가지 
	//파라미터 각각을 파라미터로 만드는 경우 : @RequestParam
	//파라미터를 전부 모아서 만드는 경우: Command 객체
	//모든 경우에 동일한 파라미터를 사용: HttpServletRequest
	//파일 업로드가 있는 경우에는 HttpServletRequest 대신에
	//MultipartHttpServletRequest로 변경
	public String emailCheck(HttpServletRequest request);
	//회원가입을 위한 메소드
	//파일이 있을 때는 HttpServletRequest 대신에 MultipartHttpServletRequest를 사용
	public void register(MultipartHttpServletRequest request);
	//로그인 처리를 위한 메소드
	public User login(HttpServletRequest request);
	//주소를 가져오는 메소드
	public String address(String loc);
	//메일을 보내는 메소드
	public void sendmail(HttpServletRequest request);
}





