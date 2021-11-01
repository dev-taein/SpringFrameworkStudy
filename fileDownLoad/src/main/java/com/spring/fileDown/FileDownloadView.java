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
		
		System.out.println("renderMergedOutputModel() ȣ��");
		
		File file = new File("d:/uploadFile/test.txt");
		response.setContentType(getContentType()); //ĳ���� ���ڵ�����, MIMEŸ���� ����
		response.setContentLength(100);//������ ũ��
		
		String userAgent = request.getHeader("User-Agent"); //�������� ������ ����
		String fileName = null;
		
		//MSIE(���ͳ��ͽ��÷ξ�) > -1 : -1���� ũ�� �ִ�true
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
