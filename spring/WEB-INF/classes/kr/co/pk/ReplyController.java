package kr.co.pk;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.pk.service.ReplyService;

//결과를 html 화면으로 만드는 것이 아니고
//text 나 json으로 만들어주는 Contorller를 만들어 주는
//어노테이션
@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	//댓글 저장을 위한 메소드
	@RequestMapping(value="reply/register", 
		method=RequestMethod.GET)
	public Map<String, Object> register(
			HttpServletRequest request)
	{
		boolean result = replyService.register(request);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
}














