package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableEx2 {
	
	/*Get방식 컨트롤러
 	@param key1
	@param key2
	*/
	
//	@RequestMapping("/resByGet")
//	public void resByGet(String key1, String key2) {
//		System.out.println("key1 : " + key1);
//		System.out.println("key2 : " + key2);
//	} //위 코드의 주소형식 http://localhost:9090/ex/resByGet?key1=aaa&key2=aaa
	
	//더 편한 방법 주소창에 파라메터 값을 바로 넣을 수 있음
	@RequestMapping("/resByPath/{key1}/{key2}/{key3}")
	public void resByGet(@PathVariable String key1, @PathVariable String key2, @PathVariable String key3) {
		System.out.println("key1 : " + key1);
		System.out.println("key2 : " + key2);
		System.out.println("key2 : " + key3);
	} // 예시 http://localhost:9090/ex/resByPath/aaa/bbb/ccc
}
