package com.spring.annotationEx;

import org.springframework.stereotype.Component;

@Component("service01") //������Ʈ id����
public class AbstractSvcImpl implements AbstractSvc {
	
	private String name = "01";
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return "AbstractSvcImpl - "  + name;
	}
}
