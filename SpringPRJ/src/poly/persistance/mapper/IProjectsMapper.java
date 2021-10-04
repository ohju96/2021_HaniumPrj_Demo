package poly.persistance.mapper;


import config.Mapper;
import poly.dto.ProjectsDTO;


@Mapper("ProjectsMapper")
public interface IProjectsMapper {


	int insertinfo(ProjectsDTO uDTO) throws Exception;

	ProjectsDTO checkID(ProjectsDTO mDTO) throws Exception;

	

	ProjectsDTO Search(ProjectsDTO oDTO) throws Exception;

	int New(ProjectsDTO wDTO) throws Exception;


}
