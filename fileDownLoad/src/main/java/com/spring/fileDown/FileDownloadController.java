package com.spring.fileDown;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {
	
	@RequestMapping("/filedown")
	public ModelAndView fileDownload() {
		System.out.println("-------���ϴٿ�ε� ����---------");
		
		ModelAndView mv = new ModelAndView("filedownload");
		
		return mv;
	}
}
