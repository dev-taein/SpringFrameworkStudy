package com.spring.sessionTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("id, name, address") //Ű�� id, name, address��  model��ü�� session���� �ٲ�
public class SpringSession {

	@RequestMapping("/session2")
	public String springSession(Model model) {
		
		//Ű�� id, ���� admin�����ϴ� �� ��ü�� ����
		model.addAttribute("id", "admin");
		
		model.addAttribute("name", "ȫ�浿");
		model.addAttribute("address", "����� ������");
		
		//Ű�� className, ���� ����Ŭ���� �̸��� �� ��ü�� ����
		model.addAttribute("className", this.getClass());
		
		return "/sessionView";
	}
}
