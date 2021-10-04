package poly.controller;
//깃테스트 이진아


//git test_김학겸

// 깃 테스트 주현

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IJoinService;

@Controller
public class MypageController {

	@Resource(name = "JoinService")
	private IJoinService JoinService;
	
	private Logger log = Logger.getLogger(getClass());
	
	
	// ================================= 마이페이지
	@RequestMapping(value = "mypage")
	public String mypage() {
		log.info("마이페이지 화면 출력");
		return "/mypage/mypage";
	}
	
	@RequestMapping(value = "mypage/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃 시작");
		session.invalidate();
		
		String result = "/alert/logOutAlert";
		
		return result;
	}
		
}
