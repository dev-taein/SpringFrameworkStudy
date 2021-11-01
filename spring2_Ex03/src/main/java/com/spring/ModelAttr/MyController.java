package com.spring.ModelAttr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//��Ű������ ���� ���� ��Ʈ�ѷ��� �۵���Ű�� ��Ĺ���� ���ο� ��Ű������ ��������� �Ѵ�.
	// server.xml���� <Context docBase="spring2_Ex03" path="/ModelAttr" reloadable="true" source="org.eclipse.jst.jee.server:spring2_Ex03"/> �߰�
	// spring����->appServlet-> servlet-context.xml���� <context:component-scan base-package="com.spring.ModelAttr" /> �߰�
	
	//@ModelAttribute ��� �� ���ο� ��Ű���� ���ο� ��Ʈ�ѷ� �߰��ϱ�
	@RequestMapping("/form")
	public String userForm() {
		return "user/userForm";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(@ModelAttribute("userInfo") UserInformation userInformation) {
		
		return "user/userInfo";
	}
}	
