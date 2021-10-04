package poly.service;

import poly.dto.ProjectsDTO;

public interface IProjectsService {

	int insertinfo(ProjectsDTO uDTO) throws Exception;

	

	int New(ProjectsDTO wDTO) throws Exception;

	int Search(ProjectsDTO oDTO) throws Exception;



}
