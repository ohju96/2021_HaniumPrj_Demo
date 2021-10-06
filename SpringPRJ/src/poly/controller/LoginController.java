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

@Controller("LoginController")
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
      
      log.info(this.getClass().getName()+" : 로그인 시작");
      
      int res = 0;
      
      ProjectsDTO mDTO = null;
      
      try {
         String id = CmmUtil.nvl(request.getParameter("id"));
         log.info("user_id : " + id);
         String password = CmmUtil.nvl(request.getParameter("pwd"));
         log.info("user_pwd : " + password);
         
         
         
         mDTO = new ProjectsDTO();
         
         mDTO.setUser_id(id);
         log.info("user_id2 : " + id);
         mDTO.setUser_pwd(EncryptUtil.encHashSHA256(password));
         log.info("user_pwd2 : " + password);
         
         res = LoginService.Loginpage(mDTO);
         log.info("서비스에서 로그인 성공, 실패 여부가 성공적으로 넘어옴");
         
         if (res==1) {
            session.setAttribute("id", id);
            log.info("로그인 성공했으므로 id를 세션에 담음");
         }
      } catch (Exception e) {
         res = 2;
         
         log.info(e.toString());
         e.printStackTrace();
         
      } finally {


         model.addAttribute("res", String.valueOf(res));
         log.info(this.getClass().getName()+"로그인 끝");
         
         mDTO = null;
      }

      return "/alert/loginAlert";
   }
}