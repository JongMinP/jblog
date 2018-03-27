package com.cafe24.jblog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	// 리눅스 스타일로 경로 이름
	private static final String SAVE_PATH = "/uploads";
	private static final String PREFIX_URL = "/uploads/images/";

	public String restore(MultipartFile multipartFile) {
		String url = "";

		try {
			String originFilename = multipartFile.getOriginalFilename();

			// type .png 같은 확장자
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();

			// 저장할 파일 이름
			String saveFilename = genSaveFilename(extName);

			// System.out.println("######" + originFilename);
			// System.out.println("######" + extName);
			// System.out.println("######" + size);
			// System.out.println("######" + saveFilename);

			writeFile(multipartFile, saveFilename);

			// url = PREFIX_URL + saveFilename;
			url = saveFilename;

			System.out.println(url);

		} catch (IOException ex) {
			// fileupload Exception 런타임 에러 상속 받아서
			throw new RuntimeException(ex);
		}
		return url;
	}

	private void writeFile(MultipartFile multipartFile, String saveFilename) throws IOException {

		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}

	private String genSaveFilename(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();

		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += extName;

		return filename;
	}

}
