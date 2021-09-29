package poly.service;

import java.util.List;

import poly.dto.ProjectsDTO;

public interface ICommunityService {

	int insertCommunity(ProjectsDTO uDTO) throws Exception;
	List<ProjectsDTO> getBoardList() throws Exception;
	ProjectsDTO getBoard(ProjectsDTO pDTO) throws Exception;
	int updateCommunity(ProjectsDTO aDTO) throws Exception;
	int deleteCommunity(ProjectsDTO aDTO) throws Exception;
}
