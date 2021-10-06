package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IMainMapper;
import poly.service.IMainService;

 @Service("MainService")
public class MainService implements IMainService {
	
	@Resource(name="MainMapper")
	private IMainMapper MainMapper;

	@Override
	public ProjectsDTO getUserInfo(ProjectsDTO pDTO) throws Exception {
		
		return MainMapper.getUserInfo(pDTO);
	}
	


}
