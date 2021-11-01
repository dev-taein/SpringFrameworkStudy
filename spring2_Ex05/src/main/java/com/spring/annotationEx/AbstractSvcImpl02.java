package com.spring.annotationEx;

import org.springframework.stereotype.Component;

@Component("service02")
public class AbstractSvcImpl02 implements AbstractSvc {
	
	private String name = "02";
	@Override
	public String getClassName() {
		return "AbstractSvcImpl - "  + name;
	}
}
