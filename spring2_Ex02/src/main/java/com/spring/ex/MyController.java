package com.spring.ex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//@PathVariable를 이용한 url을 통해 값을 전달하는 방식이다.
	
//	@RequestMapping("/person/{personName}") // person경로에 {}는 값을 넣어준것이다. 앞코드의 @PathVariable의 personName값이 같아야한다.
//	public String getPerson(@PathVariable String personName, Model model) {
//		model.addAttribute("personInfo", personName);
//		
//		return "person/personInfo";
//		
//	}//url경로에 http://localhost:9090/ex/person/홍길동 입력하여 personName에 홍길동을 적어서 값을 보내는 방법이다.
	
	
	//한글이 깨질 시((또는 이클립스 환경에서 한글설정 - General->workspace->하단에 Text file encoding을 UTF-8))
	//톰캣서버의 server.xml -> Connector 8009와 9090 모두 URIEncoding="UTF-8"로 설정 
	@RequestMapping("/person/{personName}") 
	public String getPerson(@PathVariable String personName, Model model) throws UnsupportedEncodingException {
		//한글처리
		URLDecoder.decode(URLDecoder.decode(personName, "8859_1"), "UTF-8");
		System.out.println(personName);
		
		model.addAttribute("personInfo", personName);
		
		return "person/personInfo";
		
	}//url경로에 http://localhost:9090/ex/person/홍길동 입력하여 personName에 홍길동을 적어서 값을 보내는 방법이다.
}
