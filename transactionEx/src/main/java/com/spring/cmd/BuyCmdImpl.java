package com.spring.cmd;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.transactionEx.BuyDAO;
import com.spring.transactionEx.BuyVO;


public class BuyCmdImpl implements BuyCmd {
	
	private BuyDAO buyDAO;
	private TransactionTemplate transactionTemplate1;
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate1) {
		this.transactionTemplate1 = transactionTemplate1;
	}
	
	//setter, getter
	public void setBuyDAO(BuyDAO buyDAO) {
		this.buyDAO = buyDAO;
	}
	
	public BuyDAO getBuyDAO() {
		return buyDAO;
	}
	
	@Override
	public void execute(final BuyVO buyVO) {
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				buyVO.setAmount("2"); //����ڰ� �Է��� �� ������� ������ 2�� �Է�
				buyDAO.buyTicket(buyVO);
				
				buyVO.setAmount("10");
				buyDAO.buyTicket(buyVO);
				
			}
		});
	}
}
