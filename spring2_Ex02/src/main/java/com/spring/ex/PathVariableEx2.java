package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableEx2 {
	
	/*Get��� ��Ʈ�ѷ�
 	@param key1
	@param key2
	*/
	
//	@RequestMapping("/resByGet")
//	public void resByGet(String key1, String key2) {
//		System.out.println("key1 : " + key1);
//		System.out.println("key2 : " + key2);
//	} //�� �ڵ��� �ּ����� http://localhost:9090/ex/resByGet?key1=aaa&key2=aaa
	
	//�� ���� ��� �ּ�â�� �Ķ���� ���� �ٷ� ���� �� ����
	@RequestMapping("/resByPath/{key1}/{key2}/{key3}")
	public void resByGet(@PathVariable String key1, @PathVariable String key2, @PathVariable String key3) {
		System.out.println("key1 : " + key1);
		System.out.println("key2 : " + key2);
		System.out.println("key2 : " + key3);
	} // ���� http://localhost:9090/ex/resByPath/aaa/bbb/ccc
}
