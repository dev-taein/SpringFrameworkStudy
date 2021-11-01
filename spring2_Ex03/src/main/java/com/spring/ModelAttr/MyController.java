package com.spring.ModelAttr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//패키지명을 새로 만들어서 컨트롤러를 작동시키면 톰캣에서 새로운 패키지명을 지정해줘야 한다.
	// server.xml에서 <Context docBase="spring2_Ex03" path="/ModelAttr" reloadable="true" source="org.eclipse.jst.jee.server:spring2_Ex03"/> 추가
	// spring폴더->appServlet-> servlet-context.xml에서 <context:component-scan base-package="com.spring.ModelAttr" /> 추가
	
	//@ModelAttribute 사용 및 새로운 패키지에 새로운 컨트롤러 추가하기
	@RequestMapping("/form")
	public String userForm() {
		return "user/userForm";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(@ModelAttribute("userInfo") UserInformation userInformation) {
		
		return "user/userInfo";
	}
}	
