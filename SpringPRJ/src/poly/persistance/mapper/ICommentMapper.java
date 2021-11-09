package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.CommentDTO;
import poly.dto.ProjectsDTO;

@Mapper("CommentMapper")
public interface ICommentMapper {

	CommentDTO CommentWrite(CommentDTO pDTO)throws Exception;
	
	// 댓글 등록
	
	List<CommentDTO> getCommentList() throws Exception;

}
