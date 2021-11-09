package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dto.CommentDTO;
import poly.dto.ProjectsDTO;
import poly.service.ICommentService;
import poly.service.impl.CommentService;
import poly.util.PagingVO;


@Controller("CommentController")
public class CommentController {

	@Resource(name="CommentService")
	private ICommentService CommentService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	
	//댓글작성
	@RequestMapping("comment/write")
	public String comment(HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session) throws Exception {
		
		log.info("######### 댓글 쓰기 시작 ! #########");
		String msg = "";
		
		String contents = request.getParameter("contents");
		String id = request.getParameter("comment_id");
		
		log.info("contents : " + contents);
		log.info("id : " + id);
		
		CommentDTO pDTO = new CommentDTO();
		
		pDTO.setComment_contents(contents);
		pDTO.setComment_id(id);
		
		int res = CommentService.writeComment(pDTO);
		
		if(res==0) {
			log.info("댓글 작성 실패");
			msg = "댓글 작성에 실패하였습니다.";
		}else if(res == 1) {
			log.info("댓글 작성 성공");
			msg = "댓글 작성에 성공하였습니다.";
		}
		
		model.addAttribute("res", String.valueOf(res));	
		model.addAttribute("msg", msg);
		
		return "/alert/commentAlert";
	}
	
	//댓글 보기
	 
	     
	      
	    

	
	
}
