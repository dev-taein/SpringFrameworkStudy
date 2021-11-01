package com.spring.myBatis;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hr.model.Department;
import com.spring.service.DepartmentsService;

@Controller
public class DepartmentsController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
//	@RequestMapping("/departmentsList")
//	public String getDeptList(HttpServletRequest req) {
//		List<Department> deptList = departmentsService.getDeptInfo();
//		
//		req.setAttribute("deptList", deptList);
//		
//		return "deptList";
//	}
	
	@RequestMapping("/deptList")
	public ModelAndView getDeptList(){
		ModelAndView mv = new ModelAndView();
		List<Department> deptList = departmentsService.getDeptInfo();
		
		mv.addObject("deptList", deptList);
		mv.setViewName("/deptList");
		
		return mv;
	}
	
}
