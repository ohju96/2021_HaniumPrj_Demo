package poly.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MailDTO;
import poly.dto.ProjectsDTO;
import poly.service.IMailService;
import poly.service.IPWCService;
import poly.service.impl.ProjectsService;
import poly.util.CmmUtil;


@Controller
public class PWController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "PWCService")
	private IPWCService PWCService;
	
	@Resource(name = "MailService")
	private IMailService mailService;
	
	// ================================= 비밀번호 찾기 페이지
	@RequestMapping(value = "user/forgot")
	public String forgot() {
		log.info("비밀번호 찾기 페이지 출력");
		return "/user/forgot";
	}
	
	// ================================== 비밀번호 로직
		 @RequestMapping(value = "user/Search")
		 public String Search(HttpServletRequest request, ModelMap model) throws Exception {
		 log.info("비밀번호 찾기 시작");
		 
		 String id = request.getParameter("toMail"); 
		 log.info(id);
		 
		 ProjectsDTO oDTO = new ProjectsDTO(); 
		 oDTO.setUser_id(id);
		 log.info(oDTO.getUser_id()); 
		 
		 int res = PWCService.Search(oDTO);
		 
		 String result = "";
		 if (res == 2) {
			    result = "/mail/sendMailResult";
			} else if (res == 1) {
				result = "/user/Return";
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
		 
		 int res1 = PWCService.New(wDTO);
		 
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
		
		
}
