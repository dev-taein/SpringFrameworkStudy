package com.spring.validationEx;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/memberForm")
	public String memberForm() {
		return "member/memInput";
	}
	
	@RequestMapping("/inputOK")
	public String inputOK(@ModelAttribute("member")  Member member, BindingResult result) {
//	public String inputOK(@ModelAttribute("member") @Valid Member member, BindingResult result) {	
		String viewName = "memberOK";

		//Validator 생성
		MemberValidator mValidator = new MemberValidator();
		mValidator.validate(member, result);
		
		//만약에 에러가 있으면
		if(result.hasErrors()) {
			
			//redirect를 이용
			//return "redirect:memberForm";
			viewName = "member/memInput";
			return viewName;
		}
		return viewName;
	}
	
	//오류나서 못해먹겟노
	//@Valid와 @InitBinder 이용
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new MemberValidator());
//	}
}
