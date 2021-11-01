package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableEx {
	
	//@PathVariable 활용
	//var값에 따라서 페이지를 바꾼다.
	@RequestMapping("/page/{var}") //이것은 url 입력할때 page폴더가 없어도 똑같이 입력해야한다.
	public String page(@PathVariable String var) {
		String viewName = "";
		if(var.equals("one")) {
			viewName = "page1";
		} else if (var.equals("two")) {
			viewName = "page2";
		}
		return viewName;
	}
}
