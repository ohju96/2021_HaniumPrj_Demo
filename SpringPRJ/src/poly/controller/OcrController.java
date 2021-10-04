package poly.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;
import poly.service.IOcrService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.PapagoUtil;
import poly.util.UrlUtil;

@Controller
public class OcrController {
	private Logger log = Logger.getLogger(getClass());

	/*
	 *  비즈니스 로직( 중요 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재( 싱글톤패턴 적용됨)
	 */
	@Resource(name = "OcrService")
	private IOcrService ocrService;
	
	// 업로드되는 파일이 저장되는 기본 폴더 설정(자바에서 경로는 /로 표현함)
	final private String FILE_UPLOAD_SAVE_PATH = "c:/upload"; // C:\\upload 폴더에저장
	
	/**
	 * 이미지 인식을 위한 파일업로드 화면 호출
	 */
	
	@RequestMapping(value="ocr/imageFileUpload")
	public String Index() {
		log.info(this.getClass().getName() + ".imageFileUpload! ");
		
		return "/ocr/ImageFileUpload";
	}
	
	/**
	 * 파일 업로드 및 이미지 인식
	 */
	@RequestMapping(value="ocr/getReadforImageText")
	public String getReadforImageText(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value= "fileUpload") MultipartFile mf) throws Exception {
		
		log.info("OcrController: 컨트롤러 시작");
		
		//OCR 실행결과
		String res = "";
		String t_res = "";
		
		// 업로드하는 실제 파일명
		// 다운로드 기능 구현시, 임의로 정의된 파일명을 원래대로 만들어주기 위한 목적
		String originalFileName = mf.getOriginalFilename();
		log.info("인식된 파일 이름: " + originalFileName);
		//파일 확장자 가져오기
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();
		
		// 이미지 파일 만 실행되도록함
		if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {
			
			//웹 서버에 저장되는 파일 이름
			// 업로드하는 파일 이름에 한글, 특수문자들이 저장될수 있기 때문에 강제로 영어로 숫자로 구성된 파일명으로 변경해서 저장한다.
			// 리눅스나 유닉스 등 운영체제는 다국어 지원에 취약하기 때문이다.
			String saveFileName = DateUtil.getDateTime("hhmmss") + "." + ext;
			
			// 웹 서버에 업로드한 파일 저장하는 물리적 경로.
			String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);
			
			String fullFileInfo = saveFilePath + "/"+ saveFileName;
			
			// 정상적으로 값이 생성되었는지 로그 찍어서 확인
			log.info("파일확장자 : " + ext);
			log.info("저장될 파일 이름 : " + saveFileName);
			log.info("저장될 파일 경로 : " +saveFilePath);
			log.info("전체 경로 : " + fullFileInfo);
			
			// 업로드 되는 파일을 서버에 저장
			mf.transferTo(new File(fullFileInfo));
			
			OcrDTO pDTO = new OcrDTO();
			
			pDTO.setFileName(saveFileName); //저장되는 파일명
			pDTO.setFilePath(saveFilePath); //저장되는 경로
			
			UrlUtil uu = new UrlUtil();
			
			String url = "http://127.0.0.1:5000";
			String api = "/text?";
			String iname = "ipath=";
			String ipath = fullFileInfo;
			
			log.info("url :" +url +" api : "+ api +" iname : "+ iname +" ipath : "+ ipath);
			
			res = uu.urlReadforString(url + api + iname + ipath);
			t_res = PapagoUtil.converter(res, "en");
			System.out.println("res : " + t_res );
			log.info("번역 결과 :" + t_res);
			
			
			OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
			
			if (rDTO == null) {
				rDTO = new OcrDTO();	
			}
			
			res = CmmUtil.nvl(rDTO.getTextFromImage());
			
			rDTO = null;
			pDTO = null;
			
			}else {
			res = "이미지 파일이 아니라서 인식이 불가능합니다.";
			
			}
			

			
		
		// 크롤링 결과를 넣어주기
		model.addAttribute("t_res", t_res);
		
		
		log.info("OcrController: 컨트롤러 종료! ");
		
		return "/ocr/TextFromImage";
			}
	}

