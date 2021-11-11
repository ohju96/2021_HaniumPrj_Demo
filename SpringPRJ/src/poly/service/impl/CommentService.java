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
	public int writeComment(CommentDTO qDTO) throws Exception {
		
		
		
		if(qDTO == null) {
			qDTO = new CommentDTO();
		} 
		int res = 0;
	      int res1 = CommentMapper.CommentWrite(qDTO);
	      
	      
	      if (res1==0) {
	         log.info("db저장 실패");
	      }else {
	    	  res = 1;
	    	  log.info("db저장 성공");
	      }
	   

		
		
		return res;
	}
	
	@Override
	public List<CommentDTO> getCommentList(CommentDTO pDTO) throws Exception {
		List<CommentDTO> rlist = new ArrayList<>();
		
		rlist = CommentMapper.getCommentList(pDTO);

		
		if(rlist==null) {
			//rlist가 null 일 경우 오류 방지를 위해 강제로 메모리에 LIST 를 올림 
			rlist = new ArrayList<>();
			log.info("rlist == null");
		}
		else {
			log.info("success");
		}
		log.info(rlist.get(0).getBoard_seq());
		return rlist;
	}

}
