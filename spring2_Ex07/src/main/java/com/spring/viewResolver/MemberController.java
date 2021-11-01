package com.spring.viewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@RequestMapping("/addMember")
	public String addMember(@ModelAttribute User user, BindingResult result) {
		
		System.out.println("이름 : " + user.getName() + "아이디 : " + user.getId());
		
		return "redirect:memInput";
	}
	
	
	@RequestMapping("/memInput")
	public ModelAndView showMemInfo() {
		
		return new ModelAndView("memberInput", "command", new User());
	}
}
