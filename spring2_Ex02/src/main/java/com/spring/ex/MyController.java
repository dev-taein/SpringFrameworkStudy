package com.spring.ex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//@PathVariable�� �̿��� url�� ���� ���� �����ϴ� ����̴�.
	
//	@RequestMapping("/person/{personName}") // person��ο� {}�� ���� �־��ذ��̴�. ���ڵ��� @PathVariable�� personName���� ���ƾ��Ѵ�.
//	public String getPerson(@PathVariable String personName, Model model) {
//		model.addAttribute("personInfo", personName);
//		
//		return "person/personInfo";
//		
//	}//url��ο� http://localhost:9090/ex/person/ȫ�浿 �Է��Ͽ� personName�� ȫ�浿�� ��� ���� ������ ����̴�.
	
	
	//�ѱ��� ���� ��((�Ǵ� ��Ŭ���� ȯ�濡�� �ѱۼ��� - General->workspace->�ϴܿ� Text file encoding�� UTF-8))
	//��Ĺ������ server.xml -> Connector 8009�� 9090 ��� URIEncoding="UTF-8"�� ���� 
	@RequestMapping("/person/{personName}") 
	public String getPerson(@PathVariable String personName, Model model) throws UnsupportedEncodingException {
		//�ѱ�ó��
		URLDecoder.decode(URLDecoder.decode(personName, "8859_1"), "UTF-8");
		System.out.println(personName);
		
		model.addAttribute("personInfo", personName);
		
		return "person/personInfo";
		
	}//url��ο� http://localhost:9090/ex/person/ȫ�浿 �Է��Ͽ� personName�� ȫ�浿�� ��� ���� ������ ����̴�.
}
