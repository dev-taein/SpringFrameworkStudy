package com.spring.ormEx;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

@Entity //������(���ּҾƴ�) //���������� DB�����=��ü�����=�����ܿ��� validate(��üũ),, �ڹٽ�ũ��Ʈ�� ����Ʈ�ܿ��� ��üũ(���̳����)
public class PersonVO {
	 //java.util.regex�� �̿��� ����ȭ API�� �̿���
	@Column
//	@Size(min=2, max=10, message="�̸��� 2~10�ڸ��̾�� �մϴ�.")
	@Pattern(regexp = "\\S{2,10}", message="�̸��� 2~10�ڷ� �Է��ϼ���!!") // \S=ȭ��Ʈ�����̽��� ���� ���ڸ�
	private String name;
	
	@Column
//	@Size(min=1, max=3, message="���̴� 1~3�ڸ� �����̾���մϴ�.")
	@Pattern(regexp = "\\d{1,3}", message = "���̴�1~3�ڸ� ���ڷ� �Է��ϼ���!!") // \\d�� ���ڸ� \\D=���ڰ� �ƴ� ���ڸ�
	private String age;  //int���� �� �� ����
	
	@Id //���̺��� primary key ���εȴ�.
	@Size(min=13, max=13, message="�ֹι�ȣ�� 13�ڷ� �Է��ϼ���!!!")
	private String id;
	
	@Column
	@Size(min=3, max=50, message="�ּҴ� 3~50�ڸ��� �Է��ϼ���!!!")
	private String address;
	
//	@GeneratedValue(strategy = GenerationType.AUTO) ����Ŭ�� sequence, Mysql AutoIncrment ��� = �ڵ�����
	
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
