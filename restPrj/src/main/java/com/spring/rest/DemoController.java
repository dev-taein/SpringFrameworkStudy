package com.spring.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vo.StudentVO;


//REST����� VIEW�� ������ �ʴ´�.

//��Ĺ���� ��Ŭ�� ADD �� resPrj �߰��ϱ�.
//��Ĺ���� �������� �Ʒ��ϴܿ� moduel Ŭ���ϰ� resPrj ������Ʈ�� path�� /�� ����

//�並 ����� ���� �ƴ�, ������(���ҽ�) ��ü�� ��ȯ�ϴµ� ����ϴ� ������̼��̴�. (JSON,XML,RSS,���ڿ�) ���� �ִ�.
//������ 4.0���� ������.
//���������� XML�� ó���Ѵ�. ������ �پ���� ó���ӵ��� ������.
//���� �������� ������ �ʿ���� �����ʹ� JSON���� ó���Ѵ�. ���ȼ��� ���������� ó���ӵ��� ������. = hashMap(Ű,��)�� JSON�� ����

@RestController
@RequestMapping("/demo")
public class DemoController {
	//�Ʒ��� ���ڿ� ó�� ���.
	//http://localhost:9090/demo/hi   �� �Է��ϸ� view(jsp)���� Hi!!Spring!!(���ҽ�)����Ÿ�� ȭ�鿡 ��Ÿ����.
	//�����͸� Ŭ���̾�Ʈ �������� �����ߴ�.
	@RequestMapping("/hi")
	public String hi() {
		return "Hi!!!Spring!!";
	}
	
	//JSON�� �̿��� ���
	//HTTP Status 406 ������ Not Acceptable ��, ���������� ��ü ��ȯ�� �����Ѱ��̴�. �̷� ��� pom.xml JSON���̺귯���� �߰��ؾ���.
	//http://localhost:9090/demo/studentInfo ũ������ ���� hashMap(Ű,��)���� ȭ�鿡 ��Ÿ����. {"hakbun":1,"name":"�踻��","grade":2}
	//ResponsHeader�� ���߿� contentType�� ������ �ִµ� text/html���� �� ������, JSON���·� �� ��쿡�� ContentType:application/json;charset=utf-8
	@RequestMapping("/studentInfo")
	public StudentVO studentInfo() {
		StudentVO svo = new StudentVO();
		
		svo.setHakbun(1);
		svo.setName("�踻��");
		svo.setGrade(2);
		
		return svo;
	}
	
	
	
	//JSON listŸ��
//	http://localhost:9090/demo/studentList
//	��� : [{"hakbun":1,"name":"���浿1","grade":2},{"hakbun":2,"name":"���浿1","grade":2},{"hakbun":3,"name":"���浿1","grade":2},{"hakbun":4,"name":"���浿1","grade":2},{"hakbun":5,"name":"���浿1","grade":2}]
	@RequestMapping("/studentList")
	public List<StudentVO> studentList() {
		//1.7���� ���׸�Ÿ�� ������ �����ϴ�. JRE��Ŭ�� buildPath -> edit -> 1.8�� ����,  Properties-> project faceit -> 1.8����
		List<StudentVO> studentList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("���浿"+1);
			svo.setGrade(2);
			
			studentList.add(svo);
		}
		return studentList;
	}
	
	
	//JSON MapŸ��
//	{"1":{"hakbun":1,"name":"�̰���0","grade":3},"2":{"hakbun":2,"name":"�̰���1","grade":3},"3":{"hakbun":3,"name":"�̰���2","grade":3},"4":{"hakbun":4,"name":"�̰���3","grade":3},"5":{"hakbun":5,"name":"�̰���4","grade":3}}
	// ListŸ���� [],,, MapŸ���� {}
	@RequestMapping("/studentMap")
	public Map<Integer, StudentVO> studentMap() {
		Map<Integer, StudentVO> smap = new HashMap<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("�̰���"+i);
			svo.setGrade(3);
			smap.put(i+1, svo);
		}
		return smap;
	}
	
	
	//���� �ڵ常 ������ ���
	@RequestMapping("/errorCode")
	public ResponseEntity<Void> errorCode() {
		//BAD_REQUEST = HTTP 400�� �����ڵ� ������ �߻�
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//�����Ϳ� �����ڵ� �Բ� ������ ���
	@RequestMapping("/errorCodeData")
	public ResponseEntity<List<StudentVO>> errorCodeData() {
		List<StudentVO> slist = new ArrayList<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("������"+(i+1));
			svo.setGrade(1);
			slist.add(svo);
		}
		return new ResponseEntity<List<StudentVO>>(slist, HttpStatus.NOT_FOUND);
	}
	
	
	/*HTTP Method 
	GET : ��ȸ
	Delete : �ڷ� ����
	POST : ���
	PUT : ���/����
	PATCH : PUT��� ���
	*/
}


