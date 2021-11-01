package com.spring.methodEx;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostGetEx {
	//��Ĺ���� ������ server-xml���� 
	//<Context path="/methodEx" ���� path="/��Ű����" �� ����� �Է��ߴ��� Ȯ������ ex)com.spring.cex�̸� path="cex"�̴�
	//���������� Get��İ� POST��� ����
	@RequestMapping("/input") //get����� �⺻���̹Ƿ� ���� �������� ������ get����̴�. ������ method = RequestMethod.GET �Ǵ� POST
	public String goPage() {
		return "inputForm";
	} // �ּҴ� http://localhost:9090/methodEx/input  �̴�.
	
	
	//Get����� ���� �޴¹�
	//jsp������ form�±���  action�� method�� @RequestMapping�� �Ȱ��� ���� (value�� action��, method�� method��� GET���� POST����)
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public String goPerson(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		return "person/personInfo";
	}//goPerson()
	
	
	//POST����� ���� �޴¹� (������-�����ε� ���=Model�� ������� �ʰ� ModelAndView�� ���) 
	//jsp������ form�±���  action�� method�� @RequestMapping�� �Ȱ��� ���� (value�� action��, method�� method��� GET���� POST����)
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView goPerson(HttpServletRequest request) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		System.out.println("name : " + name);
		System.out.println("id : " + id);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("person/personInfo"); //view ������ ȭ�� jsp���� �ּ�
		modelAndView.addObject("name", name);
		modelAndView.addObject("id", id);
		
//		model.addAttribute("name", name);
//		model.addAttribute("id", id);
		
		return modelAndView;
	}//goPerson()
}
