package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.ILoginMapper;
import poly.service.ILoginService;

@Service("LoginService")
public class LoginService implements ILoginService {
	
	@Resource(name="LoginMapper")
	private ILoginMapper LoginMapper;

	private Logger log = Logger.getLogger(getClass());
	
	
	@Override
	public ProjectsDTO Loginpage(ProjectsDTO mDTO) throws Exception {
		
		log.info("아이디 :" + mDTO.getUser_id());
		log.info("비밀번호 :" + mDTO.getUser_pwd());
		ProjectsDTO uDTO = new ProjectsDTO();
		uDTO = LoginMapper.checkLogin(mDTO);
		
		log.info("로그인시작");
		
		return uDTO;
	}
}
