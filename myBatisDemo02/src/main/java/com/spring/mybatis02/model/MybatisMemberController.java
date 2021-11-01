package com.spring.mybatis02.model;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mybatisMember")
public class MybatisMemberController {

	
	@Autowired
	MybatisMemberMapper mybatisMemberService;
	
	
	//회원 가입 insert [모델 객체]
	@RequestMapping("/inputForm")
	public void insertMember(Model model) {
		//addAttribute(form객체의 commandName과 inserOK()의 @Valid의 MybatisMember의 매개변수 이름(mybatisMember)을 사용해야한다., DTO)
		//이렇게하면 form태그의 path="name" 등의 db정보를 불러옴
		model.addAttribute("mybatisMember", new MybatisMember()); 
	} //반환값이 void, String 각각의 차이점이 있다.(에러 표시가 다름[에러는 같아도])

	
	//회원 가입 insert
	@RequestMapping("/insertOk")
	//@Valid는 유효성검사, MybatisMember(DTO)를 유효성검사한다.
	//@Valid의 MybatisMember의 매개변수이름은 위의 inputForm의 model.addAttribute("mybatisMember")이름과 같아야함
	public String insertOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("회원가입시 오류가 발생하였습니다.!!!");
			return "inputForm"; //forward 방식을 이용해야 inputForm의 에러메시지를 화면에 보여준다.
			//forward, redirect의 차이
			//forward는 웹컨테이너 안에서 페이지만 이동(서버 안에서 페이지 이동) request요청을 그대로 받아올 수 있다.
			//redirect는 웹브라우저에게 다른페이지로 이동하라는 명령을 보냄
		} else {
			//에러가 없으면 DB에 저장
			mybatisMemberService.insertMember(mybatisMember);
			return "redirect:list";
		}
	}//insertOk()

	
	
	//회원 수정 update
	@RequestMapping("/modifyMmeber/{id}") //   /{}는 get방식 대신에 스프링에서 지원하는 @PathVariable 기능[웹브라우저 url창에 직접 id값을 전송함.]
	public String modifyMember(@PathVariable String id, Model model) {
		//id값을 MybatisMemberMapper객체에서 getMember(id)를 통해 얻어옴
		model.addAttribute("mybatisMember", mybatisMemberService.getMember(id));
		
		return "/modifyForm";
	}
	//회원 수정 update
	@RequestMapping("/modifyOk")
	public String modifyOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("회원정보 수정 시 오류가 발생하였습니다.");
			return "modifyForm";
		} else {
			//오류가 없을시 서비스객체에서 updateMember()를 실행시킨다.
			mybatisMemberService.updateMember(mybatisMember);
			return "redirect:list";
		}
	}
	//회원 삭제 delete
	@RequestMapping("delMember")
	public void delMember(Model model) {
		model.addAttribute("mybatisMember", new MybatisMember());
	}
	
	//회원 삭제 delete
	@RequestMapping("/delMember/{id}")
	public String delMember(@PathVariable String id ,Model model) {
//		model.addAttribute("mybatisMember", new MybatisMember());
		
		//id 존재 여부 check
		if(mybatisMemberService.getMember(id) != null) {
			//id가 있는 경우
			model.addAttribute("mybatisMember", mybatisMemberService.getMember(id));
			return "delMember";
		} else {
			//id가 없는 null인 경우
			return "delFail";
		}
	}
	
	//회원 삭제 delete
	@RequestMapping("/deleteOk")
	public String deleteOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		
//		 hasErrors()는 여러개의 필드 오류를 체크할때 사용한다. 따라서 여기서는 id만 체크하면 되기때문에 getFieldError를 사용한다
		if(result.getFieldErrorCount(mybatisMember.getId()) > 0) {
			System.out.println("삭제 오류 발생");
			return "delMember";
		} else {
			mybatisMemberService.deleteMember(mybatisMember.getId());
			return "redirect:list";
		}
	}
	
	//회원 목록 list
	@RequestMapping("/list")
	public void list(Model model) { //void는 view의 이름을 그대로 쓰겠다.
		ArrayList<MybatisMember> mybatisMembers = (ArrayList<MybatisMember>) mybatisMemberService.getAllMember();
		model.addAttribute("mybatisMembers", mybatisMembers);
	}
}
