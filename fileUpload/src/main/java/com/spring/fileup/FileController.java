package com.spring.fileup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@Autowired
	private Upload upload;
	
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.GET)
	public ModelAndView uploadForm() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("file_submit");
		return mav;
	}
	
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartHttpServletRequest mRequest) {
		
		ModelAndView mav = new ModelAndView();
//		upload = new Upload(); //멤버변수 선언 시 Autowired를 사용하면 이 문장을 쓸 필요가 없다
		if(upload.fileUpload(mRequest)) {
			mav.addObject("result","파일 업로드 성공!");
		} else {
			mav.addObject("result","파일 업로드 실패!");
		}
		mav.setViewName("uploadResult");
		return mav;
	}
	
	
}
