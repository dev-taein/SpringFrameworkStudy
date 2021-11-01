package com.spring.transactionEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.cmd.BuyCmd;
import com.spring.cmd.BuyCmdImpl;

@Controller
public class TiketController {
	
	
//	@Autowired
//	private BuyDAO buyDAO;
	
	private BuyCmd buyCmd;
	@Autowired
	public void setBuyCmdImpl(BuyCmdImpl buyCmdImpl) {
		this.buyCmd = buyCmdImpl;
	}
	
	
	@RequestMapping("/buy")
	public String buy() {
		
		return "buy";
	}
	
	@RequestMapping("/buyOk")
	public String buyOk(BuyVO buyVO, Model model) {
		System.out.println("---------------buyOk() ī�� ���� ����---------------");
		System.out.println("�� ���̵� : " + buyVO.getUserId());
		System.out.println("Ƽ�� ���� : " + buyVO.getAmount());
		
//		buyDAO.buyTicket(buyVO);
		buyCmd.execute(buyVO);
		model.addAttribute("buyInfo", buyVO);
		return "buyResult";
	}
}
