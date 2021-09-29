package poly.persistance.mapper;


import config.Mapper;
import poly.dto.ProjectsDTO;


@Mapper("PWCMapper")
public interface IPWCMapper {


	ProjectsDTO Search(ProjectsDTO oDTO) throws Exception;

	int New(ProjectsDTO wDTO) throws Exception;


}
