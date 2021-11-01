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


//REST방식은 VIEW를 만들지 않는다.

//톰캣서버 우클릭 ADD 후 resPrj 추가하기.
//톰캣서버 설정에서 아래하단에 moduel 클릭하고 resPrj 프로젝트의 path를 /로 변경

//뷰를 만드는 것이 아닌, 데이터(리소스) 자체를 반환하는데 사용하는 어노테이션이다. (JSON,XML,RSS,문자열) 등이 있다.
//스프링 4.0부터 지원함.
//개인정보는 XML로 처리한다. 보안은 뛰어나지만 처리속도가 느리다.
//뉴스 정보같은 보안이 필요없는 데이터는 JSON으로 처리한다. 보안성은 떨어지지만 처리속도가 빠르다. = hashMap(키,값)이 JSON의 형태

@RestController
@RequestMapping("/demo")
public class DemoController {
	//아래는 문자열 처리 방법.
	//http://localhost:9090/demo/hi   를 입력하면 view(jsp)없이 Hi!!Spring!!(리소스)데이타가 화면에 나타난다.
	//데이터를 클라이언트 브라우저에 전송했다.
	@RequestMapping("/hi")
	public String hi() {
		return "Hi!!!Spring!!";
	}
	
	//JSON를 이용한 방법
	//HTTP Status 406 에러는 Not Acceptable 즉, 스프링에서 객체 변환을 실패한것이다. 이럴 경우 pom.xml JSON라이브러리를 추가해야함.
	//http://localhost:9090/demo/studentInfo 크롬으로 들어가면 hashMap(키,값)으로 화면에 나타난다. {"hakbun":1,"name":"김말똥","grade":2}
	//ResponsHeader의 값중에 contentType의 값들이 있는데 text/html값이 들어가 있지만, JSON형태로 들어갈 경우에는 ContentType:application/json;charset=utf-8
	@RequestMapping("/studentInfo")
	public StudentVO studentInfo() {
		StudentVO svo = new StudentVO();
		
		svo.setHakbun(1);
		svo.setName("김말똥");
		svo.setGrade(2);
		
		return svo;
	}
	
	
	
	//JSON list타입
//	http://localhost:9090/demo/studentList
//	결과 : [{"hakbun":1,"name":"강길동1","grade":2},{"hakbun":2,"name":"강길동1","grade":2},{"hakbun":3,"name":"강길동1","grade":2},{"hakbun":4,"name":"강길동1","grade":2},{"hakbun":5,"name":"강길동1","grade":2}]
	@RequestMapping("/studentList")
	public List<StudentVO> studentList() {
		//1.7부터 제네릭타입 생략이 가능하다. JRE우클릭 buildPath -> edit -> 1.8로 변경,  Properties-> project faceit -> 1.8변경
		List<StudentVO> studentList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("강길동"+1);
			svo.setGrade(2);
			
			studentList.add(svo);
		}
		return studentList;
	}
	
	
	//JSON Map타입
//	{"1":{"hakbun":1,"name":"이경자0","grade":3},"2":{"hakbun":2,"name":"이경자1","grade":3},"3":{"hakbun":3,"name":"이경자2","grade":3},"4":{"hakbun":4,"name":"이경자3","grade":3},"5":{"hakbun":5,"name":"이경자4","grade":3}}
	// List타입은 [],,, Map타입은 {}
	@RequestMapping("/studentMap")
	public Map<Integer, StudentVO> studentMap() {
		Map<Integer, StudentVO> smap = new HashMap<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("이경자"+i);
			svo.setGrade(3);
			smap.put(i+1, svo);
		}
		return smap;
	}
	
	
	//에러 코드만 보내는 경우
	@RequestMapping("/errorCode")
	public ResponseEntity<Void> errorCode() {
		//BAD_REQUEST = HTTP 400번 상태코드 에러가 발생
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	//데이터와 에러코드 함께 보내는 경우
	@RequestMapping("/errorCodeData")
	public ResponseEntity<List<StudentVO>> errorCodeData() {
		List<StudentVO> slist = new ArrayList<>();
		for(int i=0; i<5; i++) {
			StudentVO svo = new StudentVO();
			svo.setHakbun(i+1);
			svo.setName("마리아"+(i+1));
			svo.setGrade(1);
			slist.add(svo);
		}
		return new ResponseEntity<List<StudentVO>>(slist, HttpStatus.NOT_FOUND);
	}
	
	
	/*HTTP Method 
	GET : 조회
	Delete : 자료 삭제
	POST : 등록
	PUT : 등록/수정
	PATCH : PUT대신 사용
	*/
}


