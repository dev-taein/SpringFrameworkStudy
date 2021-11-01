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
		//request에서 넘어온 정보(bNo)를 받아준다
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//받아온 정보 값(bNo)를 넘겨줘야하는데 넘겨줄때는 list.jsp의
		//<a href="contentView?bNo=${vo.bNo}"</a>로 넘겨준다
		
		//값을 받아준다.
		String bNo = request.getParameter("bNo");
		//내용을 가져와 주는 작업
		BDAO dao = new BDAO();
		BVO bVo = dao.contentView(bNo);
		
		model.addAttribute("contentView", bVo);
	}
}
