package com.spring.ormVO;

public class BVO {
	private int bId;
	private String bName;
	private String bContent;
	
	//기본 생성자를 만들어 주지않으면 오류가 발생할 수 있음 
	//java.lang.NoSuchMethodException:
	public BVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BVO(int bId, String bName, String bContent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bContent = bContent;
	}
	

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	
	
}
