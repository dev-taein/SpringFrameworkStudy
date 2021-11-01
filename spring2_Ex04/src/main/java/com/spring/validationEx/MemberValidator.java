package com.spring.validationEx;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) { //해당 객체에 대한 유효성 검사가 가능한지 확인
		return Member.class.isAssignableFrom(arg0);
	}
	
	
	@Override
	public void validate(Object obj, Errors errors) { //obj는 커맨드 객체가 오고, errors는 BindingResult가 온다
		System.out.println("-----------validate()호출---------------------");
		Member member = (Member) obj;
		String memName = member.getName();
	
		
		
//		if(memName == null || memName.trim().isEmpty()) {
//			System.out.println("회원 이름을 입력하세요..");
//			errors.rejectValue("name", "입력시 오류 발생");
//		}
		
//		String memId = member.getId();
//		if(memId == null || memId.trim().isEmpty()) {
//			System.out.println("회원 아이디를 입력하세요..");
//			errors.rejectValue("id", "입력시 오류 발생");
//		}
		
		//ValidationUtils 클래스를 이용한 방ㅂ
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "입력 오휴");
		
		int memNo = member.getMemNo();
		if(memNo == 0) {
			System.out.println("주민번호를 입력하세요..");
			errors.rejectValue("memNo", "입력시 오류 발생");
		}
	}
	
	
}
