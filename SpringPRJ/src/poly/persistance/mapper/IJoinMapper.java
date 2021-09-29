package poly.persistance.mapper;

import config.Mapper;
import poly.dto.ProjectsDTO;

@Mapper("JoinMapper")
public interface IJoinMapper {

	ProjectsDTO checkID(ProjectsDTO uDTO) throws Exception;

	void insertinfo(ProjectsDTO uDTO) throws Exception;


}
