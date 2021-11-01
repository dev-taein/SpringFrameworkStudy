package com.spring.bbsController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bbsCommand.Bcmd;
import com.spring.bbsCommand.ContentCmd;
import com.spring.bbsCommand.DeleteCmd;
import com.spring.bbsCommand.ListCmd;
import com.spring.bbsCommand.ModifyCmd;
import com.spring.bbsCommand.ReplyCmd;
import com.spring.bbsCommand.ReplyViewCmd;
import com.spring.bbsCommand.WriteCmd;
import com.spring.bbsVO.BVO;
import com.spring.template.StaticTemplate;


@Controller
public class BController{
	Bcmd cmd = null;
	
	private JdbcTemplate template;
	
	@Autowired //servlet-context���� ���ø� ������ ���� ����Ѵ�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		StaticTemplate.template = this.template;
	}
	
	//Model�� view�� �����͸� �����ϴ� ��ü�̴�.
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("---------------list()ȣ��----------------------");
		cmd = new ListCmd();
		cmd.service(model);
		
		return "list";
	}
	
	//�۾���
	@RequestMapping("/writeForm")
		public String writeForm(Model model) {
		System.out.println("-----------------writeForm()ȣ��--------------------");
		
		return "writeForm";
	}
	
	@RequestMapping("/writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		System.out.println("writeOk()ȣ��");
		model.addAttribute("request", request);
		cmd = new WriteCmd();
		cmd.service(model);
		return "redirect:list";
	}
	
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println("------------------contentView ȣ��----------------");
		model.addAttribute("request", request);
		cmd = new ContentCmd();
		cmd.service(model);
		return "contentView";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("-----------------------modify() ȣ��----------------------");
		model.addAttribute("request", request);
		cmd = new ModifyCmd();
		cmd.service(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("-----------delete() ȣ��-------------------");
		model.addAttribute("request", request);
		cmd = new DeleteCmd();
		cmd.service(model);
		return "redirect:list";
	}
	
	@RequestMapping("replyForm")
	public String replyForm(HttpServletRequest request, Model model) {
		System.out.println("----------------replyForm() ȣ��---------------");
		model.addAttribute("request", request);
		cmd = new ReplyViewCmd();
		cmd.service(model);
		return "replyForm";
	}
	
	@RequestMapping("replyOk")
	public String replyOk(HttpServletRequest request, Model model) {
		System.out.println("---------------replyOk() ȣ��-------------------");
		model.addAttribute("request", request); //��� ������ �޾ƿ�
		cmd = new ReplyCmd();
		cmd.service(model);
		
		return "redirect:list";
	}
	
	@ModelAttribute("BVO")
	public BVO formBacking() {
		return new BVO();
	}
}
