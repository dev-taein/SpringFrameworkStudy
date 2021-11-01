package com.test.mvcEx01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aaa")
public class SimpleController {

	@RequestMapping("/bbb")
	public String bbb() {
		
		
		return "/aaa/bbb"; 
	}
}
