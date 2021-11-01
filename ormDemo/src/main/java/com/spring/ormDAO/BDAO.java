package com.spring.ormDAO;

import java.util.ArrayList;

import com.spring.ormVO.BVO;

public interface BDAO {
	public ArrayList<BVO> list();
	public void writeOk(String name, String bCotent);
	public void delete(String bId);
	
}
