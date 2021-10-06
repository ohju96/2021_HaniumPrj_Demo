package poly.controller;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.ProjectsDTO;
import poly.service.IMainService;


@Controller("MainController")
public class MainController {
	
	@Resource(name="MainService")
	private IMainService MainService;
	
	private Logger log = Logger.getLogger(getClass());



	// =========================================== 메인페이지 출력
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session,
	         ModelMap model) throws Exception {
		
		String id = (String)session.getAttribute("id");
		log.info("세션 아이디1 : " + id);
		
		ProjectsDTO pDTO = null;
		
		pDTO = new ProjectsDTO();
		
		pDTO.setUser_id(id);
		
		
		log.info("세션 아이디2 : " + id);
		
		ProjectsDTO rDTO = MainService.getUserInfo(pDTO);
		
		log.info("세션 아이디3 : " + id);
		log.info(rDTO.getUser_allergy());
		log.info(rDTO.getUser_name());
		
		session.setAttribute("rDTO",rDTO);
		return "/index";
	}
}
