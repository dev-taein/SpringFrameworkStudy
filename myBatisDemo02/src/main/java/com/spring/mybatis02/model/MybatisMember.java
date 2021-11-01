package com.spring.mybatis02.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

@Entity //하이버네이트(jpa validate) 유효성 검사하기
public class MybatisMember {

   @Id
   @Size(min=6, max=20, message="아이디는 6~20자리 입니다!!")
   private String id;
   
   @Size(min=6, max=20, message="비밀번호는 6~20자리 입니다!!")
   private String pwd;
   
   @Size(min=2, max=50, message="이름은 최소2자리부터 입력하세요!!")
   private String name;
   
   @Size(min=12, max=13, message="전화번호는 12~13자리로 입력하세요!!")
   private String tel;
   
   @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message="올바른 이메일 형식이 아닙니다.!")
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