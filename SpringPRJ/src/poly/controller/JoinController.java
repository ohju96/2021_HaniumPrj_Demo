package poly.controller;
//깃테스트 이진아


//git test_김학겸

// 깃 테스트 주현

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import poly.dto.ProjectsDTO;
import poly.service.IJoinService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class JoinController {

	@Resource(name = "JoinService")
	private IJoinService JoinService;
	
	private Logger log = Logger.getLogger(getClass());
	
	
	// ================================= 회원가입 페이지
	@RequestMapping(value = "user/join")
	public String join() {
		log.info("로그인 페이지 출력");
		return "/user/join";
	}
	
	// ================================== 회원가입 로직
	
		@RequestMapping(value = "user/user/join.do")
		public String insertinfo(HttpServletRequest request, ModelMap model) throws Exception {
			log.info("로그인 로직 실행");

			String id = CmmUtil.nvl(request.getParameter("id"));
			String password = CmmUtil.nvl(request.getParameter("pwd"));
			String name = CmmUtil.nvl(request.getParameter("name"));
			String year = CmmUtil.nvl(request.getParameter("year"));
			String month = CmmUtil.nvl(request.getParameter("month"));
			String datey = CmmUtil.nvl(request.getParameter("date"));
			String gender = CmmUtil.nvl(request.getParameter("gender"));
			String allergy = CmmUtil.nvl(request.getParameter("allergy"));
			String date = CmmUtil.nvl((year)+("-"+month)+("-"+datey));
			log.info("user_id : "+id);
			log.info("user_password : "+password);
			log.info("user_name : "+name);
			log.info("birth_year : "+year);
			log.info("birth_month : "+month);
			log.info("birth_date : "+datey);
			log.info("birth : "+date);
			log.info("gender : "+gender);
			log.info("allergy : "+allergy);
			ProjectsDTO uDTO = new ProjectsDTO();

			uDTO.setUser_id(id);
			//비밀번호는 절대로 복호화 되지 않도록 해시 알고리즘으로 암호화함
			uDTO.setUser_pwd(EncryptUtil.encHashSHA256(password));
			uDTO.setUser_name(name);
			uDTO.setUser_date(date);
			uDTO.setUser_gender(gender);
			uDTO.setUser_allergy(allergy);

			int res = JoinService.insertinfo(uDTO);

			
			if (res == 0) {
				log.info("회원가입 실패");
			} else if (res == 1) {
				log.info("회원가입 성공");
			} 
			
			model.addAttribute("res", String.valueOf(res));
			return "/alert/joinAlert";
		}
		
		
}
