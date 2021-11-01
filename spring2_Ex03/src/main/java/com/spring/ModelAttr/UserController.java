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

	
	//@ModelAttribute는 뷰에 모델 전달
//	@ModelAttribute("hitCar")
//	public String[] refHitCar() {
//		return new String[] {"현대","기아","대우","쌍용"};
//	}

	
//	@RequestMapping("/userForm")
//	public String userForm() {
//		System.out.println("--------------userForm-----------");
//		return "user/userForm1";
//	}
	
	
	
	
	//객체 초기화 방법
	@RequestMapping(value="/userForm", method=RequestMethod.GET)
	public String userForm() {
		System.out.println("--------------userForm-----------");
		return "user/userForm1";
	}
	
	//객체 초기화 방법
	@ModelAttribute("userVO")
	public UserVO init(HttpServletRequest request) {
		System.out.println("---------------ModelAttribute()...........");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("@ModelAttribute(): GET.........");
			
			UserVO userVO = new UserVO();
			
			//값을 미리 초기화
			userVO.setUserName("이름을 입력하세요.");
			userVO.setAddress("주소를 입력하세요.");
			userVO.setCar("자동차 입력..");
			
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
		
		model.addAttribute("msg", "회원 정보 출력 성공");
		
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
//		model.addAttribute("msg", "자동차 정보 출력");
//		
//		return model;
//	}
}
