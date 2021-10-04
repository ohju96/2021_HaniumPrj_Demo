package poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller 
public class FoodForumController {

	private Logger log = Logger.getLogger(getClass()); 

	
	// 카카오 정보 제공을 위한 매핑 카카오 로그인 or 카카오 정보 제공 화면 보일 것
	@RequestMapping(value="/FoodForum")
	public String FoodForum(HttpServletRequest request) throws Exception {
		

		
		return "/FoodForum/bullentinBoard";
	}

	
}