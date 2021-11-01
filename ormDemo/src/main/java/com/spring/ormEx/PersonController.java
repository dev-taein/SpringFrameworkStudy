package com.spring.ormEx;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Person")
public class PersonController {
	@RequestMapping("/personJoin")
	public void personForm(PersonVO personVO) {
		
	}
	
	@RequestMapping("/join")
	public String join(@Valid PersonVO personVO, BindingResult result) {
		//������ ������ hasErrors
		if(result.hasErrors()) {
			return "/Person/personJoin";
		} else {
			System.out.println("���ԵǾ����ϴ�.");
			return "/Person/personJoin";
		}
	}
}
