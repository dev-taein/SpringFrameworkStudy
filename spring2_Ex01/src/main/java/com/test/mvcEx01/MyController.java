package com.test.mvcEx01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/memberInput") //경로
	public String memberInput() {
		
		return "memberRegister"; //view의 이름을 넘겨줌(jsp파일 이름과 똑같아야함)
	}
	
	@RequestMapping("/post/memberInfo") //경로
	public String memInfo(Model model) {
		model.addAttribute("name", "김말똥");
		return "post/memInfo";
	}
	
	//파라미터를 이용함
	@RequestMapping("/model/ex")
	public String testModel(Model model) {
		model.addAttribute("address", "서울시 강남구 역삼동");
		return "/model/modelDemo";
	}
	
	//ModelAndView 이용함
	@RequestMapping("/modelAndView/mv")
	public ModelAndView modelAndView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", "aa@naver.com");
		mv.setViewName("/modelAndView/modelView"); //view(jsp파일)이름
		return mv;
	}
	
}
