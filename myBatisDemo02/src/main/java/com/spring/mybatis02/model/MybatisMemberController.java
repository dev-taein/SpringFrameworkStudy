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
	
	
	//ȸ�� ���� insert [�� ��ü]
	@RequestMapping("/inputForm")
	public void insertMember(Model model) {
		//addAttribute(form��ü�� commandName�� inserOK()�� @Valid�� MybatisMember�� �Ű����� �̸�(mybatisMember)�� ����ؾ��Ѵ�., DTO)
		//�̷����ϸ� form�±��� path="name" ���� db������ �ҷ���
		model.addAttribute("mybatisMember", new MybatisMember()); 
	} //��ȯ���� void, String ������ �������� �ִ�.(���� ǥ�ð� �ٸ�[������ ���Ƶ�])

	
	//ȸ�� ���� insert
	@RequestMapping("/insertOk")
	//@Valid�� ��ȿ���˻�, MybatisMember(DTO)�� ��ȿ���˻��Ѵ�.
	//@Valid�� MybatisMember�� �Ű������̸��� ���� inputForm�� model.addAttribute("mybatisMember")�̸��� ���ƾ���
	public String insertOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("ȸ�����Խ� ������ �߻��Ͽ����ϴ�.!!!");
			return "inputForm"; //forward ����� �̿��ؾ� inputForm�� �����޽����� ȭ�鿡 �����ش�.
			//forward, redirect�� ����
			//forward�� �������̳� �ȿ��� �������� �̵�(���� �ȿ��� ������ �̵�) request��û�� �״�� �޾ƿ� �� �ִ�.
			//redirect�� ������������ �ٸ��������� �̵��϶�� ����� ����
		} else {
			//������ ������ DB�� ����
			mybatisMemberService.insertMember(mybatisMember);
			return "redirect:list";
		}
	}//insertOk()

	
	
	//ȸ�� ���� update
	@RequestMapping("/modifyMmeber/{id}") //   /{}�� get��� ��ſ� ���������� �����ϴ� @PathVariable ���[�������� urlâ�� ���� id���� ������.]
	public String modifyMember(@PathVariable String id, Model model) {
		//id���� MybatisMemberMapper��ü���� getMember(id)�� ���� ����
		model.addAttribute("mybatisMember", mybatisMemberService.getMember(id));
		
		return "/modifyForm";
	}
	//ȸ�� ���� update
	@RequestMapping("/modifyOk")
	public String modifyOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("ȸ������ ���� �� ������ �߻��Ͽ����ϴ�.");
			return "modifyForm";
		} else {
			//������ ������ ���񽺰�ü���� updateMember()�� �����Ų��.
			mybatisMemberService.updateMember(mybatisMember);
			return "redirect:list";
		}
	}
	//ȸ�� ���� delete
	@RequestMapping("delMember")
	public void delMember(Model model) {
		model.addAttribute("mybatisMember", new MybatisMember());
	}
	
	//ȸ�� ���� delete
	@RequestMapping("/delMember/{id}")
	public String delMember(@PathVariable String id ,Model model) {
//		model.addAttribute("mybatisMember", new MybatisMember());
		
		//id ���� ���� check
		if(mybatisMemberService.getMember(id) != null) {
			//id�� �ִ� ���
			model.addAttribute("mybatisMember", mybatisMemberService.getMember(id));
			return "delMember";
		} else {
			//id�� ���� null�� ���
			return "delFail";
		}
	}
	
	//ȸ�� ���� delete
	@RequestMapping("/deleteOk")
	public String deleteOk(@Valid MybatisMember mybatisMember, BindingResult result) {
		
//		 hasErrors()�� �������� �ʵ� ������ üũ�Ҷ� ����Ѵ�. ���� ���⼭�� id�� üũ�ϸ� �Ǳ⶧���� getFieldError�� ����Ѵ�
		if(result.getFieldErrorCount(mybatisMember.getId()) > 0) {
			System.out.println("���� ���� �߻�");
			return "delMember";
		} else {
			mybatisMemberService.deleteMember(mybatisMember.getId());
			return "redirect:list";
		}
	}
	
	//ȸ�� ��� list
	@RequestMapping("/list")
	public void list(Model model) { //void�� view�� �̸��� �״�� ���ڴ�.
		ArrayList<MybatisMember> mybatisMembers = (ArrayList<MybatisMember>) mybatisMemberService.getAllMember();
		model.addAttribute("mybatisMembers", mybatisMembers);
	}
}
