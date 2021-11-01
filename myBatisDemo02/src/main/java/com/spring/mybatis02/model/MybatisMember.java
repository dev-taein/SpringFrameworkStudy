package com.spring.mybatis02.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

@Entity //���̹�����Ʈ(jpa validate) ��ȿ�� �˻��ϱ�
public class MybatisMember {

   @Id
   @Size(min=6, max=20, message="���̵�� 6~20�ڸ� �Դϴ�!!")
   private String id;
   
   @Size(min=6, max=20, message="��й�ȣ�� 6~20�ڸ� �Դϴ�!!")
   private String pwd;
   
   @Size(min=2, max=50, message="�̸��� �ּ�2�ڸ����� �Է��ϼ���!!")
   private String name;
   
   @Size(min=12, max=13, message="��ȭ��ȣ�� 12~13�ڸ��� �Է��ϼ���!!")
   private String tel;
   
   @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message="�ùٸ� �̸��� ������ �ƴմϴ�.!")
   private String email;

   public MybatisMember() {
}
   
   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }

   public String getPwd() {
       return pwd;
   }

   public void setPwd(String pwd) {
       this.pwd = pwd;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getTel() {
       return tel;
   }

   public void setTel(String tel) {
       this.tel = tel;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }
}