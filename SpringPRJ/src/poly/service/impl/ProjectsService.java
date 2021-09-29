package poly.service.impl;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import poly.dto.ProjectsDTO;
import poly.persistance.mapper.IProjectsMapper;
import poly.service.IProjectsService;
import poly.util.CmmUtil;



@Service("ProjectsService")
public class ProjectsService implements IProjectsService{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="ProjectsMapper")
	private IProjectsMapper ProjectsMapper;

	@Override
	public int insertinfo(ProjectsDTO uDTO) throws Exception {
		int res = 0;
		log.info("서비스 :" + uDTO.getUser_id());
		ProjectsDTO rDTO = new ProjectsDTO();
		rDTO = ProjectsMapper.checkID(uDTO);
		if(rDTO ==null) {
			log.info("회원가입 시작");
			ProjectsMapper.insertinfo(uDTO);
			res = 1;
			log.info("회원가입 완료");
		} else {
			log.info("가입된아이디");
		}
		return res;
	}

	
	
	@Override
	public int Search(ProjectsDTO oDTO) throws Exception {
		int res = 0;
		log.info("아이디 :" + oDTO.getUser_id());
		
		ProjectsDTO nDTO = new ProjectsDTO();
		
		nDTO = ProjectsMapper.Search(oDTO);
		
		if(nDTO ==null) {
			
			log.info("비밀번호찾기시작");
			res = 1;
			log.info("없는 아이디 입니다");
		} else {
			res = 2;
			log.info("일치하는 아이디가 있습니다");
		}
		return res;
	}
	
	@Override
	public int New(ProjectsDTO wDTO) throws Exception {
		
		
		log.info("비밀번호 :" + wDTO.getUser_pwd());
		
		ProjectsDTO qDTO = new ProjectsDTO();
		int res = 0;
		res = ProjectsMapper.New(wDTO);
		
		
		
		
		return res;
	}




	}


