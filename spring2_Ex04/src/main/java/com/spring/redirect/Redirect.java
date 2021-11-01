package com.spring.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
	
	/*
	 * redirectŰ�� �̿��� ������ �̵�
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
	
	//Ǯ������ �̿��� ���(������ �ƴ�)
	@RequestMapping("/joinURL")
	public String joinUrl() {
		return "redirect:http://localhost:9090/redirect/joinURL.jsp";
	}
	
}
