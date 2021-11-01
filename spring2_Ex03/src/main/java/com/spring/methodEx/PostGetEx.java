package com.spring.methodEx;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostGetEx {
	//톰캣서버 오류시 server-xml에서 
	//<Context path="/methodEx" 에서 path="/패키지명" 을 제대로 입력했는지 확인하자 ex)com.spring.cex이면 path="cex"이다
	//스프링에서 Get방식과 POST방식 적용
	@RequestMapping("/input") //get방식이 기본값이므로 따로 설정하지 않으면 get방식이다. 설정은 method = RequestMethod.GET 또는 POST
	public String goPage() {
		return "inputForm";
	} // 주소는 http://localhost:9090/methodEx/input  이다.
	
	
	//Get방식의 값을 받는법
	//jsp파일의 form태그의  action과 method를 @RequestMapping에 똑같이 선언 (value는 action명, method는 method방식 GET인지 POST인지)
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public String goPerson(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		return "person/personInfo";
	}//goPerson()
	
	
	//POST방식의 값을 받는법 (다형성-오버로딩 사용=Model를 사용하지 않고 ModelAndView를 사용) 
	//jsp파일의 form태그의  action과 method를 @RequestMapping에 똑같이 선언 (value는 action명, method는 method방식 GET인지 POST인지)
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView goPerson(HttpServletRequest request) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("person/personInfo"); //view 보여줄 화면 jsp파일 주소
		modelAndView.addObject("name", name);
		modelAndView.addObject("id", id);
		
//		model.addAttribute("name", name);
//		model.addAttribute("id", id);
		
		return modelAndView;
	}//goPerson()
}
