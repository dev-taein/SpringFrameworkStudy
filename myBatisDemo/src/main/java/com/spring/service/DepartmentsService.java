package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hr.model.Department;
import com.spring.hr.model.DepartmentsMapper;


@Service
public class DepartmentsService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Department> getDeptInfo(){
		List<Department> res = new ArrayList<Department>();
		
		DepartmentsMapper deptMapper = sqlSession.getMapper(DepartmentsMapper.class);
		res = deptMapper.getDepartmentsInfo();
		
		System.out.println("deptid : " + res.get(0).getDeptId());
		System.out.println("deptName : " + res.get(0).getDeptName());
		return res;
	}
}

