package com.spring.ormEx;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

@Entity //도메인(웹주소아님) //스프링에서 DB만들기=객체만들기=서버단에서 validate(폼체크),, 자바스크립트는 프론트단에서 폼체크(값이노출됨)
public class PersonVO {
	 //java.util.regex를 이용한 정규화 API를 이용함
	@Column
//	@Size(min=2, max=10, message="이름은 2~10자리이어야 합니다.")
	@Pattern(regexp = "\\S{2,10}", message="이름은 2~10자로 입력하세요!!") // \S=화이트스페이스가 없는 문자만
	private String name;
	
	@Column
//	@Size(min=1, max=3, message="나이는 1~3자리 숫자이어야합니다.")
	@Pattern(regexp = "\\d{1,3}", message = "나이는1~3자리 숫자로 입력하세요!!") // \\d는 숫자만 \\D=숫자가 아닌 문자만
	private String age;  //int형을 쓸 수 없음
	
	@Id //테이블의 primary key 매핑된다.
	@Size(min=13, max=13, message="주민번호는 13자로 입력하세요!!!")
	private String id;
	
	@Column
	@Size(min=3, max=50, message="주소는 3~50자리로 입력하세요!!!")
	private String address;
	
//	@GeneratedValue(strategy = GenerationType.AUTO) 오라클의 sequence, Mysql AutoIncrment 기능 = 자동증가
	
	//setter, getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
