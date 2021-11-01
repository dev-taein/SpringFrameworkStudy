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
//		upload = new Upload(); //������� ���� �� Autowired�� ����ϸ� �� ������ �� �ʿ䰡 ����
		if(upload.fileUpload(mRequest)) {
			mav.addObject("result","���� ���ε� ����!");
		} else {
			mav.addObject("result","���� ���ε� ����!");
		}
		mav.setViewName("uploadResult");
		return mav;
	}
	
	
}
