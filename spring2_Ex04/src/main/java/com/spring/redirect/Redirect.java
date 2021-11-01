package com.spring.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
	
	/*
	 * redirect키를 이용한 페이지 이동
	 * 
	 */
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginId";
	}
	
	@RequestMapping("/memberConfirm")
	public String memberRedirect(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		
		if(id.equals("test")) {
			return "redirect:memberOK";
		}
		
		return "redirect:memberFail";
	}
	
	@RequestMapping("/memberOK")
	public String memberOK() {
		return "member/memberOK";
	}
	
	@RequestMapping("/memberFail")
	public String memberFail() {
		return "member/memberFail";
	}
	
	//풀네임을 이용한 방법(좋은건 아님)
	@RequestMapping("/joinURL")
	public String joinUrl() {
		return "redirect:http://localhost:9090/redirect/joinURL.jsp";
	}
	
}
