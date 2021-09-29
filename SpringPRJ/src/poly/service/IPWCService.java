package poly.service;

import poly.dto.ProjectsDTO;

public interface IPWCService {

	int New(ProjectsDTO wDTO)throws Exception;

	int Search(ProjectsDTO oDTO) throws Exception;

}
