package poly.service;

import java.util.List;

import poly.dto.CommentDTO;

public interface ICommentService {

	// 댓글 작성
	int writeComment(CommentDTO pDTO) throws Exception;

	List<CommentDTO> getCommentList() throws Exception;

}
