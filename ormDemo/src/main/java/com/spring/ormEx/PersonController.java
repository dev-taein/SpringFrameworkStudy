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
		//에러가 있으면 hasErrors
		if(result.hasErrors()) {
			return "/Person/personJoin";
		} else {
			System.out.println("가입되었습니다.");
			return "/Person/personJoin";
		}
	}
}
