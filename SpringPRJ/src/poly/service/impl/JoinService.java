package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IJoinMapper;
import poly.service.IJoinService;

@Service("JoinService")
public class JoinService implements IJoinService {

	@Resource(name = "JoinMapper")
	private IJoinMapper JoinMapper;
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public int insertinfo(ProjectsDTO uDTO) throws Exception {
		int res = 0;
		log.info("서비스 :" + uDTO.getUser_id());
		ProjectsDTO rDTO = new ProjectsDTO();
		rDTO = JoinMapper.checkID(uDTO);
		if(rDTO ==null) {
			log.info("회원가입 시작");
			JoinMapper.insertinfo(uDTO);
			res = 1;
			log.info("회원가입 완료");
		} else {
			log.info("가입된아이디");
		}
		return res;
	}
}
