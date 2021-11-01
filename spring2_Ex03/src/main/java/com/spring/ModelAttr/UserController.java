package com.spring.ModelAttr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	//@ModelAttribute�� �信 �� ����
//	@ModelAttribute("hitCar")
//	public String[] refHitCar() {
//		return new String[] {"����","���","���","�ֿ�"};
//	}

	
//	@RequestMapping("/userForm")
//	public String userForm() {
//		System.out.println("--------------userForm-----------");
//		return "user/userForm1";
//	}
	
	
	
	
	//��ü �ʱ�ȭ ���
	@RequestMapping(value="/userForm", method=RequestMethod.GET)
	public String userForm() {
		System.out.println("--------------userForm-----------");
		return "user/userForm1";
	}
	
	//��ü �ʱ�ȭ ���
	@ModelAttribute("userVO")
	public UserVO init(HttpServletRequest request) {
		System.out.println("---------------ModelAttribute()...........");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("@ModelAttribute(): GET.........");
			
			UserVO userVO = new UserVO();
			
			//���� �̸� �ʱ�ȭ
			userVO.setUserName("�̸��� �Է��ϼ���.");
			userVO.setAddress("�ּҸ� �Է��ϼ���.");
			userVO.setCar("�ڵ��� �Է�..");
			
			return userVO;
			
		} else {
			System.out.println("@ModelAttribute : POST....");
			return new UserVO();
		}
	}
	
	
	
	@RequestMapping(value="/userSave", method=RequestMethod.POST)
	public ModelAndView userSave(@ModelAttribute("userVO") UserVO userVO, Model model) {
		System.out.println("-------------userSave--------------");
		System.out.println("user :"+userVO.toString());
		
		model.addAttribute("msg", "ȸ�� ���� ��� ����");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("user/userInfo1");
		modelAndView.addObject("userVO", userVO);
		
		return modelAndView;
	} //userSave()
	
//	@RequestMapping("/userView")
//	public Model userView() {
//		System.out.println("-------------userView--------------");
//		
//		Model model = new ExtendedModelMap();
//		model.addAttribute("msg", "�ڵ��� ���� ���");
//		
//		return model;
//	}
}
