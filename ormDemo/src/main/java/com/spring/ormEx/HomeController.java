package com.spring.ormEx;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ormDAO.BDAO;
import com.spring.ormDAO.BbsDAO;
import com.spring.ormVO.BVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
//	BbsDAO bbsdao;
	
	@Autowired //servlet.context.xml에 bean이 생성되어있으므로 Autowired만 하면됨
	private SqlSession sqlSession;
	
//	@Autowired
//	public void setBbsDAO(BbsDAO bbsdao) {
//		this.bbsdao = bbsdao;
//	}
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ArrayList<BVO> bvos = bbsdao.list();
//		model.addAttribute("list", bvos);
		
		//Mapper이용
		BDAO bdao = sqlSession.getMapper(BDAO.class);
		model.addAttribute("list", bdao.list());
		return "/list";
	}

	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	//DB를 처리해주는 부분(db내용추가 등)
	@RequestMapping("/writeOk")
	public String writeOk(HttpServletRequest req, Model model) {
		
		//Mapper이용
		BDAO bdao = sqlSession.getMapper(BDAO.class);
		bdao.writeOk(req.getParameter("name"), req.getParameter("bContent"));
		
		//DAO호출
//		bbsdao.writeOk(req.getParameter("name"), req.getParameter("bContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		BDAO bdao = sqlSession.getMapper(BDAO.class);
		bdao.delete(req.getParameter("bId"));
		return "redirect:list";
	}
	
}
