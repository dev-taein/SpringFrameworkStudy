package com.spring.fileup;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class Upload {
	public boolean fileUpload(MultipartHttpServletRequest mRequest) {
		boolean isUpload = false;
		
		String uploadPath = "D:/uploadFile/";
		//여러개의 파일을 받을 수 있는 메서드 getFileNames
		Iterator<String> iterator = mRequest.getFileNames();
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			//임시파일 저장
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			//파일 구분(실제 파일명을 originFileName으로 받아옴)
			String originFileName = mFile.getOriginalFilename();
			//실제 저장되는 파일명
			String saveFileName = originFileName;
			
			if(saveFileName != null && !saveFileName.equals("")) {
				//파일명이 중복되는 경우 파일명 뒤에 시간을 추가해서 파일명을 다르게함
				if(new File(uploadPath + saveFileName).exists()) {
					saveFileName = saveFileName + "_"+System.currentTimeMillis();
				}
				try {
					//transferTo()를 이용하면 파일을 쉽게 저장함
					mFile.transferTo(new File(uploadPath+saveFileName));
					isUpload = true;
				} catch (IllegalStateException e) {
					e.printStackTrace();
					isUpload = false;
				} catch (IOException e2) {
					e2.printStackTrace();
					isUpload = false;
				}
			}
		}
		return isUpload;
	}
}
