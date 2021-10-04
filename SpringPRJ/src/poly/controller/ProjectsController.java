package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MailDTO;
import poly.dto.ProjectsDTO;
import poly.service.IMailService;
import poly.service.impl.ProjectsService;
import poly.util.CmmUtil;

@Controller
public class ProjectsController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ProjectsService")
	private ProjectsService projectsService;
	
	@Resource(name = "MailService")
	private IMailService mailService;
	

	
	@RequestMapping(value = "Test")
	public String Test(HttpServletRequest request, ModelMap model) throws Exception{
		
		String name = CmmUtil.nvl(request.getParameter("name"));
		
		model.addAttribute("name", name);
		
		return "/Projects/Test";
	}
	

	@RequestMapping(value = "contact")
	public String Main() {
		log.info("contact접속");

		return "/contact";
	}
	@RequestMapping(value = "resume")
	public String resume() {
		log.info("resume접속");

		return "/resume";
	}
	@RequestMapping(value = "services")
	public String services() {
		log.info("services접속");

		return "/services";
	}
	@RequestMapping(value = "welcome")
	public String welcome() {
		log.info("welcome접속");

		return "/welcome";
	}
	@RequestMapping(value = "works")
	public String works() {
		log.info("works접속");

		return "/works";
	}
	@RequestMapping(value = "testimonials")
	public String testimonials() {
		log.info("testimonials접속");

		return "/testimonials";
	}
	@RequestMapping(value = "about")
	public String about() {
		log.info("about접속");

		return "/about";
	}
	
	//비밀번호 찾기 페이지
	@RequestMapping(value = "Projects/Forgot")
	public String Forgot() {
		log.info("비밀번호 찾기 페이지 출력");

		return "/Projects/Forgot";
	}
	
	

	//비밀번호 찾기
	 @RequestMapping(value = "Projects/Search")
	 
	 public String Search(HttpServletRequest request, ModelMap model) throws Exception {
	 log.info("비밀번호 찾기 시작");
	 
	 String id = request.getParameter("toMail"); 
	 log.info(id);
	 
	 ProjectsDTO oDTO = new ProjectsDTO(); 
	 oDTO.setUser_id(id);
	 log.info(oDTO.getUser_id()); 
	 
	 int res = projectsService.Search(oDTO);
	 
	 String result = "";
	 if (res == 2) {
		    result = "/mail/sendMailResult";
		} else if (res == 1) {
			result = "/Projects/Return";
				log.info(result);
		} else {
			result = "ERROR : 3064";
				log.info(result);
		}
	 
	 log.info(this.getClass().getName() + "mail.sendMail start!");
	 
	 String toMail = CmmUtil.nvl(request.getParameter("toMail"));
	 log.info(toMail);
	 String contents = RandomStringUtils.randomAlphanumeric(10);
	
	 MailDTO pDTO = new MailDTO();
	 
	 pDTO.setToMail(toMail);
	 pDTO.setTitle("임시 비밀번호 입니다.");
	 pDTO.setContents(contents);
	 
	 log.info("새로운 비밀번호 설정");
	 log.info(contents);
	 
	 ProjectsDTO wDTO = new ProjectsDTO(); 
	 wDTO.setUser_pwd(contents);
	 wDTO.setUser_id(id);
	 log.info(wDTO.getUser_pwd()); 
	 
	 int res1 = projectsService.New(wDTO);
	 
	 if(res1 == 0) {
		 log.info("비밀번호 변경 실패");
	 }
	 else{
		 
		 log.info("비밀번호 변경 성공");
	 }
	 
 	int res2 = mailService.doSendmail(pDTO);
	 
	 if(res2 == 1) {
		 log.info("메일발송 성공");
	 } else {
		 log.info("메일 발송 실패");
	 }
	 
	 
	 model.addAttribute("res", String.valueOf(res2));
	 
	 log.info(this.getClass().getName() + "mail.sendMail end!");
	 
	 return result;
	 
 }
	 
	/*
	 * 비밀번호 변경
	 * 
	 * @RequestMapping(value = "Projects/Pwd")
	 * 
	 * @ResponseBody public String New(HttpServletRequest request) throws Exception
	 * { log.info("새로운 비밀번호 설정");
	 * 
	 * String pw = request.getParameter("pwd"); String id =
	 * request.getParameter("id"); log.info(pw);
	 * 
	 * ProjectsDTO wDTO = new ProjectsDTO(); wDTO.setUser_pwd(pw);
	 * wDTO.setUser_id(id); log.info(wDTO.getUser_pwd());
	 * 
	 * int res = projectsService.New(wDTO); String result; if(res == 0) { result =
	 * "실패했습니다"; } else{
	 * 
	 * result = "성공입니다"; }
	 * 
	 * return result; }
	 */

}