package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("LoginMapper")
public interface ILoginMapper {

	//로그인을 위해 아이디와 비밀번호가 일치하는지 확인하기
	ProjectsDTO checkLogin(ProjectsDTO mDTO) throws Exception; 
	
	
	
}
