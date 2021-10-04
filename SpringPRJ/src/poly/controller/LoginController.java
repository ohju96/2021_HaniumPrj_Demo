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
import poly.service.ILoginService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class LoginController {
	
	@Resource(name = "LoginService")
	private ILoginService LoginService;
	
	//==================================================== 로그 찍기 위한 메소드
	private Logger log = Logger.getLogger(this.getClass());
	
	//================================== 로그인 페이지 진입
	@RequestMapping(value = "user/login")
	public String login() {
		log.info("로그인 접속");
		
		return "/user/login";
	}
	
	//================================== 로그인 처리 로직
	@RequestMapping(value = "Projects/index")
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) throws Exception {
		
		log.info("로그인 시작");
		
		int res = 0;
		
		ProjectsDTO mDTO = null;
		
		try {
			String user_id = CmmUtil.nvl(request.getParameter("id"));
			log.info("user_id : " + user_id);
			String user_pwd = CmmUtil.nvl(request.getParameter("pwd"));
			log.info("user_pwd : " + user_pwd);
			
			
			
			mDTO = new ProjectsDTO();
			
			mDTO.setUser_id(user_id);
			log.info("user_id2 : " + user_id);
			mDTO.setUser_pwd(EncryptUtil.encHashSHA256(user_pwd));
			log.info("user_pwd2 : " + user_pwd);
			
			res = LoginService.Loginpage(mDTO);
			
			if (res==1) {
				session.setAttribute("SS_user_id", user_id);
				session.setAttribute("name", mDTO.getUser_name());
			}
		} catch (Exception e) {
			res = 2;
			
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info("로그인 끝");


			model.addAttribute("res", String.valueOf(res));
			
			mDTO = null;
		}

		return "/alert/loginAlert";
	}
}
