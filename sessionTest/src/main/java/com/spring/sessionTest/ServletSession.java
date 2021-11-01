package com.spring.sessionTest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServletSession {
	@RequestMapping("/session")
	public String session(Model model, HttpSession session) {
		//session��ü�� admin�̶�� ���� id��� Ű�� ����
		session.setAttribute("id", "admin"); //Ű�� ��
		
		
		//�� ��ü�� ���� Ŭ�����̸��� className�̶�� Ű�� ����
		model.addAttribute("className", this.getClass());
		
		return "sessionView";
	}
}
