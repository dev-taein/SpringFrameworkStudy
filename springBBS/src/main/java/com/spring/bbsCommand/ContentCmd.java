package com.spring.bbsCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbsDAO.BDAO;
import com.spring.bbsVO.BVO;

public class ContentCmd implements Bcmd {
	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		//request���� �Ѿ�� ����(bNo)�� �޾��ش�
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//�޾ƿ� ���� ��(bNo)�� �Ѱ�����ϴµ� �Ѱ��ٶ��� list.jsp��
		//<a href="contentView?bNo=${vo.bNo}"</a>�� �Ѱ��ش�
		
		//���� �޾��ش�.
		String bNo = request.getParameter("bNo");
		//������ ������ �ִ� �۾�
		BDAO dao = new BDAO();
		BVO bVo = dao.contentView(bNo);
		
		model.addAttribute("contentView", bVo);
	}
}
