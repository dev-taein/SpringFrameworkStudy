package com.spring.annotationEx;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//@Component
@Controller
public class AbstractController extends org.springframework.web.servlet.mvc.AbstractController {

	//의존설정
	@Resource(name="service01")
	private AbstractSvc service;
	
	@Override
	@RequestMapping("/comp")
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("componentView");
		mv.addObject("msg", "Component Annotation Test");
		
		System.out.println("----------------------");
		System.out.println(service.getClassName());
		System.out.println("----------------------");
		
		return mv;
	}
}
