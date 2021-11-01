package com.spring.fileDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {
	
	public FileDownloadView() {
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("renderMergedOutputModel() 호출");
		
		File file = new File("d:/uploadFile/test.txt");
		response.setContentType(getContentType()); //캐릭터 인코딩지정, MIME타입을 지정
		response.setContentLength(100);//파일의 크기
		
		String userAgent = request.getHeader("User-Agent"); //브라우저의 종류를 얻어옴
		String fileName = null;
		
		//MSIE(인터넷익스플로어) > -1 : -1보다 크면 있다true
		if(userAgent.indexOf("MSIE") > -1) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(file);
			FileCopyUtils.copy(fin, out);
		} finally {
			if(fin != null) {
				try {
					fin.close();
				}catch (IOException e) {
					System.out.println("exeception : " + e.toString());
				}
			}//if
		}//finally
		out.flush();
	}
}
