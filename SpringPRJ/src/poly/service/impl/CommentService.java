package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.CommentDTO;
import poly.dto.ProjectsDTO;
import poly.persistance.mapper.ICommentMapper;
import poly.service.ICommentService;
import poly.util.CmmUtil;

@Service("CommentService")
public class CommentService implements ICommentService {
	
	@Resource (name = "CommentMapper")
	private ICommentMapper CommentMapper;
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int writeComment(CommentDTO pDTO) throws Exception {
		
		
		if(pDTO == null) {
			pDTO = new CommentDTO();
		} 
		int res = 0;
		
	      CommentDTO uDTO = CommentMapper.CommentWrite(pDTO);
	      
	      
	      if (uDTO==null) {
	         uDTO = new CommentDTO();
	      }
	   
	      if(CmmUtil.nvl(uDTO.getComment_id()).length()>0) {
	         
	         res = 1;
	      }

		
		
		return res;
	}
	
	@Override
	public List<CommentDTO> getCommentList() throws Exception {
		List<CommentDTO> rlist = new ArrayList<>();
		
		rlist = CommentMapper.getCommentList();
		
		if(rlist==null) {
			//rlist가 null 일 경우 오류 방지를 위해 강제로 메모리에 LIST 를 올림 
			rlist = new ArrayList<>();
			log.info("rlist == null");
		}
		else {
			log.info("success");
		}
		
		return rlist;
	}

}
