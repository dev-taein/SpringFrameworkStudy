package com.spring.customTagEx;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {
	private String viewName = "joinForm";
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		refData(model);
		return viewName;
	}
	
	private void refData(Model model) {
		List<Code> jCodes = new ArrayList<Code>();
		jCodes.add(new Code("001", "���α׷���"));
		jCodes.add(new Code("002", "�������"));
		jCodes.add(new Code("003", "�����̳�"));
		jCodes.add(new Code("004", "��ȹ"));
		
		String[] hobbyName = {"����", "����", "������", "���", "��ȭ", "��ȭ����"};
		String[] mw = {"����", "����"};
		
		model.addAttribute("jCodes", jCodes);
		model.addAttribute("hobbyName", hobbyName);
		model.addAttribute("mw", mw);
	}
	
	@ModelAttribute
	protected Object formBack() throws Exception{
		return new Member();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute Member member, BindingResult result, Model model) {
		new MemberValidator().validate(member, result);
		if(result.hasErrors()) {
			refData(model);
			return viewName;
		}
		return "memberOk";
	}
	
}
