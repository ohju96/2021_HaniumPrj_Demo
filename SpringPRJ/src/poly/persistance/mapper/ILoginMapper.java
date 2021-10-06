package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("LoginMapper")
public interface ILoginMapper {

	
	ProjectsDTO checkLogin(ProjectsDTO mDTO) throws Exception;

	
}
