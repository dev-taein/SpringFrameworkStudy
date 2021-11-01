package com.spring.validationEx;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) { //�ش� ��ü�� ���� ��ȿ�� �˻簡 �������� Ȯ��
		return Member.class.isAssignableFrom(arg0);
	}
	
	
	@Override
	public void validate(Object obj, Errors errors) { //obj�� Ŀ�ǵ� ��ü�� ����, errors�� BindingResult�� �´�
		System.out.println("-----------validate()ȣ��---------------------");
		Member member = (Member) obj;
		String memName = member.getName();
	
		
		
//		if(memName == null || memName.trim().isEmpty()) {
//			System.out.println("ȸ�� �̸��� �Է��ϼ���..");
//			errors.rejectValue("name", "�Է½� ���� �߻�");
//		}
		
//		String memId = member.getId();
//		if(memId == null || memId.trim().isEmpty()) {
//			System.out.println("ȸ�� ���̵� �Է��ϼ���..");
//			errors.rejectValue("id", "�Է½� ���� �߻�");
//		}
		
		//ValidationUtils Ŭ������ �̿��� �椲
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "�Է� ����");
		
		int memNo = member.getMemNo();
		if(memNo == 0) {
			System.out.println("�ֹι�ȣ�� �Է��ϼ���..");
			errors.rejectValue("memNo", "�Է½� ���� �߻�");
		}
	}
	
	
}
