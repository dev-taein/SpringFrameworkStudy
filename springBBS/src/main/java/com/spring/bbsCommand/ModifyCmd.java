package com.spring.bbsCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbsDAO.BDAO;

public class ModifyCmd implements Bcmd {
	//DB작업을 전부 저장하는 코드
	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		
		//request를 얻어 올 수 있는 이유는 
		//컨트롤러에서 request객체를 만들 었기 때문이다.
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//contentView.jsp에서 수정된 값을 가져옴
		String bNo = request.getParameter("bNo");
		String bName = request.getParameter("bName");
		String bSubject = request.getParameter("bSubject");
		String bContent = request.getParameter("bContent");
		
		BDAO bDAO = new BDAO();
		bDAO.modify(bNo, bName, bSubject, bContent);
	}
}
