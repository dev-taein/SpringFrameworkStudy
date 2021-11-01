package com.spring.customTagEx;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Member.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", "�ʼ� �Է»��� �Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "�ʼ� �Է»��� �Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address1", "required", "�ʼ� �Է»��� �Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.address2", "required", "�ʼ� �Է»��� �Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "�ʼ� �Է»��� �Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "required");
		
		Member member = (Member) target;
		if(member.getHobbys() == null || member.getHobbys().length == 0) {
			errors.rejectValue("hobbys", "select");
		}
	}
	
	
	
	
}
