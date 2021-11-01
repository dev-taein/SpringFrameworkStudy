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
		//�������� ������ ���� �� �ִ� �޼��� getFileNames
		Iterator<String> iterator = mRequest.getFileNames();
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			//�ӽ����� ����
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			//���� ����(���� ���ϸ��� originFileName���� �޾ƿ�)
			String originFileName = mFile.getOriginalFilename();
			//���� ����Ǵ� ���ϸ�
			String saveFileName = originFileName;
			
			if(saveFileName != null && !saveFileName.equals("")) {
				//���ϸ��� �ߺ��Ǵ� ��� ���ϸ� �ڿ� �ð��� �߰��ؼ� ���ϸ��� �ٸ�����
				if(new File(uploadPath + saveFileName).exists()) {
					saveFileName = saveFileName + "_"+System.currentTimeMillis();
				}
				try {
					//transferTo()�� �̿��ϸ� ������ ���� ������
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
