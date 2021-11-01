package com.spring.sessionTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("id, name, address") //키가 id, name, address인  model객체를 session으로 바꿈
public class SpringSession {

	@RequestMapping("/session2")
	public String springSession(Model model) {
		
		//키는 id, 값은 admin으로하는 모델 객체에 저장
		model.addAttribute("id", "admin");
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("address", "서울시 강남구");
		
		//키는 className, 값은 현재클래스 이름을 모델 객체에 저장
		model.addAttribute("className", this.getClass());
		
		return "/sessionView";
	}
}
