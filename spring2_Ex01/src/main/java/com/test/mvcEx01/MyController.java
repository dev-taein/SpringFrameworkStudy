package com.test.mvcEx01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/memberInput") //���
	public String memberInput() {
		
		return "memberRegister"; //view�� �̸��� �Ѱ���(jsp���� �̸��� �Ȱ��ƾ���)
	}
	
	@RequestMapping("/post/memberInfo") //���
	public String memInfo(Model model) {
		model.addAttribute("name", "�踻��");
		return "post/memInfo";
	}
	
	//�Ķ���͸� �̿���
	@RequestMapping("/model/ex")
	public String testModel(Model model) {
		model.addAttribute("address", "����� ������ ���ﵿ");
		return "/model/modelDemo";
	}
	
	//ModelAndView �̿���
	@RequestMapping("/modelAndView/mv")
	public ModelAndView modelAndView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", "aa@naver.com");
		mv.setViewName("/modelAndView/modelView"); //view(jsp����)�̸�
		return mv;
	}
	
}
