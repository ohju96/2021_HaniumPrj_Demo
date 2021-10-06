package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.ILoginMapper;
import poly.service.ILoginService;
import poly.util.CmmUtil;

@Service("LoginService")
public class LoginService implements ILoginService {
   
   @Resource(name="LoginMapper")
   private ILoginMapper LoginMapper;

   private Logger log = Logger.getLogger(getClass());
   
   
   @Override
   public int Loginpage(ProjectsDTO mDTO) throws Exception {
      log.info(this.getClass().getName()+" Loginpage 호출 !!");
      // 로그인 성공 : 1 , 실패 : 0
      int res = 0;
      
      
   
      ProjectsDTO uDTO = LoginMapper.checkLogin(mDTO);
      log.info("mapper에 mDTO를 넘겨주고 쿼리문을 날려 uDTO에 결과를 저장");
      
      if (uDTO==null) {
         uDTO = new ProjectsDTO();
         log.info("uDTO가 널이어서 강제로 메모리에 올림");
      }
   
      if(CmmUtil.nvl(uDTO.getUser_id()).length()>0) {
         log.info("로그인 성공");
         res = 1;
         
      }
      
      log.info(this.getClass().getName()+" Loginpage 끝 !!");
      return res;
   }


}