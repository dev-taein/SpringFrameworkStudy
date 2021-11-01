package com.spring.sessionTest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServletSession {
	@RequestMapping("/session")
	public String session(Model model, HttpSession session) {
		//session객체에 admin이라는 값을 id라는 키로 저장
		session.setAttribute("id", "admin"); //키와 값
		
		
		//모델 객체에 현재 클래스이름을 className이라는 키로 저장
		model.addAttribute("className", this.getClass());
		
		return "sessionView";
	}
}
