package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IPWCMapper;
import poly.service.IPWCService;

@Service
public class PWCService implements IPWCService {
	
	@Resource(name="PWCMapper")
	private IPWCMapper PWCMapper;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public int Search(ProjectsDTO oDTO) throws Exception {
		int res = 0;
		log.info("아이디 :" + oDTO.getUser_id());
		
		ProjectsDTO nDTO = new ProjectsDTO();
		
		nDTO = PWCMapper.Search(oDTO);
		
		if(nDTO ==null) {
			
			log.info("비밀번호찾기시작");
			res = 1;
			log.info("없는 아이디 입니다");
		} else {
			res = 2;
			log.info("일치하는 아이디가 있습니다");
		}
		return res;
	}
	
	@Override
	public int New(ProjectsDTO wDTO) throws Exception {
		
		
		log.info("비밀번호 :" + wDTO.getUser_pwd());
		
		ProjectsDTO qDTO = new ProjectsDTO();
		int res = 0;
		res = PWCMapper.New(wDTO);
		
		
		
		
		return res;
	}
}
