package poly.controller;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.util.PapagoUtil;
import poly.util.UrlUtil;
// .. 

@Controller
public class TestController {
	
	private Logger log = Logger.getLogger(getClass());


	@RequestMapping(value = "test")
	public String Test() {
		log.info(this.getClass());

		return "/Test";
	}
	
	@ResponseBody
	@RequestMapping(value = "testReturn")
	public String TestReturn(HttpServletRequest request) {
		String result = request.getParameter("search");

		return result;
	}
	
	@RequestMapping(value = "result", produces = "application/json; charset=utf8")
	public @ResponseBody String result(HttpServletRequest request, ModelMap model) throws Exception{
		String search = request.getParameter("search");
		log.info(search);
		
		UrlUtil uu = new UrlUtil();
		
		String url = "http://127.0.0.1:8000";
	    String api = "/search";
	    String Name = "?Text=";
	    String Text = search;
		
		
	    String res = uu.urlReadforString(url+api+Name+URLEncoder.encode(Text, "UTF-8"));
	    PapagoUtil.converter("res");
	    System.out.println("res : " + res );

		uu = null; //메모리 줄이기 위해 사용
		
		return res;
		
		
		
	}
}
