package com.app.converter.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.app.converter.exception.CustomException;
import com.itextpdf.text.DocumentException;


public interface FileConvertService {

	public String convert(MultipartFile file) throws CustomException, DocumentException, IOException;
	
	public Resource getFile(String fileName) throws IOException;
}
