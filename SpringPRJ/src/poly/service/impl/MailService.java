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

import poly.dto.MailDTO;
import poly.persistance.mapper.IMailMapper;
import poly.service.IMailService;
import poly.util.CmmUtil;



@Service("MailService")
public class MailService implements IMailService{
	private Logger log = Logger.getLogger(this.getClass());
	
	
	// 해야할 일 : 경로설정 및 로그인 완료창 표시
	@Resource(name="MailMapper")
	private IMailMapper MailMapper;

	
	final String host = "smtp.naver.com";
	final String user = "style0986@naver.com";
	final String password = "Tlseogus!2";
	
	@Override
	public int doSendmail(MailDTO pDTO) {
		
		log.info(this.getClass().getName() + ".doSendMail start!");
		
		int res = 1;
		log.info("메일발송 서비스 시작");
		
		if(pDTO == null) {
			pDTO = new MailDTO();
		}
		
		String toMail = CmmUtil.nvl(pDTO.getToMail());
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		


		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
			});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			
			message.setSubject(CmmUtil.nvl(pDTO.getTitle()));
			
			message.setText(CmmUtil.nvl(pDTO.getContents()));
			
			Transport.send(message);
			
		}catch(MessagingException e) {
			res = 0;
			log.info("[ERROR]" + this.getClass().getName() + ".doSendMail : " + e);
		}catch(Exception e) {
			res = 0;
			log.info("[ERROR]" + this.getClass().getName() + ".doSendMail : " + e);
		}
		
		log.info("메일발송 서비스 종료");
		return res;
	}

	}


